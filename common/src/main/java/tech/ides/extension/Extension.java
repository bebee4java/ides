package tech.ides.extension;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ET插件注解
 * @author songgr
 * @since 1.0.0
 * Created by songgr on 2022/02/11.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Extension {
    /**
     * 插件名称
     * @return String
     */
    String name() default "";

    /**
     * 插件描述
     * @return String
     */
    String description() default "";

    /**
     * 从哪个版本开始支持
     * @return String
     */
    String sinceVersion();
}
