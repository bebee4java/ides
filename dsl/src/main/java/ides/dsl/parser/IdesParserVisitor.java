// Generated from /Users/sgr/develop/ideaProjects/github/ides/dsl/src/main/resources/IdesParser.g4 by ANTLR 4.9.2

    package ides.dsl.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link IdesParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface IdesParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link IdesParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(IdesParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Iql}
	 * labeled alternative in {@link IdesParser#script}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIql(IdesParser.IqlContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Py}
	 * labeled alternative in {@link IdesParser#script}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPy(IdesParser.PyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Sql}
	 * labeled alternative in {@link IdesParser#script}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSql(IdesParser.SqlContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Sh}
	 * labeled alternative in {@link IdesParser#script}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSh(IdesParser.ShContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesParser#pythonCode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPythonCode(IdesParser.PythonCodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesParser#pyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPyStatement(IdesParser.PyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesParser#sqlCode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSqlCode(IdesParser.SqlCodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesParser#sqlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSqlStatement(IdesParser.SqlStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesParser#shellCode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShellCode(IdesParser.ShellCodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesParser#shellStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShellStatement(IdesParser.ShellStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Load}
	 * labeled alternative in {@link IdesParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoad(IdesParser.LoadContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Save}
	 * labeled alternative in {@link IdesParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSave(IdesParser.SaveContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Select}
	 * labeled alternative in {@link IdesParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect(IdesParser.SelectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Connect}
	 * labeled alternative in {@link IdesParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConnect(IdesParser.ConnectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Set}
	 * labeled alternative in {@link IdesParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet(IdesParser.SetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Drop}
	 * labeled alternative in {@link IdesParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop(IdesParser.DropContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Create}
	 * labeled alternative in {@link IdesParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate(IdesParser.CreateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Register}
	 * labeled alternative in {@link IdesParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegister(IdesParser.RegisterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Run}
	 * labeled alternative in {@link IdesParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRun(IdesParser.RunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Command}
	 * labeled alternative in {@link IdesParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(IdesParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesParser#module}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModule(IdesParser.ModuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesParser#format}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormat(IdesParser.FormatContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesParser#path}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPath(IdesParser.PathContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesParser#col}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCol(IdesParser.ColContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesParser#colGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColGroup(IdesParser.ColGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesParser#whereExpressions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereExpressions(IdesParser.WhereExpressionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesParser#partitionbyExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionbyExpression(IdesParser.PartitionbyExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesParser#booleanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpression(IdesParser.BooleanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesParser#keyName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyName(IdesParser.KeyNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesParser#valueName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueName(IdesParser.ValueNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesParser#mumericValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMumericValue(IdesParser.MumericValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesParser#stringValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringValue(IdesParser.StringValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(IdesParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesParser#qualifiedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedName(IdesParser.QualifiedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesParser#asAsset}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsAsset(IdesParser.AsAssetContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesParser#assetName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssetName(IdesParser.AssetNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(IdesParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesParser#quotedIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuotedIdentifier(IdesParser.QuotedIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesParser#where}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhere(IdesParser.WhereContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesParser#saveMode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSaveMode(IdesParser.SaveModeContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesParser#outTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutTable(IdesParser.OutTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesParser#commandSymbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommandSymbol(IdesParser.CommandSymbolContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesParser#commandParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommandParam(IdesParser.CommandParamContext ctx);
}