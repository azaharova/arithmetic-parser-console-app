package arithmeticparsers.ast;

import antlr.AntlrArithmeticBaseVisitor;
import antlr.AntlrArithmeticParser;
import arithmeticparsers.ast.nodes.ExpressionNode;
import arithmeticparsers.ast.nodes.impl.*;

import java.util.HashSet;

public class BuildAstVisitor extends AntlrArithmeticBaseVisitor<ExpressionNode> {

    private final HashSet<String> variablesNames = new HashSet<>();

    public HashSet<String> getVariablesNames() {
        return variablesNames;
    }

    @Override
    public ExpressionNode visitCompileUnit(AntlrArithmeticParser.CompileUnitContext context) {
        return visit(context.expr());
    }

    @Override
    public ExpressionNode visitNumberExpr(AntlrArithmeticParser.NumberExprContext context) {
        return new NumberNode(Double.parseDouble(context.value.getText()));
    }

    @Override
    public ExpressionNode visitParensExpr(AntlrArithmeticParser.ParensExprContext context) {
        return visit(context.expr());
    }

    @Override
    public ExpressionNode visitInfixExpr(AntlrArithmeticParser.InfixExprContext context) {
        ExpressionNode node;
        ExpressionNode left = visit(context.left);
        ExpressionNode right = visit(context.right);
        switch (context.op.getType()) {
            case AntlrArithmeticParser.ADDITION:
                node = new PlusNode(left, right);
                break;
            case AntlrArithmeticParser.SUBTRACTION:
                node = new MinusNode(left, right);
                break;
            case AntlrArithmeticParser.MULTIPLICATION:
                node = new MultiplicationNode(left, right);
                break;
            case AntlrArithmeticParser.DIVISION:
                node = new DivisionNode(left, right);
                break;
            default:
                throw new UnsupportedOperationException(
                        String.format("Operation '%s' is not supported", context.op.getText()));
        }
        return node;
    }

    @Override
    public ExpressionNode visitUnaryExpr(AntlrArithmeticParser.UnaryExprContext context) {
        if (context.op.getType() == AntlrArithmeticParser.ADDITION) {
            return visit(context.expr());
        } else {
            throw new UnsupportedOperationException(
                    String.format("Supports only positive number with size not more than 16 bit", context.op.getText()));
        }
    }

    @Override
    public ExpressionNode visitIdentifierExpression(AntlrArithmeticParser.IdentifierExpressionContext context) {
        variablesNames.add(context.IDENTIFIER().getText());
        return new VariableNode(context.IDENTIFIER().getText());
    }
}
