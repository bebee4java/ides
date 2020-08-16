package tech.ides.runtime

import java.util

/**
  *
  * Created by songgr on 2020/06/24.
  */
trait SQLRuntime {

  def awaitTermination

  def createRuntime

  def params:util.Map[Any, Any]

}