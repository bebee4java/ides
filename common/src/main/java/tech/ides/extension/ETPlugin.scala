package tech.ides.extension

import tech.ides.datasource.DataTable
import tech.ides.doc.{Document, TextDoc}
import tech.ides.exception.IdesException
import tech.sqlclub.common.reflect.Reflection
import tech.sqlclub.common.utils.VersionUtils

/**
 * ET插件接口
 * Created by songgr on 2022/02/11.
 */
trait ETPlugin {

  def exec(dataTable: DataTable, path: String, params: Map[String, String]): DataTable

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
  def versionCompatible = {
    import tech.ides.IDES_VERSION
    val currentVersion = IDES_VERSION
    val annotation = Reflection.getAnnotation(getClass, classOf[Extension])
    val sinceVersion = annotation.sinceVersion()

    val compare = VersionUtils.compareVersion(currentVersion, sinceVersion)

    if (compare < 0 ) {
      throw new IdesException(s"This plugin is not supported in the current version! currentVersion:$currentVersion, plugin sinceVersion:$sinceVersion")
    }

  }

}
