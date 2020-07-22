package tech.ides.exception

import scala.collection.mutable.ArrayBuffer

/**
  *
  * Created by songgr on 2020/06/08.
  */
class IdesException(message: String, cause: Throwable)
  extends Exception(message, cause) {

  def this(message: String) = this(message, null)
}

object ExceptionUtil {
  def format_exception(e: Exception) = {
    (e.toString.split("\n") ++ e.getStackTrace.map(f => "\tat " + f.toString)).mkString("\n")
  }

  def format_throwable(e: Throwable) = {
    (e.toString.split("\n") ++ e.getStackTrace.map(f => "\tat " + f.toString)).mkString("\n")
  }

  def format_cause(e: Exception) = {
    var cause = e.asInstanceOf[Throwable]
    while (cause.getCause != null) {
      cause = cause.getCause
    }
    format_throwable(cause)
  }

  def format_full_exception(e: Exception) = {
    val buffer = new ArrayBuffer[String]
    var cause = e.asInstanceOf[Throwable]
    buffer += format_throwable(cause)
    while (cause.getCause != null) {
      cause = cause.getCause
      buffer += "caused by: " + format_throwable(cause)
    }

    buffer.mkString("\n")
  }
}