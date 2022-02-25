package tech.ides.utils

import tech.ides.conf.IdesConf
import tech.ides.conf.IdesConf.IDES_RUN_PLATFORM_FRAME
import tech.ides.exception.IdesException
import tech.ides.strategy.PlatformFrameImpl
import tech.sqlclub.common.reflect.Reflection

/**
 * 平台工具
 * Created by songgr on 2022/02/25.
 */
object PlatformUtils {

  def frameworkEquals(idesConf: IdesConf, clazz:Class[_]): Boolean = {
    if (!clazz.isAnnotationPresent(classOf[PlatformFrameImpl])) {
      throw new IdesException("the annotation of `PlatformFrameImpl` is required in class " + clazz.getCanonicalName)
    }

    val platformFrame = idesConf.get(IDES_RUN_PLATFORM_FRAME)
    val frameName = Reflection.getAnnotation(clazz, classOf[PlatformFrameImpl]).frameName()
    platformFrame.equalsIgnoreCase(frameName.frame)
  }

}
