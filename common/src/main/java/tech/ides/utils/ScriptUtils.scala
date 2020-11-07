package tech.ides.utils

import tech.ides.constants.ScriptConstants.{ACTION_SET, TRANSFORM_SET, KEY_WORDS}
/**
  *
  * Created by songgr on 2020/11/06.
  */
object ScriptUtils {

  def isAction(sql:String):Boolean = {
    if (sql == null || sql.isEmpty) return false

    ACTION_SET.contains(getHeadWord(sql))
  }

  def isTransformation(sql:String):Boolean = {
    if (sql == null || sql.isEmpty) return false

    TRANSFORM_SET.contains(getHeadWord(sql))
  }

  def isScript(sql:String):Boolean = {
    if (sql == null || sql.isEmpty) return false

    KEY_WORDS.contains(getHeadWord(sql))
  }

  def getHeadWord(sql: String) = {
    sql.trim.toLowerCase().split("\\s+").head
  }
}
