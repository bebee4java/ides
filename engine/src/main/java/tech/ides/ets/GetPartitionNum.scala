package tech.ides.ets

import org.apache.spark.sql.DataFrame
import tech.ides.datasource.DataTable
import tech.ides.doc.{Document, MarkDownDoc}
import tech.ides.extension.{Action, Analysis, ETPlugin, Extension, PluginType}
import tech.ides.strategy.PlatformFrameEnum.SPARK
import tech.ides.strategy.PlatformFrameImpl
import tech.ides.strategy.PlatformStrategyCenter.SparkDataTable

/**
 * 获取表分区数目
 * Created by songgr  on 2022/02/11.
 */
@Extension(
  name = "GetPartitionNum",
  description = "获取表分区数目",
  sinceVersion = "1.0.0"
)
@PlatformFrameImpl(frameName = SPARK)
class GetPartitionNum extends ETPlugin {

  override def exec(dataTable: DataTable, path: String, params: Map[String, String]): DataTable = {
    val table = dataTable.table[DataFrame].get
    val partitionNum = table.toJavaRDD.partitions.size()
    val spark = table.sparkSession

    import spark.implicits._
    val df = Seq(partitionNum).toDF("partitionNum")
    SparkDataTable(df)
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
