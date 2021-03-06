package tech.ides.constants

import java.io.File

/**
  * 脚本常用常量
  * Created by songgr on 2020/11/05.
  */
object ScriptConstants {

  val DIRECT_QUERY = "directQuery"

  val IMPL_CLASS = "implClass"

  val FILE_FORMAT = "fileFormat"

  val PARTITION_BY_COL = "partitionByCol"

  val EXTERNAL_STORAGE = "externalStorage"

  val PRIMARY_KEYS = "primaryKeys"

  def PATH_SEPARATOR = File.pathSeparator

  def PATH_SEPARATOR_SIZE = PATH_SEPARATOR.length

  val SHELL_USER = "idesShell"

  val TEST_USER = "idesTest"

  val DEFAULT_PATH_PREFIX = "/tmp/ides"

  val BATCH_JOB = "batch"
  val STREAM_JOB = "stream"


  def KEY_WORDS = TRANSFORM_SET ++ ACTION_SET

  // transform 语句关键字
  val TRANSFORM_SET = Set("select", "load", "set", "include", "register", "connect")

  // action语句关键字
  val ACTION_SET = Set("save", "insert", "train", "run", "predict", "!")


}
