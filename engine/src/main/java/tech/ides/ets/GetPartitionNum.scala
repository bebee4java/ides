package tech.ides.ets

import org.apache.spark.sql.DataFrame
import tech.ides.doc.{Document, MarkDownDoc}
import tech.ides.extension.{Action, Analysis, ETPlugin, Extension, PluginType}

/**
 * 获取表分区数目
 * Created by songgr  on 2022/02/11.
 */
@Extension(
  name = "GetPartitionNum",
  description = "获取表分区数目",
  sinceVersion = "1.0.0"
)
class GetPartitionNum extends ETPlugin {

  override def exec(df: DataFrame, path: String, params: Map[String, String]): DataFrame = {
    val spark = df.sparkSession
    val partitionNum = df.toJavaRDD.partitions.size()

    import spark.implicits._
    Seq(partitionNum).toDF("partitionNum")
  }

  /**
   * 插件类型
   */
  override def pluginType: PluginType = PluginType(Action, Analysis)

  /**
   * 插件文档
   */
  override def doc: Document = Document(
    MarkDownDoc,
    """
      |GetPartitionNum is used to get the table partitions size.
      |
      |```sql
      |run GetPartitionNum.`tableName` as newTable;
      |```
      |
      |""".stripMargin
  )
}
