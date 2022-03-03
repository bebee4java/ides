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
		RULE_statement = 0, RULE_idesScript = 1, RULE_script = 2, RULE_pythonCode = 3, 
		RULE_pyStatement = 4, RULE_sqlCode = 5, RULE_sqlStatement = 6, RULE_shellCode = 7, 
		RULE_shellStatement = 8, RULE_query = 9, RULE_module = 10, RULE_format = 11, 
		RULE_path = 12, RULE_col = 13, RULE_colGroup = 14, RULE_whereExpressions = 15, 
		RULE_partitionbyExpression = 16, RULE_booleanExpression = 17, RULE_keyName = 18, 
		RULE_valueName = 19, RULE_mumericValue = 20, RULE_stringValue = 21, RULE_expression = 22, 
		RULE_qualifiedName = 23, RULE_asAsset = 24, RULE_assetName = 25, RULE_identifier = 26, 
		RULE_quotedIdentifier = 27, RULE_where = 28, RULE_saveMode = 29, RULE_outTable = 30, 
		RULE_commandSymbol = 31, RULE_commandParam = 32;
	private static String[] makeRuleNames() {
		return new String[] {
			"statement", "idesScript", "script", "pythonCode", "pyStatement", "sqlCode", 
			"sqlStatement", "shellCode", "shellStatement", "query", "module", "format", 
			"path", "col", "colGroup", "whereExpressions", "partitionbyExpression", 
			"booleanExpression", "keyName", "valueName", "mumericValue", "stringValue", 
			"expression", "qualifiedName", "asAsset", "assetName", "identifier", 
			"quotedIdentifier", "where", "saveMode", "outTable", "commandSymbol", 
			"commandParam"
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
		public List<IdesScriptContext> idesScript() {
			return getRuleContexts(IdesScriptContext.class);
		}
		public IdesScriptContext idesScript(int i) {
			return getRuleContext(IdesScriptContext.class,i);
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
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PY_MODE) | (1L << SQL_MODE) | (1L << SHELL_MODE) | (1L << LOAD) | (1L << SAVE) | (1L << SELECT) | (1L << CONNECT) | (1L << SET) | (1L << CREATE) | (1L << DROP) | (1L << REGISTER) | (1L << RUN) | (1L << EXEC_TOKEN))) != 0)) {
				{
				{
				setState(66);
				idesScript();
				}
				}
				setState(71);
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

	public static class IdesScriptContext extends ParserRuleContext {
		public ScriptContext script() {
			return getRuleContext(ScriptContext.class,0);
		}
		public IdesScriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idesScript; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterIdesScript(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitIdesScript(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitIdesScript(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdesScriptContext idesScript() throws RecognitionException {
		IdesScriptContext _localctx = new IdesScriptContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_idesScript);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			script();
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
		enterRule(_localctx, 4, RULE_script);
		int _la;
		try {
			setState(104);
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
				setState(74);
				query();
				setState(75);
				match(EOQ);
				}
				break;
			case PY_MODE:
				_localctx = new PyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				match(PY_MODE);
				setState(78);
				pythonCode();
				setState(79);
				match(EXIT_PY);
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(80);
					match(NL);
					}
				}

				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==GT) {
					{
					setState(83);
					outTable();
					}
				}

				}
				break;
			case SQL_MODE:
				_localctx = new SqlContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(86);
				match(SQL_MODE);
				setState(87);
				sqlCode();
				setState(88);
				match(EXIT_SQL);
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(89);
					match(NL);
					}
				}

				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==GT) {
					{
					setState(92);
					outTable();
					}
				}

				}
				break;
			case SHELL_MODE:
				_localctx = new ShContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(95);
				match(SHELL_MODE);
				setState(96);
				shellCode();
				setState(97);
				match(EXIT_SH);
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(98);
					match(NL);
					}
				}

				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==GT) {
					{
					setState(101);
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
		enterRule(_localctx, 6, RULE_pythonCode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PY_TEXT) {
				{
				{
				setState(106);
				pyStatement();
				}
				}
				setState(111);
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
		enterRule(_localctx, 8, RULE_pyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
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
		enterRule(_localctx, 10, RULE_sqlCode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SQL_TEXT) {
				{
				{
				setState(114);
				sqlStatement();
				}
				}
				setState(119);
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
		enterRule(_localctx, 12, RULE_sqlStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
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
		enterRule(_localctx, 14, RULE_shellCode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SHELL_TEXT) {
				{
				{
				setState(122);
				shellStatement();
				}
				}
				setState(127);
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
		enterRule(_localctx, 16, RULE_shellStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
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
		enterRule(_localctx, 18, RULE_query);
		int _la;
		try {
			int _alt;
			setState(208);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LOAD:
				_localctx = new LoadContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				match(LOAD);
				setState(131);
				format();
				setState(132);
				match(DOT);
				setState(133);
				path();
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPTIONS || _la==WHERE) {
					{
					setState(134);
					whereExpressions();
					}
				}

				setState(137);
				asAsset();
				}
				break;
			case SAVE:
				_localctx = new SaveContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				match(SAVE);
				setState(140);
				assetName();
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OVERWRITE) | (1L << APPEND) | (1L << ERRORIfExists) | (1L << IGNORE))) != 0)) {
					{
					setState(141);
					saveMode();
					}
				}

				setState(144);
				match(INTO);
				setState(145);
				format();
				setState(146);
				match(DOT);
				setState(147);
				path();
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPTIONS || _la==WHERE) {
					{
					setState(148);
					whereExpressions();
					}
				}

				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITIONBY) {
					{
					setState(151);
					partitionbyExpression();
					}
				}

				}
				break;
			case SELECT:
				_localctx = new SelectContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(154);
				match(SELECT);
				setState(156); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(155);
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
					setState(158); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(160);
				asAsset();
				}
				break;
			case CONNECT:
				_localctx = new ConnectContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(161);
				match(CONNECT);
				setState(162);
				format();
				setState(163);
				whereExpressions();
				setState(164);
				asAsset();
				}
				break;
			case SET:
				_localctx = new SetContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(166);
				match(SET);
				setState(167);
				expression();
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPTIONS || _la==WHERE) {
					{
					setState(168);
					whereExpressions();
					}
				}

				}
				break;
			case DROP:
				_localctx = new DropContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(171);
				match(DROP);
				setState(172);
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
				setState(173);
				format();
				setState(174);
				match(DOT);
				setState(175);
				assetName();
				}
				break;
			case CREATE:
				_localctx = new CreateContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(177);
				match(CREATE);
				setState(179); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(178);
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
					setState(181); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PY_MODE) | (1L << SQL_MODE) | (1L << SHELL_MODE) | (1L << AS) | (1L << INTO) | (1L << LOAD) | (1L << SAVE) | (1L << SELECT) | (1L << OPTIONS) | (1L << WHERE) | (1L << AND) | (1L << OVERWRITE) | (1L << APPEND) | (1L << ERRORIfExists) | (1L << IGNORE) | (1L << PARTITIONBY) | (1L << CONNECT) | (1L << SET) | (1L << CONNECTION) | (1L << FUNCTION) | (1L << CREATE) | (1L << DROP) | (1L << REGISTER) | (1L << RUN) | (1L << EXEC_TOKEN) | (1L << DOT) | (1L << EQ) | (1L << COMMA) | (1L << GT) | (1L << LT) | (1L << HYPHEN) | (1L << UNDERLINE) | (1L << SLASH) | (1L << TILDE) | (1L << COLON) | (1L << ASTERISK) | (1L << VERTICAL_BAR) | (1L << MUMERIC) | (1L << IDENTIFIER) | (1L << QUOTED_TEXT) | (1L << STRING_TEXT) | (1L << BLOCK_STRING_TEXT) | (1L << WS) | (1L << LINE_COMMENT) | (1L << BLOCK_COMMENT) | (1L << NL) | (1L << UNRECOGNIZED) | (1L << EXIT_PY) | (1L << PY_RETURN) | (1L << PY_STRING) | (1L << VARIABLE) | (1L << VariableRef) | (1L << PY_NonEnd) | (1L << PY_TEXT) | (1L << PY_COMMENT) | (1L << PY_WS) | (1L << EXIT_SQL) | (1L << SQL_RETURN) | (1L << SQL_TEXT) | (1L << DDL) | (1L << DML) | (1L << Profile))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (SQL_COMMENT1 - 64)) | (1L << (SQL_COMMENT2 - 64)) | (1L << (SQL_COMMENT_BLOCK - 64)) | (1L << (CreatStatement - 64)) | (1L << (AlterStatement - 64)) | (1L << (DropStatement - 64)) | (1L << (RenameStatement - 64)) | (1L << (TruncateStatement - 64)) | (1L << (SelectStatement - 64)) | (1L << (InsertStatement - 64)) | (1L << (UpdateStatement - 64)) | (1L << (DeleteStatement - 64)) | (1L << (ReplaceStatement - 64)) | (1L << (UseStatement - 64)) | (1L << (ShowStatement - 64)) | (1L << (ExplainStatement - 64)) | (1L << (SetStatement - 64)) | (1L << (CallStatement - 64)) | (1L << (OpenStatement - 64)) | (1L << (CloseStatement - 64)) | (1L << (TransactionStatement - 64)) | (1L << (CommitStatement - 64)) | (1L << (RollbackStatement - 64)) | (1L << (SQL_WS - 64)) | (1L << (EXIT_SH - 64)) | (1L << (SH_RETURN - 64)) | (1L << (SH_STRING - 64)) | (1L << (SH_NonEnd - 64)) | (1L << (SHELL_TEXT - 64)) | (1L << (SEHLL_COMMENT - 64)) | (1L << (SH_WS - 64)))) != 0) );
				}
				break;
			case REGISTER:
				_localctx = new RegisterContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(183);
				match(REGISTER);
				setState(184);
				module();
				setState(185);
				match(DOT);
				setState(186);
				path();
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPTIONS || _la==WHERE) {
					{
					setState(187);
					whereExpressions();
					}
				}

				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(190);
					asAsset();
					}
				}

				}
				break;
			case RUN:
				_localctx = new RunContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(193);
				match(RUN);
				setState(194);
				module();
				setState(195);
				match(DOT);
				setState(196);
				path();
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPTIONS || _la==WHERE) {
					{
					setState(197);
					whereExpressions();
					}
				}

				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(200);
					asAsset();
					}
				}

				}
				break;
			case EXEC_TOKEN:
				_localctx = new CommandContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(203);
				match(EXEC_TOKEN);
				setState(204);
				module();
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOAD) | (1L << SAVE) | (1L << SELECT) | (1L << CONNECT) | (1L << SET) | (1L << CREATE) | (1L << DROP) | (1L << REGISTER) | (1L << RUN) | (1L << DOT) | (1L << COMMA) | (1L << GT) | (1L << LT) | (1L << HYPHEN) | (1L << UNDERLINE) | (1L << SLASH) | (1L << TILDE) | (1L << COLON) | (1L << ASTERISK) | (1L << VERTICAL_BAR) | (1L << MUMERIC) | (1L << IDENTIFIER) | (1L << QUOTED_TEXT) | (1L << STRING_TEXT) | (1L << BLOCK_STRING_TEXT))) != 0)) {
					{
					setState(205);
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
		enterRule(_localctx, 20, RULE_module);
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
		enterRule(_localctx, 22, RULE_format);
		try {
			setState(216);
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
				setState(214);
				identifier();
				}
				break;
			case QUOTED_TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(215);
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
		enterRule(_localctx, 24, RULE_path);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
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
		enterRule(_localctx, 26, RULE_col);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
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
		enterRule(_localctx, 28, RULE_colGroup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(COMMA);
			setState(223);
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
		enterRule(_localctx, 30, RULE_whereExpressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			where();
			setState(226);
			expression();
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(227);
				booleanExpression();
				}
				}
				setState(232);
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
		enterRule(_localctx, 32, RULE_partitionbyExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(PARTITIONBY);
			setState(234);
			col();
			setState(238);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(235);
				colGroup();
				}
				}
				setState(240);
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
		enterRule(_localctx, 34, RULE_booleanExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(AND);
			setState(242);
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
		enterRule(_localctx, 36, RULE_keyName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
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
		enterRule(_localctx, 38, RULE_valueName);
		try {
			setState(248);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(246);
				mumericValue();
				}
				break;
			case QUOTED_TEXT:
			case STRING_TEXT:
			case BLOCK_STRING_TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(247);
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
		enterRule(_localctx, 40, RULE_mumericValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
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
		enterRule(_localctx, 42, RULE_stringValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
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
		enterRule(_localctx, 44, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			keyName();
			setState(255);
			match(EQ);
			setState(256);
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
		enterRule(_localctx, 46, RULE_qualifiedName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			identifier();
			setState(263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(259);
				match(DOT);
				setState(260);
				identifier();
				}
				}
				setState(265);
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
		enterRule(_localctx, 48, RULE_asAsset);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			match(AS);
			setState(267);
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
		enterRule(_localctx, 50, RULE_assetName);
		try {
			setState(271);
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
				setState(269);
				identifier();
				}
				break;
			case QUOTED_TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(270);
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
		enterRule(_localctx, 52, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
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
		enterRule(_localctx, 54, RULE_quotedIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
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
		enterRule(_localctx, 56, RULE_where);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
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
		enterRule(_localctx, 58, RULE_saveMode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
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
		enterRule(_localctx, 60, RULE_outTable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			match(GT);
			setState(282);
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
		enterRule(_localctx, 62, RULE_commandSymbol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
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
		enterRule(_localctx, 64, RULE_commandParam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(291);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(286);
					commandSymbol();
					}
					break;
				case 2:
					{
					setState(287);
					identifier();
					}
					break;
				case 3:
					{
					setState(288);
					quotedIdentifier();
					}
					break;
				case 4:
					{
					setState(289);
					stringValue();
					}
					break;
				case 5:
					{
					setState(290);
					mumericValue();
					}
					break;
				}
				}
				setState(293); 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3`\u012a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\7\2F\n\2\f\2\16\2I\13\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\5\4T\n\4\3\4\5\4W\n\4\3\4\3\4\3\4\3\4\5\4]\n\4\3\4\5\4`\n\4\3\4"+
		"\3\4\3\4\3\4\5\4f\n\4\3\4\5\4i\n\4\5\4k\n\4\3\5\7\5n\n\5\f\5\16\5q\13"+
		"\5\3\6\3\6\3\7\7\7v\n\7\f\7\16\7y\13\7\3\b\3\b\3\t\7\t~\n\t\f\t\16\t\u0081"+
		"\13\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\5\13\u008a\n\13\3\13\3\13\3\13"+
		"\3\13\3\13\5\13\u0091\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u0098\n\13\3"+
		"\13\5\13\u009b\n\13\3\13\3\13\6\13\u009f\n\13\r\13\16\13\u00a0\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00ac\n\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\6\13\u00b6\n\13\r\13\16\13\u00b7\3\13\3\13\3"+
		"\13\3\13\3\13\5\13\u00bf\n\13\3\13\5\13\u00c2\n\13\3\13\3\13\3\13\3\13"+
		"\3\13\5\13\u00c9\n\13\3\13\5\13\u00cc\n\13\3\13\3\13\3\13\5\13\u00d1\n"+
		"\13\5\13\u00d3\n\13\3\f\3\f\5\f\u00d7\n\f\3\r\3\r\5\r\u00db\n\r\3\16\3"+
		"\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\7\21\u00e7\n\21\f\21\16\21"+
		"\u00ea\13\21\3\22\3\22\3\22\7\22\u00ef\n\22\f\22\16\22\u00f2\13\22\3\23"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\5\25\u00fb\n\25\3\26\3\26\3\27\3\27\3\30"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\7\31\u0108\n\31\f\31\16\31\u010b\13\31"+
		"\3\32\3\32\3\32\3\33\3\33\5\33\u0112\n\33\3\34\3\34\3\35\3\35\3\36\3\36"+
		"\3\37\3\37\3 \3 \3 \3!\3!\3\"\3\"\3\"\3\"\3\"\6\"\u0126\n\"\r\"\16\"\u0127"+
		"\3\"\2\2#\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66"+
		"8:<>@B\2\t\3\2((\3\2\25\26\3\2+-\6\2\b\n\23\24\27\32**\3\2\13\f\3\2\16"+
		"\21\4\2\34\34\36\'\2\u0136\2G\3\2\2\2\4J\3\2\2\2\6j\3\2\2\2\bo\3\2\2\2"+
		"\nr\3\2\2\2\fw\3\2\2\2\16z\3\2\2\2\20\177\3\2\2\2\22\u0082\3\2\2\2\24"+
		"\u00d2\3\2\2\2\26\u00d6\3\2\2\2\30\u00da\3\2\2\2\32\u00dc\3\2\2\2\34\u00de"+
		"\3\2\2\2\36\u00e0\3\2\2\2 \u00e3\3\2\2\2\"\u00eb\3\2\2\2$\u00f3\3\2\2"+
		"\2&\u00f6\3\2\2\2(\u00fa\3\2\2\2*\u00fc\3\2\2\2,\u00fe\3\2\2\2.\u0100"+
		"\3\2\2\2\60\u0104\3\2\2\2\62\u010c\3\2\2\2\64\u0111\3\2\2\2\66\u0113\3"+
		"\2\2\28\u0115\3\2\2\2:\u0117\3\2\2\2<\u0119\3\2\2\2>\u011b\3\2\2\2@\u011e"+
		"\3\2\2\2B\u0125\3\2\2\2DF\5\4\3\2ED\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2"+
		"\2\2H\3\3\2\2\2IG\3\2\2\2JK\5\6\4\2K\5\3\2\2\2LM\5\24\13\2MN\7(\2\2Nk"+
		"\3\2\2\2OP\7\3\2\2PQ\5\b\5\2QS\7\63\2\2RT\7\61\2\2SR\3\2\2\2ST\3\2\2\2"+
		"TV\3\2\2\2UW\5> \2VU\3\2\2\2VW\3\2\2\2Wk\3\2\2\2XY\7\4\2\2YZ\5\f\7\2Z"+
		"\\\7<\2\2[]\7\61\2\2\\[\3\2\2\2\\]\3\2\2\2]_\3\2\2\2^`\5> \2_^\3\2\2\2"+
		"_`\3\2\2\2`k\3\2\2\2ab\7\5\2\2bc\5\20\t\2ce\7Z\2\2df\7\61\2\2ed\3\2\2"+
		"\2ef\3\2\2\2fh\3\2\2\2gi\5> \2hg\3\2\2\2hi\3\2\2\2ik\3\2\2\2jL\3\2\2\2"+
		"jO\3\2\2\2jX\3\2\2\2ja\3\2\2\2k\7\3\2\2\2ln\5\n\6\2ml\3\2\2\2nq\3\2\2"+
		"\2om\3\2\2\2op\3\2\2\2p\t\3\2\2\2qo\3\2\2\2rs\79\2\2s\13\3\2\2\2tv\5\16"+
		"\b\2ut\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2x\r\3\2\2\2yw\3\2\2\2z{\7"+
		">\2\2{\17\3\2\2\2|~\5\22\n\2}|\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2\177"+
		"\u0080\3\2\2\2\u0080\21\3\2\2\2\u0081\177\3\2\2\2\u0082\u0083\7^\2\2\u0083"+
		"\23\3\2\2\2\u0084\u0085\7\b\2\2\u0085\u0086\5\30\r\2\u0086\u0087\7\34"+
		"\2\2\u0087\u0089\5\32\16\2\u0088\u008a\5 \21\2\u0089\u0088\3\2\2\2\u0089"+
		"\u008a\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\5\62\32\2\u008c\u00d3\3"+
		"\2\2\2\u008d\u008e\7\t\2\2\u008e\u0090\5\64\33\2\u008f\u0091\5<\37\2\u0090"+
		"\u008f\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\7\7"+
		"\2\2\u0093\u0094\5\30\r\2\u0094\u0095\7\34\2\2\u0095\u0097\5\32\16\2\u0096"+
		"\u0098\5 \21\2\u0097\u0096\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009a\3\2"+
		"\2\2\u0099\u009b\5\"\22\2\u009a\u0099\3\2\2\2\u009a\u009b\3\2\2\2\u009b"+
		"\u00d3\3\2\2\2\u009c\u009e\7\n\2\2\u009d\u009f\n\2\2\2\u009e\u009d\3\2"+
		"\2\2\u009f\u00a0\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1"+
		"\u00a2\3\2\2\2\u00a2\u00d3\5\62\32\2\u00a3\u00a4\7\23\2\2\u00a4\u00a5"+
		"\5\30\r\2\u00a5\u00a6\5 \21\2\u00a6\u00a7\5\62\32\2\u00a7\u00d3\3\2\2"+
		"\2\u00a8\u00a9\7\24\2\2\u00a9\u00ab\5.\30\2\u00aa\u00ac\5 \21\2\u00ab"+
		"\u00aa\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00d3\3\2\2\2\u00ad\u00ae\7\30"+
		"\2\2\u00ae\u00af\t\3\2\2\u00af\u00b0\5\30\r\2\u00b0\u00b1\7\34\2\2\u00b1"+
		"\u00b2\5\64\33\2\u00b2\u00d3\3\2\2\2\u00b3\u00b5\7\27\2\2\u00b4\u00b6"+
		"\n\2\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7"+
		"\u00b8\3\2\2\2\u00b8\u00d3\3\2\2\2\u00b9\u00ba\7\31\2\2\u00ba\u00bb\5"+
		"\26\f\2\u00bb\u00bc\7\34\2\2\u00bc\u00be\5\32\16\2\u00bd\u00bf\5 \21\2"+
		"\u00be\u00bd\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c1\3\2\2\2\u00c0\u00c2"+
		"\5\62\32\2\u00c1\u00c0\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00d3\3\2\2\2"+
		"\u00c3\u00c4\7\32\2\2\u00c4\u00c5\5\26\f\2\u00c5\u00c6\7\34\2\2\u00c6"+
		"\u00c8\5\32\16\2\u00c7\u00c9\5 \21\2\u00c8\u00c7\3\2\2\2\u00c8\u00c9\3"+
		"\2\2\2\u00c9\u00cb\3\2\2\2\u00ca\u00cc\5\62\32\2\u00cb\u00ca\3\2\2\2\u00cb"+
		"\u00cc\3\2\2\2\u00cc\u00d3\3\2\2\2\u00cd\u00ce\7\33\2\2\u00ce\u00d0\5"+
		"\26\f\2\u00cf\u00d1\5B\"\2\u00d0\u00cf\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1"+
		"\u00d3\3\2\2\2\u00d2\u0084\3\2\2\2\u00d2\u008d\3\2\2\2\u00d2\u009c\3\2"+
		"\2\2\u00d2\u00a3\3\2\2\2\u00d2\u00a8\3\2\2\2\u00d2\u00ad\3\2\2\2\u00d2"+
		"\u00b3\3\2\2\2\u00d2\u00b9\3\2\2\2\u00d2\u00c3\3\2\2\2\u00d2\u00cd\3\2"+
		"\2\2\u00d3\25\3\2\2\2\u00d4\u00d7\5\66\34\2\u00d5\u00d7\58\35\2\u00d6"+
		"\u00d4\3\2\2\2\u00d6\u00d5\3\2\2\2\u00d7\27\3\2\2\2\u00d8\u00db\5\66\34"+
		"\2\u00d9\u00db\58\35\2\u00da\u00d8\3\2\2\2\u00da\u00d9\3\2\2\2\u00db\31"+
		"\3\2\2\2\u00dc\u00dd\58\35\2\u00dd\33\3\2\2\2\u00de\u00df\5\66\34\2\u00df"+
		"\35\3\2\2\2\u00e0\u00e1\7\36\2\2\u00e1\u00e2\5\34\17\2\u00e2\37\3\2\2"+
		"\2\u00e3\u00e4\5:\36\2\u00e4\u00e8\5.\30\2\u00e5\u00e7\5$\23\2\u00e6\u00e5"+
		"\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9"+
		"!\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb\u00ec\7\22\2\2\u00ec\u00f0\5\34\17"+
		"\2\u00ed\u00ef\5\36\20\2\u00ee\u00ed\3\2\2\2\u00ef\u00f2\3\2\2\2\u00f0"+
		"\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1#\3\2\2\2\u00f2\u00f0\3\2\2\2"+
		"\u00f3\u00f4\7\r\2\2\u00f4\u00f5\5.\30\2\u00f5%\3\2\2\2\u00f6\u00f7\5"+
		"\60\31\2\u00f7\'\3\2\2\2\u00f8\u00fb\5*\26\2\u00f9\u00fb\5,\27\2\u00fa"+
		"\u00f8\3\2\2\2\u00fa\u00f9\3\2\2\2\u00fb)\3\2\2\2\u00fc\u00fd\7)\2\2\u00fd"+
		"+\3\2\2\2\u00fe\u00ff\t\4\2\2\u00ff-\3\2\2\2\u0100\u0101\5&\24\2\u0101"+
		"\u0102\7\35\2\2\u0102\u0103\5(\25\2\u0103/\3\2\2\2\u0104\u0109\5\66\34"+
		"\2\u0105\u0106\7\34\2\2\u0106\u0108\5\66\34\2\u0107\u0105\3\2\2\2\u0108"+
		"\u010b\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a\61\3\2\2"+
		"\2\u010b\u0109\3\2\2\2\u010c\u010d\7\6\2\2\u010d\u010e\5\64\33\2\u010e"+
		"\63\3\2\2\2\u010f\u0112\5\66\34\2\u0110\u0112\58\35\2\u0111\u010f\3\2"+
		"\2\2\u0111\u0110\3\2\2\2\u0112\65\3\2\2\2\u0113\u0114\t\5\2\2\u0114\67"+
		"\3\2\2\2\u0115\u0116\7+\2\2\u01169\3\2\2\2\u0117\u0118\t\6\2\2\u0118;"+
		"\3\2\2\2\u0119\u011a\t\7\2\2\u011a=\3\2\2\2\u011b\u011c\7\37\2\2\u011c"+
		"\u011d\5\64\33\2\u011d?\3\2\2\2\u011e\u011f\t\b\2\2\u011fA\3\2\2\2\u0120"+
		"\u0126\5@!\2\u0121\u0126\5\66\34\2\u0122\u0126\58\35\2\u0123\u0126\5,"+
		"\27\2\u0124\u0126\5*\26\2\u0125\u0120\3\2\2\2\u0125\u0121\3\2\2\2\u0125"+
		"\u0122\3\2\2\2\u0125\u0123\3\2\2\2\u0125\u0124\3\2\2\2\u0126\u0127\3\2"+
		"\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128C\3\2\2\2#GSV\\_ehj"+
		"ow\177\u0089\u0090\u0097\u009a\u00a0\u00ab\u00b7\u00be\u00c1\u00c8\u00cb"+
		"\u00d0\u00d2\u00d6\u00da\u00e8\u00f0\u00fa\u0109\u0111\u0125\u0127";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}