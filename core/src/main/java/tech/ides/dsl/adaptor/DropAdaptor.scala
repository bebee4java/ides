package tech.ides.dsl.adaptor

import java.util.UUID

import ides.dsl.parser.{IdesLexer, IdesParser}
import ides.dsl.parser.IdesParser.DropContext
import tech.ides.dsl.listener.ScriptQueryExecListener
import tech.ides.dsl.statement.{DropSqlStatement, SqlStatement}
import tech.ides.dsl.utils.DslUtil.{currentText, parseAssetName}
import tech.ides.metastore.{ConnectMappingKey, ConnectMetaStore}
import tech.ides.storage.ExternalStorageInfo
import tech.ides.constants.ScriptConstants.RESOURCE

/**
  * Drop 语法适配器
  * Created by songgr on 2021/03/15.
  */
case class DropAdaptor(scriptQueryExecListener: ScriptQueryExecListener) extends ScriptDslAdaptor {

  override def parse(context: IdesParser.QueryContext): SqlStatement = {
    val dropContext = context.asInstanceOf[DropContext]
    val sql = currentText(dropContext)
    val resource = dropContext.resource.getType
    val format = dropContext.format().getText
    val assetName = parseAssetName(dropContext.assetName())

    DropSqlStatement(sql, resource, format, assetName)
  }

  override def execute(context: IdesParser.QueryContext): Unit = {
    val DropSqlStatement(_, resource, format, assetName) = parse(context)

    val res = resource match {
      case IdesLexer.CONNECTION =>
        val mappingKey = ConnectMappingKey(format, assetName)
        ConnectMetaStore.remove(mappingKey)
        val flag = ConnectMetaStore.storage.dropConfig(mappingKey.toString, ExternalStorageInfo.ConnectMetaData)
        ("CONNECTION", flag)
      case IdesLexer.FUNCTION =>
        // todo
        ("FUNCTION", true)
    }

    val spark = scriptQueryExecListener.sparkSession

    val tempTable = "d_" + UUID.randomUUID().toString.replace("-", "")
    import spark.implicits._
    // 结果作为输出表
    val outputTable = Seq(res).toDF(RESOURCE, "result")
    outputTable.createOrReplaceTempView(tempTable)
    scriptQueryExecListener.setLastTableName(tempTable)
  }

}
