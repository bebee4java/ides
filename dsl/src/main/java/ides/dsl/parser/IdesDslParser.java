// Generated from /Users/sgr/develop/ideaProject/ides/dsl/src/main/resources/IdesDsl.g4 by ANTLR 4.7.2

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
public class IdesDslParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, AS=3, INTO=4, LOAD=5, SAVE=6, SELECT=7, OPTIONS=8, WHERE=9, 
		AND=10, OVERWRITE=11, APPEND=12, ERRORIfExists=13, IGNORE=14, PARTITIONBY=15, 
		DOT=16, EOQ=17, MUMERIC=18, IDENTIFIER=19, QUOTED_TEXT=20, STRING_TEXT=21, 
		BLOCK_STRING_TEXT=22, LINE_COMMENT=23, BLOCK_COMMENT=24, WS=25, UNRECOGNIZED=26;
	public static final int
		RULE_statement = 0, RULE_script = 1, RULE_query = 2, RULE_format = 3, 
		RULE_path = 4, RULE_col = 5, RULE_colGroup = 6, RULE_whereExpressions = 7, 
		RULE_partitionbyExpression = 8, RULE_booleanExpression = 9, RULE_expression = 10, 
		RULE_qualifiedName = 11, RULE_asTableName = 12, RULE_tableName = 13, RULE_identifier = 14, 
		RULE_quotedIdentifier = 15, RULE_where = 16, RULE_saveMode = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"statement", "script", "query", "format", "path", "col", "colGroup", 
			"whereExpressions", "partitionbyExpression", "booleanExpression", "expression", 
			"qualifiedName", "asTableName", "tableName", "identifier", "quotedIdentifier", 
			"where", "saveMode"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'='", "'as'", "'into'", "'load'", "'save'", "'select'", 
			"'options'", "'where'", "'and'", "'overwrite'", "'append'", "'errorIfExists'", 
			"'ignore'", null, "'.'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "AS", "INTO", "LOAD", "SAVE", "SELECT", "OPTIONS", 
			"WHERE", "AND", "OVERWRITE", "APPEND", "ERRORIfExists", "IGNORE", "PARTITIONBY", 
			"DOT", "EOQ", "MUMERIC", "IDENTIFIER", "QUOTED_TEXT", "STRING_TEXT", 
			"BLOCK_STRING_TEXT", "LINE_COMMENT", "BLOCK_COMMENT", "WS", "UNRECOGNIZED"
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
	public String getGrammarFileName() { return "IdesDsl.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public IdesDslParser(TokenStream input) {
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
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesDslVisitor ) return ((IdesDslVisitor<? extends T>)visitor).visitStatement(this);
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
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOAD) | (1L << SAVE) | (1L << SELECT))) != 0)) {
				{
				{
				setState(36);
				script();
				}
				}
				setState(41);
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
	public static class SqlContext extends ScriptContext {
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public TerminalNode EOQ() { return getToken(IdesDslParser.EOQ, 0); }
		public SqlContext(ScriptContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).enterSql(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).exitSql(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesDslVisitor ) return ((IdesDslVisitor<? extends T>)visitor).visitSql(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScriptContext script() throws RecognitionException {
		ScriptContext _localctx = new ScriptContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_script);
		try {
			_localctx = new SqlContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			query();
			setState(43);
			match(EOQ);
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
		public TerminalNode LOAD() { return getToken(IdesDslParser.LOAD, 0); }
		public FormatContext format() {
			return getRuleContext(FormatContext.class,0);
		}
		public TerminalNode DOT() { return getToken(IdesDslParser.DOT, 0); }
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public AsTableNameContext asTableName() {
			return getRuleContext(AsTableNameContext.class,0);
		}
		public WhereExpressionsContext whereExpressions() {
			return getRuleContext(WhereExpressionsContext.class,0);
		}
		public LoadContext(QueryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).enterLoad(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).exitLoad(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesDslVisitor ) return ((IdesDslVisitor<? extends T>)visitor).visitLoad(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SelectContext extends QueryContext {
		public TerminalNode SELECT() { return getToken(IdesDslParser.SELECT, 0); }
		public AsTableNameContext asTableName() {
			return getRuleContext(AsTableNameContext.class,0);
		}
		public List<TerminalNode> EOQ() { return getTokens(IdesDslParser.EOQ); }
		public TerminalNode EOQ(int i) {
			return getToken(IdesDslParser.EOQ, i);
		}
		public SelectContext(QueryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).enterSelect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).exitSelect(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesDslVisitor ) return ((IdesDslVisitor<? extends T>)visitor).visitSelect(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SaveContext extends QueryContext {
		public TerminalNode SAVE() { return getToken(IdesDslParser.SAVE, 0); }
		public SaveModeContext saveMode() {
			return getRuleContext(SaveModeContext.class,0);
		}
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TerminalNode AS() { return getToken(IdesDslParser.AS, 0); }
		public FormatContext format() {
			return getRuleContext(FormatContext.class,0);
		}
		public TerminalNode DOT() { return getToken(IdesDslParser.DOT, 0); }
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
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
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).enterSave(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).exitSave(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesDslVisitor ) return ((IdesDslVisitor<? extends T>)visitor).visitSave(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_query);
		int _la;
		try {
			int _alt;
			setState(74);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LOAD:
				_localctx = new LoadContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				match(LOAD);
				setState(46);
				format();
				setState(47);
				match(DOT);
				setState(48);
				path();
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPTIONS || _la==WHERE) {
					{
					setState(49);
					whereExpressions();
					}
				}

				setState(52);
				asTableName();
				}
				break;
			case SAVE:
				_localctx = new SaveContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				match(SAVE);
				setState(55);
				saveMode();
				setState(56);
				tableName();
				setState(57);
				match(AS);
				setState(58);
				format();
				setState(59);
				match(DOT);
				setState(60);
				path();
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPTIONS || _la==WHERE) {
					{
					setState(61);
					whereExpressions();
					}
				}

				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITIONBY) {
					{
					setState(64);
					partitionbyExpression();
					}
				}

				}
				break;
			case SELECT:
				_localctx = new SelectContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				match(SELECT);
				setState(69); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(68);
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
					setState(71); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(73);
				asTableName();
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
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).enterFormat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).exitFormat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesDslVisitor ) return ((IdesDslVisitor<? extends T>)visitor).visitFormat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormatContext format() throws RecognitionException {
		FormatContext _localctx = new FormatContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_format);
		try {
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				identifier();
				}
				break;
			case QUOTED_TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
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
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).enterPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).exitPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesDslVisitor ) return ((IdesDslVisitor<? extends T>)visitor).visitPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathContext path() throws RecognitionException {
		PathContext _localctx = new PathContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_path);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
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
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).enterCol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).exitCol(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesDslVisitor ) return ((IdesDslVisitor<? extends T>)visitor).visitCol(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColContext col() throws RecognitionException {
		ColContext _localctx = new ColContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_col);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
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
		public ColContext col() {
			return getRuleContext(ColContext.class,0);
		}
		public ColGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colGroup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).enterColGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).exitColGroup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesDslVisitor ) return ((IdesDslVisitor<? extends T>)visitor).visitColGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColGroupContext colGroup() throws RecognitionException {
		ColGroupContext _localctx = new ColGroupContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_colGroup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(T__0);
			setState(85);
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
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).enterWhereExpressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).exitWhereExpressions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesDslVisitor ) return ((IdesDslVisitor<? extends T>)visitor).visitWhereExpressions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhereExpressionsContext whereExpressions() throws RecognitionException {
		WhereExpressionsContext _localctx = new WhereExpressionsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_whereExpressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			where();
			setState(88);
			expression();
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(89);
				booleanExpression();
				}
				}
				setState(94);
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
		public TerminalNode PARTITIONBY() { return getToken(IdesDslParser.PARTITIONBY, 0); }
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
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).enterPartitionbyExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).exitPartitionbyExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesDslVisitor ) return ((IdesDslVisitor<? extends T>)visitor).visitPartitionbyExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PartitionbyExpressionContext partitionbyExpression() throws RecognitionException {
		PartitionbyExpressionContext _localctx = new PartitionbyExpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_partitionbyExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(PARTITIONBY);
			setState(96);
			col();
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(97);
				colGroup();
				}
				}
				setState(102);
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
		public TerminalNode AND() { return getToken(IdesDslParser.AND, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BooleanExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).enterBooleanExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).exitBooleanExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesDslVisitor ) return ((IdesDslVisitor<? extends T>)visitor).visitBooleanExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanExpressionContext booleanExpression() throws RecognitionException {
		BooleanExpressionContext _localctx = new BooleanExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_booleanExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(AND);
			setState(104);
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

	public static class ExpressionContext extends ParserRuleContext {
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode MUMERIC() { return getToken(IdesDslParser.MUMERIC, 0); }
		public TerminalNode STRING_TEXT() { return getToken(IdesDslParser.STRING_TEXT, 0); }
		public TerminalNode BLOCK_STRING_TEXT() { return getToken(IdesDslParser.BLOCK_STRING_TEXT, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesDslVisitor ) return ((IdesDslVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			qualifiedName();
			setState(107);
			match(T__1);
			setState(108);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUMERIC) | (1L << STRING_TEXT) | (1L << BLOCK_STRING_TEXT))) != 0)) ) {
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

	public static class QualifiedNameContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(IdesDslParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(IdesDslParser.DOT, i);
		}
		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).enterQualifiedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).exitQualifiedName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesDslVisitor ) return ((IdesDslVisitor<? extends T>)visitor).visitQualifiedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_qualifiedName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			identifier();
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(111);
				match(DOT);
				setState(112);
				identifier();
				}
				}
				setState(117);
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

	public static class AsTableNameContext extends ParserRuleContext {
		public TerminalNode AS() { return getToken(IdesDslParser.AS, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public AsTableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asTableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).enterAsTableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).exitAsTableName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesDslVisitor ) return ((IdesDslVisitor<? extends T>)visitor).visitAsTableName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsTableNameContext asTableName() throws RecognitionException {
		AsTableNameContext _localctx = new AsTableNameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_asTableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(AS);
			setState(119);
			tableName();
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

	public static class TableNameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).enterTableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).exitTableName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesDslVisitor ) return ((IdesDslVisitor<? extends T>)visitor).visitTableName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableNameContext tableName() throws RecognitionException {
		TableNameContext _localctx = new TableNameContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
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

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(IdesDslParser.IDENTIFIER, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesDslVisitor ) return ((IdesDslVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
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
		public TerminalNode QUOTED_TEXT() { return getToken(IdesDslParser.QUOTED_TEXT, 0); }
		public QuotedIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quotedIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).enterQuotedIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).exitQuotedIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesDslVisitor ) return ((IdesDslVisitor<? extends T>)visitor).visitQuotedIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuotedIdentifierContext quotedIdentifier() throws RecognitionException {
		QuotedIdentifierContext _localctx = new QuotedIdentifierContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_quotedIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
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
		public TerminalNode OPTIONS() { return getToken(IdesDslParser.OPTIONS, 0); }
		public TerminalNode WHERE() { return getToken(IdesDslParser.WHERE, 0); }
		public WhereContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).enterWhere(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).exitWhere(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesDslVisitor ) return ((IdesDslVisitor<? extends T>)visitor).visitWhere(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhereContext where() throws RecognitionException {
		WhereContext _localctx = new WhereContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_where);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
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
		public TerminalNode OVERWRITE() { return getToken(IdesDslParser.OVERWRITE, 0); }
		public TerminalNode APPEND() { return getToken(IdesDslParser.APPEND, 0); }
		public TerminalNode ERRORIfExists() { return getToken(IdesDslParser.ERRORIfExists, 0); }
		public TerminalNode IGNORE() { return getToken(IdesDslParser.IGNORE, 0); }
		public SaveModeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_saveMode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).enterSaveMode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IdesDslListener ) ((IdesDslListener)listener).exitSaveMode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IdesDslVisitor ) return ((IdesDslVisitor<? extends T>)visitor).visitSaveMode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SaveModeContext saveMode() throws RecognitionException {
		SaveModeContext _localctx = new SaveModeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_saveMode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\34\u0086\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\7\2(\n\2\f\2\16\2+\13\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4"+
		"\5\4\65\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4A\n\4\3\4\5\4D"+
		"\n\4\3\4\3\4\6\4H\n\4\r\4\16\4I\3\4\5\4M\n\4\3\5\3\5\5\5Q\n\5\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\7\t]\n\t\f\t\16\t`\13\t\3\n\3\n\3\n\7"+
		"\ne\n\n\f\n\16\nh\13\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\7\r"+
		"t\n\r\f\r\16\rw\13\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22"+
		"\3\22\3\23\3\23\3\23\2\2\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \""+
		"$\2\6\3\2\23\23\4\2\24\24\27\30\3\2\n\13\3\2\r\20\2~\2)\3\2\2\2\4,\3\2"+
		"\2\2\6L\3\2\2\2\bP\3\2\2\2\nR\3\2\2\2\fT\3\2\2\2\16V\3\2\2\2\20Y\3\2\2"+
		"\2\22a\3\2\2\2\24i\3\2\2\2\26l\3\2\2\2\30p\3\2\2\2\32x\3\2\2\2\34{\3\2"+
		"\2\2\36}\3\2\2\2 \177\3\2\2\2\"\u0081\3\2\2\2$\u0083\3\2\2\2&(\5\4\3\2"+
		"\'&\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*\3\3\2\2\2+)\3\2\2\2,-\5\6"+
		"\4\2-.\7\23\2\2.\5\3\2\2\2/\60\7\7\2\2\60\61\5\b\5\2\61\62\7\22\2\2\62"+
		"\64\5\n\6\2\63\65\5\20\t\2\64\63\3\2\2\2\64\65\3\2\2\2\65\66\3\2\2\2\66"+
		"\67\5\32\16\2\67M\3\2\2\289\7\b\2\29:\5$\23\2:;\5\34\17\2;<\7\5\2\2<="+
		"\5\b\5\2=>\7\22\2\2>@\5\n\6\2?A\5\20\t\2@?\3\2\2\2@A\3\2\2\2AC\3\2\2\2"+
		"BD\5\22\n\2CB\3\2\2\2CD\3\2\2\2DM\3\2\2\2EG\7\t\2\2FH\n\2\2\2GF\3\2\2"+
		"\2HI\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KM\5\32\16\2L/\3\2\2\2L8\3\2"+
		"\2\2LE\3\2\2\2M\7\3\2\2\2NQ\5\36\20\2OQ\5 \21\2PN\3\2\2\2PO\3\2\2\2Q\t"+
		"\3\2\2\2RS\5 \21\2S\13\3\2\2\2TU\5\36\20\2U\r\3\2\2\2VW\7\3\2\2WX\5\f"+
		"\7\2X\17\3\2\2\2YZ\5\"\22\2Z^\5\26\f\2[]\5\24\13\2\\[\3\2\2\2]`\3\2\2"+
		"\2^\\\3\2\2\2^_\3\2\2\2_\21\3\2\2\2`^\3\2\2\2ab\7\21\2\2bf\5\f\7\2ce\5"+
		"\16\b\2dc\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2g\23\3\2\2\2hf\3\2\2\2"+
		"ij\7\f\2\2jk\5\26\f\2k\25\3\2\2\2lm\5\30\r\2mn\7\4\2\2no\t\3\2\2o\27\3"+
		"\2\2\2pu\5\36\20\2qr\7\22\2\2rt\5\36\20\2sq\3\2\2\2tw\3\2\2\2us\3\2\2"+
		"\2uv\3\2\2\2v\31\3\2\2\2wu\3\2\2\2xy\7\5\2\2yz\5\34\17\2z\33\3\2\2\2{"+
		"|\5\36\20\2|\35\3\2\2\2}~\7\25\2\2~\37\3\2\2\2\177\u0080\7\26\2\2\u0080"+
		"!\3\2\2\2\u0081\u0082\t\4\2\2\u0082#\3\2\2\2\u0083\u0084\t\5\2\2\u0084"+
		"%\3\2\2\2\f)\64@CILP^fu";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}