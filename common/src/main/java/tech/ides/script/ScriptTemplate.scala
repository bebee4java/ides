package tech.ides.script

import org.apache.commons.lang3.StringUtils
import org.joda.time.DateTime
import tech.ides.conf.IdesConf
import tech.ides.conf.IdesConf.SCRIPT_DEFAULT_DATEFORMAT
import tech.sqlclub.common.utils.StringTemplate

/**
 * 脚本模块处理
 * Created by songgr on 2022/03/09.
 */
object ScriptTemplate {

  val DATE_FORMAT = IdesConf.getOrCreate.get(SCRIPT_DEFAULT_DATEFORMAT)

  val PRESET_VARIABLES = Map[String, Any](
    "yesterday" -> DateTime.now().minusDays(1).toString(DATE_FORMAT),
    "today" -> DateTime.now().toString(DATE_FORMAT),
    "tomorrow" -> DateTime.now().plusDays(1).toString(DATE_FORMAT),
    "theDayBeforeYesterday" -> DateTime.now().minusDays(2).toString(DATE_FORMAT),
    "date" -> new DateTime(),
    "currentTimestamp" -> System.currentTimeMillis()
  )

  val NOESCAPE_LIST = List("##")

  def merge(sql: String, variables: Map[String, Any]): String = {
    // sql不包含$ 直接返回
    if (StringUtils.containsNone(sql, "$")) {
      return sql
    }

    StringTemplate.namedEvaluate(sql, PRESET_VARIABLES ++ variables, NOESCAPE_LIST)
  }
}
