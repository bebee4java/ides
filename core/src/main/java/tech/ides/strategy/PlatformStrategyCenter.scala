package tech.ides.strategy

import org.apache.commons.lang3.StringUtils
import tech.ides.conf.IdesConf.IDES_RUN_PLATFORM_FRAME
import org.apache.spark.sql.{DataFrame, DataFrameReader, DataFrameWriter, Row}
import tech.ides.conf.IdesConf
import tech.ides.datasource.{AnyDataTable, DataTable}
import tech.ides.datasource.reader.Reader
import tech.ides.datasource.writer.Writer
import tech.ides.strategy.PlatformFrameEnum.SPARK
import tech.sqlclub.common.utils.Assert


/**
 * 平台策略中心
 * 屏蔽因平台差异产生不同的策略
 * Created by songgr on 2022/02/20.
 */
object PlatformStrategyCenter {
  /**
   * 数据读取 spark实现
   *
   * @param reader {@link DataFrameReader}
   */
  case class SparkDataReader(reader: DataFrameReader) extends Reader {
    override def getReader[T: Manifest]: T = {
      Assert.isTrue(manifest[DataFrameReader].equals(manifest[T]),
        "the generic type must be DataFrameReader when using spark to read data!")
      reader.asInstanceOf[T]
    }
  }


  /**
   * 数据存储 spark实现
   *
   * @param writer {@link DataFrameWriter}
   */
  case class SparkDataWriter(writer: DataFrameWriter[Row]) extends Writer {
    override def getWriter[T:Manifest]: T = {
      Assert.isTrue(manifest[DataFrameWriter[Row]].equals(manifest[T]),
        "the generic type must be DataFrameWriter[Row] when using spark to write data!")
      writer.asInstanceOf[T]
    }
  }

  /**
   * 数据表 spark实现
   *
   * @param df {@link DataFrame}
   */
  case class SparkDataTable(df: DataFrame) extends DataTable(SPARK) {
    override def createOrReplaceTempView(viewName: String): Unit =
      df.createOrReplaceTempView(viewName)

    override def table[T:Manifest]: Option[T] = {
      Assert.isTrue(manifest[DataFrame].equals(manifest[T]),
        "the generic type must be DataFrame when using spark to get the data table!")
      Option(df).map(_.asInstanceOf[T])
    }
  }

  /**
   * 平台使用的框架
   * @return
   */
  def platformFrame = {
    val platformFrame = IdesConf.getOrCreate.get(IDES_RUN_PLATFORM_FRAME)
    platformFrame match {
      case _ if StringUtils.equalsIgnoreCase(SPARK.frame, platformFrame) => SPARK
      case _ => SPARK
    }
  }

}


