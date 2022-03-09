package tech.ides.dsl.adaptor

import ides.dsl.parser.IdesParser
import ides.dsl.parser.IdesParser.RunContext
import tech.ides.datasource.DataTable
import tech.ides.dsl.listener.ScriptQueryExecListener
import tech.ides.dsl.statement.{RunSqlStatement, SqlStatement}
import tech.ides.dsl.utils.DslUtil.{currentText, parseAssetName, whereExpressionsToMap}
import tech.ides.extension.ETPluginRegister
import tech.ides.strategy.PlatformFrameEnum.SPARK
import tech.ides.strategy.PlatformStrategyCenter
import tech.ides.strategy.PlatformStrategyCenter.{SparkDataReader, SparkDataTable}

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

  override def execute(context: IdesParser.QueryContext): Unit = {

    val RunSqlStatement(_, module, path, options, tableName) = parse(context)
    val sparkSession = scriptQueryExecListener.sparkSession

    val df = sparkSession.table(path)
    var table: DataTable = PlatformStrategyCenter.platformFrame match {
      case SPARK => SparkDataTable(df)
    }

    // 获取et插件
    ETPluginRegister.find(module).map {
      etPlugin =>
        // 插件版本校验
        etPlugin.versionCompatible
        // 执行插件
        table = etPlugin.exec(table, path, options)
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
