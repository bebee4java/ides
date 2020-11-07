package tech.ides.dsl;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.misc.Interval;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * 大小写更改字符流
 * Created by songgr on 2020/11/06.
 */
public class CaseChangeCharStream implements CharStream {

    private final CharStream charStream;
    private final boolean upper;

    /**
     * Constructs a new CaseChangeCharStream wrapping the given {@link CharStream} forcing
     * all characters to upper case or lower case.
     * @param charStream The stream to wrap.
     * @param upper If true force each symbol to upper case, otherwise force to lower. Default is false.
     */
    public CaseChangeCharStream(CharStream charStream, boolean upper) {
        this.charStream = charStream;
        this.upper = upper;
    }


    public CaseChangeCharStream(CharStream charStream) {
        this.charStream = charStream;
        this.upper = false;
    }

    public CaseChangeCharStream(String string) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(string.getBytes());
        CharStream charStream = CharStreams.fromStream(bais);
        this.charStream = charStream;
        this.upper = false;
    }

    @Override
    public String getText(Interval interval) {
        return charStream.getText(interval);
    }

    @Override
    public void consume() {
        charStream.consume();
    }

    @Override
    public int LA(int i) {
        int c = charStream.LA(i);
        if (c <= 0) { return c; }
        if (upper) {
            return Character.toUpperCase(c);
        }
        return Character.toLowerCase(c);
    }

    @Override
    public int mark() {
        return charStream.mark();
    }

    @Override
    public void release(int marker) {
        charStream.release(marker);
    }

    @Override
    public int index() {
        return charStream.index();
    }

    @Override
    public void seek(int index) {
        charStream.seek(index);
    }

    @Override
    public int size() {
        return charStream.size();
    }

    @Override
    public String getSourceName() {
        return charStream.getSourceName();
    }
}
