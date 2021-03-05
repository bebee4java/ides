// Generated from /Users/sgr/develop/github/ides/dsl/src/main/resources/IdesParser.g4 by ANTLR 4.7.2

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
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PY_MODE=1, SQL_MODE=2, SHELL_MODE=3, AS=4, INTO=5, LOAD=6, SAVE=7, SELECT=8, 
		OPTIONS=9, WHERE=10, AND=11, OVERWRITE=12, APPEND=13, ERRORIfExists=14, 
		IGNORE=15, PARTITIONBY=16, CONNECT=17, SET=18, DOT=19, EQ=20, COMMA=21, 
		OUT=22, EOQ=23, MUMERIC=24, IDENTIFIER=25, QUOTED_TEXT=26, STRING_TEXT=27, 
		BLOCK_STRING_TEXT=28, WS=29, LINE_COMMENT=30, BLOCK_COMMENT=31, NL=32, 
		UNRECOGNIZED=33, EXIT_PY=34, PY_RETURN=35, PY_STRING=36, VARIABLE=37, 
		VariableRef=38, PY_NonEnd=39, PY_TEXT=40, PY_COMMENT=41, PY_WS=42, EXIT_SQL=43, 
		SQL_RETURN=44, SQL_TEXT=45, DDL=46, DML=47, Profile=48, SQL_COMMENT1=49, 
		SQL_COMMENT2=50, SQL_COMMENT_BLOCK=51, CreatStatement=52, AlterStatement=53, 
		DropStatement=54, RenameStatement=55, TruncateStatement=56, SelectStatement=57, 
		InsertStatement=58, UpdateStatement=59, DeleteStatement=60, ReplaceStatement=61, 
		UseStatement=62, ShowStatement=63, ExplainStatement=64, SetStatement=65, 
		CallStatement=66, OpenStatement=67, CloseStatement=68, TransactionStatement=69, 
		CommitStatement=70, RollbackStatement=71, SQL_WS=72, EXIT_SH=73, SH_RETURN=74, 
		SH_STRING=75, SH_NonEnd=76, SHELL_TEXT=77, SEHLL_COMMENT=78, SH_WS=79;
	public static final int
		RULE_statement = 0, RULE_script = 1, RULE_pythonCode = 2, RULE_pyStatement = 3, 
		RULE_sqlCode = 4, RULE_sqlStatement = 5, RULE_shellCode = 6, RULE_shellStatement = 7, 
		RULE_query = 8, RULE_format = 9, RULE_path = 10, RULE_col = 11, RULE_colGroup = 12, 
		RULE_whereExpressions = 13, RULE_partitionbyExpression = 14, RULE_booleanExpression = 15, 
		RULE_keyName = 16, RULE_valueName = 17, RULE_expression = 18, RULE_qualifiedName = 19, 
		RULE_asAsset = 20, RULE_assetName = 21, RULE_identifier = 22, RULE_quotedIdentifier = 23, 
		RULE_where = 24, RULE_saveMode = 25, RULE_outTable = 26;
	private static String[] makeRuleNames() {
		return new String[] {
			"statement", "script", "pythonCode", "pyStatement", "sqlCode", "sqlStatement", 
			"shellCode", "shellStatement", "query", "format", "path", "col", "colGroup", 
			"whereExpressions", "partitionbyExpression", "booleanExpression", "keyName", 
			"valueName", "expression", "qualifiedName", "asAsset", "assetName", "identifier", 
			"quotedIdentifier", "where", "saveMode", "outTable"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'as'", "'into'", "'load'", "'save'", "'select'", 
			"'options'", "'where'", "'and'", "'overwrite'", "'append'", "'errorIfExists'", 
			"'ignore'", null, "'connect'", "'set'", "'.'", "'='", "','", "'>'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PY_MODE", "SQL_MODE", "SHELL_MODE", "AS", "INTO", "LOAD", "SAVE", 
			"SELECT", "OPTIONS", "WHERE", "AND", "OVERWRITE", "APPEND", "ERRORIfExists", 
			"IGNORE", "PARTITIONBY", "CONNECT", "SET", "DOT", "EQ", "COMMA", "OUT", 
			"EOQ", "MUMERIC", "IDENTIFIER", "QUOTED_TEXT", "STRING_TEXT", "BLOCK_STRING_TEXT", 
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
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PY_MODE) | (1L << SQL_MODE) | (1L << SHELL_MODE) | (1L << LOAD) | (1L << SAVE) | (1L << SELECT) | (1L << CONNECT) | (1L << SET))) != 0)) {
				{
				{
				setState(54);
				script();
				}
				}
				setState(59);
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
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LOAD:
			case SAVE:
			case SELECT:
			case CONNECT:
			case SET:
				_localctx = new IqlContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				query();
				setState(61);
				match(EOQ);
				}
				break;
			case PY_MODE:
				_localctx = new PyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				match(PY_MODE);
				setState(64);
				pythonCode();
				setState(65);
				match(EXIT_PY);
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(66);
					match(NL);
					}
				}

				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUT) {
					{
					setState(69);
					outTable();
					}
				}

				}
				break;
			case SQL_MODE:
				_localctx = new SqlContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(72);
				match(SQL_MODE);
				setState(73);
				sqlCode();
				setState(74);
				match(EXIT_SQL);
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(75);
					match(NL);
					}
				}

				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUT) {
					{
					setState(78);
					outTable();
					}
				}

				}
				break;
			case SHELL_MODE:
				_localctx = new ShContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(81);
				match(SHELL_MODE);
				setState(82);
				shellCode();
				setState(83);
				match(EXIT_SH);
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(84);
					match(NL);
					}
				}

				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUT) {
					{
					setState(87);
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
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PY_TEXT) {
				{
				{
				setState(92);
				pyStatement();
				}
				}
				setState(97);
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
			setState(98);
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
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SQL_TEXT) {
				{
				{
				setState(100);
				sqlStatement();
				}
				}
				setState(105);
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
			setState(106);
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
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SHELL_TEXT) {
				{
				{
				setState(108);
				shellStatement();
				}
				}
				setState(113);
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
			setState(114);
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

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_query);
		int _la;
		try {
			int _alt;
			setState(157);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LOAD:
				_localctx = new LoadContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				match(LOAD);
				setState(117);
				format();
				setState(118);
				match(DOT);
				setState(119);
				path();
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPTIONS || _la==WHERE) {
					{
					setState(120);
					whereExpressions();
					}
				}

				setState(123);
				asAsset();
				}
				break;
			case SAVE:
				_localctx = new SaveContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				match(SAVE);
				setState(126);
				assetName();
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OVERWRITE) | (1L << APPEND) | (1L << ERRORIfExists) | (1L << IGNORE))) != 0)) {
					{
					setState(127);
					saveMode();
					}
				}

				setState(130);
				match(INTO);
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

				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITIONBY) {
					{
					setState(137);
					partitionbyExpression();
					}
				}

				}
				break;
			case SELECT:
				_localctx = new SelectContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(140);
				match(SELECT);
				setState(142); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(141);
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
					setState(144); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(146);
				asAsset();
				}
				break;
			case CONNECT:
				_localctx = new ConnectContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(147);
				match(CONNECT);
				setState(148);
				format();
				setState(149);
				whereExpressions();
				setState(150);
				asAsset();
				}
				break;
			case SET:
				_localctx = new SetContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(152);
				match(SET);
				setState(153);
				expression();
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPTIONS || _la==WHERE) {
					{
					setState(154);
					whereExpressions();
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
		enterRule(_localctx, 18, RULE_format);
		try {
			setState(161);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				identifier();
				}
				break;
			case QUOTED_TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(160);
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
		enterRule(_localctx, 20, RULE_path);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
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
		enterRule(_localctx, 22, RULE_col);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
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
		enterRule(_localctx, 24, RULE_colGroup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(COMMA);
			setState(168);
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
		enterRule(_localctx, 26, RULE_whereExpressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			where();
			setState(171);
			expression();
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(172);
				booleanExpression();
				}
				}
				setState(177);
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
		enterRule(_localctx, 28, RULE_partitionbyExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(PARTITIONBY);
			setState(179);
			col();
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(180);
				colGroup();
				}
				}
				setState(185);
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
		enterRule(_localctx, 30, RULE_booleanExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(AND);
			setState(187);
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
		enterRule(_localctx, 32, RULE_keyName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
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
		enterRule(_localctx, 34, RULE_valueName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
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
		enterRule(_localctx, 36, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			keyName();
			setState(194);
			match(EQ);
			setState(195);
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
		enterRule(_localctx, 38, RULE_qualifiedName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			identifier();
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(198);
				match(DOT);
				setState(199);
				identifier();
				}
				}
				setState(204);
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
		enterRule(_localctx, 40, RULE_asAsset);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(AS);
			setState(206);
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
		enterRule(_localctx, 42, RULE_assetName);
		try {
			setState(210);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(208);
				identifier();
				}
				break;
			case QUOTED_TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(209);
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
		enterRule(_localctx, 44, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
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
		enterRule(_localctx, 46, RULE_quotedIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
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
		enterRule(_localctx, 48, RULE_where);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
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
		enterRule(_localctx, 50, RULE_saveMode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
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
		enterRule(_localctx, 52, RULE_outTable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(OUT);
			setState(221);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3Q\u00e2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\7\2:\n\2\f\2\16\2=\13\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\5\3F\n\3\3\3\5\3I\n\3\3\3\3\3\3\3\3\3\5\3O\n\3\3\3\5"+
		"\3R\n\3\3\3\3\3\3\3\3\3\5\3X\n\3\3\3\5\3[\n\3\5\3]\n\3\3\4\7\4`\n\4\f"+
		"\4\16\4c\13\4\3\5\3\5\3\6\7\6h\n\6\f\6\16\6k\13\6\3\7\3\7\3\b\7\bp\n\b"+
		"\f\b\16\bs\13\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\5\n|\n\n\3\n\3\n\3\n\3\n\3"+
		"\n\5\n\u0083\n\n\3\n\3\n\3\n\3\n\3\n\5\n\u008a\n\n\3\n\5\n\u008d\n\n\3"+
		"\n\3\n\6\n\u0091\n\n\r\n\16\n\u0092\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\5\n\u009e\n\n\5\n\u00a0\n\n\3\13\3\13\5\13\u00a4\n\13\3\f\3\f\3\r\3"+
		"\r\3\16\3\16\3\16\3\17\3\17\3\17\7\17\u00b0\n\17\f\17\16\17\u00b3\13\17"+
		"\3\20\3\20\3\20\7\20\u00b8\n\20\f\20\16\20\u00bb\13\20\3\21\3\21\3\21"+
		"\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\7\25\u00cb\n\25"+
		"\f\25\16\25\u00ce\13\25\3\26\3\26\3\26\3\27\3\27\5\27\u00d5\n\27\3\30"+
		"\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34\2\2\35\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66\2\6\3\2\31\31\4\2"+
		"\32\32\34\36\3\2\13\f\3\2\16\21\2\u00e2\2;\3\2\2\2\4\\\3\2\2\2\6a\3\2"+
		"\2\2\bd\3\2\2\2\ni\3\2\2\2\fl\3\2\2\2\16q\3\2\2\2\20t\3\2\2\2\22\u009f"+
		"\3\2\2\2\24\u00a3\3\2\2\2\26\u00a5\3\2\2\2\30\u00a7\3\2\2\2\32\u00a9\3"+
		"\2\2\2\34\u00ac\3\2\2\2\36\u00b4\3\2\2\2 \u00bc\3\2\2\2\"\u00bf\3\2\2"+
		"\2$\u00c1\3\2\2\2&\u00c3\3\2\2\2(\u00c7\3\2\2\2*\u00cf\3\2\2\2,\u00d4"+
		"\3\2\2\2.\u00d6\3\2\2\2\60\u00d8\3\2\2\2\62\u00da\3\2\2\2\64\u00dc\3\2"+
		"\2\2\66\u00de\3\2\2\28:\5\4\3\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2"+
		"\2<\3\3\2\2\2=;\3\2\2\2>?\5\22\n\2?@\7\31\2\2@]\3\2\2\2AB\7\3\2\2BC\5"+
		"\6\4\2CE\7$\2\2DF\7\"\2\2ED\3\2\2\2EF\3\2\2\2FH\3\2\2\2GI\5\66\34\2HG"+
		"\3\2\2\2HI\3\2\2\2I]\3\2\2\2JK\7\4\2\2KL\5\n\6\2LN\7-\2\2MO\7\"\2\2NM"+
		"\3\2\2\2NO\3\2\2\2OQ\3\2\2\2PR\5\66\34\2QP\3\2\2\2QR\3\2\2\2R]\3\2\2\2"+
		"ST\7\5\2\2TU\5\16\b\2UW\7K\2\2VX\7\"\2\2WV\3\2\2\2WX\3\2\2\2XZ\3\2\2\2"+
		"Y[\5\66\34\2ZY\3\2\2\2Z[\3\2\2\2[]\3\2\2\2\\>\3\2\2\2\\A\3\2\2\2\\J\3"+
		"\2\2\2\\S\3\2\2\2]\5\3\2\2\2^`\5\b\5\2_^\3\2\2\2`c\3\2\2\2a_\3\2\2\2a"+
		"b\3\2\2\2b\7\3\2\2\2ca\3\2\2\2de\7*\2\2e\t\3\2\2\2fh\5\f\7\2gf\3\2\2\2"+
		"hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2j\13\3\2\2\2ki\3\2\2\2lm\7/\2\2m\r\3\2\2"+
		"\2np\5\20\t\2on\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2r\17\3\2\2\2sq\3"+
		"\2\2\2tu\7O\2\2u\21\3\2\2\2vw\7\b\2\2wx\5\24\13\2xy\7\25\2\2y{\5\26\f"+
		"\2z|\5\34\17\2{z\3\2\2\2{|\3\2\2\2|}\3\2\2\2}~\5*\26\2~\u00a0\3\2\2\2"+
		"\177\u0080\7\t\2\2\u0080\u0082\5,\27\2\u0081\u0083\5\64\33\2\u0082\u0081"+
		"\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\7\7\2\2\u0085"+
		"\u0086\5\24\13\2\u0086\u0087\7\25\2\2\u0087\u0089\5\26\f\2\u0088\u008a"+
		"\5\34\17\2\u0089\u0088\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008c\3\2\2\2"+
		"\u008b\u008d\5\36\20\2\u008c\u008b\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u00a0"+
		"\3\2\2\2\u008e\u0090\7\n\2\2\u008f\u0091\n\2\2\2\u0090\u008f\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\3\2"+
		"\2\2\u0094\u00a0\5*\26\2\u0095\u0096\7\23\2\2\u0096\u0097\5\24\13\2\u0097"+
		"\u0098\5\34\17\2\u0098\u0099\5*\26\2\u0099\u00a0\3\2\2\2\u009a\u009b\7"+
		"\24\2\2\u009b\u009d\5&\24\2\u009c\u009e\5\34\17\2\u009d\u009c\3\2\2\2"+
		"\u009d\u009e\3\2\2\2\u009e\u00a0\3\2\2\2\u009fv\3\2\2\2\u009f\177\3\2"+
		"\2\2\u009f\u008e\3\2\2\2\u009f\u0095\3\2\2\2\u009f\u009a\3\2\2\2\u00a0"+
		"\23\3\2\2\2\u00a1\u00a4\5.\30\2\u00a2\u00a4\5\60\31\2\u00a3\u00a1\3\2"+
		"\2\2\u00a3\u00a2\3\2\2\2\u00a4\25\3\2\2\2\u00a5\u00a6\5\60\31\2\u00a6"+
		"\27\3\2\2\2\u00a7\u00a8\5.\30\2\u00a8\31\3\2\2\2\u00a9\u00aa\7\27\2\2"+
		"\u00aa\u00ab\5\30\r\2\u00ab\33\3\2\2\2\u00ac\u00ad\5\62\32\2\u00ad\u00b1"+
		"\5&\24\2\u00ae\u00b0\5 \21\2\u00af\u00ae\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1"+
		"\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\35\3\2\2\2\u00b3\u00b1\3\2\2"+
		"\2\u00b4\u00b5\7\22\2\2\u00b5\u00b9\5\30\r\2\u00b6\u00b8\5\32\16\2\u00b7"+
		"\u00b6\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2"+
		"\2\2\u00ba\37\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00bd\7\r\2\2\u00bd\u00be"+
		"\5&\24\2\u00be!\3\2\2\2\u00bf\u00c0\5(\25\2\u00c0#\3\2\2\2\u00c1\u00c2"+
		"\t\3\2\2\u00c2%\3\2\2\2\u00c3\u00c4\5\"\22\2\u00c4\u00c5\7\26\2\2\u00c5"+
		"\u00c6\5$\23\2\u00c6\'\3\2\2\2\u00c7\u00cc\5.\30\2\u00c8\u00c9\7\25\2"+
		"\2\u00c9\u00cb\5.\30\2\u00ca\u00c8\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca"+
		"\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd)\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf"+
		"\u00d0\7\6\2\2\u00d0\u00d1\5,\27\2\u00d1+\3\2\2\2\u00d2\u00d5\5.\30\2"+
		"\u00d3\u00d5\5\60\31\2\u00d4\u00d2\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5-"+
		"\3\2\2\2\u00d6\u00d7\7\33\2\2\u00d7/\3\2\2\2\u00d8\u00d9\7\34\2\2\u00d9"+
		"\61\3\2\2\2\u00da\u00db\t\4\2\2\u00db\63\3\2\2\2\u00dc\u00dd\t\5\2\2\u00dd"+
		"\65\3\2\2\2\u00de\u00df\7\30\2\2\u00df\u00e0\5,\27\2\u00e0\67\3\2\2\2"+
		"\31;EHNQWZ\\aiq{\u0082\u0089\u008c\u0092\u009d\u009f\u00a3\u00b1\u00b9"+
		"\u00cc\u00d4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}