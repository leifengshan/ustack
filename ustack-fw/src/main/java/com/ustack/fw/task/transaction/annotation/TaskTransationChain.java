package com.ustack.fw.task.transaction.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description: 任务职责连注解
 *
 * @author ferris
 * @date 2018/4/26 19:12
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TaskTransationChain {

    String[] pre() default {};

    String[] transation() default {};

    String[] post() default {};

    Class<?>[] preTypes() default {};

    Class<?>[] transationTypes() default {};

    Class<?>[] postTypes() default {};
}
