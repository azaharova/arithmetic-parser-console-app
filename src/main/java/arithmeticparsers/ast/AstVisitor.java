package arithmeticparsers.ast;

import arithmeticparsers.ast.nodes.ExpressionNode;
import arithmeticparsers.ast.nodes.impl.*;

abstract class AstVisitor<T> {
    public abstract T visit(PlusNode node);

    public abstract T visit(MinusNode node);

    public abstract T visit(MultiplicationNode node);

    public abstract T visit(DivisionNode node);

    public abstract T visit(NumberNode node);

    public abstract T visit(VariableNode node);

    public T visit(ExpressionNode node) {
        if (node.getClass() == PlusNode.class) {
            return visit((PlusNode) node);
        } else if (node.getClass() == MinusNode.class) {
            return visit((MinusNode) node);
        } else if (node.getClass() == MultiplicationNode.class) {
            return visit((MultiplicationNode) node);
        } else if (node.getClass() == DivisionNode.class) {
            return visit((DivisionNode) node);
        } else if (node.getClass() == NumberNode.class) {
            return visit((NumberNode) node);
        } else if (node.getClass() == VariableNode.class) {
            return visit((VariableNode) node);
        } else {
            return null;
        }
    }
}