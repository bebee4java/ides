// Generated from /Users/sgr/develop/ideaProjects/github/ides/dsl/src/main/resources/IdesParser.g4 by ANTLR 4.9.2

    package ides.dsl.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IdesParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PY_MODE=1, SQL_MODE=2, SHELL_MODE=3, AS=4, INTO=5, LOAD=6, SAVE=7, SELECT=8, 
		OPTIONS=9, WHERE=10, AND=11, OVERWRITE=12, APPEND=13, ERRORIfExists=14, 
		IGNORE=15, PARTITIONBY=16, CONNECT=17, SET=18, CONNECTION=19, FUNCTION=20, 
		CREATE=21, DROP=22, REGISTER=23, RUN=24, EXEC_TOKEN=25, DOT=26, EQ=27, 
		COMMA=28, GT=29, LT=30, HYPHEN=31, UNDERLINE=32, SLASH=33, TILDE=34, COLON=35, 
		ASTERISK=36, VERTICAL_BAR=37, EOQ=38, MUMERIC=39, IDENTIFIER=40, QUOTED_TEXT=41, 
		STRING_TEXT=42, BLOCK_STRING_TEXT=43, WS=44, LINE_COMMENT=45, BLOCK_COMMENT=46, 
		NL=47, UNRECOGNIZED=48, EXIT_PY=49, PY_RETURN=50, PY_STRING=51, VARIABLE=52, 
		VariableRef=53, PY_NonEnd=54, PY_TEXT=55, PY_COMMENT=56, PY_WS=57, EXIT_SQL=58, 
		SQL_RETURN=59, SQL_TEXT=60, DDL=61, DML=62, Profile=63, SQL_COMMENT1=64, 
		SQL_COMMENT2=65, SQL_COMMENT_BLOCK=66, CreatStatement=67, AlterStatement=68, 
		DropStatement=69, RenameStatement=70, TruncateStatement=71, SelectStatement=72, 
		InsertStatement=73, UpdateStatement=74, DeleteStatement=75, ReplaceStatement=76, 
		UseStatement=77, ShowStatement=78, ExplainStatement=79, SetStatement=80, 
		CallStatement=81, OpenStatement=82, CloseStatement=83, TransactionStatement=84, 
		CommitStatement=85, RollbackStatement=86, SQL_WS=87, EXIT_SH=88, SH_RETURN=89, 
		SH_STRING=90, SH_NonEnd=91, SHELL_TEXT=92, SEHLL_COMMENT=93, SH_WS=94;
	public static final int
		RULE_statement = 0, RULE_script = 1, RULE_pythonCode = 2, RULE_pyStatement = 3, 
		RULE_sqlCode = 4, RULE_sqlStatement = 5, RULE_shellCode = 6, RULE_shellStatement = 7, 
		RULE_query = 8, RULE_module = 9, RULE_format = 10, RULE_path = 11, RULE_col = 12, 
		RULE_colGroup = 13, RULE_whereExpressions = 14, RULE_partitionbyExpression = 15, 
		RULE_booleanExpression = 16, RULE_keyName = 17, RULE_valueName = 18, RULE_mumericValue = 19, 
		RULE_stringValue = 20, RULE_expression = 21, RULE_qualifiedName = 22, 
		RULE_asAsset = 23, RULE_assetName = 24, RULE_identifier = 25, RULE_quotedIdentifier = 26, 
		RULE_where = 27, RULE_saveMode = 28, RULE_outTable = 29, RULE_commandSymbol = 30, 
		RULE_commandParam = 31;
	private static String[] makeRuleNames() {
		return new String[] {
			"statement", "script", "pythonCode", "pyStatement", "sqlCode", "sqlStatement", 
			"shellCode", "shellStatement", "query", "module", "format", "path", "col", 
			"colGroup", "whereExpressions", "partitionbyExpression", "booleanExpression", 
			"keyName", "valueName", "mumericValue", "stringValue", "expression", 
			"qualifiedName", "asAsset", "assetName", "identifier", "quotedIdentifier", 
			"where", "saveMode", "outTable", "commandSymbol", "commandParam"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'as'", "'into'", "'load'", "'save'", "'select'", 
			"'options'", "'where'", "'and'", "'overwrite'", "'append'", "'errorIfExists'", 
			"'ignore'", null, "'connect'", "'set'", "'connection'", "'function'", 
			"'create'", "'drop'", "'register'", "'run'", "'!'", "'.'", "'='", "','", 
			"'>'", "'<'", "'-'", "'_'", "'/'", "'~'", "':'", "'*'", "'|'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PY_MODE", "SQL_MODE", "SHELL_MODE", "AS", "INTO", "LOAD", "SAVE", 
			"SELECT", "OPTIONS", "WHERE", "AND", "OVERWRITE", "APPEND", "ERRORIfExists", 
			"IGNORE", "PARTITIONBY", "CONNECT", "SET", "CONNECTION", "FUNCTION", 
			"CREATE", "DROP", "REGISTER", "RUN", "EXEC_TOKEN", "DOT", "EQ", "COMMA", 
			"GT", "LT", "HYPHEN", "UNDERLINE", "SLASH", "TILDE", "COLON", "ASTERISK", 
			"VERTICAL_BAR", "EOQ", "MUMERIC", "IDENTIFIER", "QUOTED_TEXT", "STRING_TEXT", 
			"BLOCK_STRING_TEXT", "WS", "LINE_COMMENT", "BLOCK_COMMENT", "NL", "UNRECOGNIZED", 
			"EXIT_PY", "PY_RETURN", "PY_STRING", "VARIABLE", "VariableRef", "PY_NonEnd", 
			"PY_TEXT", "PY_COMMENT", "PY_WS", "EXIT_SQL", "SQL_RETURN", "SQL_TEXT", 
			"DDL", "DML", "Profile", "SQL_COMMENT1", "SQL_COMMENT2", "SQL_COMMENT_BLOCK", 
			"CreatStatement", "AlterStatement", "DropStatement", "RenameStatement", 
			"TruncateStatement", "SelectStatement", "InsertStatement", "UpdateStatement", 
			"DeleteStatement", "ReplaceStatement", "UseStatement", "ShowStatement", 
			"ExplainStatement", "SetStatement", "CallStatement", "OpenStatement", 
			"CloseStatement", "TransactionStatement", "CommitStatement", "RollbackStatement", 
			"SQL_WS", "EXIT_SH", "SH_RETURN", "SH_STRING", "SH_NonEnd", "SHELL_TEXT", 
			"SEHLL_COMMENT", "SH_WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "IdesParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public IdesParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StatementContext extends ParserRuleContext {
		public List<ScriptContext> script() {
			return getRuleContexts(ScriptContext.class);
		}
		public ScriptContext script(int i) {
			return getRuleContext(ScriptContext.class,i);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PY_MODE) | (1L << SQL_MODE) | (1L << SHELL_MODE) | (1L << LOAD) | (1L << SAVE) | (1L << SELECT) | (1L << CONNECT) | (1L << SET) | (1L << CREATE) | (1L << DROP) | (1L << REGISTER) | (1L << RUN) | (1L << EXEC_TOKEN))) != 0)) {
				{
				{
				setState(64);
				script();
				}
				}
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ScriptContext extends ParserRuleContext {
		public ScriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_script; }
	 
		public ScriptContext() { }
		public void copyFrom(ScriptContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IqlContext extends ScriptContext {
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public TerminalNode EOQ() { return getToken(IdesParser.EOQ, 0); }
		public IqlContext(ScriptContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterIql(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitIql(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitIql(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShContext extends ScriptContext {
		public TerminalNode SHELL_MODE() { return getToken(IdesParser.SHELL_MODE, 0); }
		public ShellCodeContext shellCode() {
			return getRuleContext(ShellCodeContext.class,0);
		}
		public TerminalNode EXIT_SH() { return getToken(IdesParser.EXIT_SH, 0); }
		public TerminalNode NL() { return getToken(IdesParser.NL, 0); }
		public OutTableContext outTable() {
			return getRuleContext(OutTableContext.class,0);
		}
		public ShContext(ScriptContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterSh(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitSh(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitSh(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PyContext extends ScriptContext {
		public TerminalNode PY_MODE() { return getToken(IdesParser.PY_MODE, 0); }
		public PythonCodeContext pythonCode() {
			return getRuleContext(PythonCodeContext.class,0);
		}
		public TerminalNode EXIT_PY() { return getToken(IdesParser.EXIT_PY, 0); }
		public TerminalNode NL() { return getToken(IdesParser.NL, 0); }
		public OutTableContext outTable() {
			return getRuleContext(OutTableContext.class,0);
		}
		public PyContext(ScriptContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterPy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitPy(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitPy(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SqlContext extends ScriptContext {
		public TerminalNode SQL_MODE() { return getToken(IdesParser.SQL_MODE, 0); }
		public SqlCodeContext sqlCode() {
			return getRuleContext(SqlCodeContext.class,0);
		}
		public TerminalNode EXIT_SQL() { return getToken(IdesParser.EXIT_SQL, 0); }
		public TerminalNode NL() { return getToken(IdesParser.NL, 0); }
		public OutTableContext outTable() {
			return getRuleContext(OutTableContext.class,0);
		}
		public SqlContext(ScriptContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterSql(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitSql(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitSql(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScriptContext script() throws RecognitionException {
		ScriptContext _localctx = new ScriptContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_script);
		int _la;
		try {
			setState(100);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LOAD:
			case SAVE:
			case SELECT:
			case CONNECT:
			case SET:
			case CREATE:
			case DROP:
			case REGISTER:
			case RUN:
			case EXEC_TOKEN:
				_localctx = new IqlContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				query();
				setState(71);
				match(EOQ);
				}
				break;
			case PY_MODE:
				_localctx = new PyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				match(PY_MODE);
				setState(74);
				pythonCode();
				setState(75);
				match(EXIT_PY);
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(76);
					match(NL);
					}
				}

				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==GT) {
					{
					setState(79);
					outTable();
					}
				}

				}
				break;
			case SQL_MODE:
				_localctx = new SqlContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(82);
				match(SQL_MODE);
				setState(83);
				sqlCode();
				setState(84);
				match(EXIT_SQL);
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(85);
					match(NL);
					}
				}

				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==GT) {
					{
					setState(88);
					outTable();
					}
				}

				}
				break;
			case SHELL_MODE:
				_localctx = new ShContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(91);
				match(SHELL_MODE);
				setState(92);
				shellCode();
				setState(93);
				match(EXIT_SH);
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(94);
					match(NL);
					}
				}

				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==GT) {
					{
					setState(97);
					outTable();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PythonCodeContext extends ParserRuleContext {
		public List<PyStatementContext> pyStatement() {
			return getRuleContexts(PyStatementContext.class);
		}
		public PyStatementContext pyStatement(int i) {
			return getRuleContext(PyStatementContext.class,i);
		}
		public PythonCodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pythonCode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterPythonCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitPythonCode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitPythonCode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PythonCodeContext pythonCode() throws RecognitionException {
		PythonCodeContext _localctx = new PythonCodeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_pythonCode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PY_TEXT) {
				{
				{
				setState(102);
				pyStatement();
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PyStatementContext extends ParserRuleContext {
		public TerminalNode PY_TEXT() { return getToken(IdesParser.PY_TEXT, 0); }
		public PyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pyStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterPyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitPyStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitPyStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PyStatementContext pyStatement() throws RecognitionException {
		PyStatementContext _localctx = new PyStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_pyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(PY_TEXT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SqlCodeContext extends ParserRuleContext {
		public List<SqlStatementContext> sqlStatement() {
			return getRuleContexts(SqlStatementContext.class);
		}
		public SqlStatementContext sqlStatement(int i) {
			return getRuleContext(SqlStatementContext.class,i);
		}
		public SqlCodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlCode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterSqlCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitSqlCode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitSqlCode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SqlCodeContext sqlCode() throws RecognitionException {
		SqlCodeContext _localctx = new SqlCodeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_sqlCode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SQL_TEXT) {
				{
				{
				setState(110);
				sqlStatement();
				}
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SqlStatementContext extends ParserRuleContext {
		public TerminalNode SQL_TEXT() { return getToken(IdesParser.SQL_TEXT, 0); }
		public SqlStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterSqlStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitSqlStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitSqlStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SqlStatementContext sqlStatement() throws RecognitionException {
		SqlStatementContext _localctx = new SqlStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_sqlStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(SQL_TEXT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ShellCodeContext extends ParserRuleContext {
		public List<ShellStatementContext> shellStatement() {
			return getRuleContexts(ShellStatementContext.class);
		}
		public ShellStatementContext shellStatement(int i) {
			return getRuleContext(ShellStatementContext.class,i);
		}
		public ShellCodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shellCode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterShellCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitShellCode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitShellCode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShellCodeContext shellCode() throws RecognitionException {
		ShellCodeContext _localctx = new ShellCodeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_shellCode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SHELL_TEXT) {
				{
				{
				setState(118);
				shellStatement();
				}
				}
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ShellStatementContext extends ParserRuleContext {
		public TerminalNode SHELL_TEXT() { return getToken(IdesParser.SHELL_TEXT, 0); }
		public ShellStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shellStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterShellStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitShellStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitShellStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShellStatementContext shellStatement() throws RecognitionException {
		ShellStatementContext _localctx = new ShellStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_shellStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(SHELL_TEXT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryContext extends ParserRuleContext {
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
	 
		public QueryContext() { }
		public void copyFrom(QueryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LoadContext extends QueryContext {
		public TerminalNode LOAD() { return getToken(IdesParser.LOAD, 0); }
		public FormatContext format() {
			return getRuleContext(FormatContext.class,0);
		}
		public TerminalNode DOT() { return getToken(IdesParser.DOT, 0); }
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public AsAssetContext asAsset() {
			return getRuleContext(AsAssetContext.class,0);
		}
		public WhereExpressionsContext whereExpressions() {
			return getRuleContext(WhereExpressionsContext.class,0);
		}
		public LoadContext(QueryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterLoad(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitLoad(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitLoad(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetContext extends QueryContext {
		public TerminalNode SET() { return getToken(IdesParser.SET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public WhereExpressionsContext whereExpressions() {
			return getRuleContext(WhereExpressionsContext.class,0);
		}
		public SetContext(QueryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitSet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitSet(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RegisterContext extends QueryContext {
		public TerminalNode REGISTER() { return getToken(IdesParser.REGISTER, 0); }
		public ModuleContext module() {
			return getRuleContext(ModuleContext.class,0);
		}
		public TerminalNode DOT() { return getToken(IdesParser.DOT, 0); }
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public WhereExpressionsContext whereExpressions() {
			return getRuleContext(WhereExpressionsContext.class,0);
		}
		public AsAssetContext asAsset() {
			return getRuleContext(AsAssetContext.class,0);
		}
		public RegisterContext(QueryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterRegister(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitRegister(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitRegister(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CommandContext extends QueryContext {
		public TerminalNode EXEC_TOKEN() { return getToken(IdesParser.EXEC_TOKEN, 0); }
		public ModuleContext module() {
			return getRuleContext(ModuleContext.class,0);
		}
		public CommandParamContext commandParam() {
			return getRuleContext(CommandParamContext.class,0);
		}
		public CommandContext(QueryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitCommand(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CreateContext extends QueryContext {
		public TerminalNode CREATE() { return getToken(IdesParser.CREATE, 0); }
		public List<TerminalNode> EOQ() { return getTokens(IdesParser.EOQ); }
		public TerminalNode EOQ(int i) {
			return getToken(IdesParser.EOQ, i);
		}
		public CreateContext(QueryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterCreate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitCreate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitCreate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConnectContext extends QueryContext {
		public TerminalNode CONNECT() { return getToken(IdesParser.CONNECT, 0); }
		public FormatContext format() {
			return getRuleContext(FormatContext.class,0);
		}
		public WhereExpressionsContext whereExpressions() {
			return getRuleContext(WhereExpressionsContext.class,0);
		}
		public AsAssetContext asAsset() {
			return getRuleContext(AsAssetContext.class,0);
		}
		public ConnectContext(QueryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterConnect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitConnect(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitConnect(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SelectContext extends QueryContext {
		public TerminalNode SELECT() { return getToken(IdesParser.SELECT, 0); }
		public AsAssetContext asAsset() {
			return getRuleContext(AsAssetContext.class,0);
		}
		public List<TerminalNode> EOQ() { return getTokens(IdesParser.EOQ); }
		public TerminalNode EOQ(int i) {
			return getToken(IdesParser.EOQ, i);
		}
		public SelectContext(QueryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterSelect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitSelect(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitSelect(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SaveContext extends QueryContext {
		public TerminalNode SAVE() { return getToken(IdesParser.SAVE, 0); }
		public AssetNameContext assetName() {
			return getRuleContext(AssetNameContext.class,0);
		}
		public TerminalNode INTO() { return getToken(IdesParser.INTO, 0); }
		public FormatContext format() {
			return getRuleContext(FormatContext.class,0);
		}
		public TerminalNode DOT() { return getToken(IdesParser.DOT, 0); }
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public SaveModeContext saveMode() {
			return getRuleContext(SaveModeContext.class,0);
		}
		public WhereExpressionsContext whereExpressions() {
			return getRuleContext(WhereExpressionsContext.class,0);
		}
		public PartitionbyExpressionContext partitionbyExpression() {
			return getRuleContext(PartitionbyExpressionContext.class,0);
		}
		public SaveContext(QueryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterSave(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitSave(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitSave(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RunContext extends QueryContext {
		public TerminalNode RUN() { return getToken(IdesParser.RUN, 0); }
		public ModuleContext module() {
			return getRuleContext(ModuleContext.class,0);
		}
		public TerminalNode DOT() { return getToken(IdesParser.DOT, 0); }
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public WhereExpressionsContext whereExpressions() {
			return getRuleContext(WhereExpressionsContext.class,0);
		}
		public AsAssetContext asAsset() {
			return getRuleContext(AsAssetContext.class,0);
		}
		public RunContext(QueryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterRun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitRun(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitRun(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DropContext extends QueryContext {
		public Token resource;
		public TerminalNode DROP() { return getToken(IdesParser.DROP, 0); }
		public FormatContext format() {
			return getRuleContext(FormatContext.class,0);
		}
		public TerminalNode DOT() { return getToken(IdesParser.DOT, 0); }
		public AssetNameContext assetName() {
			return getRuleContext(AssetNameContext.class,0);
		}
		public TerminalNode CONNECTION() { return getToken(IdesParser.CONNECTION, 0); }
		public TerminalNode FUNCTION() { return getToken(IdesParser.FUNCTION, 0); }
		public DropContext(QueryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterDrop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitDrop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitDrop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_query);
		int _la;
		try {
			int _alt;
			setState(204);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LOAD:
				_localctx = new LoadContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				match(LOAD);
				setState(127);
				format();
				setState(128);
				match(DOT);
				setState(129);
				path();
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPTIONS || _la==WHERE) {
					{
					setState(130);
					whereExpressions();
					}
				}

				setState(133);
				asAsset();
				}
				break;
			case SAVE:
				_localctx = new SaveContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				match(SAVE);
				setState(136);
				assetName();
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OVERWRITE) | (1L << APPEND) | (1L << ERRORIfExists) | (1L << IGNORE))) != 0)) {
					{
					setState(137);
					saveMode();
					}
				}

				setState(140);
				match(INTO);
				setState(141);
				format();
				setState(142);
				match(DOT);
				setState(143);
				path();
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPTIONS || _la==WHERE) {
					{
					setState(144);
					whereExpressions();
					}
				}

				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITIONBY) {
					{
					setState(147);
					partitionbyExpression();
					}
				}

				}
				break;
			case SELECT:
				_localctx = new SelectContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(150);
				match(SELECT);
				setState(152); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(151);
						_la = _input.LA(1);
						if ( _la <= 0 || (_la==EOQ) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(154); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(156);
				asAsset();
				}
				break;
			case CONNECT:
				_localctx = new ConnectContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(157);
				match(CONNECT);
				setState(158);
				format();
				setState(159);
				whereExpressions();
				setState(160);
				asAsset();
				}
				break;
			case SET:
				_localctx = new SetContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(162);
				match(SET);
				setState(163);
				expression();
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPTIONS || _la==WHERE) {
					{
					setState(164);
					whereExpressions();
					}
				}

				}
				break;
			case DROP:
				_localctx = new DropContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(167);
				match(DROP);
				setState(168);
				((DropContext)_localctx).resource = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==CONNECTION || _la==FUNCTION) ) {
					((DropContext)_localctx).resource = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(169);
				format();
				setState(170);
				match(DOT);
				setState(171);
				assetName();
				}
				break;
			case CREATE:
				_localctx = new CreateContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(173);
				match(CREATE);
				setState(175); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(174);
					_la = _input.LA(1);
					if ( _la <= 0 || (_la==EOQ) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					setState(177); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PY_MODE) | (1L << SQL_MODE) | (1L << SHELL_MODE) | (1L << AS) | (1L << INTO) | (1L << LOAD) | (1L << SAVE) | (1L << SELECT) | (1L << OPTIONS) | (1L << WHERE) | (1L << AND) | (1L << OVERWRITE) | (1L << APPEND) | (1L << ERRORIfExists) | (1L << IGNORE) | (1L << PARTITIONBY) | (1L << CONNECT) | (1L << SET) | (1L << CONNECTION) | (1L << FUNCTION) | (1L << CREATE) | (1L << DROP) | (1L << REGISTER) | (1L << RUN) | (1L << EXEC_TOKEN) | (1L << DOT) | (1L << EQ) | (1L << COMMA) | (1L << GT) | (1L << LT) | (1L << HYPHEN) | (1L << UNDERLINE) | (1L << SLASH) | (1L << TILDE) | (1L << COLON) | (1L << ASTERISK) | (1L << VERTICAL_BAR) | (1L << MUMERIC) | (1L << IDENTIFIER) | (1L << QUOTED_TEXT) | (1L << STRING_TEXT) | (1L << BLOCK_STRING_TEXT) | (1L << WS) | (1L << LINE_COMMENT) | (1L << BLOCK_COMMENT) | (1L << NL) | (1L << UNRECOGNIZED) | (1L << EXIT_PY) | (1L << PY_RETURN) | (1L << PY_STRING) | (1L << VARIABLE) | (1L << VariableRef) | (1L << PY_NonEnd) | (1L << PY_TEXT) | (1L << PY_COMMENT) | (1L << PY_WS) | (1L << EXIT_SQL) | (1L << SQL_RETURN) | (1L << SQL_TEXT) | (1L << DDL) | (1L << DML) | (1L << Profile))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (SQL_COMMENT1 - 64)) | (1L << (SQL_COMMENT2 - 64)) | (1L << (SQL_COMMENT_BLOCK - 64)) | (1L << (CreatStatement - 64)) | (1L << (AlterStatement - 64)) | (1L << (DropStatement - 64)) | (1L << (RenameStatement - 64)) | (1L << (TruncateStatement - 64)) | (1L << (SelectStatement - 64)) | (1L << (InsertStatement - 64)) | (1L << (UpdateStatement - 64)) | (1L << (DeleteStatement - 64)) | (1L << (ReplaceStatement - 64)) | (1L << (UseStatement - 64)) | (1L << (ShowStatement - 64)) | (1L << (ExplainStatement - 64)) | (1L << (SetStatement - 64)) | (1L << (CallStatement - 64)) | (1L << (OpenStatement - 64)) | (1L << (CloseStatement - 64)) | (1L << (TransactionStatement - 64)) | (1L << (CommitStatement - 64)) | (1L << (RollbackStatement - 64)) | (1L << (SQL_WS - 64)) | (1L << (EXIT_SH - 64)) | (1L << (SH_RETURN - 64)) | (1L << (SH_STRING - 64)) | (1L << (SH_NonEnd - 64)) | (1L << (SHELL_TEXT - 64)) | (1L << (SEHLL_COMMENT - 64)) | (1L << (SH_WS - 64)))) != 0) );
				}
				break;
			case REGISTER:
				_localctx = new RegisterContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(179);
				match(REGISTER);
				setState(180);
				module();
				setState(181);
				match(DOT);
				setState(182);
				path();
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPTIONS || _la==WHERE) {
					{
					setState(183);
					whereExpressions();
					}
				}

				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(186);
					asAsset();
					}
				}

				}
				break;
			case RUN:
				_localctx = new RunContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(189);
				match(RUN);
				setState(190);
				module();
				setState(191);
				match(DOT);
				setState(192);
				path();
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPTIONS || _la==WHERE) {
					{
					setState(193);
					whereExpressions();
					}
				}

				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(196);
					asAsset();
					}
				}

				}
				break;
			case EXEC_TOKEN:
				_localctx = new CommandContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(199);
				match(EXEC_TOKEN);
				setState(200);
				module();
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOAD) | (1L << SAVE) | (1L << SELECT) | (1L << CONNECT) | (1L << SET) | (1L << CREATE) | (1L << DROP) | (1L << REGISTER) | (1L << RUN) | (1L << DOT) | (1L << COMMA) | (1L << GT) | (1L << LT) | (1L << HYPHEN) | (1L << UNDERLINE) | (1L << SLASH) | (1L << TILDE) | (1L << COLON) | (1L << ASTERISK) | (1L << VERTICAL_BAR) | (1L << MUMERIC) | (1L << IDENTIFIER) | (1L << QUOTED_TEXT) | (1L << STRING_TEXT) | (1L << BLOCK_STRING_TEXT))) != 0)) {
					{
					setState(201);
					commandParam();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModuleContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public QuotedIdentifierContext quotedIdentifier() {
			return getRuleContext(QuotedIdentifierContext.class,0);
		}
		public ModuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterModule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitModule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitModule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModuleContext module() throws RecognitionException {
		ModuleContext _localctx = new ModuleContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_module);
		try {
			setState(208);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LOAD:
			case SAVE:
			case SELECT:
			case CONNECT:
			case SET:
			case CREATE:
			case DROP:
			case REGISTER:
			case RUN:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(206);
				identifier();
				}
				break;
			case QUOTED_TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(207);
				quotedIdentifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormatContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public QuotedIdentifierContext quotedIdentifier() {
			return getRuleContext(QuotedIdentifierContext.class,0);
		}
		public FormatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_format; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterFormat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitFormat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitFormat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormatContext format() throws RecognitionException {
		FormatContext _localctx = new FormatContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_format);
		try {
			setState(212);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LOAD:
			case SAVE:
			case SELECT:
			case CONNECT:
			case SET:
			case CREATE:
			case DROP:
			case REGISTER:
			case RUN:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(210);
				identifier();
				}
				break;
			case QUOTED_TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(211);
				quotedIdentifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathContext extends ParserRuleContext {
		public QuotedIdentifierContext quotedIdentifier() {
			return getRuleContext(QuotedIdentifierContext.class,0);
		}
		public PathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathContext path() throws RecognitionException {
		PathContext _localctx = new PathContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_path);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			quotedIdentifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ColContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_col; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterCol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitCol(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitCol(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColContext col() throws RecognitionException {
		ColContext _localctx = new ColContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_col);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColGroupContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(IdesParser.COMMA, 0); }
		public ColContext col() {
			return getRuleContext(ColContext.class,0);
		}
		public ColGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colGroup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterColGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitColGroup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitColGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColGroupContext colGroup() throws RecognitionException {
		ColGroupContext _localctx = new ColGroupContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_colGroup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(COMMA);
			setState(219);
			col();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhereExpressionsContext extends ParserRuleContext {
		public WhereContext where() {
			return getRuleContext(WhereContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<BooleanExpressionContext> booleanExpression() {
			return getRuleContexts(BooleanExpressionContext.class);
		}
		public BooleanExpressionContext booleanExpression(int i) {
			return getRuleContext(BooleanExpressionContext.class,i);
		}
		public WhereExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereExpressions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterWhereExpressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitWhereExpressions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitWhereExpressions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhereExpressionsContext whereExpressions() throws RecognitionException {
		WhereExpressionsContext _localctx = new WhereExpressionsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_whereExpressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			where();
			setState(222);
			expression();
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(223);
				booleanExpression();
				}
				}
				setState(228);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PartitionbyExpressionContext extends ParserRuleContext {
		public TerminalNode PARTITIONBY() { return getToken(IdesParser.PARTITIONBY, 0); }
		public ColContext col() {
			return getRuleContext(ColContext.class,0);
		}
		public List<ColGroupContext> colGroup() {
			return getRuleContexts(ColGroupContext.class);
		}
		public ColGroupContext colGroup(int i) {
			return getRuleContext(ColGroupContext.class,i);
		}
		public PartitionbyExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partitionbyExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterPartitionbyExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitPartitionbyExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitPartitionbyExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PartitionbyExpressionContext partitionbyExpression() throws RecognitionException {
		PartitionbyExpressionContext _localctx = new PartitionbyExpressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_partitionbyExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(PARTITIONBY);
			setState(230);
			col();
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(231);
				colGroup();
				}
				}
				setState(236);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanExpressionContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(IdesParser.AND, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BooleanExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterBooleanExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitBooleanExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitBooleanExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanExpressionContext booleanExpression() throws RecognitionException {
		BooleanExpressionContext _localctx = new BooleanExpressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_booleanExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			match(AND);
			setState(238);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeyNameContext extends ParserRuleContext {
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public KeyNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterKeyName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitKeyName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitKeyName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyNameContext keyName() throws RecognitionException {
		KeyNameContext _localctx = new KeyNameContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_keyName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			qualifiedName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueNameContext extends ParserRuleContext {
		public MumericValueContext mumericValue() {
			return getRuleContext(MumericValueContext.class,0);
		}
		public StringValueContext stringValue() {
			return getRuleContext(StringValueContext.class,0);
		}
		public ValueNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterValueName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitValueName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitValueName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueNameContext valueName() throws RecognitionException {
		ValueNameContext _localctx = new ValueNameContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_valueName);
		try {
			setState(244);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(242);
				mumericValue();
				}
				break;
			case QUOTED_TEXT:
			case STRING_TEXT:
			case BLOCK_STRING_TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(243);
				stringValue();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MumericValueContext extends ParserRuleContext {
		public TerminalNode MUMERIC() { return getToken(IdesParser.MUMERIC, 0); }
		public MumericValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mumericValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterMumericValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitMumericValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitMumericValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MumericValueContext mumericValue() throws RecognitionException {
		MumericValueContext _localctx = new MumericValueContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_mumericValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(MUMERIC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringValueContext extends ParserRuleContext {
		public TerminalNode STRING_TEXT() { return getToken(IdesParser.STRING_TEXT, 0); }
		public TerminalNode BLOCK_STRING_TEXT() { return getToken(IdesParser.BLOCK_STRING_TEXT, 0); }
		public TerminalNode QUOTED_TEXT() { return getToken(IdesParser.QUOTED_TEXT, 0); }
		public StringValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterStringValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitStringValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitStringValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringValueContext stringValue() throws RecognitionException {
		StringValueContext _localctx = new StringValueContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_stringValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << QUOTED_TEXT) | (1L << STRING_TEXT) | (1L << BLOCK_STRING_TEXT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public KeyNameContext keyName() {
			return getRuleContext(KeyNameContext.class,0);
		}
		public TerminalNode EQ() { return getToken(IdesParser.EQ, 0); }
		public ValueNameContext valueName() {
			return getRuleContext(ValueNameContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			keyName();
			setState(251);
			match(EQ);
			setState(252);
			valueName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QualifiedNameContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(IdesParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(IdesParser.DOT, i);
		}
		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterQualifiedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitQualifiedName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitQualifiedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_qualifiedName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			identifier();
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(255);
				match(DOT);
				setState(256);
				identifier();
				}
				}
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AsAssetContext extends ParserRuleContext {
		public TerminalNode AS() { return getToken(IdesParser.AS, 0); }
		public AssetNameContext assetName() {
			return getRuleContext(AssetNameContext.class,0);
		}
		public AsAssetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asAsset; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterAsAsset(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitAsAsset(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitAsAsset(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsAssetContext asAsset() throws RecognitionException {
		AsAssetContext _localctx = new AsAssetContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_asAsset);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			match(AS);
			setState(263);
			assetName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssetNameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public QuotedIdentifierContext quotedIdentifier() {
			return getRuleContext(QuotedIdentifierContext.class,0);
		}
		public AssetNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assetName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterAssetName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitAssetName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitAssetName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssetNameContext assetName() throws RecognitionException {
		AssetNameContext _localctx = new AssetNameContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_assetName);
		try {
			setState(267);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LOAD:
			case SAVE:
			case SELECT:
			case CONNECT:
			case SET:
			case CREATE:
			case DROP:
			case REGISTER:
			case RUN:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(265);
				identifier();
				}
				break;
			case QUOTED_TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(266);
				quotedIdentifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(IdesParser.IDENTIFIER, 0); }
		public TerminalNode LOAD() { return getToken(IdesParser.LOAD, 0); }
		public TerminalNode SAVE() { return getToken(IdesParser.SAVE, 0); }
		public TerminalNode SELECT() { return getToken(IdesParser.SELECT, 0); }
		public TerminalNode CONNECT() { return getToken(IdesParser.CONNECT, 0); }
		public TerminalNode SET() { return getToken(IdesParser.SET, 0); }
		public TerminalNode DROP() { return getToken(IdesParser.DROP, 0); }
		public TerminalNode CREATE() { return getToken(IdesParser.CREATE, 0); }
		public TerminalNode REGISTER() { return getToken(IdesParser.REGISTER, 0); }
		public TerminalNode RUN() { return getToken(IdesParser.RUN, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOAD) | (1L << SAVE) | (1L << SELECT) | (1L << CONNECT) | (1L << SET) | (1L << CREATE) | (1L << DROP) | (1L << REGISTER) | (1L << RUN) | (1L << IDENTIFIER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuotedIdentifierContext extends ParserRuleContext {
		public TerminalNode QUOTED_TEXT() { return getToken(IdesParser.QUOTED_TEXT, 0); }
		public QuotedIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quotedIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterQuotedIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitQuotedIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitQuotedIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuotedIdentifierContext quotedIdentifier() throws RecognitionException {
		QuotedIdentifierContext _localctx = new QuotedIdentifierContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_quotedIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			match(QUOTED_TEXT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhereContext extends ParserRuleContext {
		public TerminalNode OPTIONS() { return getToken(IdesParser.OPTIONS, 0); }
		public TerminalNode WHERE() { return getToken(IdesParser.WHERE, 0); }
		public WhereContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterWhere(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitWhere(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitWhere(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhereContext where() throws RecognitionException {
		WhereContext _localctx = new WhereContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_where);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			_la = _input.LA(1);
			if ( !(_la==OPTIONS || _la==WHERE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SaveModeContext extends ParserRuleContext {
		public TerminalNode OVERWRITE() { return getToken(IdesParser.OVERWRITE, 0); }
		public TerminalNode APPEND() { return getToken(IdesParser.APPEND, 0); }
		public TerminalNode ERRORIfExists() { return getToken(IdesParser.ERRORIfExists, 0); }
		public TerminalNode IGNORE() { return getToken(IdesParser.IGNORE, 0); }
		public SaveModeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_saveMode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterSaveMode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitSaveMode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitSaveMode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SaveModeContext saveMode() throws RecognitionException {
		SaveModeContext _localctx = new SaveModeContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_saveMode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OVERWRITE) | (1L << APPEND) | (1L << ERRORIfExists) | (1L << IGNORE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OutTableContext extends ParserRuleContext {
		public TerminalNode GT() { return getToken(IdesParser.GT, 0); }
		public AssetNameContext assetName() {
			return getRuleContext(AssetNameContext.class,0);
		}
		public OutTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outTable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterOutTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitOutTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitOutTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OutTableContext outTable() throws RecognitionException {
		OutTableContext _localctx = new OutTableContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_outTable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			match(GT);
			setState(278);
			assetName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommandSymbolContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(IdesParser.DOT, 0); }
		public TerminalNode COMMA() { return getToken(IdesParser.COMMA, 0); }
		public TerminalNode GT() { return getToken(IdesParser.GT, 0); }
		public TerminalNode LT() { return getToken(IdesParser.LT, 0); }
		public TerminalNode HYPHEN() { return getToken(IdesParser.HYPHEN, 0); }
		public TerminalNode UNDERLINE() { return getToken(IdesParser.UNDERLINE, 0); }
		public TerminalNode SLASH() { return getToken(IdesParser.SLASH, 0); }
		public TerminalNode TILDE() { return getToken(IdesParser.TILDE, 0); }
		public TerminalNode COLON() { return getToken(IdesParser.COLON, 0); }
		public TerminalNode ASTERISK() { return getToken(IdesParser.ASTERISK, 0); }
		public TerminalNode VERTICAL_BAR() { return getToken(IdesParser.VERTICAL_BAR, 0); }
		public CommandSymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commandSymbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterCommandSymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitCommandSymbol(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitCommandSymbol(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandSymbolContext commandSymbol() throws RecognitionException {
		CommandSymbolContext _localctx = new CommandSymbolContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_commandSymbol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOT) | (1L << COMMA) | (1L << GT) | (1L << LT) | (1L << HYPHEN) | (1L << UNDERLINE) | (1L << SLASH) | (1L << TILDE) | (1L << COLON) | (1L << ASTERISK) | (1L << VERTICAL_BAR))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommandParamContext extends ParserRuleContext {
		public List<CommandSymbolContext> commandSymbol() {
			return getRuleContexts(CommandSymbolContext.class);
		}
		public CommandSymbolContext commandSymbol(int i) {
			return getRuleContext(CommandSymbolContext.class,i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<QuotedIdentifierContext> quotedIdentifier() {
			return getRuleContexts(QuotedIdentifierContext.class);
		}
		public QuotedIdentifierContext quotedIdentifier(int i) {
			return getRuleContext(QuotedIdentifierContext.class,i);
		}
		public List<StringValueContext> stringValue() {
			return getRuleContexts(StringValueContext.class);
		}
		public StringValueContext stringValue(int i) {
			return getRuleContext(StringValueContext.class,i);
		}
		public List<MumericValueContext> mumericValue() {
			return getRuleContexts(MumericValueContext.class);
		}
		public MumericValueContext mumericValue(int i) {
			return getRuleContext(MumericValueContext.class,i);
		}
		public CommandParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commandParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterCommandParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitCommandParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitCommandParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandParamContext commandParam() throws RecognitionException {
		CommandParamContext _localctx = new CommandParamContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_commandParam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(287);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(282);
					commandSymbol();
					}
					break;
				case 2:
					{
					setState(283);
					identifier();
					}
					break;
				case 3:
					{
					setState(284);
					quotedIdentifier();
					}
					break;
				case 4:
					{
					setState(285);
					stringValue();
					}
					break;
				case 5:
					{
					setState(286);
					mumericValue();
					}
					break;
				}
				}
				setState(289); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOAD) | (1L << SAVE) | (1L << SELECT) | (1L << CONNECT) | (1L << SET) | (1L << CREATE) | (1L << DROP) | (1L << REGISTER) | (1L << RUN) | (1L << DOT) | (1L << COMMA) | (1L << GT) | (1L << LT) | (1L << HYPHEN) | (1L << UNDERLINE) | (1L << SLASH) | (1L << TILDE) | (1L << COLON) | (1L << ASTERISK) | (1L << VERTICAL_BAR) | (1L << MUMERIC) | (1L << IDENTIFIER) | (1L << QUOTED_TEXT) | (1L << STRING_TEXT) | (1L << BLOCK_STRING_TEXT))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3`\u0126\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\7\2D\n\2\f\2\16\2G\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3P\n\3\3"+
		"\3\5\3S\n\3\3\3\3\3\3\3\3\3\5\3Y\n\3\3\3\5\3\\\n\3\3\3\3\3\3\3\3\3\5\3"+
		"b\n\3\3\3\5\3e\n\3\5\3g\n\3\3\4\7\4j\n\4\f\4\16\4m\13\4\3\5\3\5\3\6\7"+
		"\6r\n\6\f\6\16\6u\13\6\3\7\3\7\3\b\7\bz\n\b\f\b\16\b}\13\b\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\n\5\n\u0086\n\n\3\n\3\n\3\n\3\n\3\n\5\n\u008d\n\n\3\n\3"+
		"\n\3\n\3\n\3\n\5\n\u0094\n\n\3\n\5\n\u0097\n\n\3\n\3\n\6\n\u009b\n\n\r"+
		"\n\16\n\u009c\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00a8\n\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\6\n\u00b2\n\n\r\n\16\n\u00b3\3\n\3\n\3\n\3"+
		"\n\3\n\5\n\u00bb\n\n\3\n\5\n\u00be\n\n\3\n\3\n\3\n\3\n\3\n\5\n\u00c5\n"+
		"\n\3\n\5\n\u00c8\n\n\3\n\3\n\3\n\5\n\u00cd\n\n\5\n\u00cf\n\n\3\13\3\13"+
		"\5\13\u00d3\n\13\3\f\3\f\5\f\u00d7\n\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\7\20\u00e3\n\20\f\20\16\20\u00e6\13\20\3\21\3\21\3\21"+
		"\7\21\u00eb\n\21\f\21\16\21\u00ee\13\21\3\22\3\22\3\22\3\23\3\23\3\24"+
		"\3\24\5\24\u00f7\n\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30"+
		"\3\30\7\30\u0104\n\30\f\30\16\30\u0107\13\30\3\31\3\31\3\31\3\32\3\32"+
		"\5\32\u010e\n\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3\37"+
		"\3 \3 \3!\3!\3!\3!\3!\6!\u0122\n!\r!\16!\u0123\3!\2\2\"\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@\2\t\3\2((\3\2\25\26"+
		"\3\2+-\6\2\b\n\23\24\27\32**\3\2\13\f\3\2\16\21\4\2\34\34\36\'\2\u0133"+
		"\2E\3\2\2\2\4f\3\2\2\2\6k\3\2\2\2\bn\3\2\2\2\ns\3\2\2\2\fv\3\2\2\2\16"+
		"{\3\2\2\2\20~\3\2\2\2\22\u00ce\3\2\2\2\24\u00d2\3\2\2\2\26\u00d6\3\2\2"+
		"\2\30\u00d8\3\2\2\2\32\u00da\3\2\2\2\34\u00dc\3\2\2\2\36\u00df\3\2\2\2"+
		" \u00e7\3\2\2\2\"\u00ef\3\2\2\2$\u00f2\3\2\2\2&\u00f6\3\2\2\2(\u00f8\3"+
		"\2\2\2*\u00fa\3\2\2\2,\u00fc\3\2\2\2.\u0100\3\2\2\2\60\u0108\3\2\2\2\62"+
		"\u010d\3\2\2\2\64\u010f\3\2\2\2\66\u0111\3\2\2\28\u0113\3\2\2\2:\u0115"+
		"\3\2\2\2<\u0117\3\2\2\2>\u011a\3\2\2\2@\u0121\3\2\2\2BD\5\4\3\2CB\3\2"+
		"\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2F\3\3\2\2\2GE\3\2\2\2HI\5\22\n\2IJ\7"+
		"(\2\2Jg\3\2\2\2KL\7\3\2\2LM\5\6\4\2MO\7\63\2\2NP\7\61\2\2ON\3\2\2\2OP"+
		"\3\2\2\2PR\3\2\2\2QS\5<\37\2RQ\3\2\2\2RS\3\2\2\2Sg\3\2\2\2TU\7\4\2\2U"+
		"V\5\n\6\2VX\7<\2\2WY\7\61\2\2XW\3\2\2\2XY\3\2\2\2Y[\3\2\2\2Z\\\5<\37\2"+
		"[Z\3\2\2\2[\\\3\2\2\2\\g\3\2\2\2]^\7\5\2\2^_\5\16\b\2_a\7Z\2\2`b\7\61"+
		"\2\2a`\3\2\2\2ab\3\2\2\2bd\3\2\2\2ce\5<\37\2dc\3\2\2\2de\3\2\2\2eg\3\2"+
		"\2\2fH\3\2\2\2fK\3\2\2\2fT\3\2\2\2f]\3\2\2\2g\5\3\2\2\2hj\5\b\5\2ih\3"+
		"\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2l\7\3\2\2\2mk\3\2\2\2no\79\2\2o\t"+
		"\3\2\2\2pr\5\f\7\2qp\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2t\13\3\2\2\2"+
		"us\3\2\2\2vw\7>\2\2w\r\3\2\2\2xz\5\20\t\2yx\3\2\2\2z}\3\2\2\2{y\3\2\2"+
		"\2{|\3\2\2\2|\17\3\2\2\2}{\3\2\2\2~\177\7^\2\2\177\21\3\2\2\2\u0080\u0081"+
		"\7\b\2\2\u0081\u0082\5\26\f\2\u0082\u0083\7\34\2\2\u0083\u0085\5\30\r"+
		"\2\u0084\u0086\5\36\20\2\u0085\u0084\3\2\2\2\u0085\u0086\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087\u0088\5\60\31\2\u0088\u00cf\3\2\2\2\u0089\u008a\7"+
		"\t\2\2\u008a\u008c\5\62\32\2\u008b\u008d\5:\36\2\u008c\u008b\3\2\2\2\u008c"+
		"\u008d\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\7\7\2\2\u008f\u0090\5\26"+
		"\f\2\u0090\u0091\7\34\2\2\u0091\u0093\5\30\r\2\u0092\u0094\5\36\20\2\u0093"+
		"\u0092\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0096\3\2\2\2\u0095\u0097\5 "+
		"\21\2\u0096\u0095\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u00cf\3\2\2\2\u0098"+
		"\u009a\7\n\2\2\u0099\u009b\n\2\2\2\u009a\u0099\3\2\2\2\u009b\u009c\3\2"+
		"\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\3\2\2\2\u009e"+
		"\u00cf\5\60\31\2\u009f\u00a0\7\23\2\2\u00a0\u00a1\5\26\f\2\u00a1\u00a2"+
		"\5\36\20\2\u00a2\u00a3\5\60\31\2\u00a3\u00cf\3\2\2\2\u00a4\u00a5\7\24"+
		"\2\2\u00a5\u00a7\5,\27\2\u00a6\u00a8\5\36\20\2\u00a7\u00a6\3\2\2\2\u00a7"+
		"\u00a8\3\2\2\2\u00a8\u00cf\3\2\2\2\u00a9\u00aa\7\30\2\2\u00aa\u00ab\t"+
		"\3\2\2\u00ab\u00ac\5\26\f\2\u00ac\u00ad\7\34\2\2\u00ad\u00ae\5\62\32\2"+
		"\u00ae\u00cf\3\2\2\2\u00af\u00b1\7\27\2\2\u00b0\u00b2\n\2\2\2\u00b1\u00b0"+
		"\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4"+
		"\u00cf\3\2\2\2\u00b5\u00b6\7\31\2\2\u00b6\u00b7\5\24\13\2\u00b7\u00b8"+
		"\7\34\2\2\u00b8\u00ba\5\30\r\2\u00b9\u00bb\5\36\20\2\u00ba\u00b9\3\2\2"+
		"\2\u00ba\u00bb\3\2\2\2\u00bb\u00bd\3\2\2\2\u00bc\u00be\5\60\31\2\u00bd"+
		"\u00bc\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00cf\3\2\2\2\u00bf\u00c0\7\32"+
		"\2\2\u00c0\u00c1\5\24\13\2\u00c1\u00c2\7\34\2\2\u00c2\u00c4\5\30\r\2\u00c3"+
		"\u00c5\5\36\20\2\u00c4\u00c3\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c7\3"+
		"\2\2\2\u00c6\u00c8\5\60\31\2\u00c7\u00c6\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8"+
		"\u00cf\3\2\2\2\u00c9\u00ca\7\33\2\2\u00ca\u00cc\5\24\13\2\u00cb\u00cd"+
		"\5@!\2\u00cc\u00cb\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cf\3\2\2\2\u00ce"+
		"\u0080\3\2\2\2\u00ce\u0089\3\2\2\2\u00ce\u0098\3\2\2\2\u00ce\u009f\3\2"+
		"\2\2\u00ce\u00a4\3\2\2\2\u00ce\u00a9\3\2\2\2\u00ce\u00af\3\2\2\2\u00ce"+
		"\u00b5\3\2\2\2\u00ce\u00bf\3\2\2\2\u00ce\u00c9\3\2\2\2\u00cf\23\3\2\2"+
		"\2\u00d0\u00d3\5\64\33\2\u00d1\u00d3\5\66\34\2\u00d2\u00d0\3\2\2\2\u00d2"+
		"\u00d1\3\2\2\2\u00d3\25\3\2\2\2\u00d4\u00d7\5\64\33\2\u00d5\u00d7\5\66"+
		"\34\2\u00d6\u00d4\3\2\2\2\u00d6\u00d5\3\2\2\2\u00d7\27\3\2\2\2\u00d8\u00d9"+
		"\5\66\34\2\u00d9\31\3\2\2\2\u00da\u00db\5\64\33\2\u00db\33\3\2\2\2\u00dc"+
		"\u00dd\7\36\2\2\u00dd\u00de\5\32\16\2\u00de\35\3\2\2\2\u00df\u00e0\58"+
		"\35\2\u00e0\u00e4\5,\27\2\u00e1\u00e3\5\"\22\2\u00e2\u00e1\3\2\2\2\u00e3"+
		"\u00e6\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\37\3\2\2"+
		"\2\u00e6\u00e4\3\2\2\2\u00e7\u00e8\7\22\2\2\u00e8\u00ec\5\32\16\2\u00e9"+
		"\u00eb\5\34\17\2\u00ea\u00e9\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec\u00ea\3"+
		"\2\2\2\u00ec\u00ed\3\2\2\2\u00ed!\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f0"+
		"\7\r\2\2\u00f0\u00f1\5,\27\2\u00f1#\3\2\2\2\u00f2\u00f3\5.\30\2\u00f3"+
		"%\3\2\2\2\u00f4\u00f7\5(\25\2\u00f5\u00f7\5*\26\2\u00f6\u00f4\3\2\2\2"+
		"\u00f6\u00f5\3\2\2\2\u00f7\'\3\2\2\2\u00f8\u00f9\7)\2\2\u00f9)\3\2\2\2"+
		"\u00fa\u00fb\t\4\2\2\u00fb+\3\2\2\2\u00fc\u00fd\5$\23\2\u00fd\u00fe\7"+
		"\35\2\2\u00fe\u00ff\5&\24\2\u00ff-\3\2\2\2\u0100\u0105\5\64\33\2\u0101"+
		"\u0102\7\34\2\2\u0102\u0104\5\64\33\2\u0103\u0101\3\2\2\2\u0104\u0107"+
		"\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106/\3\2\2\2\u0107"+
		"\u0105\3\2\2\2\u0108\u0109\7\6\2\2\u0109\u010a\5\62\32\2\u010a\61\3\2"+
		"\2\2\u010b\u010e\5\64\33\2\u010c\u010e\5\66\34\2\u010d\u010b\3\2\2\2\u010d"+
		"\u010c\3\2\2\2\u010e\63\3\2\2\2\u010f\u0110\t\5\2\2\u0110\65\3\2\2\2\u0111"+
		"\u0112\7+\2\2\u0112\67\3\2\2\2\u0113\u0114\t\6\2\2\u01149\3\2\2\2\u0115"+
		"\u0116\t\7\2\2\u0116;\3\2\2\2\u0117\u0118\7\37\2\2\u0118\u0119\5\62\32"+
		"\2\u0119=\3\2\2\2\u011a\u011b\t\b\2\2\u011b?\3\2\2\2\u011c\u0122\5> \2"+
		"\u011d\u0122\5\64\33\2\u011e\u0122\5\66\34\2\u011f\u0122\5*\26\2\u0120"+
		"\u0122\5(\25\2\u0121\u011c\3\2\2\2\u0121\u011d\3\2\2\2\u0121\u011e\3\2"+
		"\2\2\u0121\u011f\3\2\2\2\u0121\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123"+
		"\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124A\3\2\2\2#EORX[adfks{\u0085\u008c"+
		"\u0093\u0096\u009c\u00a7\u00b3\u00ba\u00bd\u00c4\u00c7\u00cc\u00ce\u00d2"+
		"\u00d6\u00e4\u00ec\u00f6\u0105\u010d\u0121\u0123";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}