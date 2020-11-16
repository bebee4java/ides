grammar IdesDsl;

@header {
    package ides.dsl.parser;
}

// 一个脚本以0到n条query语句组成
statement
    : script*
    ;

script
    : query EOQ # Sql
    ;

// query语句规则
query
    : LOAD format DOT path whereExpressions? asTableName # Load
    | SAVE tableName saveMode? INTO format DOT path whereExpressions? partitionbyExpression? # Save
    | SELECT ~(EOQ)+ asTableName # Select
    ;

format
    : identifier
    | quotedIdentifier
    ;

path
    : quotedIdentifier
    ;

col
    : identifier
    ;

colGroup
    : ',' col
    ;

whereExpressions
    : where expression booleanExpression*
    ;

partitionbyExpression
    : PARTITIONBY col colGroup*
    ;

booleanExpression
    : AND expression
    ;

expression
    : qualifiedName '=' (MUMERIC | STRING_TEXT | BLOCK_STRING_TEXT)
    ;

qualifiedName
    : identifier ('.' identifier)*
    ;

asTableName
    : AS tableName
    ;

tableName
    : identifier
    ;

identifier
    : IDENTIFIER
    ;

quotedIdentifier
    : QUOTED_TEXT
    ;

where: OPTIONS|WHERE;
saveMode: OVERWRITE|APPEND|ERRORIfExists|IGNORE;


//============================
// Start of the keywords list
//============================
AS: 'as';
INTO: 'into';
LOAD: 'load';
SAVE: 'save';
SELECT: 'select';
OPTIONS:'options';
WHERE: 'where';
AND: 'and';
OVERWRITE: 'overwrite';
APPEND: 'append';
ERRORIfExists: 'errorIfExists';
IGNORE: 'ignore';
PARTITIONBY: 'partitionBy'|'partitionby';
//============================
// End of the keywords list
//============================

DOT
    : '.'
    ;

// end of query
EOQ
    : ';'
    ;

MUMERIC
    : ('-'|'+')? DIGIT* '.'? DIGIT+
    ;

// 标识符规则: 数字，字母和下划线（_）组成，数字不能打头，下划线不能单独打头
IDENTIFIER
    : LETTER(DIGIT | LETTER | '_')* // 字母开头后面接任意个(数字｜字母｜下划线) a1 ab1 a_1 ab_
    | '_'(DIGIT | LETTER | '_')+  // _开头后面至少接一个(数字｜字母｜下划线) _1 _a _a1 _1a
    ;

// 匹配`x` x是非`(可以通过\转义)的任何字符
QUOTED_TEXT
    : '`' ( ~('`'|'\\') | ('\\' .) )*? '`'
    ;

STRING_TEXT
    : '\'' ( ~('\''|'\\') | ('\\' .) )*? '\''
    | '"' ( ~('"'|'\\') | ('\\' .) )*? '"'
    ;

BLOCK_STRING_TEXT
    : '\'\'\'' .*? '\'\'\''
    | '"""' .*? '"""'
    ;

// fragment：该规则本身不是一个词法符号，它只会被其他词法规则使用
fragment
DIGIT
    : [0-9]    // 定义数字
    ;

fragment
LETTER
    : [a-zA-Z]    // 定义字母
    ;

// ～x 是指除x外的任何字符
LINE_COMMENT
    : '--' ~[\r\n]* ('\n' | '\r\n')?  -> channel(HIDDEN) // 单行注释
    ;

BLOCK_COMMENT
    : '/*' .*? '*/' -> channel(HIDDEN)  // 多行注释
    ;

// match both UNIX and Windows newLines
//NL
//    : '\n'
//    | '\r\n'
//    ;

// channel(HIDDEN) 隐藏通道会 忽略却保留 匹配的词法符号
WS
    : [ \r\n\t]+ -> channel(HIDDEN)    // 匹配一个或者多个空白字符
    ;

// Catch-all for anything we can't recognize.
// We use this to be able to ignore and recover all the text
// when splitting statements with DelimiterLexer
UNRECOGNIZED
    : .
    ;