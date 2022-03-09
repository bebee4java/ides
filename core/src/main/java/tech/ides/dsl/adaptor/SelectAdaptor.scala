package tech.ides.dsl.adaptor

import ides.dsl.parser.IdesParser
import ides.dsl.parser.IdesParser.SelectContext
import tech.ides.dsl.listener.ScriptQueryExecListener
import tech.ides.dsl.statement.{SelectSqlStatement, SqlStatement}
import tech.ides.dsl.utils.DslUtil.{currentText, parseAssetName}

/**
  *
  * Created by songgr on 2020/11/06.
  */
case class SelectAdaptor(scriptQueryExecListener: ScriptQueryExecListener) extends ScriptDslAdaptor {
  override def parse(context: IdesParser.QueryContext): SqlStatement = {

    val selectContext = context.asInstanceOf[SelectContext]
    val sql = currentText(selectContext)

    val tableName = parseAssetName(selectContext.asAsset().assetName())

    SelectSqlStatement(sql, tableName)
  }

  override def execute(context: IdesParser.QueryContext): Unit = {

    val SelectSqlStatement(_sql, tableName) = parse(context)
    val sparkSession = scriptQueryExecListener.sparkSession

    // tableName 索引
    val index = _sql.lastIndexOf(tableName)
    // last as 索引
    val asIndex = _sql.substring(0, index).toLowerCase.lastIndexOf("as")
    // 截取 asTableName 内容
    val sql = _sql.substring(0, asIndex)

    val df = sparkSession.sql(sql)

    // todo 权限校验

    df.createOrReplaceTempView(tableName)

    // set last table name
    scriptQueryExecListener.setLastTableName(tableName)
  }

}
