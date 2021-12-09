package arithmeticparsers.ast.nodes.impl;

import arithmeticparsers.ast.nodes.ExpressionNode;

public class MultiplicationNode extends ExpressionNode {
    public MultiplicationNode(ExpressionNode left, ExpressionNode right) {
        super(left, right);
    }
}
