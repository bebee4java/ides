package tech.ides.dsl.adaptor

import ides.dsl.parser.IdesParser
import ides.dsl.parser.IdesParser.SetContext
import org.apache.commons.lang3.math.NumberUtils
import tech.ides.dsl.listener.ScriptQueryExecListener
import tech.ides.dsl.statement.{SetSqlStatement, SqlStatement}
import tech.ides.dsl.utils.DslUtil.{cleanStr, currentText, whereExpressionsToMap}

/**
 * Set 语法适配器
 * Created by songgr on 2022/03/07.
 */
case class SetAdaptor(scriptQueryExecListener: ScriptQueryExecListener) extends ScriptDslAdaptor {
  /**
   * 脚本解析
   *
   * @param context 脚本上下文
   * @return
   */
  override def parse(context: IdesParser.QueryContext): SqlStatement = {

    val setContext = context.asInstanceOf[SetContext]
    val sql = currentText(setContext)

    val key = setContext.expression().keyName().getText
    val valueName = setContext.expression().valueName()

    val value = valueName match {
      case _ if null != valueName.mumericValue() => {
        val text = valueName.mumericValue().getText
        if (text.contains(".")) NumberUtils.createDouble(text) else NumberUtils.createLong(text)
      }
      case _ if null != valueName.stringValue() => cleanStr(valueName.stringValue().getText)
      case _ => valueName.getText
    }

    val whereExpsContext = setContext.whereExpressions()
    val options = whereExpressionsToMap(whereExpsContext)

    SetSqlStatement(sql, key, value, options)
  }

  /**
   * 脚本执行
   *
   * @param context 脚本上下文
   */
  override def execute(context: IdesParser.QueryContext): Unit = {
    val SetSqlStatement(sql, key, value, options) = parse(context)

    if (options.isEmpty) {
      scriptQueryExecListener.addEnv(key, value)
    }

    //todo 支持shell sql 设置变量

  }
}
