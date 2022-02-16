package tech.ides.extension

/**
 * 插件类型
 * Created by songgr on 2022/02/11.
 */
case class PluginType(operatorType: OperatorType, processType: ProcessType)

/**
 * 算子类型
 */
sealed abstract class OperatorType

case object Action extends OperatorType

case object Transform extends OperatorType

/**
 * 数据处理类型
 */
sealed abstract class ProcessType

case object ETL extends ProcessType

case object Algo extends ProcessType

case object Analysis extends ProcessType