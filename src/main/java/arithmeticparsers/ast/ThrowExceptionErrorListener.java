package arithmeticparsers.ast;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class ThrowExceptionErrorListener extends BaseErrorListener {

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
                            String msg,
                            RecognitionException e) {
        throw new UnsupportedOperationException("Invalid Expression: " + msg);
    }
}
