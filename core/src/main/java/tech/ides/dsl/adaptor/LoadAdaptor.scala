package tech.ides.dsl.adaptor

import ides.dsl.parser.IdesDslParser
import ides.dsl.parser.IdesDslParser.LoadContext
import org.apache.spark.sql.{DataFrame, DataFrameReader}
import tech.ides.core.ScriptQueryExecute
import tech.ides.datasource.{DataSourceConfig, DataSourceFactory}
import tech.ides.dsl.listener.ScriptQueryExecListener
import tech.ides.dsl.statement.{LoadSqlStatement, SqlStatement}
import tech.ides.dsl.utils.DslUtil._

/**
  * Load 语法适配器
  * Created by songgr on 2020/11/05.
  */
case class LoadAdaptor(scriptQueryExecListener: ScriptQueryExecListener) extends ScriptDslAdaptor {

  override def parse(context: IdesDslParser.QueryContext): SqlStatement = {

    val loadContext = context.asInstanceOf[LoadContext]

    val sql = currentText(loadContext)
    val format = loadContext.format().getText
    val path = loadContext.path().getText

    val whereExpsContext = loadContext.whereExpressions()
    val options = whereExpressionsToMap(whereExpsContext)

    val tableName = parseAssetName(loadContext.asAsset().assetName())

    LoadSqlStatement(sql, format, path, options, tableName)
  }

  override def enterContext(context: IdesDslParser.QueryContext): Unit = {
    val LoadSqlStatement(_, format, path, options, tableName) = parse(context)
    val sparkSession = scriptQueryExecListener.sparkSession
    val reader = sparkSession.read
    var table: DataFrame = null

    val owner = options.getOrElse("owner", ScriptQueryExecute.getOrCreateContext().owner)
    val resourcePath = resourceRealPath(scriptQueryExecListener, Option(owner) , cleanStr(path))

    val dsConf = DataSourceConfig(resourcePath, options, Option(sparkSession.emptyDataFrame))

    // 从工厂获取数据源
    DataSourceFactory.take(format, options).map {
      dataSource =>
        table = dataSource.asInstanceOf[ {def load(reader: DataFrameReader, config: DataSourceConfig): DataFrame}].
          load(reader, dsConf)

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
