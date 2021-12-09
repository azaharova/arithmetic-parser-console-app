package arithmeticparsers.ast;

import arithmeticparsers.ast.nodes.impl.*;

import java.util.HashMap;

public class CalculateExpressionVisitor extends AstVisitor<Double> {

    private HashMap<String, Short> variables = new HashMap<>();

    public CalculateExpressionVisitor setVariables(HashMap<String, Short> variables) {
        this.variables = variables;
        return this;
    }

    @Override
    public Double visit(PlusNode node) {
        return visit(node.getLeft()) + visit(node.getRight());
    }

    @Override
    public Double visit(MinusNode node) {
        return visit(node.getLeft()) - visit(node.getRight());
    }

    @Override
    public Double visit(MultiplicationNode node) {
        return visit(node.getLeft()) * visit(node.getRight());
    }

    @Override
    public Double visit(DivisionNode node) {
        return visit(node.getLeft()) / visit(node.getRight());
    }

    @Override
    public Double visit(NumberNode node) {
        return node.getValue();
    }

    @Override
    public Double visit(VariableNode node) {
        return node.getValue(variables);
    }
}
