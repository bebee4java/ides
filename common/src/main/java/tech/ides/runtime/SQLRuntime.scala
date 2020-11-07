package tech.ides.runtime

import java.util

/**
  *
  * Created by songgr on 2020/06/24.
  */
trait SQLRuntime {

  def awaitTermination

  private[runtime] def createRuntime:SQLRuntime

  def params:util.Map[Any, Any]

}