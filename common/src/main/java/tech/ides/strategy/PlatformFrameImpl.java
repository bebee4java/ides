package tech.ides.strategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 平台框架实现注解
 * Created by songgr on 2022/02/20.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PlatformFrameImpl {
    /**
     * 实现的框架类型
     * @return PlatformFrameEnum
     */
    PlatformFrameEnum frameName() default PlatformFrameEnum.SPARK;
}
