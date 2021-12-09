package arithmeticparsers.ast.nodes.impl;

import arithmeticparsers.ast.nodes.ExpressionNode;

public class PlusNode extends ExpressionNode {
    public PlusNode(ExpressionNode left, ExpressionNode right) {
        super(left, right);
    }
}
