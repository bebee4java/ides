package tech.ides.dsl;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/**
 * 语法错误监听器，错误抛出异常
 * Created by songgr on 2020/11/06.
 */
public class SyntaxErrorListener extends BaseErrorListener {

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        throw new RuntimeException("IDES dsl parse error in [row:" + line + " column:" + charPositionInLine + "]  error msg: " + msg);
    }
}
