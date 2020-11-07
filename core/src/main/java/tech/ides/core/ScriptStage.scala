package tech.ides.core

/**
  *
  * Created by songgr on 2020/11/05.
  */
object ScriptStage extends Enumeration {
  type stage = Value
  val include = Value("include")
  val preProcess = Value("preProcess")
  val auth = Value("auth")
  val physical = Value("physical")
  val grammar = Value("grammar")
}
