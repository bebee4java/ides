package tech.ides.core.platform

import org.apache.spark.IdesConf

trait Lifecycle

/**
  * 平台整个生命周期，在指定环节加入规则
  * Created by songgr on 2021/03/11.
  */
trait PlatformLifecycle extends Lifecycle {

  def beforeSQLRuntime(idesConf: IdesConf)

  def afterSQLRuntime(idesConf: IdesConf)

}

/**
  * 服务整个生命周期，在指定环节加入规则
  * Created by songgr on 2021/03/11.
  */
trait ServiceLifecycle extends Lifecycle {
  def beforeService(idesConf: IdesConf)

  def afterService(idesConf: IdesConf)
}