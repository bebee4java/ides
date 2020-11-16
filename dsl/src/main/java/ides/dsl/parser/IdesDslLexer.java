
    package ides.dsl.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IdesDslLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, AS=3, INTO=4, LOAD=5, SAVE=6, SELECT=7, OPTIONS=8, WHERE=9, 
		AND=10, OVERWRITE=11, APPEND=12, ERRORIfExists=13, IGNORE=14, PARTITIONBY=15, 
		DOT=16, EOQ=17, MUMERIC=18, IDENTIFIER=19, QUOTED_TEXT=20, STRING_TEXT=21, 
		BLOCK_STRING_TEXT=22, LINE_COMMENT=23, BLOCK_COMMENT=24, WS=25, UNRECOGNIZED=26;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "AS", "INTO", "LOAD", "SAVE", "SELECT", "OPTIONS", "WHERE", 
			"AND", "OVERWRITE", "APPEND", "ERRORIfExists", "IGNORE", "PARTITIONBY", 
			"DOT", "EOQ", "MUMERIC", "IDENTIFIER", "QUOTED_TEXT", "STRING_TEXT", 
			"BLOCK_STRING_TEXT", "DIGIT", "LETTER", "LINE_COMMENT", "BLOCK_COMMENT", 
			"WS", "UNRECOGNIZED"
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


	public IdesDslLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "IdesDsl.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\34\u0138\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00a7\n\20\3\21\3\21\3\22\3\22\3\23"+
		"\5\23\u00ae\n\23\3\23\7\23\u00b1\n\23\f\23\16\23\u00b4\13\23\3\23\5\23"+
		"\u00b7\n\23\3\23\6\23\u00ba\n\23\r\23\16\23\u00bb\3\24\3\24\3\24\3\24"+
		"\7\24\u00c2\n\24\f\24\16\24\u00c5\13\24\3\24\3\24\3\24\3\24\6\24\u00cb"+
		"\n\24\r\24\16\24\u00cc\5\24\u00cf\n\24\3\25\3\25\3\25\3\25\7\25\u00d5"+
		"\n\25\f\25\16\25\u00d8\13\25\3\25\3\25\3\26\3\26\3\26\3\26\7\26\u00e0"+
		"\n\26\f\26\16\26\u00e3\13\26\3\26\3\26\3\26\3\26\3\26\7\26\u00ea\n\26"+
		"\f\26\16\26\u00ed\13\26\3\26\5\26\u00f0\n\26\3\27\3\27\3\27\3\27\3\27"+
		"\7\27\u00f7\n\27\f\27\16\27\u00fa\13\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\7\27\u0104\n\27\f\27\16\27\u0107\13\27\3\27\3\27\3\27\5\27"+
		"\u010c\n\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32\7\32\u0116\n\32\f"+
		"\32\16\32\u0119\13\32\3\32\3\32\3\32\5\32\u011e\n\32\3\32\3\32\3\33\3"+
		"\33\3\33\3\33\7\33\u0126\n\33\f\33\16\33\u0129\13\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\34\6\34\u0131\n\34\r\34\16\34\u0132\3\34\3\34\3\35\3\35\b\u00d6"+
		"\u00e1\u00eb\u00f8\u0105\u0127\2\36\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\2\61\2\63\31\65\32\67\339\34\3\2\n\4\2--//\4\2^^bb\4\2))^^\4\2$$^^\3"+
		"\2\62;\4\2C\\c|\4\2\f\f\17\17\5\2\13\f\17\17\"\"\2\u0150\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\3;\3\2\2\2\5=\3\2\2\2\7?\3\2\2\2\tB\3\2\2\2"+
		"\13G\3\2\2\2\rL\3\2\2\2\17Q\3\2\2\2\21X\3\2\2\2\23`\3\2\2\2\25f\3\2\2"+
		"\2\27j\3\2\2\2\31t\3\2\2\2\33{\3\2\2\2\35\u0089\3\2\2\2\37\u00a6\3\2\2"+
		"\2!\u00a8\3\2\2\2#\u00aa\3\2\2\2%\u00ad\3\2\2\2\'\u00ce\3\2\2\2)\u00d0"+
		"\3\2\2\2+\u00ef\3\2\2\2-\u010b\3\2\2\2/\u010d\3\2\2\2\61\u010f\3\2\2\2"+
		"\63\u0111\3\2\2\2\65\u0121\3\2\2\2\67\u0130\3\2\2\29\u0136\3\2\2\2;<\7"+
		".\2\2<\4\3\2\2\2=>\7?\2\2>\6\3\2\2\2?@\7c\2\2@A\7u\2\2A\b\3\2\2\2BC\7"+
		"k\2\2CD\7p\2\2DE\7v\2\2EF\7q\2\2F\n\3\2\2\2GH\7n\2\2HI\7q\2\2IJ\7c\2\2"+
		"JK\7f\2\2K\f\3\2\2\2LM\7u\2\2MN\7c\2\2NO\7x\2\2OP\7g\2\2P\16\3\2\2\2Q"+
		"R\7u\2\2RS\7g\2\2ST\7n\2\2TU\7g\2\2UV\7e\2\2VW\7v\2\2W\20\3\2\2\2XY\7"+
		"q\2\2YZ\7r\2\2Z[\7v\2\2[\\\7k\2\2\\]\7q\2\2]^\7p\2\2^_\7u\2\2_\22\3\2"+
		"\2\2`a\7y\2\2ab\7j\2\2bc\7g\2\2cd\7t\2\2de\7g\2\2e\24\3\2\2\2fg\7c\2\2"+
		"gh\7p\2\2hi\7f\2\2i\26\3\2\2\2jk\7q\2\2kl\7x\2\2lm\7g\2\2mn\7t\2\2no\7"+
		"y\2\2op\7t\2\2pq\7k\2\2qr\7v\2\2rs\7g\2\2s\30\3\2\2\2tu\7c\2\2uv\7r\2"+
		"\2vw\7r\2\2wx\7g\2\2xy\7p\2\2yz\7f\2\2z\32\3\2\2\2{|\7g\2\2|}\7t\2\2}"+
		"~\7t\2\2~\177\7q\2\2\177\u0080\7t\2\2\u0080\u0081\7K\2\2\u0081\u0082\7"+
		"h\2\2\u0082\u0083\7G\2\2\u0083\u0084\7z\2\2\u0084\u0085\7k\2\2\u0085\u0086"+
		"\7u\2\2\u0086\u0087\7v\2\2\u0087\u0088\7u\2\2\u0088\34\3\2\2\2\u0089\u008a"+
		"\7k\2\2\u008a\u008b\7i\2\2\u008b\u008c\7p\2\2\u008c\u008d\7q\2\2\u008d"+
		"\u008e\7t\2\2\u008e\u008f\7g\2\2\u008f\36\3\2\2\2\u0090\u0091\7r\2\2\u0091"+
		"\u0092\7c\2\2\u0092\u0093\7t\2\2\u0093\u0094\7v\2\2\u0094\u0095\7k\2\2"+
		"\u0095\u0096\7v\2\2\u0096\u0097\7k\2\2\u0097\u0098\7q\2\2\u0098\u0099"+
		"\7p\2\2\u0099\u009a\7D\2\2\u009a\u00a7\7{\2\2\u009b\u009c\7r\2\2\u009c"+
		"\u009d\7c\2\2\u009d\u009e\7t\2\2\u009e\u009f\7v\2\2\u009f\u00a0\7k\2\2"+
		"\u00a0\u00a1\7v\2\2\u00a1\u00a2\7k\2\2\u00a2\u00a3\7q\2\2\u00a3\u00a4"+
		"\7p\2\2\u00a4\u00a5\7d\2\2\u00a5\u00a7\7{\2\2\u00a6\u0090\3\2\2\2\u00a6"+
		"\u009b\3\2\2\2\u00a7 \3\2\2\2\u00a8\u00a9\7\60\2\2\u00a9\"\3\2\2\2\u00aa"+
		"\u00ab\7=\2\2\u00ab$\3\2\2\2\u00ac\u00ae\t\2\2\2\u00ad\u00ac\3\2\2\2\u00ad"+
		"\u00ae\3\2\2\2\u00ae\u00b2\3\2\2\2\u00af\u00b1\5/\30\2\u00b0\u00af\3\2"+
		"\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3"+
		"\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b7\7\60\2\2\u00b6\u00b5\3"+
		"\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00ba\5/\30\2\u00b9"+
		"\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2"+
		"\2\2\u00bc&\3\2\2\2\u00bd\u00c3\5\61\31\2\u00be\u00c2\5/\30\2\u00bf\u00c2"+
		"\5\61\31\2\u00c0\u00c2\7a\2\2\u00c1\u00be\3\2\2\2\u00c1\u00bf\3\2\2\2"+
		"\u00c1\u00c0\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4"+
		"\3\2\2\2\u00c4\u00cf\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00ca\7a\2\2\u00c7"+
		"\u00cb\5/\30\2\u00c8\u00cb\5\61\31\2\u00c9\u00cb\7a\2\2\u00ca\u00c7\3"+
		"\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc"+
		"\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cf\3\2\2\2\u00ce\u00bd\3\2"+
		"\2\2\u00ce\u00c6\3\2\2\2\u00cf(\3\2\2\2\u00d0\u00d6\7b\2\2\u00d1\u00d5"+
		"\n\3\2\2\u00d2\u00d3\7^\2\2\u00d3\u00d5\13\2\2\2\u00d4\u00d1\3\2\2\2\u00d4"+
		"\u00d2\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d6\u00d4\3\2"+
		"\2\2\u00d7\u00d9\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9\u00da\7b\2\2\u00da"+
		"*\3\2\2\2\u00db\u00e1\7)\2\2\u00dc\u00e0\n\4\2\2\u00dd\u00de\7^\2\2\u00de"+
		"\u00e0\13\2\2\2\u00df\u00dc\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e3\3"+
		"\2\2\2\u00e1\u00e2\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00e4\3\2\2\2\u00e3"+
		"\u00e1\3\2\2\2\u00e4\u00f0\7)\2\2\u00e5\u00eb\7$\2\2\u00e6\u00ea\n\5\2"+
		"\2\u00e7\u00e8\7^\2\2\u00e8\u00ea\13\2\2\2\u00e9\u00e6\3\2\2\2\u00e9\u00e7"+
		"\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00ec\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec"+
		"\u00ee\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00f0\7$\2\2\u00ef\u00db\3\2"+
		"\2\2\u00ef\u00e5\3\2\2\2\u00f0,\3\2\2\2\u00f1\u00f2\7)\2\2\u00f2\u00f3"+
		"\7)\2\2\u00f3\u00f4\7)\2\2\u00f4\u00f8\3\2\2\2\u00f5\u00f7\13\2\2\2\u00f6"+
		"\u00f5\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f8\u00f6\3\2"+
		"\2\2\u00f9\u00fb\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb\u00fc\7)\2\2\u00fc"+
		"\u00fd\7)\2\2\u00fd\u010c\7)\2\2\u00fe\u00ff\7$\2\2\u00ff\u0100\7$\2\2"+
		"\u0100\u0101\7$\2\2\u0101\u0105\3\2\2\2\u0102\u0104\13\2\2\2\u0103\u0102"+
		"\3\2\2\2\u0104\u0107\3\2\2\2\u0105\u0106\3\2\2\2\u0105\u0103\3\2\2\2\u0106"+
		"\u0108\3\2\2\2\u0107\u0105\3\2\2\2\u0108\u0109\7$\2\2\u0109\u010a\7$\2"+
		"\2\u010a\u010c\7$\2\2\u010b\u00f1\3\2\2\2\u010b\u00fe\3\2\2\2\u010c.\3"+
		"\2\2\2\u010d\u010e\t\6\2\2\u010e\60\3\2\2\2\u010f\u0110\t\7\2\2\u0110"+
		"\62\3\2\2\2\u0111\u0112\7/\2\2\u0112\u0113\7/\2\2\u0113\u0117\3\2\2\2"+
		"\u0114\u0116\n\b\2\2\u0115\u0114\3\2\2\2\u0116\u0119\3\2\2\2\u0117\u0115"+
		"\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u011d\3\2\2\2\u0119\u0117\3\2\2\2\u011a"+
		"\u011e\7\f\2\2\u011b\u011c\7\17\2\2\u011c\u011e\7\f\2\2\u011d\u011a\3"+
		"\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u011f\3\2\2\2\u011f"+
		"\u0120\b\32\2\2\u0120\64\3\2\2\2\u0121\u0122\7\61\2\2\u0122\u0123\7,\2"+
		"\2\u0123\u0127\3\2\2\2\u0124\u0126\13\2\2\2\u0125\u0124\3\2\2\2\u0126"+
		"\u0129\3\2\2\2\u0127\u0128\3\2\2\2\u0127\u0125\3\2\2\2\u0128\u012a\3\2"+
		"\2\2\u0129\u0127\3\2\2\2\u012a\u012b\7,\2\2\u012b\u012c\7\61\2\2\u012c"+
		"\u012d\3\2\2\2\u012d\u012e\b\33\2\2\u012e\66\3\2\2\2\u012f\u0131\t\t\2"+
		"\2\u0130\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133"+
		"\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0135\b\34\2\2\u01358\3\2\2\2\u0136"+
		"\u0137\13\2\2\2\u0137:\3\2\2\2\33\2\u00a6\u00ad\u00b2\u00b6\u00bb\u00c1"+
		"\u00c3\u00ca\u00cc\u00ce\u00d4\u00d6\u00df\u00e1\u00e9\u00eb\u00ef\u00f8"+
		"\u0105\u010b\u0117\u011d\u0127\u0132\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}