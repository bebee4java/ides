package ides.dsl.parser;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * Created by songgr on 2020/10/22.
 */
public class VisitorTest {

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
        IdesDslLexer helloLexer = new IdesDslLexer(cpcs);

        CommonTokenStream tokenStream = new CommonTokenStream(helloLexer);

        IdesDslParser parser = new IdesDslParser(tokenStream);


        IdesDslParser.StatementContext statement = parser.statement();

        MyVisitor myVisitor = new MyVisitor();
        myVisitor.visit(statement);

        System.out.println("sql: " + myVisitor.cnt);
        System.out.println("load: " + myVisitor.loadcnt);
    }

}

class MyVisitor extends IdesDslBaseVisitor {
    int cnt = 0;
    int loadcnt = 0;

    @Override
    public Object visitSql(IdesDslParser.SqlContext ctx) {

        cnt += 1;
        System.out.println(ctx.getText());
        return super.visitSql(ctx);
    }

    @Override
    public Object visitLoad(IdesDslParser.LoadContext ctx) {
        loadcnt += 1;
        System.out.println("load ---> " + ctx.format().getText());
        return super.visitLoad(ctx);
    }
}