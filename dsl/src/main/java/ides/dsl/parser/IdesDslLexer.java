// Generated from /Users/sgr/develop/github/ides/dsl/src/main/resources/IdesDsl.g4 by ANTLR 4.7.2

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
		CONNECT=16, SET=17, DOT=18, EOQ=19, MUMERIC=20, IDENTIFIER=21, QUOTED_TEXT=22, 
		STRING_TEXT=23, BLOCK_STRING_TEXT=24, LINE_COMMENT=25, BLOCK_COMMENT=26, 
		WS=27, UNRECOGNIZED=28;
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
			"CONNECT", "SET", "DOT", "EOQ", "MUMERIC", "IDENTIFIER", "QUOTED_TEXT", 
			"STRING_TEXT", "BLOCK_STRING_TEXT", "DIGIT", "LETTER", "LINE_COMMENT", 
			"BLOCK_COMMENT", "WS", "UNRECOGNIZED"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'='", "'as'", "'into'", "'load'", "'save'", "'select'", 
			"'options'", "'where'", "'and'", "'overwrite'", "'append'", "'errorIfExists'", 
			"'ignore'", null, "'connect'", "'set'", "'.'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "AS", "INTO", "LOAD", "SAVE", "SELECT", "OPTIONS", 
			"WHERE", "AND", "OVERWRITE", "APPEND", "ERRORIfExists", "IGNORE", "PARTITIONBY", 
			"CONNECT", "SET", "DOT", "EOQ", "MUMERIC", "IDENTIFIER", "QUOTED_TEXT", 
			"STRING_TEXT", "BLOCK_STRING_TEXT", "LINE_COMMENT", "BLOCK_COMMENT", 
			"WS", "UNRECOGNIZED"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\36\u0148\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00ab\n\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\24"+
		"\3\24\3\25\5\25\u00be\n\25\3\25\7\25\u00c1\n\25\f\25\16\25\u00c4\13\25"+
		"\3\25\5\25\u00c7\n\25\3\25\6\25\u00ca\n\25\r\25\16\25\u00cb\3\26\3\26"+
		"\3\26\3\26\7\26\u00d2\n\26\f\26\16\26\u00d5\13\26\3\26\3\26\3\26\3\26"+
		"\6\26\u00db\n\26\r\26\16\26\u00dc\5\26\u00df\n\26\3\27\3\27\3\27\3\27"+
		"\7\27\u00e5\n\27\f\27\16\27\u00e8\13\27\3\27\3\27\3\30\3\30\3\30\3\30"+
		"\7\30\u00f0\n\30\f\30\16\30\u00f3\13\30\3\30\3\30\3\30\3\30\3\30\7\30"+
		"\u00fa\n\30\f\30\16\30\u00fd\13\30\3\30\5\30\u0100\n\30\3\31\3\31\3\31"+
		"\3\31\3\31\7\31\u0107\n\31\f\31\16\31\u010a\13\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\7\31\u0114\n\31\f\31\16\31\u0117\13\31\3\31\3\31"+
		"\3\31\5\31\u011c\n\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34\7\34\u0126"+
		"\n\34\f\34\16\34\u0129\13\34\3\34\3\34\3\34\5\34\u012e\n\34\3\34\3\34"+
		"\3\35\3\35\3\35\3\35\7\35\u0136\n\35\f\35\16\35\u0139\13\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\36\6\36\u0141\n\36\r\36\16\36\u0142\3\36\3\36\3\37\3"+
		"\37\b\u00e6\u00f1\u00fb\u0108\u0115\u0137\2 \3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27-\30/\31\61\32\63\2\65\2\67\339\34;\35=\36\3\2\n\4\2--//\4\2^^bb\4"+
		"\2))^^\4\2$$^^\3\2\62;\4\2C\\c|\4\2\f\f\17\17\5\2\13\f\17\17\"\"\2\u0160"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\3?\3\2\2"+
		"\2\5A\3\2\2\2\7C\3\2\2\2\tF\3\2\2\2\13K\3\2\2\2\rP\3\2\2\2\17U\3\2\2\2"+
		"\21\\\3\2\2\2\23d\3\2\2\2\25j\3\2\2\2\27n\3\2\2\2\31x\3\2\2\2\33\177\3"+
		"\2\2\2\35\u008d\3\2\2\2\37\u00aa\3\2\2\2!\u00ac\3\2\2\2#\u00b4\3\2\2\2"+
		"%\u00b8\3\2\2\2\'\u00ba\3\2\2\2)\u00bd\3\2\2\2+\u00de\3\2\2\2-\u00e0\3"+
		"\2\2\2/\u00ff\3\2\2\2\61\u011b\3\2\2\2\63\u011d\3\2\2\2\65\u011f\3\2\2"+
		"\2\67\u0121\3\2\2\29\u0131\3\2\2\2;\u0140\3\2\2\2=\u0146\3\2\2\2?@\7."+
		"\2\2@\4\3\2\2\2AB\7?\2\2B\6\3\2\2\2CD\7c\2\2DE\7u\2\2E\b\3\2\2\2FG\7k"+
		"\2\2GH\7p\2\2HI\7v\2\2IJ\7q\2\2J\n\3\2\2\2KL\7n\2\2LM\7q\2\2MN\7c\2\2"+
		"NO\7f\2\2O\f\3\2\2\2PQ\7u\2\2QR\7c\2\2RS\7x\2\2ST\7g\2\2T\16\3\2\2\2U"+
		"V\7u\2\2VW\7g\2\2WX\7n\2\2XY\7g\2\2YZ\7e\2\2Z[\7v\2\2[\20\3\2\2\2\\]\7"+
		"q\2\2]^\7r\2\2^_\7v\2\2_`\7k\2\2`a\7q\2\2ab\7p\2\2bc\7u\2\2c\22\3\2\2"+
		"\2de\7y\2\2ef\7j\2\2fg\7g\2\2gh\7t\2\2hi\7g\2\2i\24\3\2\2\2jk\7c\2\2k"+
		"l\7p\2\2lm\7f\2\2m\26\3\2\2\2no\7q\2\2op\7x\2\2pq\7g\2\2qr\7t\2\2rs\7"+
		"y\2\2st\7t\2\2tu\7k\2\2uv\7v\2\2vw\7g\2\2w\30\3\2\2\2xy\7c\2\2yz\7r\2"+
		"\2z{\7r\2\2{|\7g\2\2|}\7p\2\2}~\7f\2\2~\32\3\2\2\2\177\u0080\7g\2\2\u0080"+
		"\u0081\7t\2\2\u0081\u0082\7t\2\2\u0082\u0083\7q\2\2\u0083\u0084\7t\2\2"+
		"\u0084\u0085\7K\2\2\u0085\u0086\7h\2\2\u0086\u0087\7G\2\2\u0087\u0088"+
		"\7z\2\2\u0088\u0089\7k\2\2\u0089\u008a\7u\2\2\u008a\u008b\7v\2\2\u008b"+
		"\u008c\7u\2\2\u008c\34\3\2\2\2\u008d\u008e\7k\2\2\u008e\u008f\7i\2\2\u008f"+
		"\u0090\7p\2\2\u0090\u0091\7q\2\2\u0091\u0092\7t\2\2\u0092\u0093\7g\2\2"+
		"\u0093\36\3\2\2\2\u0094\u0095\7r\2\2\u0095\u0096\7c\2\2\u0096\u0097\7"+
		"t\2\2\u0097\u0098\7v\2\2\u0098\u0099\7k\2\2\u0099\u009a\7v\2\2\u009a\u009b"+
		"\7k\2\2\u009b\u009c\7q\2\2\u009c\u009d\7p\2\2\u009d\u009e\7D\2\2\u009e"+
		"\u00ab\7{\2\2\u009f\u00a0\7r\2\2\u00a0\u00a1\7c\2\2\u00a1\u00a2\7t\2\2"+
		"\u00a2\u00a3\7v\2\2\u00a3\u00a4\7k\2\2\u00a4\u00a5\7v\2\2\u00a5\u00a6"+
		"\7k\2\2\u00a6\u00a7\7q\2\2\u00a7\u00a8\7p\2\2\u00a8\u00a9\7d\2\2\u00a9"+
		"\u00ab\7{\2\2\u00aa\u0094\3\2\2\2\u00aa\u009f\3\2\2\2\u00ab \3\2\2\2\u00ac"+
		"\u00ad\7e\2\2\u00ad\u00ae\7q\2\2\u00ae\u00af\7p\2\2\u00af\u00b0\7p\2\2"+
		"\u00b0\u00b1\7g\2\2\u00b1\u00b2\7e\2\2\u00b2\u00b3\7v\2\2\u00b3\"\3\2"+
		"\2\2\u00b4\u00b5\7u\2\2\u00b5\u00b6\7g\2\2\u00b6\u00b7\7v\2\2\u00b7$\3"+
		"\2\2\2\u00b8\u00b9\7\60\2\2\u00b9&\3\2\2\2\u00ba\u00bb\7=\2\2\u00bb(\3"+
		"\2\2\2\u00bc\u00be\t\2\2\2\u00bd\u00bc\3\2\2\2\u00bd\u00be\3\2\2\2\u00be"+
		"\u00c2\3\2\2\2\u00bf\u00c1\5\63\32\2\u00c0\u00bf\3\2\2\2\u00c1\u00c4\3"+
		"\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4"+
		"\u00c2\3\2\2\2\u00c5\u00c7\7\60\2\2\u00c6\u00c5\3\2\2\2\u00c6\u00c7\3"+
		"\2\2\2\u00c7\u00c9\3\2\2\2\u00c8\u00ca\5\63\32\2\u00c9\u00c8\3\2\2\2\u00ca"+
		"\u00cb\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc*\3\2\2\2"+
		"\u00cd\u00d3\5\65\33\2\u00ce\u00d2\5\63\32\2\u00cf\u00d2\5\65\33\2\u00d0"+
		"\u00d2\7a\2\2\u00d1\u00ce\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d0\3\2"+
		"\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4"+
		"\u00df\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00da\7a\2\2\u00d7\u00db\5\63"+
		"\32\2\u00d8\u00db\5\65\33\2\u00d9\u00db\7a\2\2\u00da\u00d7\3\2\2\2\u00da"+
		"\u00d8\3\2\2\2\u00da\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00da\3\2"+
		"\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00df\3\2\2\2\u00de\u00cd\3\2\2\2\u00de"+
		"\u00d6\3\2\2\2\u00df,\3\2\2\2\u00e0\u00e6\7b\2\2\u00e1\u00e5\n\3\2\2\u00e2"+
		"\u00e3\7^\2\2\u00e3\u00e5\13\2\2\2\u00e4\u00e1\3\2\2\2\u00e4\u00e2\3\2"+
		"\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7"+
		"\u00e9\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ea\7b\2\2\u00ea.\3\2\2\2\u00eb"+
		"\u00f1\7)\2\2\u00ec\u00f0\n\4\2\2\u00ed\u00ee\7^\2\2\u00ee\u00f0\13\2"+
		"\2\2\u00ef\u00ec\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1"+
		"\u00f2\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f2\u00f4\3\2\2\2\u00f3\u00f1\3\2"+
		"\2\2\u00f4\u0100\7)\2\2\u00f5\u00fb\7$\2\2\u00f6\u00fa\n\5\2\2\u00f7\u00f8"+
		"\7^\2\2\u00f8\u00fa\13\2\2\2\u00f9\u00f6\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa"+
		"\u00fd\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc\u00fe\3\2"+
		"\2\2\u00fd\u00fb\3\2\2\2\u00fe\u0100\7$\2\2\u00ff\u00eb\3\2\2\2\u00ff"+
		"\u00f5\3\2\2\2\u0100\60\3\2\2\2\u0101\u0102\7)\2\2\u0102\u0103\7)\2\2"+
		"\u0103\u0104\7)\2\2\u0104\u0108\3\2\2\2\u0105\u0107\13\2\2\2\u0106\u0105"+
		"\3\2\2\2\u0107\u010a\3\2\2\2\u0108\u0109\3\2\2\2\u0108\u0106\3\2\2\2\u0109"+
		"\u010b\3\2\2\2\u010a\u0108\3\2\2\2\u010b\u010c\7)\2\2\u010c\u010d\7)\2"+
		"\2\u010d\u011c\7)\2\2\u010e\u010f\7$\2\2\u010f\u0110\7$\2\2\u0110\u0111"+
		"\7$\2\2\u0111\u0115\3\2\2\2\u0112\u0114\13\2\2\2\u0113\u0112\3\2\2\2\u0114"+
		"\u0117\3\2\2\2\u0115\u0116\3\2\2\2\u0115\u0113\3\2\2\2\u0116\u0118\3\2"+
		"\2\2\u0117\u0115\3\2\2\2\u0118\u0119\7$\2\2\u0119\u011a\7$\2\2\u011a\u011c"+
		"\7$\2\2\u011b\u0101\3\2\2\2\u011b\u010e\3\2\2\2\u011c\62\3\2\2\2\u011d"+
		"\u011e\t\6\2\2\u011e\64\3\2\2\2\u011f\u0120\t\7\2\2\u0120\66\3\2\2\2\u0121"+
		"\u0122\7/\2\2\u0122\u0123\7/\2\2\u0123\u0127\3\2\2\2\u0124\u0126\n\b\2"+
		"\2\u0125\u0124\3\2\2\2\u0126\u0129\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128"+
		"\3\2\2\2\u0128\u012d\3\2\2\2\u0129\u0127\3\2\2\2\u012a\u012e\7\f\2\2\u012b"+
		"\u012c\7\17\2\2\u012c\u012e\7\f\2\2\u012d\u012a\3\2\2\2\u012d\u012b\3"+
		"\2\2\2\u012d\u012e\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0130\b\34\2\2\u0130"+
		"8\3\2\2\2\u0131\u0132\7\61\2\2\u0132\u0133\7,\2\2\u0133\u0137\3\2\2\2"+
		"\u0134\u0136\13\2\2\2\u0135\u0134\3\2\2\2\u0136\u0139\3\2\2\2\u0137\u0138"+
		"\3\2\2\2\u0137\u0135\3\2\2\2\u0138\u013a\3\2\2\2\u0139\u0137\3\2\2\2\u013a"+
		"\u013b\7,\2\2\u013b\u013c\7\61\2\2\u013c\u013d\3\2\2\2\u013d\u013e\b\35"+
		"\2\2\u013e:\3\2\2\2\u013f\u0141\t\t\2\2\u0140\u013f\3\2\2\2\u0141\u0142"+
		"\3\2\2\2\u0142\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0144\3\2\2\2\u0144"+
		"\u0145\b\36\2\2\u0145<\3\2\2\2\u0146\u0147\13\2\2\2\u0147>\3\2\2\2\33"+
		"\2\u00aa\u00bd\u00c2\u00c6\u00cb\u00d1\u00d3\u00da\u00dc\u00de\u00e4\u00e6"+
		"\u00ef\u00f1\u00f9\u00fb\u00ff\u0108\u0115\u011b\u0127\u012d\u0137\u0142"+
		"\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}