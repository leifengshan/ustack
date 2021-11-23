package com.ustack.fw.task;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Description: EnableFerrisTask
 *
 * @author Ferris
 * @date 2021/11/19 15:24
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({TaskConfiguration.class})
public @interface EnableFerrisTask {
}
