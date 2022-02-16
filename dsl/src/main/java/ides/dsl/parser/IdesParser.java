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
		CREATE=21, DROP=22, REGISTER=23, RUN=24, DOT=25, EQ=26, COMMA=27, OUT=28, 
		EOQ=29, MUMERIC=30, IDENTIFIER=31, QUOTED_TEXT=32, STRING_TEXT=33, BLOCK_STRING_TEXT=34, 
		WS=35, LINE_COMMENT=36, BLOCK_COMMENT=37, NL=38, UNRECOGNIZED=39, EXIT_PY=40, 
		PY_RETURN=41, PY_STRING=42, VARIABLE=43, VariableRef=44, PY_NonEnd=45, 
		PY_TEXT=46, PY_COMMENT=47, PY_WS=48, EXIT_SQL=49, SQL_RETURN=50, SQL_TEXT=51, 
		DDL=52, DML=53, Profile=54, SQL_COMMENT1=55, SQL_COMMENT2=56, SQL_COMMENT_BLOCK=57, 
		CreatStatement=58, AlterStatement=59, DropStatement=60, RenameStatement=61, 
		TruncateStatement=62, SelectStatement=63, InsertStatement=64, UpdateStatement=65, 
		DeleteStatement=66, ReplaceStatement=67, UseStatement=68, ShowStatement=69, 
		ExplainStatement=70, SetStatement=71, CallStatement=72, OpenStatement=73, 
		CloseStatement=74, TransactionStatement=75, CommitStatement=76, RollbackStatement=77, 
		SQL_WS=78, EXIT_SH=79, SH_RETURN=80, SH_STRING=81, SH_NonEnd=82, SHELL_TEXT=83, 
		SEHLL_COMMENT=84, SH_WS=85;
	public static final int
		RULE_statement = 0, RULE_script = 1, RULE_pythonCode = 2, RULE_pyStatement = 3, 
		RULE_sqlCode = 4, RULE_sqlStatement = 5, RULE_shellCode = 6, RULE_shellStatement = 7, 
		RULE_query = 8, RULE_module = 9, RULE_format = 10, RULE_path = 11, RULE_col = 12, 
		RULE_colGroup = 13, RULE_whereExpressions = 14, RULE_partitionbyExpression = 15, 
		RULE_booleanExpression = 16, RULE_keyName = 17, RULE_valueName = 18, RULE_expression = 19, 
		RULE_qualifiedName = 20, RULE_asAsset = 21, RULE_assetName = 22, RULE_identifier = 23, 
		RULE_quotedIdentifier = 24, RULE_where = 25, RULE_saveMode = 26, RULE_outTable = 27;
	private static String[] makeRuleNames() {
		return new String[] {
			"statement", "script", "pythonCode", "pyStatement", "sqlCode", "sqlStatement", 
			"shellCode", "shellStatement", "query", "module", "format", "path", "col", 
			"colGroup", "whereExpressions", "partitionbyExpression", "booleanExpression", 
			"keyName", "valueName", "expression", "qualifiedName", "asAsset", "assetName", 
			"identifier", "quotedIdentifier", "where", "saveMode", "outTable"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'as'", "'into'", "'load'", "'save'", "'select'", 
			"'options'", "'where'", "'and'", "'overwrite'", "'append'", "'errorIfExists'", 
			"'ignore'", null, "'connect'", "'set'", "'connection'", "'function'", 
			"'create'", "'drop'", "'register'", "'run'", "'.'", "'='", "','", "'>'", 
			"';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PY_MODE", "SQL_MODE", "SHELL_MODE", "AS", "INTO", "LOAD", "SAVE", 
			"SELECT", "OPTIONS", "WHERE", "AND", "OVERWRITE", "APPEND", "ERRORIfExists", 
			"IGNORE", "PARTITIONBY", "CONNECT", "SET", "CONNECTION", "FUNCTION", 
			"CREATE", "DROP", "REGISTER", "RUN", "DOT", "EQ", "COMMA", "OUT", "EOQ", 
			"MUMERIC", "IDENTIFIER", "QUOTED_TEXT", "STRING_TEXT", "BLOCK_STRING_TEXT", 
			"WS", "LINE_COMMENT", "BLOCK_COMMENT", "NL", "UNRECOGNIZED", "EXIT_PY", 
			"PY_RETURN", "PY_STRING", "VARIABLE", "VariableRef", "PY_NonEnd", "PY_TEXT", 
			"PY_COMMENT", "PY_WS", "EXIT_SQL", "SQL_RETURN", "SQL_TEXT", "DDL", "DML", 
			"Profile", "SQL_COMMENT1", "SQL_COMMENT2", "SQL_COMMENT_BLOCK", "CreatStatement", 
			"AlterStatement", "DropStatement", "RenameStatement", "TruncateStatement", 
			"SelectStatement", "InsertStatement", "UpdateStatement", "DeleteStatement", 
			"ReplaceStatement", "UseStatement", "ShowStatement", "ExplainStatement", 
			"SetStatement", "CallStatement", "OpenStatement", "CloseStatement", "TransactionStatement", 
			"CommitStatement", "RollbackStatement", "SQL_WS", "EXIT_SH", "SH_RETURN", 
			"SH_STRING", "SH_NonEnd", "SHELL_TEXT", "SEHLL_COMMENT", "SH_WS"
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
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PY_MODE) | (1L << SQL_MODE) | (1L << SHELL_MODE) | (1L << LOAD) | (1L << SAVE) | (1L << SELECT) | (1L << CONNECT) | (1L << SET) | (1L << CREATE) | (1L << DROP) | (1L << REGISTER) | (1L << RUN))) != 0)) {
				{
				{
				setState(56);
				script();
				}
				}
				setState(61);
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
			setState(92);
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
				_localctx = new IqlContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				query();
				setState(63);
				match(EOQ);
				}
				break;
			case PY_MODE:
				_localctx = new PyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				match(PY_MODE);
				setState(66);
				pythonCode();
				setState(67);
				match(EXIT_PY);
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(68);
					match(NL);
					}
				}

				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUT) {
					{
					setState(71);
					outTable();
					}
				}

				}
				break;
			case SQL_MODE:
				_localctx = new SqlContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				match(SQL_MODE);
				setState(75);
				sqlCode();
				setState(76);
				match(EXIT_SQL);
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(77);
					match(NL);
					}
				}

				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUT) {
					{
					setState(80);
					outTable();
					}
				}

				}
				break;
			case SHELL_MODE:
				_localctx = new ShContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(83);
				match(SHELL_MODE);
				setState(84);
				shellCode();
				setState(85);
				match(EXIT_SH);
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(86);
					match(NL);
					}
				}

				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUT) {
					{
					setState(89);
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
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PY_TEXT) {
				{
				{
				setState(94);
				pyStatement();
				}
				}
				setState(99);
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
			setState(100);
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
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SQL_TEXT) {
				{
				{
				setState(102);
				sqlStatement();
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
			setState(108);
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
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SHELL_TEXT) {
				{
				{
				setState(110);
				shellStatement();
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
			setState(116);
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
			setState(191);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LOAD:
				_localctx = new LoadContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				match(LOAD);
				setState(119);
				format();
				setState(120);
				match(DOT);
				setState(121);
				path();
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPTIONS || _la==WHERE) {
					{
					setState(122);
					whereExpressions();
					}
				}

				setState(125);
				asAsset();
				}
				break;
			case SAVE:
				_localctx = new SaveContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				match(SAVE);
				setState(128);
				assetName();
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OVERWRITE) | (1L << APPEND) | (1L << ERRORIfExists) | (1L << IGNORE))) != 0)) {
					{
					setState(129);
					saveMode();
					}
				}

				setState(132);
				match(INTO);
				setState(133);
				format();
				setState(134);
				match(DOT);
				setState(135);
				path();
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPTIONS || _la==WHERE) {
					{
					setState(136);
					whereExpressions();
					}
				}

				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITIONBY) {
					{
					setState(139);
					partitionbyExpression();
					}
				}

				}
				break;
			case SELECT:
				_localctx = new SelectContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(142);
				match(SELECT);
				setState(144); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(143);
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
					setState(146); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(148);
				asAsset();
				}
				break;
			case CONNECT:
				_localctx = new ConnectContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(149);
				match(CONNECT);
				setState(150);
				format();
				setState(151);
				whereExpressions();
				setState(152);
				asAsset();
				}
				break;
			case SET:
				_localctx = new SetContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(154);
				match(SET);
				setState(155);
				expression();
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPTIONS || _la==WHERE) {
					{
					setState(156);
					whereExpressions();
					}
				}

				}
				break;
			case DROP:
				_localctx = new DropContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(159);
				match(DROP);
				setState(160);
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
				setState(161);
				format();
				setState(162);
				match(DOT);
				setState(163);
				assetName();
				}
				break;
			case CREATE:
				_localctx = new CreateContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(165);
				match(CREATE);
				setState(167); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(166);
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
					setState(169); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PY_MODE) | (1L << SQL_MODE) | (1L << SHELL_MODE) | (1L << AS) | (1L << INTO) | (1L << LOAD) | (1L << SAVE) | (1L << SELECT) | (1L << OPTIONS) | (1L << WHERE) | (1L << AND) | (1L << OVERWRITE) | (1L << APPEND) | (1L << ERRORIfExists) | (1L << IGNORE) | (1L << PARTITIONBY) | (1L << CONNECT) | (1L << SET) | (1L << CONNECTION) | (1L << FUNCTION) | (1L << CREATE) | (1L << DROP) | (1L << REGISTER) | (1L << RUN) | (1L << DOT) | (1L << EQ) | (1L << COMMA) | (1L << OUT) | (1L << MUMERIC) | (1L << IDENTIFIER) | (1L << QUOTED_TEXT) | (1L << STRING_TEXT) | (1L << BLOCK_STRING_TEXT) | (1L << WS) | (1L << LINE_COMMENT) | (1L << BLOCK_COMMENT) | (1L << NL) | (1L << UNRECOGNIZED) | (1L << EXIT_PY) | (1L << PY_RETURN) | (1L << PY_STRING) | (1L << VARIABLE) | (1L << VariableRef) | (1L << PY_NonEnd) | (1L << PY_TEXT) | (1L << PY_COMMENT) | (1L << PY_WS) | (1L << EXIT_SQL) | (1L << SQL_RETURN) | (1L << SQL_TEXT) | (1L << DDL) | (1L << DML) | (1L << Profile) | (1L << SQL_COMMENT1) | (1L << SQL_COMMENT2) | (1L << SQL_COMMENT_BLOCK) | (1L << CreatStatement) | (1L << AlterStatement) | (1L << DropStatement) | (1L << RenameStatement) | (1L << TruncateStatement) | (1L << SelectStatement))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (InsertStatement - 64)) | (1L << (UpdateStatement - 64)) | (1L << (DeleteStatement - 64)) | (1L << (ReplaceStatement - 64)) | (1L << (UseStatement - 64)) | (1L << (ShowStatement - 64)) | (1L << (ExplainStatement - 64)) | (1L << (SetStatement - 64)) | (1L << (CallStatement - 64)) | (1L << (OpenStatement - 64)) | (1L << (CloseStatement - 64)) | (1L << (TransactionStatement - 64)) | (1L << (CommitStatement - 64)) | (1L << (RollbackStatement - 64)) | (1L << (SQL_WS - 64)) | (1L << (EXIT_SH - 64)) | (1L << (SH_RETURN - 64)) | (1L << (SH_STRING - 64)) | (1L << (SH_NonEnd - 64)) | (1L << (SHELL_TEXT - 64)) | (1L << (SEHLL_COMMENT - 64)) | (1L << (SH_WS - 64)))) != 0) );
				}
				break;
			case REGISTER:
				_localctx = new RegisterContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(171);
				match(REGISTER);
				setState(172);
				module();
				setState(173);
				match(DOT);
				setState(174);
				path();
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPTIONS || _la==WHERE) {
					{
					setState(175);
					whereExpressions();
					}
				}

				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(178);
					asAsset();
					}
				}

				}
				break;
			case RUN:
				_localctx = new RunContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(181);
				match(RUN);
				setState(182);
				module();
				setState(183);
				match(DOT);
				setState(184);
				path();
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPTIONS || _la==WHERE) {
					{
					setState(185);
					whereExpressions();
					}
				}

				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(188);
					asAsset();
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
			setState(195);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				identifier();
				}
				break;
			case QUOTED_TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(194);
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
			setState(199);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(197);
				identifier();
				}
				break;
			case QUOTED_TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(198);
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
			setState(201);
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
			setState(203);
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
			setState(205);
			match(COMMA);
			setState(206);
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
			setState(208);
			where();
			setState(209);
			expression();
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(210);
				booleanExpression();
				}
				}
				setState(215);
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
			setState(216);
			match(PARTITIONBY);
			setState(217);
			col();
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(218);
				colGroup();
				}
				}
				setState(223);
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
			setState(224);
			match(AND);
			setState(225);
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
			setState(227);
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
		public TerminalNode MUMERIC() { return getToken(IdesParser.MUMERIC, 0); }
		public TerminalNode STRING_TEXT() { return getToken(IdesParser.STRING_TEXT, 0); }
		public TerminalNode BLOCK_STRING_TEXT() { return getToken(IdesParser.BLOCK_STRING_TEXT, 0); }
		public TerminalNode QUOTED_TEXT() { return getToken(IdesParser.QUOTED_TEXT, 0); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUMERIC) | (1L << QUOTED_TEXT) | (1L << STRING_TEXT) | (1L << BLOCK_STRING_TEXT))) != 0)) ) {
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
		enterRule(_localctx, 38, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			keyName();
			setState(232);
			match(EQ);
			setState(233);
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
		enterRule(_localctx, 40, RULE_qualifiedName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			identifier();
			setState(240);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(236);
				match(DOT);
				setState(237);
				identifier();
				}
				}
				setState(242);
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
		enterRule(_localctx, 42, RULE_asAsset);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			match(AS);
			setState(244);
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
		enterRule(_localctx, 44, RULE_assetName);
		try {
			setState(248);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(246);
				identifier();
				}
				break;
			case QUOTED_TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(247);
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
		enterRule(_localctx, 46, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(IDENTIFIER);
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
		enterRule(_localctx, 48, RULE_quotedIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
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
		enterRule(_localctx, 50, RULE_where);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
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
		enterRule(_localctx, 52, RULE_saveMode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
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
		public TerminalNode OUT() { return getToken(IdesParser.OUT, 0); }
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
		enterRule(_localctx, 54, RULE_outTable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			match(OUT);
			setState(259);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3W\u0108\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\7\2<\n\2\f\2\16\2?\13\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3H\n\3\3\3\5\3K\n\3\3\3\3\3\3\3\3\3\5\3Q"+
		"\n\3\3\3\5\3T\n\3\3\3\3\3\3\3\3\3\5\3Z\n\3\3\3\5\3]\n\3\5\3_\n\3\3\4\7"+
		"\4b\n\4\f\4\16\4e\13\4\3\5\3\5\3\6\7\6j\n\6\f\6\16\6m\13\6\3\7\3\7\3\b"+
		"\7\br\n\b\f\b\16\bu\13\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\5\n~\n\n\3\n\3\n"+
		"\3\n\3\n\3\n\5\n\u0085\n\n\3\n\3\n\3\n\3\n\3\n\5\n\u008c\n\n\3\n\5\n\u008f"+
		"\n\n\3\n\3\n\6\n\u0093\n\n\r\n\16\n\u0094\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\5\n\u00a0\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\6\n\u00aa\n\n\r"+
		"\n\16\n\u00ab\3\n\3\n\3\n\3\n\3\n\5\n\u00b3\n\n\3\n\5\n\u00b6\n\n\3\n"+
		"\3\n\3\n\3\n\3\n\5\n\u00bd\n\n\3\n\5\n\u00c0\n\n\5\n\u00c2\n\n\3\13\3"+
		"\13\5\13\u00c6\n\13\3\f\3\f\5\f\u00ca\n\f\3\r\3\r\3\16\3\16\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\7\20\u00d6\n\20\f\20\16\20\u00d9\13\20\3\21\3\21"+
		"\3\21\7\21\u00de\n\21\f\21\16\21\u00e1\13\21\3\22\3\22\3\22\3\23\3\23"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\7\26\u00f1\n\26\f\26\16"+
		"\26\u00f4\13\26\3\27\3\27\3\27\3\30\3\30\5\30\u00fb\n\30\3\31\3\31\3\32"+
		"\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\35\2\2\36\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668\2\7\3\2\37\37\3\2\25\26\4"+
		"\2  \"$\3\2\13\f\3\2\16\21\2\u0111\2=\3\2\2\2\4^\3\2\2\2\6c\3\2\2\2\b"+
		"f\3\2\2\2\nk\3\2\2\2\fn\3\2\2\2\16s\3\2\2\2\20v\3\2\2\2\22\u00c1\3\2\2"+
		"\2\24\u00c5\3\2\2\2\26\u00c9\3\2\2\2\30\u00cb\3\2\2\2\32\u00cd\3\2\2\2"+
		"\34\u00cf\3\2\2\2\36\u00d2\3\2\2\2 \u00da\3\2\2\2\"\u00e2\3\2\2\2$\u00e5"+
		"\3\2\2\2&\u00e7\3\2\2\2(\u00e9\3\2\2\2*\u00ed\3\2\2\2,\u00f5\3\2\2\2."+
		"\u00fa\3\2\2\2\60\u00fc\3\2\2\2\62\u00fe\3\2\2\2\64\u0100\3\2\2\2\66\u0102"+
		"\3\2\2\28\u0104\3\2\2\2:<\5\4\3\2;:\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2"+
		"\2\2>\3\3\2\2\2?=\3\2\2\2@A\5\22\n\2AB\7\37\2\2B_\3\2\2\2CD\7\3\2\2DE"+
		"\5\6\4\2EG\7*\2\2FH\7(\2\2GF\3\2\2\2GH\3\2\2\2HJ\3\2\2\2IK\58\35\2JI\3"+
		"\2\2\2JK\3\2\2\2K_\3\2\2\2LM\7\4\2\2MN\5\n\6\2NP\7\63\2\2OQ\7(\2\2PO\3"+
		"\2\2\2PQ\3\2\2\2QS\3\2\2\2RT\58\35\2SR\3\2\2\2ST\3\2\2\2T_\3\2\2\2UV\7"+
		"\5\2\2VW\5\16\b\2WY\7Q\2\2XZ\7(\2\2YX\3\2\2\2YZ\3\2\2\2Z\\\3\2\2\2[]\5"+
		"8\35\2\\[\3\2\2\2\\]\3\2\2\2]_\3\2\2\2^@\3\2\2\2^C\3\2\2\2^L\3\2\2\2^"+
		"U\3\2\2\2_\5\3\2\2\2`b\5\b\5\2a`\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2"+
		"d\7\3\2\2\2ec\3\2\2\2fg\7\60\2\2g\t\3\2\2\2hj\5\f\7\2ih\3\2\2\2jm\3\2"+
		"\2\2ki\3\2\2\2kl\3\2\2\2l\13\3\2\2\2mk\3\2\2\2no\7\65\2\2o\r\3\2\2\2p"+
		"r\5\20\t\2qp\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2t\17\3\2\2\2us\3\2\2"+
		"\2vw\7U\2\2w\21\3\2\2\2xy\7\b\2\2yz\5\26\f\2z{\7\33\2\2{}\5\30\r\2|~\5"+
		"\36\20\2}|\3\2\2\2}~\3\2\2\2~\177\3\2\2\2\177\u0080\5,\27\2\u0080\u00c2"+
		"\3\2\2\2\u0081\u0082\7\t\2\2\u0082\u0084\5.\30\2\u0083\u0085\5\66\34\2"+
		"\u0084\u0083\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087"+
		"\7\7\2\2\u0087\u0088\5\26\f\2\u0088\u0089\7\33\2\2\u0089\u008b\5\30\r"+
		"\2\u008a\u008c\5\36\20\2\u008b\u008a\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\u008e\3\2\2\2\u008d\u008f\5 \21\2\u008e\u008d\3\2\2\2\u008e\u008f\3\2"+
		"\2\2\u008f\u00c2\3\2\2\2\u0090\u0092\7\n\2\2\u0091\u0093\n\2\2\2\u0092"+
		"\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2"+
		"\2\2\u0095\u0096\3\2\2\2\u0096\u00c2\5,\27\2\u0097\u0098\7\23\2\2\u0098"+
		"\u0099\5\26\f\2\u0099\u009a\5\36\20\2\u009a\u009b\5,\27\2\u009b\u00c2"+
		"\3\2\2\2\u009c\u009d\7\24\2\2\u009d\u009f\5(\25\2\u009e\u00a0\5\36\20"+
		"\2\u009f\u009e\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00c2\3\2\2\2\u00a1\u00a2"+
		"\7\30\2\2\u00a2\u00a3\t\3\2\2\u00a3\u00a4\5\26\f\2\u00a4\u00a5\7\33\2"+
		"\2\u00a5\u00a6\5.\30\2\u00a6\u00c2\3\2\2\2\u00a7\u00a9\7\27\2\2\u00a8"+
		"\u00aa\n\2\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00a9\3\2"+
		"\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00c2\3\2\2\2\u00ad\u00ae\7\31\2\2\u00ae"+
		"\u00af\5\24\13\2\u00af\u00b0\7\33\2\2\u00b0\u00b2\5\30\r\2\u00b1\u00b3"+
		"\5\36\20\2\u00b2\u00b1\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b5\3\2\2\2"+
		"\u00b4\u00b6\5,\27\2\u00b5\u00b4\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00c2"+
		"\3\2\2\2\u00b7\u00b8\7\32\2\2\u00b8\u00b9\5\24\13\2\u00b9\u00ba\7\33\2"+
		"\2\u00ba\u00bc\5\30\r\2\u00bb\u00bd\5\36\20\2\u00bc\u00bb\3\2\2\2\u00bc"+
		"\u00bd\3\2\2\2\u00bd\u00bf\3\2\2\2\u00be\u00c0\5,\27\2\u00bf\u00be\3\2"+
		"\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c2\3\2\2\2\u00c1x\3\2\2\2\u00c1\u0081"+
		"\3\2\2\2\u00c1\u0090\3\2\2\2\u00c1\u0097\3\2\2\2\u00c1\u009c\3\2\2\2\u00c1"+
		"\u00a1\3\2\2\2\u00c1\u00a7\3\2\2\2\u00c1\u00ad\3\2\2\2\u00c1\u00b7\3\2"+
		"\2\2\u00c2\23\3\2\2\2\u00c3\u00c6\5\60\31\2\u00c4\u00c6\5\62\32\2\u00c5"+
		"\u00c3\3\2\2\2\u00c5\u00c4\3\2\2\2\u00c6\25\3\2\2\2\u00c7\u00ca\5\60\31"+
		"\2\u00c8\u00ca\5\62\32\2\u00c9\u00c7\3\2\2\2\u00c9\u00c8\3\2\2\2\u00ca"+
		"\27\3\2\2\2\u00cb\u00cc\5\62\32\2\u00cc\31\3\2\2\2\u00cd\u00ce\5\60\31"+
		"\2\u00ce\33\3\2\2\2\u00cf\u00d0\7\35\2\2\u00d0\u00d1\5\32\16\2\u00d1\35"+
		"\3\2\2\2\u00d2\u00d3\5\64\33\2\u00d3\u00d7\5(\25\2\u00d4\u00d6\5\"\22"+
		"\2\u00d5\u00d4\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8"+
		"\3\2\2\2\u00d8\37\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da\u00db\7\22\2\2\u00db"+
		"\u00df\5\32\16\2\u00dc\u00de\5\34\17\2\u00dd\u00dc\3\2\2\2\u00de\u00e1"+
		"\3\2\2\2\u00df\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0!\3\2\2\2\u00e1"+
		"\u00df\3\2\2\2\u00e2\u00e3\7\r\2\2\u00e3\u00e4\5(\25\2\u00e4#\3\2\2\2"+
		"\u00e5\u00e6\5*\26\2\u00e6%\3\2\2\2\u00e7\u00e8\t\4\2\2\u00e8\'\3\2\2"+
		"\2\u00e9\u00ea\5$\23\2\u00ea\u00eb\7\34\2\2\u00eb\u00ec\5&\24\2\u00ec"+
		")\3\2\2\2\u00ed\u00f2\5\60\31\2\u00ee\u00ef\7\33\2\2\u00ef\u00f1\5\60"+
		"\31\2\u00f0\u00ee\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2"+
		"\u00f3\3\2\2\2\u00f3+\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f6\7\6\2\2"+
		"\u00f6\u00f7\5.\30\2\u00f7-\3\2\2\2\u00f8\u00fb\5\60\31\2\u00f9\u00fb"+
		"\5\62\32\2\u00fa\u00f8\3\2\2\2\u00fa\u00f9\3\2\2\2\u00fb/\3\2\2\2\u00fc"+
		"\u00fd\7!\2\2\u00fd\61\3\2\2\2\u00fe\u00ff\7\"\2\2\u00ff\63\3\2\2\2\u0100"+
		"\u0101\t\5\2\2\u0101\65\3\2\2\2\u0102\u0103\t\6\2\2\u0103\67\3\2\2\2\u0104"+
		"\u0105\7\36\2\2\u0105\u0106\5.\30\2\u01069\3\2\2\2\37=GJPSY\\^cks}\u0084"+
		"\u008b\u008e\u0094\u009f\u00ab\u00b2\u00b5\u00bc\u00bf\u00c1\u00c5\u00c9"+
		"\u00d7\u00df\u00f2\u00fa";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}