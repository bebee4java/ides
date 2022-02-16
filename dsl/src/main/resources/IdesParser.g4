parser grammar IdesParser;

@header {
    package ides.dsl.parser;
}

options { tokenVocab=IdesLexer; }

// 一个脚本以0到n条query语句组成
statement
    : script*
    ;

script
    : query EOQ # Iql
    | PY_MODE pythonCode EXIT_PY NL? outTable? # Py
    | SQL_MODE sqlCode EXIT_SQL NL? outTable? # Sql
    | SHELL_MODE shellCode EXIT_SH NL? outTable? # Sh
    ;

pythonCode
    : pyStatement*
    ;

pyStatement
    : PY_TEXT
    ;

sqlCode
    : sqlStatement*
    ;

sqlStatement
    : SQL_TEXT
    ;

shellCode
    : shellStatement*
    ;

shellStatement
    : SHELL_TEXT
    ;

// query语句规则
query
    : LOAD format DOT path whereExpressions? asAsset # Load
    | SAVE assetName saveMode? INTO format DOT path whereExpressions? partitionbyExpression? # Save
    | SELECT ~(EOQ)+ asAsset # Select
    | CONNECT format whereExpressions asAsset # Connect
    | SET expression whereExpressions? # Set
    | DROP resource=(CONNECTION|FUNCTION) format DOT assetName # Drop
    | CREATE ~(EOQ)+ # Create
    | REGISTER module DOT path whereExpressions? asAsset? # Register
    | RUN module DOT path whereExpressions? asAsset? # Run
    ;

module
    : identifier
    | quotedIdentifier
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
    : COMMA col
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

keyName
    : qualifiedName
    ;
valueName
    : MUMERIC
    | STRING_TEXT
    | BLOCK_STRING_TEXT
    | QUOTED_TEXT
    ;

expression
    : keyName EQ valueName
    ;

qualifiedName
    : identifier (DOT identifier)*
    ;

asAsset
    : AS assetName
    ;

assetName
    : identifier
    | quotedIdentifier
    ;

identifier
    : IDENTIFIER
    ;

quotedIdentifier
    : QUOTED_TEXT
    ;

where: OPTIONS|WHERE;
saveMode: OVERWRITE|APPEND|ERRORIfExists|IGNORE;

outTable : OUT assetName;