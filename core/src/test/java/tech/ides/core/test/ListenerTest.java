package tech.ides.core.test;

import ides.dsl.parser.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import tech.ides.dsl.CaseChangeCharStream;
import tech.ides.dsl.listener.ScriptQueryExecListener;

import java.io.IOException;

/**
 * Created by songgr on 2020/10/23.
 */
public class ListenerTest {
    public static void main(String[] args) throws IOException {
//        String expr = "load hive.`a.bc` where a.aa.a=1 and a.b = 's' and a='''ssdsde.sdede''' as table1;";
        String expr = "%py \n" +
                "print('>')" +
                "exit 1 " +
                "\n%\n" +
                "> abc\n" +
                "select 1 AS   \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "      Tb1;";
        System.out.println(expr);
        CharStream cpcs = new CaseChangeCharStream(expr);
        IdesLexer idesDslLexer = new IdesLexer(cpcs);

        CommonTokenStream tokenStream = new CommonTokenStream(idesDslLexer);

        IdesParser parser = new IdesParser(tokenStream);
        ScriptQueryExecListener listener = new ScriptQueryExecListener(null, "", "test");

        IdesParser.StatementContext statement = parser.statement();

        ParseTreeWalker.DEFAULT.walk(listener, statement);
    }
}

