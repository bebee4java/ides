package ides.dsl.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Interval;
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
                "!hdfs -cp /tmp/abc.txt /tmp/dd;";
        CodePointCharStream cpcs = CharStreams.fromString(expr);
        IdesLexer idesDslLexer = new IdesLexer(cpcs);

        CommonTokenStream tokenStream = new CommonTokenStream(idesDslLexer);

        IdesParser parser = new IdesParser(tokenStream);
        MyListener listener = new MyListener();

        IdesParser.StatementContext statement = parser.statement();

        ParseTreeWalker.DEFAULT.walk(listener, statement);
    }
}

class MyListener extends IdesParserBaseListener {
    @Override
    public void exitSql(IdesParser.SqlContext ctx) {
        System.out.println(ctx.getText());
    }

    @Override
    public void exitLoad(IdesParser.LoadContext ctx) {
        String text = ctx.format().getText();
        System.out.println("load -----> " + text);

    }

    @Override
    public void exitCommand(IdesParser.CommandContext ctx) {
        String text = ctx.commandParam().getText();
        System.out.println("exec=======>" + text);
        String commandParam = currentText(ctx.commandParam());

        System.out.println(commandParam);
        System.out.println(commandParam.split(" "));

        super.exitCommand(ctx);
    }

    public String currentText(ParserRuleContext ctx) {
        if ( ctx == null ) return null;
        IdesLexer lexer = (IdesLexer)ctx.start.getTokenSource();
        CharStream input = lexer._input;

        int start = ctx.start.getStartIndex();
        int stop = ctx.stop.getStopIndex();
        Interval interval = new Interval(start, stop);
        return input.getText(interval);
    }
}
