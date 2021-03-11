package tech.ides.core.platform

import org.apache.spark.IdesConf

/**
  * 平台整个生命周期，在指定环节加入规则
  * Created by songgr on 2021/03/11.
  */
trait PlatformLifecycle {

  def beforeSQLRuntime(idesConf: IdesConf)

  def afterSQLRuntime(idesConf: IdesConf)

  def beforeService(idesConf: IdesConf)

  def afterService(idesConf: IdesConf)

}
