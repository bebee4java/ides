lexer grammar IdesLexer;

@header {
    package ides.dsl.parser;
}

channels { COMMENT }

PY_MODE : '%python'('(' (IDENTIFIER|QUOTED_TEXT)? ')')? NL -> pushMode(PYTHON_LAN);
SQL_MODE : '%sql'('(' (IDENTIFIER|QUOTED_TEXT)? ')')? NL -> pushMode(SQL_LAN);
SHELL_MODE : '%sh' NL -> pushMode(SHELL_LAN);

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
CONNECT: 'connect';
SET: 'set';
//============================
// End of the keywords list
//============================

DOT
    : '.'
    ;

EQ
  : '='
  ;

COMMA
    : ','
    ;

OUT
    : '>'
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

WS  : (' '|'\r'|'\t'|'\n') -> channel(HIDDEN)
    ;

// ～x 是指除x外的任何字符
LINE_COMMENT
    : '--' ~[\r\n]* NL?  -> channel(HIDDEN) // 单行注释
    ;

BLOCK_COMMENT
    : '/*' .*? '*/' -> channel(HIDDEN)  // 多行注释
    ;

// match both UNIX and Windows newLines
NL
    : '\n'
    | '\r\n'
    ;

// channel(HIDDEN) 隐藏通道会 忽略却保留 匹配的词法符号
//WS
//    : [ \r\n\t]+ -> channel(HIDDEN)    // 匹配一个或者多个空白字符
//    ;

// Catch-all for anything we can't recognize.
// We use this to be able to ignore and recover all the text
// when splitting statements with DelimiterLexer
UNRECOGNIZED
    : .
    ;


//============================
// Start of the python mode
//============================
mode PYTHON_LAN;

EXIT_PY : '%' -> popMode;
IGNORE_PY : . -> more ;

PY_RETURN
    : '\n'
    | '\r\n'
    ;

PY_STRING
    : '\'\'\'' .*? '\'\'\''
    | '"""' .*? '"""'
    | '\'' ( ~('\''|'\\') | ('\\' .) )*? '\''
    | '"' ( ~('"'|'\\') | ('\\' .) )*? '"'
    ;

VARIABLE
    : LETTER(DIGIT | LETTER | '_')*
    | '_'(DIGIT | LETTER | '_')+
    ;

VariableRef
    : '%'[ \t]*VARIABLE
    | '%'[ \t]*'(' .*? ')'
    | '%'[ \t]*'{' .*? '}'
    ;

// % 打头认为end
PY_NonEnd
    : ~[ \r\n\t]+ ( [ \t]* '%' [ \t]* ~[ \r\n\t]+ )+
    ;

PY_TEXT
    : ( PY_STRING| PY_NonEnd | VariableRef | ~('#'|'%'|'"'|'\''|'\r'|'\n') )+ PY_RETURN?
    ;

PY_COMMENT
    : '#'+ ~('#'|'\r'|'\n')* -> channel(COMMENT)
    ;

PY_WS
    : [ \r\n\t]+ -> skip
    ;
//============================
// End of the python mode
//============================

//============================
// Start of the SQL mode
//============================
mode SQL_LAN;

EXIT_SQL : '%' -> popMode;
IGNORE_SQL : . -> more ;

SQL_RETURN
    : '\n'
    | '\r\n'
    ;

SQL_TEXT
    : DML SQL_RETURN?
    | DDL SQL_RETURN?
    | Profile SQL_RETURN?
    ;

DDL
    : CreatStatement
    | AlterStatement
    | DropStatement
    | RenameStatement
    | TruncateStatement
    ;

DML
    : SelectStatement
    | InsertStatement
    | UpdateStatement
    | DeleteStatement
    | ReplaceStatement
    ;

Profile
    : UseStatement
    | ShowStatement
    | ExplainStatement
    | SetStatement
    | CallStatement
    | OpenStatement
    | CloseStatement
    | TransactionStatement
    | CommitStatement
    | RollbackStatement
    ;

SQL_COMMENT1
    : '#'+ ~('#'|'\r'|'\n')* -> channel(COMMENT)
    ;

SQL_COMMENT2
    : '-'+ ~('-'|'\r'|'\n')* -> channel(COMMENT)
    ;

SQL_COMMENT_BLOCK
    : '/*' .*? '*/' -> channel(COMMENT)
    ;

CreatStatement : 'create' ~(';')+ ';' ;
AlterStatement : 'alter' ~(';')+ ';' ;
DropStatement : 'drop' ~(';')+ ';' ;
RenameStatement : 'rename' ~(';')+ ';' ;
TruncateStatement : 'truncate' ~(';')+ ';' ;

SelectStatement : 'select' ~(';')+ ';' ;
InsertStatement : 'insert' ~(';')+ ';' ;
UpdateStatement : 'update' ~(';')+ ';' ;
DeleteStatement : 'delete' ~(';')+ ';' ;
ReplaceStatement : 'replace' ~(';')+ ';' ;

UseStatement : 'use' ~(';')+ ';' ;
ShowStatement : 'show' ~(';')+ ';' ;
ExplainStatement : 'explain' ~(';')+ ';' ;
SetStatement : 'set' ~(';')+ ';' ;
CallStatement : 'call' ~(';')+ ';' ;
OpenStatement : 'open' ~(';')+ ';' ;
CloseStatement : 'close' ~(';')+ ';' ;
TransactionStatement : ('start'|'begin') ~(';')+ ';';
CommitStatement : 'commit' ~(';')* ';';
RollbackStatement : 'rollback' ~(';')* ';';

SQL_WS
    : [ \r\n\t]+ -> skip
    ;
//============================
// End of the SQL mode
//============================

//============================
// Start of the shell mode
//============================
mode SHELL_LAN;

EXIT_SH : '%' -> popMode;
IGNORE_SH : . -> more ;

SH_RETURN
    : '\n'
    | '\r\n'
    ;

SH_STRING
    : '\'\'\'' .*? '\'\'\''
    | '"""' .*? '"""'
    | '\'' ( ~('\''|'\\') | ('\\' .) )*? '\''
    | '"' ( ~('"'|'\\') | ('\\' .) )*? '"'
    ;

// % 打头认为end
SH_NonEnd
    : ~[ \r\n\t]+ '%' ~(';'|'\r'|'\n')*
    ;

SHELL_TEXT
    : (~('#'|'%'|'"'|'\''|';'|'\r'|'\n') | SH_STRING| SH_NonEnd)+ ';' SH_RETURN?
    ;

SEHLL_COMMENT
    : '#'+ ~('#'|'\r'|'\n')* -> channel(COMMENT)
    ;

SH_WS
    : [ \r\n\t]+ -> skip
    ;
//============================
// End of the shell mode
//============================