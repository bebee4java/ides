package tech.ides.dsl.listener

import ides.dsl.parser.{IdesParser, IdesParserBaseListener}
import tech.ides.dsl.adaptor.{CommandAdaptor, SetAdaptor}
import tech.ides.dsl.statement.{QuerySqlStatement, SqlStatement}
import tech.ides.dsl.utils.DslUtil.currentText
import tech.ides.script.ScriptTemplate
import tech.sqlclub.common.log.Logging
import scala.collection.mutable.ArrayBuffer

/**
 * 脚本预处理监听器类
 * 主要处理 宏命令翻译、include脚本处理、set变量渲染脚本等
 * Created by songgr on 2022/03/02.
 */
class PreProcessListener(sqel: ScriptQueryExecListener) extends IdesParserBaseListener with Logging {

  private val statements = new ArrayBuffer[SqlStatement]()

  def toScript = statements.map(_.sql).mkString("\n")

  def addStatement(statement: SqlStatement) = {
    statements += statement
    this
  }

  /**
   * command语句处理
   * 宏(!)命令 翻译成run语句
   */
  override def exitCommand(ctx: IdesParser.CommandContext): Unit = {
    val statement = CommandAdaptor(sqel).parse(ctx)
//    println("Command=============>")
//    println(statement.sql)
  }


  /**
   * set语句处理
   * 执行set语法将变量值设置到env中
   */
  override def exitSet(ctx: IdesParser.SetContext): Unit = {
    SetAdaptor(sqel).execute(ctx)
  }

  /**
   * 单条iql语句
   * 包含load、save、run、set等基本语法
   */
  override def exitIql(ctx: IdesParser.IqlContext): Unit = {
    val sql = currentText(ctx)
    // 进行变量渲染
    val script = ScriptTemplate.merge(sql, sqel.env)
    addStatement(QuerySqlStatement(script, sql))
  }

  /**
   * 单个ides语句
   * 包含 iql基本语法、python/shell/scala原始语法、sql原始语句
   */
  override def exitIdesScript(ctx: IdesParser.IdesScriptContext): Unit = {
    val script = currentText(ctx)

    val statement = QuerySqlStatement(script, script)
    if ( !statements.map(_.originalSQL).exists(_.equals(statement.originalSQL)) ) {
      log.debug(s"add sqlStatement: ${statement.originalSQL}")
      addStatement(statement)
    }
  }

  /**
   * 整个脚本
   */
  override def exitStatement(ctx: IdesParser.StatementContext): Unit = { }
}
