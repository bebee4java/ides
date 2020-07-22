package tech.ides.runtime

/**
  *
  * Created by songgr on 2020/06/24.
  */
trait SQLRuntime {

  def awaitTermination

  def createRuntime

  def params:Map[String,String]

}