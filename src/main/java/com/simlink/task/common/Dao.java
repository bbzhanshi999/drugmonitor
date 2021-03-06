package com.simlink.task.common;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

/**
 * 
* @ClassName: Dao 
* @Description: 数据访问Bean注解<p>
 * 用于数据访问实现类，Spring会自动加载使用该注解的对象<br>
 * 默认数据源名称为default，默认不开启路由 
* @author  
* @date 2015年12月10日 下午1:51:33 
*
 */
@Target( { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Dao {

    /** 数据访问Bean名称 */
    String value() default "";

    /** 该Bean使用的数据源名称 */
    String datasource() default "default";
    
    /** 开启路由功能  */
    boolean openRoute() default false;

}
