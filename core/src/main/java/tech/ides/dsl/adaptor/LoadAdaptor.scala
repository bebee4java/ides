package tech.ides.dsl.adaptor

import ides.dsl.parser.IdesParser
import ides.dsl.parser.IdesParser.LoadContext
import tech.ides.core.ScriptQueryExecute
import tech.ides.datasource.DataSource.Method
import tech.ides.datasource.reader.DataReader
import tech.ides.datasource.{DataSourceConfig, DataSourceFactory, DataTable}
import tech.ides.dsl.listener.ScriptQueryExecListener
import tech.ides.dsl.statement.{LoadSqlStatement, SqlStatement}
import tech.ides.dsl.utils.DslUtil._
import tech.ides.strategy.PlatformStrategyCenter
import tech.ides.strategy.PlatformFrameEnum.SPARK
import tech.ides.strategy.PlatformStrategyCenter.{SparkDataReader, SparkDataTable}

/**
  * Load 语法适配器
  * Created by songgr on 2020/11/05.
  */
case class LoadAdaptor(scriptQueryExecListener: ScriptQueryExecListener) extends ScriptDslAdaptor {

  override def parse(context: IdesParser.QueryContext): SqlStatement = {

    val loadContext = context.asInstanceOf[LoadContext]

    val sql = currentText(loadContext)
    val format = loadContext.format().getText
    val path = loadContext.path().getText

    val whereExpsContext = loadContext.whereExpressions()
    val options = whereExpressionsToMap(whereExpsContext)

    val tableName = parseAssetName(loadContext.asAsset().assetName())

    LoadSqlStatement(sql, format, path, options, tableName)
  }

  override def execute(context: IdesParser.QueryContext): Unit = {
    val LoadSqlStatement(_, format, path, options, tableName) = parse(context)
    val sparkSession = scriptQueryExecListener.sparkSession
    val reader = sparkSession.read
    var table:DataTable = null

    val owner = options.getOrElse("owner", ScriptQueryExecute.getOrCreateContext().owner)
    val resourcePath = resourceRealPath(scriptQueryExecListener, Option(owner) , cleanStr(path))

    val (dataReader, dataTable) = PlatformStrategyCenter.platformFrame match {
      case SPARK => (SparkDataReader(reader), SparkDataTable(null))
    }
    val dsConf = DataSourceConfig(resourcePath, options, dataTable)

    // 从工厂获取数据源
    DataSourceFactory.take(format, Method.SOURCE, options).map {
      dataSource =>
        table = dataSource.asInstanceOf[DataReader].load(dataReader, dsConf)
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
