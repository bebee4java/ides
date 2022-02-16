package tech.ides.extension

import org.apache.spark.sql.DataFrame
import tech.ides.doc.{Document, TextDoc}

/**
 * ET插件接口
 * Created by songgr on 2022/02/11.
 */
trait ETPlugin {

  def exec(df: DataFrame, path: String, params: Map[String, String]): DataFrame

  /**
   * 插件类型
   */
  def pluginType:PluginType

  /**
   * 插件文档
   */
  def doc: Document = Document(TextDoc, "")

  /**
   * 版本是否兼容
   */
  def versionCompatible:Boolean = true

}
