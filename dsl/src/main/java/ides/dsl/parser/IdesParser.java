// Generated from IdesParser.g4 by ANTLR 4.7.1
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
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SCALA_MODE=1, PY_MODE=2, SQL_MODE=3, SHELL_MODE=4, AS=5, INTO=6, LOAD=7, 
		SAVE=8, SELECT=9, OPTIONS=10, WHERE=11, AND=12, OVERWRITE=13, APPEND=14, 
		ERRORIfExists=15, IGNORE=16, PARTITIONBY=17, CONNECT=18, SET=19, CONNECTION=20, 
		FUNCTION=21, CREATE=22, DROP=23, REGISTER=24, RUN=25, EXEC_TOKEN=26, DOT=27, 
		EQ=28, COMMA=29, GT=30, LT=31, HYPHEN=32, UNDERLINE=33, SLASH=34, TILDE=35, 
		COLON=36, ASTERISK=37, VERTICAL_BAR=38, EOQ=39, MUMERIC=40, IDENTIFIER=41, 
		QUOTED_TEXT=42, STRING_TEXT=43, BLOCK_STRING_TEXT=44, VARIABLE=45, WS=46, 
		LINE_COMMENT=47, BLOCK_COMMENT=48, NL=49, UNRECOGNIZED=50, EXIT_SCALA=51, 
		SCALA_RETURN=52, SCALA_STRING=53, SCALA_NonEnd=54, SCALA_IMPORT=55, SCALA_CLASS_SEGMENT=56, 
		SCALA_METHOD_SEGMENT=57, SCALA_BLOCK_BODY=58, SCALA_METHOD=59, SCALA_CLASS=60, 
		SCALA_TEXT=61, SCALA_COMMENT=62, SCALA_COMMENT_BLOCK=63, SCALA_WS=64, 
		EXIT_PY=65, PY_RETURN=66, PY_STRING=67, VariableRef=68, PY_NonEnd=69, 
		PY_TEXT=70, PY_COMMENT=71, PY_WS=72, EXIT_SQL=73, SQL_RETURN=74, SQL_TEXT=75, 
		DDL=76, DML=77, Profile=78, SQL_COMMENT1=79, SQL_COMMENT2=80, SQL_COMMENT_BLOCK=81, 
		CreatStatement=82, AlterStatement=83, DropStatement=84, RenameStatement=85, 
		TruncateStatement=86, SelectStatement=87, InsertStatement=88, UpdateStatement=89, 
		DeleteStatement=90, ReplaceStatement=91, UseStatement=92, ShowStatement=93, 
		ExplainStatement=94, SetStatement=95, CallStatement=96, OpenStatement=97, 
		CloseStatement=98, TransactionStatement=99, CommitStatement=100, RollbackStatement=101, 
		SQL_WS=102, EXIT_SH=103, SH_RETURN=104, SH_STRING=105, SH_NonEnd=106, 
		SHELL_TEXT=107, SEHLL_COMMENT=108, SH_WS=109;
	public static final int
		RULE_statement = 0, RULE_idesScript = 1, RULE_script = 2, RULE_scalaCode = 3, 
		RULE_scalaStatement = 4, RULE_pythonCode = 5, RULE_pyStatement = 6, RULE_sqlCode = 7, 
		RULE_sqlStatement = 8, RULE_shellCode = 9, RULE_shellStatement = 10, RULE_query = 11, 
		RULE_module = 12, RULE_format = 13, RULE_path = 14, RULE_col = 15, RULE_colGroup = 16, 
		RULE_whereExpressions = 17, RULE_partitionbyExpression = 18, RULE_booleanExpression = 19, 
		RULE_keyName = 20, RULE_valueName = 21, RULE_mumericValue = 22, RULE_stringValue = 23, 
		RULE_expression = 24, RULE_qualifiedName = 25, RULE_asAsset = 26, RULE_assetName = 27, 
		RULE_identifier = 28, RULE_quotedIdentifier = 29, RULE_where = 30, RULE_saveMode = 31, 
		RULE_outTable = 32, RULE_commandSymbol = 33, RULE_commandParam = 34;
	public static final String[] ruleNames = {
		"statement", "idesScript", "script", "scalaCode", "scalaStatement", "pythonCode", 
		"pyStatement", "sqlCode", "sqlStatement", "shellCode", "shellStatement", 
		"query", "module", "format", "path", "col", "colGroup", "whereExpressions", 
		"partitionbyExpression", "booleanExpression", "keyName", "valueName", 
		"mumericValue", "stringValue", "expression", "qualifiedName", "asAsset", 
		"assetName", "identifier", "quotedIdentifier", "where", "saveMode", "outTable", 
		"commandSymbol", "commandParam"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, "'as'", "'into'", "'load'", "'save'", "'select'", 
		"'options'", "'where'", "'and'", "'overwrite'", "'append'", "'errorIfExists'", 
		"'ignore'", null, "'connect'", "'set'", "'connection'", "'function'", 
		"'create'", "'drop'", "'register'", "'run'", "'!'", "'.'", "'='", "','", 
		"'>'", "'<'", "'-'", "'_'", "'/'", "'~'", "':'", "'*'", "'|'", "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SCALA_MODE", "PY_MODE", "SQL_MODE", "SHELL_MODE", "AS", "INTO", 
		"LOAD", "SAVE", "SELECT", "OPTIONS", "WHERE", "AND", "OVERWRITE", "APPEND", 
		"ERRORIfExists", "IGNORE", "PARTITIONBY", "CONNECT", "SET", "CONNECTION", 
		"FUNCTION", "CREATE", "DROP", "REGISTER", "RUN", "EXEC_TOKEN", "DOT", 
		"EQ", "COMMA", "GT", "LT", "HYPHEN", "UNDERLINE", "SLASH", "TILDE", "COLON", 
		"ASTERISK", "VERTICAL_BAR", "EOQ", "MUMERIC", "IDENTIFIER", "QUOTED_TEXT", 
		"STRING_TEXT", "BLOCK_STRING_TEXT", "VARIABLE", "WS", "LINE_COMMENT", 
		"BLOCK_COMMENT", "NL", "UNRECOGNIZED", "EXIT_SCALA", "SCALA_RETURN", "SCALA_STRING", 
		"SCALA_NonEnd", "SCALA_IMPORT", "SCALA_CLASS_SEGMENT", "SCALA_METHOD_SEGMENT", 
		"SCALA_BLOCK_BODY", "SCALA_METHOD", "SCALA_CLASS", "SCALA_TEXT", "SCALA_COMMENT", 
		"SCALA_COMMENT_BLOCK", "SCALA_WS", "EXIT_PY", "PY_RETURN", "PY_STRING", 
		"VariableRef", "PY_NonEnd", "PY_TEXT", "PY_COMMENT", "PY_WS", "EXIT_SQL", 
		"SQL_RETURN", "SQL_TEXT", "DDL", "DML", "Profile", "SQL_COMMENT1", "SQL_COMMENT2", 
		"SQL_COMMENT_BLOCK", "CreatStatement", "AlterStatement", "DropStatement", 
		"RenameStatement", "TruncateStatement", "SelectStatement", "InsertStatement", 
		"UpdateStatement", "DeleteStatement", "ReplaceStatement", "UseStatement", 
		"ShowStatement", "ExplainStatement", "SetStatement", "CallStatement", 
		"OpenStatement", "CloseStatement", "TransactionStatement", "CommitStatement", 
		"RollbackStatement", "SQL_WS", "EXIT_SH", "SH_RETURN", "SH_STRING", "SH_NonEnd", 
		"SHELL_TEXT", "SEHLL_COMMENT", "SH_WS"
	};
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
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SCALA_MODE) | (1L << PY_MODE) | (1L << SQL_MODE) | (1L << SHELL_MODE) | (1L << LOAD) | (1L << SAVE) | (1L << SELECT) | (1L << CONNECT) | (1L << SET) | (1L << CREATE) | (1L << DROP) | (1L << REGISTER) | (1L << RUN) | (1L << EXEC_TOKEN))) != 0)) {
				{
				{
				setState(70);
				idesScript();
				}
				}
				setState(75);
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
			setState(76);
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
	public static class ScalaContext extends ScriptContext {
		public TerminalNode SCALA_MODE() { return getToken(IdesParser.SCALA_MODE, 0); }
		public ScalaCodeContext scalaCode() {
			return getRuleContext(ScalaCodeContext.class,0);
		}
		public TerminalNode EXIT_SCALA() { return getToken(IdesParser.EXIT_SCALA, 0); }
		public TerminalNode NL() { return getToken(IdesParser.NL, 0); }
		public ScalaContext(ScriptContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterScala(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitScala(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitScala(this);
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
			setState(114);
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
				setState(78);
				query();
				setState(79);
				match(EOQ);
				}
				break;
			case SCALA_MODE:
				_localctx = new ScalaContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				match(SCALA_MODE);
				setState(82);
				scalaCode();
				setState(83);
				match(EXIT_SCALA);
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(84);
					match(NL);
					}
				}

				}
				break;
			case PY_MODE:
				_localctx = new PyContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(87);
				match(PY_MODE);
				setState(88);
				pythonCode();
				setState(89);
				match(EXIT_PY);
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(90);
					match(NL);
					}
				}

				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==GT) {
					{
					setState(93);
					outTable();
					}
				}

				}
				break;
			case SQL_MODE:
				_localctx = new SqlContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(96);
				match(SQL_MODE);
				setState(97);
				sqlCode();
				setState(98);
				match(EXIT_SQL);
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(99);
					match(NL);
					}
				}

				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==GT) {
					{
					setState(102);
					outTable();
					}
				}

				}
				break;
			case SHELL_MODE:
				_localctx = new ShContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(105);
				match(SHELL_MODE);
				setState(106);
				shellCode();
				setState(107);
				match(EXIT_SH);
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(108);
					match(NL);
					}
				}

				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==GT) {
					{
					setState(111);
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

	public static class ScalaCodeContext extends ParserRuleContext {
		public List<ScalaStatementContext> scalaStatement() {
			return getRuleContexts(ScalaStatementContext.class);
		}
		public ScalaStatementContext scalaStatement(int i) {
			return getRuleContext(ScalaStatementContext.class,i);
		}
		public ScalaCodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scalaCode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterScalaCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitScalaCode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitScalaCode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScalaCodeContext scalaCode() throws RecognitionException {
		ScalaCodeContext _localctx = new ScalaCodeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_scalaCode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SCALA_TEXT) {
				{
				{
				setState(116);
				scalaStatement();
				}
				}
				setState(121);
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

	public static class ScalaStatementContext extends ParserRuleContext {
		public TerminalNode SCALA_TEXT() { return getToken(IdesParser.SCALA_TEXT, 0); }
		public ScalaStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scalaStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).enterScalaStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesParserListener ) ((IdesParserListener)listener).exitScalaStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesParserVisitor ) return ((IdesParserVisitor<? extends T>)visitor).visitScalaStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScalaStatementContext scalaStatement() throws RecognitionException {
		ScalaStatementContext _localctx = new ScalaStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_scalaStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(SCALA_TEXT);
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
		enterRule(_localctx, 10, RULE_pythonCode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PY_TEXT) {
				{
				{
				setState(124);
				pyStatement();
				}
				}
				setState(129);
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
		enterRule(_localctx, 12, RULE_pyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
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
		enterRule(_localctx, 14, RULE_sqlCode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SQL_TEXT) {
				{
				{
				setState(132);
				sqlStatement();
				}
				}
				setState(137);
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
		enterRule(_localctx, 16, RULE_sqlStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
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
		enterRule(_localctx, 18, RULE_shellCode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SHELL_TEXT) {
				{
				{
				setState(140);
				shellStatement();
				}
				}
				setState(145);
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
		enterRule(_localctx, 20, RULE_shellStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
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
		enterRule(_localctx, 22, RULE_query);
		int _la;
		try {
			int _alt;
			setState(226);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LOAD:
				_localctx = new LoadContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				match(LOAD);
				setState(149);
				format();
				setState(150);
				match(DOT);
				setState(151);
				path();
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPTIONS || _la==WHERE) {
					{
					setState(152);
					whereExpressions();
					}
				}

				setState(155);
				asAsset();
				}
				break;
			case SAVE:
				_localctx = new SaveContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				match(SAVE);
				setState(158);
				assetName();
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OVERWRITE) | (1L << APPEND) | (1L << ERRORIfExists) | (1L << IGNORE))) != 0)) {
					{
					setState(159);
					saveMode();
					}
				}

				setState(162);
				match(INTO);
				setState(163);
				format();
				setState(164);
				match(DOT);
				setState(165);
				path();
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPTIONS || _la==WHERE) {
					{
					setState(166);
					whereExpressions();
					}
				}

				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITIONBY) {
					{
					setState(169);
					partitionbyExpression();
					}
				}

				}
				break;
			case SELECT:
				_localctx = new SelectContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(172);
				match(SELECT);
				setState(174); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(173);
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
					setState(176); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(178);
				asAsset();
				}
				break;
			case CONNECT:
				_localctx = new ConnectContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(179);
				match(CONNECT);
				setState(180);
				format();
				setState(181);
				whereExpressions();
				setState(182);
				asAsset();
				}
				break;
			case SET:
				_localctx = new SetContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(184);
				match(SET);
				setState(185);
				expression();
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPTIONS || _la==WHERE) {
					{
					setState(186);
					whereExpressions();
					}
				}

				}
				break;
			case DROP:
				_localctx = new DropContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(189);
				match(DROP);
				setState(190);
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
				setState(191);
				format();
				setState(192);
				match(DOT);
				setState(193);
				assetName();
				}
				break;
			case CREATE:
				_localctx = new CreateContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(195);
				match(CREATE);
				setState(197); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(196);
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
					setState(199); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SCALA_MODE) | (1L << PY_MODE) | (1L << SQL_MODE) | (1L << SHELL_MODE) | (1L << AS) | (1L << INTO) | (1L << LOAD) | (1L << SAVE) | (1L << SELECT) | (1L << OPTIONS) | (1L << WHERE) | (1L << AND) | (1L << OVERWRITE) | (1L << APPEND) | (1L << ERRORIfExists) | (1L << IGNORE) | (1L << PARTITIONBY) | (1L << CONNECT) | (1L << SET) | (1L << CONNECTION) | (1L << FUNCTION) | (1L << CREATE) | (1L << DROP) | (1L << REGISTER) | (1L << RUN) | (1L << EXEC_TOKEN) | (1L << DOT) | (1L << EQ) | (1L << COMMA) | (1L << GT) | (1L << LT) | (1L << HYPHEN) | (1L << UNDERLINE) | (1L << SLASH) | (1L << TILDE) | (1L << COLON) | (1L << ASTERISK) | (1L << VERTICAL_BAR) | (1L << MUMERIC) | (1L << IDENTIFIER) | (1L << QUOTED_TEXT) | (1L << STRING_TEXT) | (1L << BLOCK_STRING_TEXT) | (1L << VARIABLE) | (1L << WS) | (1L << LINE_COMMENT) | (1L << BLOCK_COMMENT) | (1L << NL) | (1L << UNRECOGNIZED) | (1L << EXIT_SCALA) | (1L << SCALA_RETURN) | (1L << SCALA_STRING) | (1L << SCALA_NonEnd) | (1L << SCALA_IMPORT) | (1L << SCALA_CLASS_SEGMENT) | (1L << SCALA_METHOD_SEGMENT) | (1L << SCALA_BLOCK_BODY) | (1L << SCALA_METHOD) | (1L << SCALA_CLASS) | (1L << SCALA_TEXT) | (1L << SCALA_COMMENT) | (1L << SCALA_COMMENT_BLOCK))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (SCALA_WS - 64)) | (1L << (EXIT_PY - 64)) | (1L << (PY_RETURN - 64)) | (1L << (PY_STRING - 64)) | (1L << (VariableRef - 64)) | (1L << (PY_NonEnd - 64)) | (1L << (PY_TEXT - 64)) | (1L << (PY_COMMENT - 64)) | (1L << (PY_WS - 64)) | (1L << (EXIT_SQL - 64)) | (1L << (SQL_RETURN - 64)) | (1L << (SQL_TEXT - 64)) | (1L << (DDL - 64)) | (1L << (DML - 64)) | (1L << (Profile - 64)) | (1L << (SQL_COMMENT1 - 64)) | (1L << (SQL_COMMENT2 - 64)) | (1L << (SQL_COMMENT_BLOCK - 64)) | (1L << (CreatStatement - 64)) | (1L << (AlterStatement - 64)) | (1L << (DropStatement - 64)) | (1L << (RenameStatement - 64)) | (1L << (TruncateStatement - 64)) | (1L << (SelectStatement - 64)) | (1L << (InsertStatement - 64)) | (1L << (UpdateStatement - 64)) | (1L << (DeleteStatement - 64)) | (1L << (ReplaceStatement - 64)) | (1L << (UseStatement - 64)) | (1L << (ShowStatement - 64)) | (1L << (ExplainStatement - 64)) | (1L << (SetStatement - 64)) | (1L << (CallStatement - 64)) | (1L << (OpenStatement - 64)) | (1L << (CloseStatement - 64)) | (1L << (TransactionStatement - 64)) | (1L << (CommitStatement - 64)) | (1L << (RollbackStatement - 64)) | (1L << (SQL_WS - 64)) | (1L << (EXIT_SH - 64)) | (1L << (SH_RETURN - 64)) | (1L << (SH_STRING - 64)) | (1L << (SH_NonEnd - 64)) | (1L << (SHELL_TEXT - 64)) | (1L << (SEHLL_COMMENT - 64)) | (1L << (SH_WS - 64)))) != 0) );
				}
				break;
			case REGISTER:
				_localctx = new RegisterContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(201);
				match(REGISTER);
				setState(202);
				module();
				setState(203);
				match(DOT);
				setState(204);
				path();
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPTIONS || _la==WHERE) {
					{
					setState(205);
					whereExpressions();
					}
				}

				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(208);
					asAsset();
					}
				}

				}
				break;
			case RUN:
				_localctx = new RunContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(211);
				match(RUN);
				setState(212);
				module();
				setState(213);
				match(DOT);
				setState(214);
				path();
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPTIONS || _la==WHERE) {
					{
					setState(215);
					whereExpressions();
					}
				}

				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(218);
					asAsset();
					}
				}

				}
				break;
			case EXEC_TOKEN:
				_localctx = new CommandContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(221);
				match(EXEC_TOKEN);
				setState(222);
				module();
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOAD) | (1L << SAVE) | (1L << SELECT) | (1L << CONNECT) | (1L << SET) | (1L << CREATE) | (1L << DROP) | (1L << REGISTER) | (1L << RUN) | (1L << DOT) | (1L << COMMA) | (1L << GT) | (1L << LT) | (1L << HYPHEN) | (1L << UNDERLINE) | (1L << SLASH) | (1L << TILDE) | (1L << COLON) | (1L << ASTERISK) | (1L << VERTICAL_BAR) | (1L << MUMERIC) | (1L << IDENTIFIER) | (1L << QUOTED_TEXT) | (1L << STRING_TEXT) | (1L << BLOCK_STRING_TEXT))) != 0)) {
					{
					setState(223);
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
		enterRule(_localctx, 24, RULE_module);
		try {
			setState(230);
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
				setState(228);
				identifier();
				}
				break;
			case QUOTED_TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(229);
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
		enterRule(_localctx, 26, RULE_format);
		try {
			setState(234);
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
				setState(232);
				identifier();
				}
				break;
			case QUOTED_TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(233);
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
		enterRule(_localctx, 28, RULE_path);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
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
		enterRule(_localctx, 30, RULE_col);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
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
		enterRule(_localctx, 32, RULE_colGroup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(COMMA);
			setState(241);
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
		enterRule(_localctx, 34, RULE_whereExpressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			where();
			setState(244);
			expression();
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(245);
				booleanExpression();
				}
				}
				setState(250);
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
		enterRule(_localctx, 36, RULE_partitionbyExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(PARTITIONBY);
			setState(252);
			col();
			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(253);
				colGroup();
				}
				}
				setState(258);
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
		enterRule(_localctx, 38, RULE_booleanExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(AND);
			setState(260);
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
		enterRule(_localctx, 40, RULE_keyName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
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
		enterRule(_localctx, 42, RULE_valueName);
		try {
			setState(266);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(264);
				mumericValue();
				}
				break;
			case QUOTED_TEXT:
			case STRING_TEXT:
			case BLOCK_STRING_TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(265);
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
		enterRule(_localctx, 44, RULE_mumericValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
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
		enterRule(_localctx, 46, RULE_stringValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
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
		enterRule(_localctx, 48, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			keyName();
			setState(273);
			match(EQ);
			setState(274);
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
		enterRule(_localctx, 50, RULE_qualifiedName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			identifier();
			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(277);
				match(DOT);
				setState(278);
				identifier();
				}
				}
				setState(283);
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
		enterRule(_localctx, 52, RULE_asAsset);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			match(AS);
			setState(285);
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
		enterRule(_localctx, 54, RULE_assetName);
		try {
			setState(289);
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
				setState(287);
				identifier();
				}
				break;
			case QUOTED_TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(288);
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
		enterRule(_localctx, 56, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
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
		enterRule(_localctx, 58, RULE_quotedIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
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
		enterRule(_localctx, 60, RULE_where);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
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
		enterRule(_localctx, 62, RULE_saveMode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
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
		enterRule(_localctx, 64, RULE_outTable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			match(GT);
			setState(300);
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
		enterRule(_localctx, 66, RULE_commandSymbol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
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
		enterRule(_localctx, 68, RULE_commandParam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(309);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
				case 1:
					{
					setState(304);
					commandSymbol();
					}
					break;
				case 2:
					{
					setState(305);
					identifier();
					}
					break;
				case 3:
					{
					setState(306);
					quotedIdentifier();
					}
					break;
				case 4:
					{
					setState(307);
					stringValue();
					}
					break;
				case 5:
					{
					setState(308);
					mumericValue();
					}
					break;
				}
				}
				setState(311); 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3o\u013c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\7\2J\n\2\f\2\16\2M\13\2\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\5\4X\n\4\3\4\3\4\3\4\3\4\5\4^\n\4\3\4\5\4a\n\4\3\4"+
		"\3\4\3\4\3\4\5\4g\n\4\3\4\5\4j\n\4\3\4\3\4\3\4\3\4\5\4p\n\4\3\4\5\4s\n"+
		"\4\5\4u\n\4\3\5\7\5x\n\5\f\5\16\5{\13\5\3\6\3\6\3\7\7\7\u0080\n\7\f\7"+
		"\16\7\u0083\13\7\3\b\3\b\3\t\7\t\u0088\n\t\f\t\16\t\u008b\13\t\3\n\3\n"+
		"\3\13\7\13\u0090\n\13\f\13\16\13\u0093\13\13\3\f\3\f\3\r\3\r\3\r\3\r\3"+
		"\r\5\r\u009c\n\r\3\r\3\r\3\r\3\r\3\r\5\r\u00a3\n\r\3\r\3\r\3\r\3\r\3\r"+
		"\5\r\u00aa\n\r\3\r\5\r\u00ad\n\r\3\r\3\r\6\r\u00b1\n\r\r\r\16\r\u00b2"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00be\n\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\6\r\u00c8\n\r\r\r\16\r\u00c9\3\r\3\r\3\r\3\r\3\r\5\r\u00d1"+
		"\n\r\3\r\5\r\u00d4\n\r\3\r\3\r\3\r\3\r\3\r\5\r\u00db\n\r\3\r\5\r\u00de"+
		"\n\r\3\r\3\r\3\r\5\r\u00e3\n\r\5\r\u00e5\n\r\3\16\3\16\5\16\u00e9\n\16"+
		"\3\17\3\17\5\17\u00ed\n\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\7\23\u00f9\n\23\f\23\16\23\u00fc\13\23\3\24\3\24\3\24\7\24\u0101"+
		"\n\24\f\24\16\24\u0104\13\24\3\25\3\25\3\25\3\26\3\26\3\27\3\27\5\27\u010d"+
		"\n\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\7\33\u011a"+
		"\n\33\f\33\16\33\u011d\13\33\3\34\3\34\3\34\3\35\3\35\5\35\u0124\n\35"+
		"\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3\"\3#\3#\3$\3$\3$\3$\3$\6$\u0138"+
		"\n$\r$\16$\u0139\3$\2\2%\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&("+
		"*,.\60\62\64\668:<>@BDF\2\t\3\2))\3\2\26\27\3\2,.\6\2\t\13\24\25\30\33"+
		"++\3\2\f\r\3\2\17\22\4\2\35\35\37(\2\u0149\2K\3\2\2\2\4N\3\2\2\2\6t\3"+
		"\2\2\2\by\3\2\2\2\n|\3\2\2\2\f\u0081\3\2\2\2\16\u0084\3\2\2\2\20\u0089"+
		"\3\2\2\2\22\u008c\3\2\2\2\24\u0091\3\2\2\2\26\u0094\3\2\2\2\30\u00e4\3"+
		"\2\2\2\32\u00e8\3\2\2\2\34\u00ec\3\2\2\2\36\u00ee\3\2\2\2 \u00f0\3\2\2"+
		"\2\"\u00f2\3\2\2\2$\u00f5\3\2\2\2&\u00fd\3\2\2\2(\u0105\3\2\2\2*\u0108"+
		"\3\2\2\2,\u010c\3\2\2\2.\u010e\3\2\2\2\60\u0110\3\2\2\2\62\u0112\3\2\2"+
		"\2\64\u0116\3\2\2\2\66\u011e\3\2\2\28\u0123\3\2\2\2:\u0125\3\2\2\2<\u0127"+
		"\3\2\2\2>\u0129\3\2\2\2@\u012b\3\2\2\2B\u012d\3\2\2\2D\u0130\3\2\2\2F"+
		"\u0137\3\2\2\2HJ\5\4\3\2IH\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\3\3"+
		"\2\2\2MK\3\2\2\2NO\5\6\4\2O\5\3\2\2\2PQ\5\30\r\2QR\7)\2\2Ru\3\2\2\2ST"+
		"\7\3\2\2TU\5\b\5\2UW\7\65\2\2VX\7\63\2\2WV\3\2\2\2WX\3\2\2\2Xu\3\2\2\2"+
		"YZ\7\4\2\2Z[\5\f\7\2[]\7C\2\2\\^\7\63\2\2]\\\3\2\2\2]^\3\2\2\2^`\3\2\2"+
		"\2_a\5B\"\2`_\3\2\2\2`a\3\2\2\2au\3\2\2\2bc\7\5\2\2cd\5\20\t\2df\7K\2"+
		"\2eg\7\63\2\2fe\3\2\2\2fg\3\2\2\2gi\3\2\2\2hj\5B\"\2ih\3\2\2\2ij\3\2\2"+
		"\2ju\3\2\2\2kl\7\6\2\2lm\5\24\13\2mo\7i\2\2np\7\63\2\2on\3\2\2\2op\3\2"+
		"\2\2pr\3\2\2\2qs\5B\"\2rq\3\2\2\2rs\3\2\2\2su\3\2\2\2tP\3\2\2\2tS\3\2"+
		"\2\2tY\3\2\2\2tb\3\2\2\2tk\3\2\2\2u\7\3\2\2\2vx\5\n\6\2wv\3\2\2\2x{\3"+
		"\2\2\2yw\3\2\2\2yz\3\2\2\2z\t\3\2\2\2{y\3\2\2\2|}\7?\2\2}\13\3\2\2\2~"+
		"\u0080\5\16\b\2\177~\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081"+
		"\u0082\3\2\2\2\u0082\r\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0085\7H\2\2"+
		"\u0085\17\3\2\2\2\u0086\u0088\5\22\n\2\u0087\u0086\3\2\2\2\u0088\u008b"+
		"\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\21\3\2\2\2\u008b"+
		"\u0089\3\2\2\2\u008c\u008d\7M\2\2\u008d\23\3\2\2\2\u008e\u0090\5\26\f"+
		"\2\u008f\u008e\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092"+
		"\3\2\2\2\u0092\25\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0095\7m\2\2\u0095"+
		"\27\3\2\2\2\u0096\u0097\7\t\2\2\u0097\u0098\5\34\17\2\u0098\u0099\7\35"+
		"\2\2\u0099\u009b\5\36\20\2\u009a\u009c\5$\23\2\u009b\u009a\3\2\2\2\u009b"+
		"\u009c\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\5\66\34\2\u009e\u00e5\3"+
		"\2\2\2\u009f\u00a0\7\n\2\2\u00a0\u00a2\58\35\2\u00a1\u00a3\5@!\2\u00a2"+
		"\u00a1\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\7\b"+
		"\2\2\u00a5\u00a6\5\34\17\2\u00a6\u00a7\7\35\2\2\u00a7\u00a9\5\36\20\2"+
		"\u00a8\u00aa\5$\23\2\u00a9\u00a8\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ac"+
		"\3\2\2\2\u00ab\u00ad\5&\24\2\u00ac\u00ab\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad"+
		"\u00e5\3\2\2\2\u00ae\u00b0\7\13\2\2\u00af\u00b1\n\2\2\2\u00b0\u00af\3"+
		"\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3"+
		"\u00b4\3\2\2\2\u00b4\u00e5\5\66\34\2\u00b5\u00b6\7\24\2\2\u00b6\u00b7"+
		"\5\34\17\2\u00b7\u00b8\5$\23\2\u00b8\u00b9\5\66\34\2\u00b9\u00e5\3\2\2"+
		"\2\u00ba\u00bb\7\25\2\2\u00bb\u00bd\5\62\32\2\u00bc\u00be\5$\23\2\u00bd"+
		"\u00bc\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00e5\3\2\2\2\u00bf\u00c0\7\31"+
		"\2\2\u00c0\u00c1\t\3\2\2\u00c1\u00c2\5\34\17\2\u00c2\u00c3\7\35\2\2\u00c3"+
		"\u00c4\58\35\2\u00c4\u00e5\3\2\2\2\u00c5\u00c7\7\30\2\2\u00c6\u00c8\n"+
		"\2\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9"+
		"\u00ca\3\2\2\2\u00ca\u00e5\3\2\2\2\u00cb\u00cc\7\32\2\2\u00cc\u00cd\5"+
		"\32\16\2\u00cd\u00ce\7\35\2\2\u00ce\u00d0\5\36\20\2\u00cf\u00d1\5$\23"+
		"\2\u00d0\u00cf\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d3\3\2\2\2\u00d2\u00d4"+
		"\5\66\34\2\u00d3\u00d2\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00e5\3\2\2\2"+
		"\u00d5\u00d6\7\33\2\2\u00d6\u00d7\5\32\16\2\u00d7\u00d8\7\35\2\2\u00d8"+
		"\u00da\5\36\20\2\u00d9\u00db\5$\23\2\u00da\u00d9\3\2\2\2\u00da\u00db\3"+
		"\2\2\2\u00db\u00dd\3\2\2\2\u00dc\u00de\5\66\34\2\u00dd\u00dc\3\2\2\2\u00dd"+
		"\u00de\3\2\2\2\u00de\u00e5\3\2\2\2\u00df\u00e0\7\34\2\2\u00e0\u00e2\5"+
		"\32\16\2\u00e1\u00e3\5F$\2\u00e2\u00e1\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3"+
		"\u00e5\3\2\2\2\u00e4\u0096\3\2\2\2\u00e4\u009f\3\2\2\2\u00e4\u00ae\3\2"+
		"\2\2\u00e4\u00b5\3\2\2\2\u00e4\u00ba\3\2\2\2\u00e4\u00bf\3\2\2\2\u00e4"+
		"\u00c5\3\2\2\2\u00e4\u00cb\3\2\2\2\u00e4\u00d5\3\2\2\2\u00e4\u00df\3\2"+
		"\2\2\u00e5\31\3\2\2\2\u00e6\u00e9\5:\36\2\u00e7\u00e9\5<\37\2\u00e8\u00e6"+
		"\3\2\2\2\u00e8\u00e7\3\2\2\2\u00e9\33\3\2\2\2\u00ea\u00ed\5:\36\2\u00eb"+
		"\u00ed\5<\37\2\u00ec\u00ea\3\2\2\2\u00ec\u00eb\3\2\2\2\u00ed\35\3\2\2"+
		"\2\u00ee\u00ef\5<\37\2\u00ef\37\3\2\2\2\u00f0\u00f1\5:\36\2\u00f1!\3\2"+
		"\2\2\u00f2\u00f3\7\37\2\2\u00f3\u00f4\5 \21\2\u00f4#\3\2\2\2\u00f5\u00f6"+
		"\5> \2\u00f6\u00fa\5\62\32\2\u00f7\u00f9\5(\25\2\u00f8\u00f7\3\2\2\2\u00f9"+
		"\u00fc\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb%\3\2\2\2"+
		"\u00fc\u00fa\3\2\2\2\u00fd\u00fe\7\23\2\2\u00fe\u0102\5 \21\2\u00ff\u0101"+
		"\5\"\22\2\u0100\u00ff\3\2\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2\2\2"+
		"\u0102\u0103\3\2\2\2\u0103\'\3\2\2\2\u0104\u0102\3\2\2\2\u0105\u0106\7"+
		"\16\2\2\u0106\u0107\5\62\32\2\u0107)\3\2\2\2\u0108\u0109\5\64\33\2\u0109"+
		"+\3\2\2\2\u010a\u010d\5.\30\2\u010b\u010d\5\60\31\2\u010c\u010a\3\2\2"+
		"\2\u010c\u010b\3\2\2\2\u010d-\3\2\2\2\u010e\u010f\7*\2\2\u010f/\3\2\2"+
		"\2\u0110\u0111\t\4\2\2\u0111\61\3\2\2\2\u0112\u0113\5*\26\2\u0113\u0114"+
		"\7\36\2\2\u0114\u0115\5,\27\2\u0115\63\3\2\2\2\u0116\u011b\5:\36\2\u0117"+
		"\u0118\7\35\2\2\u0118\u011a\5:\36\2\u0119\u0117\3\2\2\2\u011a\u011d\3"+
		"\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c\65\3\2\2\2\u011d"+
		"\u011b\3\2\2\2\u011e\u011f\7\7\2\2\u011f\u0120\58\35\2\u0120\67\3\2\2"+
		"\2\u0121\u0124\5:\36\2\u0122\u0124\5<\37\2\u0123\u0121\3\2\2\2\u0123\u0122"+
		"\3\2\2\2\u01249\3\2\2\2\u0125\u0126\t\5\2\2\u0126;\3\2\2\2\u0127\u0128"+
		"\7,\2\2\u0128=\3\2\2\2\u0129\u012a\t\6\2\2\u012a?\3\2\2\2\u012b\u012c"+
		"\t\7\2\2\u012cA\3\2\2\2\u012d\u012e\7 \2\2\u012e\u012f\58\35\2\u012fC"+
		"\3\2\2\2\u0130\u0131\t\b\2\2\u0131E\3\2\2\2\u0132\u0138\5D#\2\u0133\u0138"+
		"\5:\36\2\u0134\u0138\5<\37\2\u0135\u0138\5\60\31\2\u0136\u0138\5.\30\2"+
		"\u0137\u0132\3\2\2\2\u0137\u0133\3\2\2\2\u0137\u0134\3\2\2\2\u0137\u0135"+
		"\3\2\2\2\u0137\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u0137\3\2\2\2\u0139"+
		"\u013a\3\2\2\2\u013aG\3\2\2\2%KW]`fiorty\u0081\u0089\u0091\u009b\u00a2"+
		"\u00a9\u00ac\u00b2\u00bd\u00c9\u00d0\u00d3\u00da\u00dd\u00e2\u00e4\u00e8"+
		"\u00ec\u00fa\u0102\u010c\u011b\u0123\u0137\u0139";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}