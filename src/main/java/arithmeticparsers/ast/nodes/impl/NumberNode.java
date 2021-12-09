package arithmeticparsers.ast.nodes.impl;

import arithmeticparsers.ast.nodes.ExpressionNode;

public class NumberNode extends ExpressionNode {
    private double value;

    public NumberNode() {
        super(null, null);
    }

    public NumberNode(double value) {
        super(null, null);
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
