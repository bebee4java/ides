package tech.ides.dsl.adaptor

import java.util.UUID

import ides.dsl.parser.IdesDslParser
import ides.dsl.parser.IdesDslParser.SaveContext
import org.apache.spark.sql._
import tech.ides.core.ScriptQueryExecute
import tech.ides.datasource.{DataSinkConfig, DataSourceFactory}
import tech.ides.dsl.listener.ScriptQueryExecListener
import tech.ides.dsl.statement.{SaveSqlStatement, SqlStatement}
import tech.ides.dsl.utils.DslUtil.{cleanStr, currentText, resourceRealPath, whereExpressionsToMap}
import tech.ides.job.ScriptJobManager

import scala.collection.mutable.ListBuffer
import scala.collection.JavaConverters._

/**
  * Save 语法适配器
  * Created by songgr on 2020/11/16.
  */
case class SaveAdaptor(scriptQueryExecListener: ScriptQueryExecListener) extends ScriptDslAdaptor {

  override def parse(context: IdesDslParser.QueryContext): SqlStatement = {
    val saveContext = context.asInstanceOf[SaveContext]

    val sql = currentText(saveContext)
    val inputTableName = saveContext.tableName().getText
    val saveModeContext = saveContext.saveMode()
    val saveMode = saveModeContext match {
        case c if c == null => SaveMode.ErrorIfExists
        case c if c.OVERWRITE() != null => SaveMode.Overwrite
        case c if c.APPEND() != null => SaveMode.Append
        case c if c.ERRORIfExists() != null => SaveMode.ErrorIfExists
        case c if c.IGNORE() != null => SaveMode.Ignore
    }

    val format = saveContext.format().getText
    val path = saveContext.path().getText

    val whereExpsContext = saveContext.whereExpressions()
    val options = whereExpressionsToMap(whereExpsContext)
    saveContext.partitionbyExpression()

    val partitionByCol = ListBuffer[String]()
    val partitionbyExpressionContext = saveContext.partitionbyExpression()
    if ( partitionbyExpressionContext != null ) {
      partitionByCol += partitionbyExpressionContext.col().getText

      partitionbyExpressionContext.colGroup().asScala.foreach {
        col =>
          partitionByCol += col.col().getText
      }
    }

    SaveSqlStatement(sql, inputTableName, saveMode, format, path, options, partitionByCol.toList)

  }

  override def enterContext(context: IdesDslParser.QueryContext): Unit = {
    val SaveSqlStatement(_, inputTableName, saveMode, format, path, options, partitionByCol) = parse(context)

    val spark = scriptQueryExecListener.sparkSession
    val sqec = ScriptQueryExecute.getOrCreateContext()

    var originalTable = spark.table(inputTableName)

    val job = ScriptJobManager.getScriptJobInfo.get(sqec.groupId)

    if (options.contains("fileNum")) {
      // 按文件数重新分区
      originalTable = originalTable.repartition(options("fileNum").toInt)
    }
    val write = originalTable.write

    val owner = options.getOrElse("owner", sqec.owner)
    val resourcePath = resourceRealPath(scriptQueryExecListener, Option(owner) , cleanStr(path))

    // 从工厂获取数据源
    DataSourceFactory.take(format, options).map {
      dataSource =>
        val config = if (partitionByCol.nonEmpty) {
          options ++ Map("partitionByCol" -> partitionByCol.mkString(","))
        } else options
        val dataSinkConfig = DataSinkConfig(resourcePath, config, saveMode, Option(originalTable))
        dataSource.asInstanceOf[{ def save(writer: DataFrameWriter[Row], config: DataSinkConfig)}]
          .save(write, dataSinkConfig)

      // todo 权限校验
    }.getOrElse{
      // todo 没有匹配做提示
    }

    val tempTable = "_" + UUID.randomUUID().toString.replace("-", "")
    import spark.implicits._
    // 将job作为输出表
    val outputTable = if (job.isDefined) spark.createDataset(Seq(job.get)) else spark.emptyDataFrame
    outputTable.createOrReplaceTempView(tempTable)
    scriptQueryExecListener.setLastTableName(tempTable)
  }

}
