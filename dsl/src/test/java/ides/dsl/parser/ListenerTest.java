package ides.dsl.parser;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * Created by songgr on 2020/10/23.
 */
public class ListenerTest {
    public static void main(String[] args) {
        String expr = "load hive.`a.bc` as table1;\n" +
                "\n----注释" +
                "\n" +
                "\n/*------*/" +
                "\n" +
                "\n" +
                "\n" +
                "load jsonStr.`abc` as table1;\n" +
                "load hive.`a.abc` as table1;\n" +
                "save a;";
        CodePointCharStream cpcs = CharStreams.fromString(expr);
        IdesDslLexer idesDslLexer = new IdesDslLexer(cpcs);

        CommonTokenStream tokenStream = new CommonTokenStream(idesDslLexer);

        IdesDslParser parser = new IdesDslParser(tokenStream);
        MyListener listener = new MyListener();

        IdesDslParser.StatementContext statement = parser.statement();

        ParseTreeWalker.DEFAULT.walk(listener, statement);
    }
}

class MyListener extends IdesDslBaseListener {
    @Override
    public void exitSql(IdesDslParser.SqlContext ctx) {
        System.out.println(ctx.getText());
    }

    @Override
    public void exitLoad(IdesDslParser.LoadContext ctx) {
        String text = ctx.format().getText();
        System.out.println("load -----> " + text);

    }
}
