package tech.ides.dsl.adaptor

import ides.dsl.parser.IdesParser
import ides.dsl.parser.IdesParser.RunContext
import org.apache.spark.sql.DataFrame
import tech.ides.dsl.listener.ScriptQueryExecListener
import tech.ides.dsl.statement.{RunSqlStatement, SqlStatement}
import tech.ides.dsl.utils.DslUtil.{currentText, parseAssetName, whereExpressionsToMap}
import tech.ides.extension.ETPluginRegister

/**
 * Run 语法适配器
 * Created by songgr on 2022/02/16.
 */
case class RunAdaptor(scriptQueryExecListener: ScriptQueryExecListener) extends ScriptDslAdaptor {
  override def parse(context: IdesParser.QueryContext): SqlStatement = {
    val runContext = context.asInstanceOf[RunContext]

    val sql = currentText(runContext)
    val module = runContext.module().getText
    val path = runContext.path().getText

    val whereExpsContext = runContext.whereExpressions()
    val options = whereExpressionsToMap(whereExpsContext)

    val tableName = parseAssetName(runContext.asAsset().assetName())

    RunSqlStatement(sql, module, path, options, tableName)
  }

  override def enterContext(context: IdesParser.QueryContext): Unit = {

    val RunSqlStatement(_, module, path, options, tableName) = parse(context)
    val sparkSession = scriptQueryExecListener.sparkSession

    val df = sparkSession.table(path)
    var table: DataFrame = null

    // 获取et插件
    ETPluginRegister.find(module).map {
      etPlugin =>
        table = etPlugin.asInstanceOf[ {def exec(df: DataFrame, path: String, params: Map[String, String]): DataFrame}].
          exec(df, path, options)

      // todo 权限校验
    }.getOrElse{
      // todo 没有匹配做提示
    }

    // 注册临时表
    table.createOrReplaceTempView(tableName)

    // set last table name
    scriptQueryExecListener.setLastTableName(tableName)
  }
}
