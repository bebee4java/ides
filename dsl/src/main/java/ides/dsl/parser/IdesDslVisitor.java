// Generated from /Users/sgr/develop/ideaProject/ides/dsl/src/main/resources/IdesDsl.g4 by ANTLR 4.7.2

    package ides.dsl.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link IdesDslParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface IdesDslVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link IdesDslParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(IdesDslParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Sql}
	 * labeled alternative in {@link IdesDslParser#script}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSql(IdesDslParser.SqlContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Load}
	 * labeled alternative in {@link IdesDslParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoad(IdesDslParser.LoadContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Save}
	 * labeled alternative in {@link IdesDslParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSave(IdesDslParser.SaveContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesDslParser#format}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormat(IdesDslParser.FormatContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesDslParser#path}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPath(IdesDslParser.PathContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesDslParser#col}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCol(IdesDslParser.ColContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesDslParser#colGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColGroup(IdesDslParser.ColGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesDslParser#whereExpressions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereExpressions(IdesDslParser.WhereExpressionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesDslParser#partitionbyExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionbyExpression(IdesDslParser.PartitionbyExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesDslParser#booleanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpression(IdesDslParser.BooleanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesDslParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(IdesDslParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesDslParser#qualifiedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedName(IdesDslParser.QualifiedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesDslParser#asTableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsTableName(IdesDslParser.AsTableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesDslParser#tableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableName(IdesDslParser.TableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesDslParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(IdesDslParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesDslParser#quotedIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuotedIdentifier(IdesDslParser.QuotedIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesDslParser#eoq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEoq(IdesDslParser.EoqContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesDslParser#dot}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDot(IdesDslParser.DotContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesDslParser#as}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAs(IdesDslParser.AsContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesDslParser#where}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhere(IdesDslParser.WhereContext ctx);
	/**
	 * Visit a parse tree produced by {@link IdesDslParser#saveMode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSaveMode(IdesDslParser.SaveModeContext ctx);
}