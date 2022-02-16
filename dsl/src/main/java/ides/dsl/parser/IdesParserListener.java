// Generated from /Users/sgr/develop/ideaProjects/github/ides/dsl/src/main/resources/IdesParser.g4 by ANTLR 4.9.2

    package ides.dsl.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link IdesParser}.
 */
public interface IdesParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link IdesParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(IdesParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(IdesParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Iql}
	 * labeled alternative in {@link IdesParser#script}.
	 * @param ctx the parse tree
	 */
	void enterIql(IdesParser.IqlContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Iql}
	 * labeled alternative in {@link IdesParser#script}.
	 * @param ctx the parse tree
	 */
	void exitIql(IdesParser.IqlContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Py}
	 * labeled alternative in {@link IdesParser#script}.
	 * @param ctx the parse tree
	 */
	void enterPy(IdesParser.PyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Py}
	 * labeled alternative in {@link IdesParser#script}.
	 * @param ctx the parse tree
	 */
	void exitPy(IdesParser.PyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Sql}
	 * labeled alternative in {@link IdesParser#script}.
	 * @param ctx the parse tree
	 */
	void enterSql(IdesParser.SqlContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Sql}
	 * labeled alternative in {@link IdesParser#script}.
	 * @param ctx the parse tree
	 */
	void exitSql(IdesParser.SqlContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Sh}
	 * labeled alternative in {@link IdesParser#script}.
	 * @param ctx the parse tree
	 */
	void enterSh(IdesParser.ShContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Sh}
	 * labeled alternative in {@link IdesParser#script}.
	 * @param ctx the parse tree
	 */
	void exitSh(IdesParser.ShContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesParser#pythonCode}.
	 * @param ctx the parse tree
	 */
	void enterPythonCode(IdesParser.PythonCodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesParser#pythonCode}.
	 * @param ctx the parse tree
	 */
	void exitPythonCode(IdesParser.PythonCodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesParser#pyStatement}.
	 * @param ctx the parse tree
	 */
	void enterPyStatement(IdesParser.PyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesParser#pyStatement}.
	 * @param ctx the parse tree
	 */
	void exitPyStatement(IdesParser.PyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesParser#sqlCode}.
	 * @param ctx the parse tree
	 */
	void enterSqlCode(IdesParser.SqlCodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesParser#sqlCode}.
	 * @param ctx the parse tree
	 */
	void exitSqlCode(IdesParser.SqlCodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesParser#sqlStatement}.
	 * @param ctx the parse tree
	 */
	void enterSqlStatement(IdesParser.SqlStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesParser#sqlStatement}.
	 * @param ctx the parse tree
	 */
	void exitSqlStatement(IdesParser.SqlStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesParser#shellCode}.
	 * @param ctx the parse tree
	 */
	void enterShellCode(IdesParser.ShellCodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesParser#shellCode}.
	 * @param ctx the parse tree
	 */
	void exitShellCode(IdesParser.ShellCodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesParser#shellStatement}.
	 * @param ctx the parse tree
	 */
	void enterShellStatement(IdesParser.ShellStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesParser#shellStatement}.
	 * @param ctx the parse tree
	 */
	void exitShellStatement(IdesParser.ShellStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Load}
	 * labeled alternative in {@link IdesParser#query}.
	 * @param ctx the parse tree
	 */
	void enterLoad(IdesParser.LoadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Load}
	 * labeled alternative in {@link IdesParser#query}.
	 * @param ctx the parse tree
	 */
	void exitLoad(IdesParser.LoadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Save}
	 * labeled alternative in {@link IdesParser#query}.
	 * @param ctx the parse tree
	 */
	void enterSave(IdesParser.SaveContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Save}
	 * labeled alternative in {@link IdesParser#query}.
	 * @param ctx the parse tree
	 */
	void exitSave(IdesParser.SaveContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Select}
	 * labeled alternative in {@link IdesParser#query}.
	 * @param ctx the parse tree
	 */
	void enterSelect(IdesParser.SelectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Select}
	 * labeled alternative in {@link IdesParser#query}.
	 * @param ctx the parse tree
	 */
	void exitSelect(IdesParser.SelectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Connect}
	 * labeled alternative in {@link IdesParser#query}.
	 * @param ctx the parse tree
	 */
	void enterConnect(IdesParser.ConnectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Connect}
	 * labeled alternative in {@link IdesParser#query}.
	 * @param ctx the parse tree
	 */
	void exitConnect(IdesParser.ConnectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Set}
	 * labeled alternative in {@link IdesParser#query}.
	 * @param ctx the parse tree
	 */
	void enterSet(IdesParser.SetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Set}
	 * labeled alternative in {@link IdesParser#query}.
	 * @param ctx the parse tree
	 */
	void exitSet(IdesParser.SetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Drop}
	 * labeled alternative in {@link IdesParser#query}.
	 * @param ctx the parse tree
	 */
	void enterDrop(IdesParser.DropContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Drop}
	 * labeled alternative in {@link IdesParser#query}.
	 * @param ctx the parse tree
	 */
	void exitDrop(IdesParser.DropContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Create}
	 * labeled alternative in {@link IdesParser#query}.
	 * @param ctx the parse tree
	 */
	void enterCreate(IdesParser.CreateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Create}
	 * labeled alternative in {@link IdesParser#query}.
	 * @param ctx the parse tree
	 */
	void exitCreate(IdesParser.CreateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Register}
	 * labeled alternative in {@link IdesParser#query}.
	 * @param ctx the parse tree
	 */
	void enterRegister(IdesParser.RegisterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Register}
	 * labeled alternative in {@link IdesParser#query}.
	 * @param ctx the parse tree
	 */
	void exitRegister(IdesParser.RegisterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Run}
	 * labeled alternative in {@link IdesParser#query}.
	 * @param ctx the parse tree
	 */
	void enterRun(IdesParser.RunContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Run}
	 * labeled alternative in {@link IdesParser#query}.
	 * @param ctx the parse tree
	 */
	void exitRun(IdesParser.RunContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesParser#module}.
	 * @param ctx the parse tree
	 */
	void enterModule(IdesParser.ModuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesParser#module}.
	 * @param ctx the parse tree
	 */
	void exitModule(IdesParser.ModuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesParser#format}.
	 * @param ctx the parse tree
	 */
	void enterFormat(IdesParser.FormatContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesParser#format}.
	 * @param ctx the parse tree
	 */
	void exitFormat(IdesParser.FormatContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesParser#path}.
	 * @param ctx the parse tree
	 */
	void enterPath(IdesParser.PathContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesParser#path}.
	 * @param ctx the parse tree
	 */
	void exitPath(IdesParser.PathContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesParser#col}.
	 * @param ctx the parse tree
	 */
	void enterCol(IdesParser.ColContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesParser#col}.
	 * @param ctx the parse tree
	 */
	void exitCol(IdesParser.ColContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesParser#colGroup}.
	 * @param ctx the parse tree
	 */
	void enterColGroup(IdesParser.ColGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesParser#colGroup}.
	 * @param ctx the parse tree
	 */
	void exitColGroup(IdesParser.ColGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesParser#whereExpressions}.
	 * @param ctx the parse tree
	 */
	void enterWhereExpressions(IdesParser.WhereExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesParser#whereExpressions}.
	 * @param ctx the parse tree
	 */
	void exitWhereExpressions(IdesParser.WhereExpressionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesParser#partitionbyExpression}.
	 * @param ctx the parse tree
	 */
	void enterPartitionbyExpression(IdesParser.PartitionbyExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesParser#partitionbyExpression}.
	 * @param ctx the parse tree
	 */
	void exitPartitionbyExpression(IdesParser.PartitionbyExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExpression(IdesParser.BooleanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExpression(IdesParser.BooleanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesParser#keyName}.
	 * @param ctx the parse tree
	 */
	void enterKeyName(IdesParser.KeyNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesParser#keyName}.
	 * @param ctx the parse tree
	 */
	void exitKeyName(IdesParser.KeyNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesParser#valueName}.
	 * @param ctx the parse tree
	 */
	void enterValueName(IdesParser.ValueNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesParser#valueName}.
	 * @param ctx the parse tree
	 */
	void exitValueName(IdesParser.ValueNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(IdesParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(IdesParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(IdesParser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(IdesParser.QualifiedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesParser#asAsset}.
	 * @param ctx the parse tree
	 */
	void enterAsAsset(IdesParser.AsAssetContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesParser#asAsset}.
	 * @param ctx the parse tree
	 */
	void exitAsAsset(IdesParser.AsAssetContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesParser#assetName}.
	 * @param ctx the parse tree
	 */
	void enterAssetName(IdesParser.AssetNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesParser#assetName}.
	 * @param ctx the parse tree
	 */
	void exitAssetName(IdesParser.AssetNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(IdesParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(IdesParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesParser#quotedIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterQuotedIdentifier(IdesParser.QuotedIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesParser#quotedIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitQuotedIdentifier(IdesParser.QuotedIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesParser#where}.
	 * @param ctx the parse tree
	 */
	void enterWhere(IdesParser.WhereContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesParser#where}.
	 * @param ctx the parse tree
	 */
	void exitWhere(IdesParser.WhereContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesParser#saveMode}.
	 * @param ctx the parse tree
	 */
	void enterSaveMode(IdesParser.SaveModeContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesParser#saveMode}.
	 * @param ctx the parse tree
	 */
	void exitSaveMode(IdesParser.SaveModeContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesParser#outTable}.
	 * @param ctx the parse tree
	 */
	void enterOutTable(IdesParser.OutTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesParser#outTable}.
	 * @param ctx the parse tree
	 */
	void exitOutTable(IdesParser.OutTableContext ctx);
}