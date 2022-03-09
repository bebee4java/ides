package tech.ides.dsl.adaptor

import ides.dsl.parser.IdesParser
import ides.dsl.parser.IdesParser.CommandContext
import tech.ides.dsl.listener.ScriptQueryExecListener
import tech.ides.dsl.statement.{CommandSqlStatement, SqlStatement}
import tech.ides.dsl.utils.DslUtil.currentText


/**
 * Run 语法适配器
 * Created by songgr on 2022/02/16.
 */
case class CommandAdaptor(scriptQueryExecListener: ScriptQueryExecListener) extends ScriptDslAdaptor {
  override def parse(context: IdesParser.QueryContext): SqlStatement = {
    val commandContext = context.asInstanceOf[CommandContext]

    val sql = currentText(commandContext)
    val module = commandContext.module().getText
    val commandParamStr = currentText(commandContext.commandParam())

    // 翻译原始命令
    val rawCommand = ""

    val parameters = Option(commandParamStr)
      .map(str => str.split(" ").map(_.trim).filter(_.nonEmpty))
      .getOrElse(Array[String]())

    CommandSqlStatement(sql, module, rawCommand, parameters)
  }

  override def execute(context: IdesParser.QueryContext): Unit = {

    val CommandSqlStatement(sql, module, rawCommand, parameters) = parse(context)
    println(sql)
    println(parameters.mkString(","))
  }
}
