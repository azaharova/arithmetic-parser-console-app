package arithmeticparsers.ast.nodes.impl;

import arithmeticparsers.ast.nodes.ExpressionNode;

public class DivisionNode extends ExpressionNode {
    public DivisionNode(ExpressionNode left, ExpressionNode right) {
        super(left, right);
    }
}
