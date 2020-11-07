package tech.ides.core.test;

import ides.dsl.parser.IdesDslBaseListener;
import ides.dsl.parser.IdesDslLexer;
import ides.dsl.parser.IdesDslParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
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
        String expr = "select 1 AS   \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "      Tb1";
        CharStream cpcs = new CaseChangeCharStream(expr);
        IdesDslLexer idesDslLexer = new IdesDslLexer(cpcs);

        CommonTokenStream tokenStream = new CommonTokenStream(idesDslLexer);

        IdesDslParser parser = new IdesDslParser(tokenStream);
        ScriptQueryExecListener listener = new ScriptQueryExecListener(null, "", "test");

        IdesDslParser.StatementContext statement = parser.statement();

        ParseTreeWalker.DEFAULT.walk(listener, statement);
    }
}

