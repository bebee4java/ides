package tech.ides.dsl.adaptor

import ides.dsl.parser.IdesParser
import ides.dsl.parser.IdesParser.ConnectContext
import tech.ides.datasource.DataSourceFactory
import tech.ides.dsl.listener.ScriptQueryExecListener
import tech.ides.dsl.statement.{ConnectSqlStatement, SqlStatement}
import tech.ides.dsl.utils.DslUtil.{currentText, parseAssetName, whereExpressionsToMap}
import tech.ides.metastore.{ConnectMappingKey, ConnectMetaStore}
import tech.ides.storage.ExternalStorageInfo.ConnectMetaData
import tech.ides.constants.ScriptConstants.EXTERNAL_STORAGE

/**
  * Connect 语法适配器
  * Created by songgr on 2021/02/21.
  */
case class ConnectAdaptor(scriptQueryExecListener: ScriptQueryExecListener) extends ScriptDslAdaptor {

  override def parse(context: IdesParser.QueryContext): SqlStatement = {
    val connectContext = context.asInstanceOf[ConnectContext]
    val sql = currentText(connectContext)
    val format = connectContext.format().getText
    val options = whereExpressionsToMap(connectContext.whereExpressions())

    val connectName = parseAssetName(connectContext.asAsset().assetName())

    ConnectSqlStatement(sql, format, options, connectName)
  }

  override def execute(context: IdesParser.QueryContext): Unit = {
    val ConnectSqlStatement(_, format, options, connectName) = parse(context)

    DataSourceFactory.findBothNames(format).map{
      names =>
        names.map(name => ConnectMetaStore.add(ConnectMappingKey(name, connectName), options))
    }.getOrElse(ConnectMetaStore.add(ConnectMappingKey(format, connectName), options))

    val storage = options.getOrElse(EXTERNAL_STORAGE, "false").toBoolean

    if (storage && ConnectMetaStore.storage != null) {
      ConnectMetaStore.storage.saveConfig(ConnectMappingKey(format, connectName).toString, ConnectMetaData, options + ("format" -> format), true)
    }

    scriptQueryExecListener.setLastTableName(null)
  }

}
