
    package ides.dsl.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link IdesDslParser}.
 */
public interface IdesDslListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link IdesDslParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(IdesDslParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesDslParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(IdesDslParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Sql}
	 * labeled alternative in {@link IdesDslParser#script}.
	 * @param ctx the parse tree
	 */
	void enterSql(IdesDslParser.SqlContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Sql}
	 * labeled alternative in {@link IdesDslParser#script}.
	 * @param ctx the parse tree
	 */
	void exitSql(IdesDslParser.SqlContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Load}
	 * labeled alternative in {@link IdesDslParser#query}.
	 * @param ctx the parse tree
	 */
	void enterLoad(IdesDslParser.LoadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Load}
	 * labeled alternative in {@link IdesDslParser#query}.
	 * @param ctx the parse tree
	 */
	void exitLoad(IdesDslParser.LoadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Save}
	 * labeled alternative in {@link IdesDslParser#query}.
	 * @param ctx the parse tree
	 */
	void enterSave(IdesDslParser.SaveContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Save}
	 * labeled alternative in {@link IdesDslParser#query}.
	 * @param ctx the parse tree
	 */
	void exitSave(IdesDslParser.SaveContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Select}
	 * labeled alternative in {@link IdesDslParser#query}.
	 * @param ctx the parse tree
	 */
	void enterSelect(IdesDslParser.SelectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Select}
	 * labeled alternative in {@link IdesDslParser#query}.
	 * @param ctx the parse tree
	 */
	void exitSelect(IdesDslParser.SelectContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesDslParser#format}.
	 * @param ctx the parse tree
	 */
	void enterFormat(IdesDslParser.FormatContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesDslParser#format}.
	 * @param ctx the parse tree
	 */
	void exitFormat(IdesDslParser.FormatContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesDslParser#path}.
	 * @param ctx the parse tree
	 */
	void enterPath(IdesDslParser.PathContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesDslParser#path}.
	 * @param ctx the parse tree
	 */
	void exitPath(IdesDslParser.PathContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesDslParser#col}.
	 * @param ctx the parse tree
	 */
	void enterCol(IdesDslParser.ColContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesDslParser#col}.
	 * @param ctx the parse tree
	 */
	void exitCol(IdesDslParser.ColContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesDslParser#colGroup}.
	 * @param ctx the parse tree
	 */
	void enterColGroup(IdesDslParser.ColGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesDslParser#colGroup}.
	 * @param ctx the parse tree
	 */
	void exitColGroup(IdesDslParser.ColGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesDslParser#whereExpressions}.
	 * @param ctx the parse tree
	 */
	void enterWhereExpressions(IdesDslParser.WhereExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesDslParser#whereExpressions}.
	 * @param ctx the parse tree
	 */
	void exitWhereExpressions(IdesDslParser.WhereExpressionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesDslParser#partitionbyExpression}.
	 * @param ctx the parse tree
	 */
	void enterPartitionbyExpression(IdesDslParser.PartitionbyExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesDslParser#partitionbyExpression}.
	 * @param ctx the parse tree
	 */
	void exitPartitionbyExpression(IdesDslParser.PartitionbyExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesDslParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExpression(IdesDslParser.BooleanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesDslParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExpression(IdesDslParser.BooleanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesDslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(IdesDslParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesDslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(IdesDslParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesDslParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(IdesDslParser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesDslParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(IdesDslParser.QualifiedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesDslParser#asTableName}.
	 * @param ctx the parse tree
	 */
	void enterAsTableName(IdesDslParser.AsTableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesDslParser#asTableName}.
	 * @param ctx the parse tree
	 */
	void exitAsTableName(IdesDslParser.AsTableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesDslParser#tableName}.
	 * @param ctx the parse tree
	 */
	void enterTableName(IdesDslParser.TableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesDslParser#tableName}.
	 * @param ctx the parse tree
	 */
	void exitTableName(IdesDslParser.TableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesDslParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(IdesDslParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesDslParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(IdesDslParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesDslParser#quotedIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterQuotedIdentifier(IdesDslParser.QuotedIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesDslParser#quotedIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitQuotedIdentifier(IdesDslParser.QuotedIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesDslParser#where}.
	 * @param ctx the parse tree
	 */
	void enterWhere(IdesDslParser.WhereContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesDslParser#where}.
	 * @param ctx the parse tree
	 */
	void exitWhere(IdesDslParser.WhereContext ctx);
	/**
	 * Enter a parse tree produced by {@link IdesDslParser#saveMode}.
	 * @param ctx the parse tree
	 */
	void enterSaveMode(IdesDslParser.SaveModeContext ctx);
	/**
	 * Exit a parse tree produced by {@link IdesDslParser#saveMode}.
	 * @param ctx the parse tree
	 */
	void exitSaveMode(IdesDslParser.SaveModeContext ctx);
}