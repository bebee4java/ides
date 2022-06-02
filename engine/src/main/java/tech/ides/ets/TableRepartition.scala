package tech.ides.ets

import org.apache.spark.sql.DataFrame
import tech.ides.datasource.{DataTable, SparkDataTable}
import tech.ides.exception.IdesException
import tech.ides.extension.{ETL, ETPlugin, Extension, PluginType, Transform}
import tech.ides.strategy.PlatformFrameEnum.SPARK
import tech.ides.strategy.PlatformFrameImpl

/**
 * 对表进行重新分区
 * Created by songgr on 2022/02/16.
 */
@Extension(
  name = "TableRepartition",
  description = "表数据重新分区",
  sinceVersion = "1.0.0"
)
@PlatformFrameImpl(frameName = SPARK)
class TableRepartition extends ETPlugin {
  override def exec(dataTable: DataTable, path: String, params: Map[String, String]): DataTable = {

    val partitionNum = params.get("partitionNum")
    val table = dataTable.table[DataFrame].get

    if (partitionNum.isDefined) {
      val df = table.repartition(partitionNum.get.toInt)
      SparkDataTable(df)
    } else {
      throw new IdesException("partitionNum parameter must be set")
    }
  }

  /**
   * 插件类型
   */
  override def pluginType: PluginType = PluginType(Transform, ETL)
}
