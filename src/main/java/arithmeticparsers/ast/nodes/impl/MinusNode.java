package arithmeticparsers.ast.nodes.impl;

import arithmeticparsers.ast.nodes.ExpressionNode;

public class MinusNode extends ExpressionNode {
    public MinusNode(ExpressionNode left, ExpressionNode right) {
        super(left, right);
    }
}