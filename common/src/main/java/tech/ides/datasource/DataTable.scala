package tech.ides.datasource

import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.{DataFrame, Row, RowFactory, SparkSession}
import tech.ides.strategy.PlatformFrameEnum
import tech.ides.strategy.PlatformFrameEnum.SPARK
import tech.sqlclub.common.exception.SQLClubException
import tech.sqlclub.common.reflect.{ClassPath, Reflection}
import tech.sqlclub.common.utils.Assert
import scala.reflect.{ClassTag, classTag}
import scala.reflect.runtime.universe.TypeTag

/**
 * 数据表格抽象类
 * Created by songgr on 2022/02/20.
 */
abstract class DataTable(val frame: PlatformFrameEnum) {
  def createOrReplaceTempView(viewName: String) = {
    frame match {
      case PlatformFrameEnum.SPARK =>
        table[DataFrame].map(tb => tb.createOrReplaceTempView(viewName))
      case _ =>
        throw new SQLClubException(s"the ${frame.frame} frame is not supported yet!")
    }
  }

  def table[T: Manifest]: Option[T]
}

/**
 * 任意实现Product子类的Seq数据转成表
 *
 * Example:
 *  {{{
 *    import tech.ides.strategy.PlatformFrameEnum.SPARK
 *    import org.apache.spark.sql.DataFrame
 *
 *    val table = AnyProductDataTable(Seq((1,2,3)), SPARK)
 *                .table[DataFrame]
 *    table.get.show()
 *
 *  }}}
 *
 */
case class AnyProductDataTable[A <: Product :TypeTag](dataTable: Seq[A], override val frame: PlatformFrameEnum)
          (implicit spark: SparkSession = SparkSession.active) extends DataTable(frame) {

  override def table[T: Manifest]: Option[T] = {
    frame match {
      case PlatformFrameEnum.SPARK =>
        Some(spark.createDataFrame(dataTable)).map(_.asInstanceOf[T])
      case _ =>
        throw new SQLClubException(s"the ${frame.frame} frame is not supported yet!")
    }
  }
}

/**
 * 任意javaBean对象的Seq数据转成表
 *
 * Example:
 *  {{{
 *    import tech.ides.strategy.PlatformFrameEnum.SPARK
 *    import tech.ides.engine.test.Person;
 *
 *    val list = Seq(new Person("a", 1), new Person("b", 2),
 *               new Person("c", 3))
 *    AnyJavaBeanDataTable(list, SPARK)
 *        .createOrReplaceTempView("person")
 *    spark.sql("select name, count(1) from person group by name")
 *        .show()
 *  }}}
 *
 */
case class AnyJavaBeanDataTable[A <: Object :ClassTag](dataTable: Seq[A], override val frame: PlatformFrameEnum, schema: StructType = null)
          (implicit spark: SparkSession = SparkSession.active) extends DataTable(frame) {
    override def table[T: Manifest]: Option[T] = {
      frame match {
        case PlatformFrameEnum.SPARK =>
          if (null != schema) {
            val rows = new java.util.ArrayList[Row]()
            dataTable.foreach(it => {
              val reflection = Reflection(ClassPath.fromInstance(it))
              val fieldNames = reflection.getFieldNames
              val values = fieldNames.map(fieldName => {
                reflection.getOrSetFieldByName(fieldName).asInstanceOf[AnyRef]
              })
              val row = RowFactory.create(values: _*)
              rows.add(row)
            })
            return Some(spark.createDataFrame(rows, schema)).map(_.asInstanceOf[T])
          }

          val list = new java.util.ArrayList[A]()
          dataTable.foreach(it => list.add(it))
          Some(spark.createDataFrame(list, classTag[A].runtimeClass)).map(_.asInstanceOf[T])
        case _ =>
          throw new SQLClubException(s"the ${frame.frame} frame is not supported yet!")
      }
    }
}

/**
 * 数据表 spark实现
 *
 * @param df {@link DataFrame}
 */
case class SparkDataTable(df: DataFrame) extends DataTable(SPARK) {
  override def table[T:Manifest]: Option[T] = {
    Assert.isTrue(manifest[DataFrame].equals(manifest[T]),
      "the generic type must be DataFrame when using spark to get the data table!")
    Option(df).map(_.asInstanceOf[T])
  }
}