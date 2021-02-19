package tech.ides.storage.impl

import org.apache.spark.sql.types.{StringType, StructField, StructType}
import org.apache.spark.sql._
import tech.ides.core.ScriptQueryExecute
import tech.ides.storage.ExternalStorage
import tech.sqlclub.common.utils.PathUtils

/**
  * external storage implement by parquet
  * Created by songgr on 2021/02/15.
  */
class ParquetExternalStorage extends ExternalStorage {

  lazy val spark = ScriptQueryExecute.context.execListener.sparkSession

  /**
    * config data schema:
    * root
    * |-- key: string (nullable = false)
    * |-- value: string (nullable = true)
    *
    * e.g.
    * +------+---------------------+
    * |key   |value                |
    * +------+---------------------+
    * |driver|com.mysql.jdbc.Driver|
    * |user  |root                 |
    * +------+---------------------+
    */
  lazy val schema = StructType(Seq(
    StructField(name = "key", dataType = StringType, nullable = false),
    StructField(name = "value", dataType = StringType)
  ))

  override def readConfig(configId: String, key: String): Option[String] = {
    val realPath = PathUtils() / rootPath / spark.sparkContext.appName / configId
    val df = spark.read.parquet(realPath.toPath)
    val schema = df.schema
    require(schema.size == 2 && schema(0).dataType == StringType && schema(1).dataType == StringType,
      "config data schema must be 2 StringType field!")
    DataFrameUtils.getAllFieldValue(df)
      .filter(it => it(0).asInstanceOf[String] == key)
      .map(_(1).asInstanceOf[String]).headOption
  }

  override def readConfig(configId: String): Map[String, String] = {
    val realPath = PathUtils() / rootPath / spark.sparkContext.appName / configId
    val df = spark.read.parquet(realPath.toPath)
    val schema = df.schema
    require(schema.size == 2 && schema(0).dataType == StringType && schema(1).dataType == StringType,
      "config data schema must be 2 StringType field!")
    DataFrameUtils.getAllFieldValue(df).map(it => (it(0).asInstanceOf[String], it(1).asInstanceOf[String])).toMap
  }

  override def saveConfig(configId: String, key: String, value: String, overwrite:Boolean): Unit = {
    val realPath = PathUtils() / rootPath / spark.sparkContext.appName / configId
    val rows = Seq(Row.fromSeq(Seq(key, value)))
    val df = spark.createDataFrame(spark.sparkContext.parallelize(rows, 1), schema)
    val mode = if (overwrite) SaveMode.Overwrite else SaveMode.Append
    df.write.mode(mode).parquet(realPath.toPath)
  }

  override def saveConfig(configId: String, configMap: Map[String, String], overwrite: Boolean): Unit = {
    val realPath = PathUtils() / rootPath / spark.sparkContext.appName / configId
    val rows = configMap.map {
      case (k, v) =>
        Row.fromSeq(Seq(k, v))
    }
    val df = spark.createDataFrame(spark.sparkContext.parallelize(rows.toSeq, 1), schema)
    val mode = if (overwrite) SaveMode.Overwrite else SaveMode.Append
    df.write.mode(mode).parquet(realPath.toPath)
  }

  override def readAsTable(tableName: String): DataFrame = {
    val realPath = PathUtils() / rootPath / spark.sparkContext.appName / tableName
    spark.read.parquet(realPath.toPath)
  }

  override def saveAsTable(tableName: String, table: DataFrame, overwrite: Boolean): Unit = {
    val realPath = PathUtils() / rootPath / spark.sparkContext.appName / tableName
    val mode = if (overwrite) SaveMode.Overwrite else SaveMode.Append
    table.coalesce(1).write.mode(mode).parquet(realPath.toPath)
  }
}
