package arithmeticparsers.ast.nodes;

import java.util.HashMap;
import java.util.Map;

public abstract class ExpressionNode {
    private ExpressionNode left;
    private ExpressionNode right;

    public ExpressionNode(ExpressionNode left, ExpressionNode right) {
        this.left = left;
        this.right = right;
    }

    public ExpressionNode getRight() {
        return right;
    }

    public ExpressionNode getLeft() {
        return left;
    }
}
