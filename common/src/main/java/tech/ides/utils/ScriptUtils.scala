package tech.ides.utils

import tech.ides.constants.ScriptConstants.{ACTION_SET, KEY_WORDS, TRANSFORM_SET}
import scala.collection.mutable
import scala.collection.mutable.ListBuffer

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

    KEY_WORDS.contains(getHeadWord(sql)) ||
    getHeadWord(sql).startsWith("--") ||
    getHeadWord(sql).startsWith("/*")
  }

  def getHeadWord(sql: String) = {
    sql.trim.toLowerCase().split("\\s+").head
  }

  /**
    * 将脚本切分成多行
    * @param script 脚本内容
    * @return List[String]
    */
  def readLines(script: String): List[String] = {
    if ( script == null ) return List()
    val sql = script.trim
    if ( sql.isEmpty ) return List()

    val lines = new ListBuffer[String]
    val line = new StringBuffer
    val chars = sql.toCharArray
    val totalSize = chars.length // 总字符数
    val stack = new mutable.Stack[Char]()
    var i = 0

    // 是否是string块开头
    def strBlock(i: Int) = (chars(i) == '"' && chars(i + 1) == '"' && chars(i + 2) == '"') ||
      (chars(i) == ''' && chars(i + 1) == ''' && chars(i + 2) == ''')

    // 是否是string开头
    def str(i: Int) = chars(i) == '`' || chars(i) == ''' || chars(i) == '"'

    // 是否是单行注释
    def line_comment(i: Int) = chars(i) == '-' && chars(i + 1) == '-'

    // 多行注释开始
    def block_comment_left(i: Int) = chars(i) == '/' && chars(i + 1) == '*'

    def reset= {
      lines += line.toString
      line.setLength(0)
    }

    def escape(index:Int, append:Boolean = true):Int = {
      if (chars(index) != '\\') return index
      if (append) line.append('\\').append(chars(index+1))
      index + 2
    }

    def wholeStack(index: Int, quoteSize: Int, EOF:Option[Char], append:Boolean=true): Int = {
      var pos = index // 当前位置
      var whole = true // 是否是完整的引用
      while (pos < totalSize && (stack.size < quoteSize * 2 || !whole) && (EOF.isEmpty || EOF.get != chars(pos) ) ) {
        if(chars(pos) == '\\') {
          pos = escape(pos, append)
        } else {
          if (append) line.append(chars(pos))
          stack.push(chars(pos))
          if (EOF.isEmpty) {
            val list = stack.toList
            val last = list.length - 1

            if (stack.size >= quoteSize * 2) {
              whole = true // 需要先重置成true
              for (i <- 0 until quoteSize) {
                whole = whole && list(i) == list(last - i)
              }
            }
          }
          pos += 1
        }
      }
      stack.clear()
      pos
    }

    while (i < chars.length) {
      if (chars(i) == ';') {
        line.append(';')
        i +=1
        reset
      }
      if (i < totalSize)
        i match {
            // 转义字符
          case _ if chars(i) == '\\' =>
            i = escape(i)
          case _ if strBlock(i) =>
            // 字符块
            i = wholeStack(i, 3, None)
          case _ if str(i) =>
            // 字符串
            i = wholeStack(i, 1, None)
          case _ if block_comment_left(i) =>
            // 多行注释
            i = wholeStack(i, 2, None, false)
            // reset 注释不需要加入到结果
          case _ if line_comment(i) =>
            // 单行注释
            // 设置引用标识len等于总字符数 遇到终止符'\n'就是完整的stack
            i = wholeStack(i, totalSize, Some('\n'), false)
            // reset 注释不需要加入到结果
          case _ =>
            line.append(chars(i))
            i += 1
        }
    }

    if (line.length() > 0) reset
    lines.toList
  }

}
