package tech.ides.exception

/**
  *
  * Created by songgr on 2020/06/08.
  */
class IdesException(message: String, cause: Throwable)
  extends Exception(message, cause) {

  def this(message: String) = this(message, null)
}