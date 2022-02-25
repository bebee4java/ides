package tech.ides.datasource

import tech.ides.strategy.PlatformFrameEnum

/**
 * 数据表格抽象类
 * Created by songgr on 2022/02/20.
 */
abstract class DataTable
(
  val frame: PlatformFrameEnum
) {
  def createOrReplaceTempView(viewName: String)

  def table[T:Manifest]: Option[T]
}

case class AnyDataTable[T](dataTable:T, override val frame: PlatformFrameEnum) extends DataTable(frame) {
  override def createOrReplaceTempView(viewName: String): Unit =
    dataTable.asInstanceOf[{def createOrReplaceTempView(viewName: String)}].createOrReplaceTempView(viewName)

  override def table[T:Manifest]: Option[T] = Option(dataTable).map(_.asInstanceOf[T])
}