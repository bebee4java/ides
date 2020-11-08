package tech.ides.datasource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据源注解
 * @author songgr
 * @since 1.0.0
 * Created by songgr on 2020/10/25.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {
    enum Method {
        /**
         * 数据输入
         */
        SOURCE,
        /**
         * 数据输出
         */
        SINK
    }

    /**
     * 支持的数据源类型: source/sink 两种
     * @return Method[]
     */
    Method[] types();

    /**
     * 数据源名称
     * @return String
     */
    String name() default "";

    /**
     * 数据源描述
     * @return String
     */
    String description() default "";

    /**
     * 是否是直接数据源操作
     * 比如jdbc直接direct sql查询需要设置为true, 默认false
     * @return boolean
     */
    boolean directDataSource() default false;

    /**
     * 从哪个版本开始支持
     * @return String
     */
    String sinceVersion();

}
