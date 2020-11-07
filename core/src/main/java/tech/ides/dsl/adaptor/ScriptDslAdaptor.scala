package tech.ides.dsl.adaptor

import ides.dsl.parser.IdesDslParser.QueryContext
import tech.ides.dsl.listener.ScriptQueryExecListener
import tech.ides.dsl.statement.SqlStatement

/**
  * 脚本语法适配器
  * Created by songgr on 2020/11/05.
  */
trait ScriptDslAdaptor {

  def scriptQueryExecListener:ScriptQueryExecListener

  def parse(context: QueryContext): SqlStatement

  def enterContext(context: QueryContext)

}
