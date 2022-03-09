package tech.ides.dsl.adaptor

import ides.dsl.parser.IdesParser.QueryContext
import tech.ides.dsl.listener.ScriptQueryExecListener
import tech.ides.dsl.statement.SqlStatement

/**
  * 脚本语法适配器
  * Created by songgr on 2020/11/05.
  */
trait ScriptDslAdaptor {

  /**
   * 脚本执行监听类
   * @return
   */
  def scriptQueryExecListener:ScriptQueryExecListener

  /**
   * 脚本解析
   * @param context 脚本上下文
   * @return
   */
  def parse(context: QueryContext): SqlStatement

  /**
   * 脚本执行
   * @param context 脚本上下文
   */
  def execute(context: QueryContext)

}
