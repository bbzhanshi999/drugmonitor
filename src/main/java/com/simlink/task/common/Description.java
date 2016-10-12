package com.simlink.task.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 描述注解
 * <p>
 * 用于对类、方法、字段描述
 * 
 * @author 
 */
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Description {

    /** 描述 */
    String[] value();

}
