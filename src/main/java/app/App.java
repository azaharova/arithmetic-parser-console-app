package app;

import antlr.AntlrArithmeticLexer;
import antlr.AntlrArithmeticParser;
import arithmeticparsers.ast.BuildAstVisitor;
import arithmeticparsers.ast.CalculateExpressionVisitor;
import arithmeticparsers.ast.ThrowExceptionErrorListener;
import arithmeticparsers.ast.nodes.ExpressionNode;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

class App {
    public static void main(String[] arguments) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter arithmetic expression: ");
        String expression = reader.readLine();
        var lexer = new AntlrArithmeticLexer(CharStreams.fromString(expression));
        lexer.removeErrorListeners();
        lexer.addErrorListener(new ThrowExceptionErrorListener());
        final AntlrArithmeticParser parser = new AntlrArithmeticParser(
                new CommonTokenStream(lexer));
        try {
            AntlrArithmeticParser.CompileUnitContext cst = parser.compileUnit();
            BuildAstVisitor buildAstVisitor = new BuildAstVisitor();
            ExpressionNode ast = buildAstVisitor.visitCompileUnit(cst);
            HashSet<String> varNames = buildAstVisitor.getVariablesNames();
            HashMap<String, Short> variables = new HashMap<>();
            for (String varName : varNames) {
                System.out.print("Enter value of " + varName + ": ");
                String inputValue = reader.readLine();
                try {
                    short variableValue = Short.parseShort(inputValue);
                    if (variableValue < 0) {
                        throw new NumberFormatException();
                    }
                    variables.put(varName, variableValue);
                } catch (NumberFormatException ex) {
                    throw new NumberFormatException("Supports only positive number with size not more than 16 bit");
                }
            }
            Double value = new CalculateExpressionVisitor().setVariables(variables).visit(ast);
            System.out.println("Result is: " + value.toString());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}