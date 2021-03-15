package tech.ides.storage.impl

import org.apache.hadoop.fs.Path
import org.apache.hadoop.hdfs.HdfsOperator
import org.apache.spark.sql.types.{StringType, StructField, StructType}
import org.apache.spark.sql._
import tech.ides.core.ScriptQueryExecute
import tech.ides.storage.ExternalStorage
import tech.ides.storage.ExternalStorageInfo.StorageInfo
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
    * |-- configId: string (nullable = false)
    * |-- storageInfo: string (nullable = false)
    * |-- key: string (nullable = false)
    * |-- value: string (nullable = true)
    *
    * e.g.
    * +---------+---------------+------+---------------------+
    * |configId |storageInfo    |key   |value                |
    * +---------+---------------+------+---------------------+
    * |test.test|connectMetaData|driver|com.mysql.jdbc.Driver|
    * |test.test|connectMetaData|user  |root                 |
    * +---------+---------------+------+---------------------+
    */
  lazy val schema = StructType(Seq(
    StructField(name = "configId", dataType = StringType, nullable = false),
    StructField(name = "storageInfo", dataType = StringType, nullable = false),
    StructField(name = "key", dataType = StringType, nullable = false),
    StructField(name = "value", dataType = StringType)
  ))

  val configIdIndex = 0
  val storageInfoIndex = 1
  val keyIndex = 2
  val valueIndex = 3

  override def readConfig(configId: String, storageInfo:StorageInfo, key: String): Option[String] = {
    val realPath = PathUtils() / rootPath / spark.sparkContext.appName / storageInfo.toString / configId
    val path = realPath.toPath
    if (!HdfsOperator.fileExists(path)) {
      return None
    }
    val df = spark.read.parquet(path)
    val schema = df.schema
    require(schema.size == 4 && !schema.exists(f => f.dataType != StringType),
      "config data schema must be 4 StringType fields!")
    DataFrameUtils.getAllFieldValue(df)
      .filter(it => it(keyIndex).asInstanceOf[String] == key)
      .map(_(valueIndex).asInstanceOf[String]).headOption
  }

  override def readConfig(configId: String, storageInfo:StorageInfo): Map[String, String] = {
    val realPath = PathUtils() / rootPath / spark.sparkContext.appName / storageInfo.toString / configId
    val path = realPath.toPath
    if (!HdfsOperator.fileExists(path)) {
      return Map()
    }
    val df = spark.read.parquet(path)
    val schema = df.schema
    require(schema.size == 4 && !schema.exists(f => f.dataType != StringType),
      "config data schema must be 4 StringType fields!")
    DataFrameUtils.getAllFieldValue(df).map(it => (it(keyIndex).asInstanceOf[String], it(valueIndex).asInstanceOf[String])).toMap
  }

  override def readConfig(storageInfo: StorageInfo): Map[String, Map[String, String]] = {
    val realPath = PathUtils() / rootPath / spark.sparkContext.appName / storageInfo.toString
    val realPathStr = realPath.toPath
    val path = new Path(realPathStr, "*")
    if (!HdfsOperator.fileExists(realPathStr)) {
      return Map()
    }
    val df = spark.read.option("basePath", realPathStr).parquet(path.toString)
    val schema = df.schema
    require(schema.size == 4 && !schema.exists(f => f.dataType != StringType),
      "config data schema must be 4 StringType fields!")
    DataFrameUtils.getAllFieldValue(df)
      .map(it => (it(configIdIndex).asInstanceOf[String], it(keyIndex).asInstanceOf[String], it(valueIndex).asInstanceOf[String]))
      .groupBy(_._1).map(it => (it._1, it._2.map(it => (it._2, it._3)).toMap))
  }

  override def saveConfig(configId: String, storageInfo:StorageInfo, key: String, value: String, overwrite:Boolean): Unit = {
    val realPath = PathUtils() / rootPath / spark.sparkContext.appName / storageInfo.toString / configId
    val rows = Seq(Row.fromSeq(Seq(configId, storageInfo.toString, key, value)))
    val df = spark.createDataFrame(spark.sparkContext.parallelize(rows, 1), schema)
    val mode = if (overwrite) SaveMode.Overwrite else SaveMode.Append
    df.write.mode(mode).parquet(realPath.toPath)
  }

  override def saveConfig(configId: String, storageInfo:StorageInfo, configMap: Map[String, String], overwrite: Boolean): Unit = {
    val realPath = PathUtils() / rootPath / spark.sparkContext.appName / storageInfo.toString / configId
    val rows = configMap.map {
      case (k, v) =>
        Row.fromSeq(Seq(configId, storageInfo.toString, k, v))
    }
    val df = spark.createDataFrame(spark.sparkContext.parallelize(rows.toSeq, 1), schema)
    val mode = if (overwrite) SaveMode.Overwrite else SaveMode.Append
    df.write.mode(mode).parquet(realPath.toPath)
  }

  override def dropConfig(configId: String, storageInfo: StorageInfo): Boolean = {
    val realPath = PathUtils() / rootPath / spark.sparkContext.appName / storageInfo.toString / configId
    val realPathStr = realPath.toPath
    if (!HdfsOperator.fileExists(realPathStr)) {
      return true
    }
    HdfsOperator.deleteDir(realPathStr)
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

  override def dropTable(tableName: String): Boolean = {
    val realPath = PathUtils() / rootPath / spark.sparkContext.appName / tableName
    val realPathStr = realPath.toPath
    if (!HdfsOperator.fileExists(realPathStr)) {
      return true
    }
    HdfsOperator.deleteDir(realPathStr)
  }

}
