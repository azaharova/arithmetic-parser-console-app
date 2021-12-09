package arithmeticparsers.ast.nodes.impl;


import arithmeticparsers.ast.nodes.ExpressionNode;

import java.util.Map;

public class VariableNode extends ExpressionNode {
    private String key;

    public Double getValue(Map<String, Short> variables) {
        return Double.parseDouble(String.valueOf(variables.get(key)));
    }

    private Double value;

    public VariableNode() {
        super(null, null);
    }

    public VariableNode(String key) {
        super(null, null);
        this.key = key;
    }
}
