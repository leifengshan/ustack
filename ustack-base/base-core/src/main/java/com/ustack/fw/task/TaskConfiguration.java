package com.ustack.fw.task;

import com.ustack.fw.task.annotation.TaskChainBeanPostProcessor;
import com.ustack.fw.task.transaction.annotation.TaskTransationChainBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description: SpringBootTaskStarter
 *
 * @author Ferris
 * @date 2021/11/19 15:17
 * @Version 1.0
 */
@Configuration
public class TaskConfiguration {

    @Bean
    TaskChainBeanPostProcessor getTaskChainBeanPostProcessor(){
        return new TaskChainBeanPostProcessor();
    }

    @Bean
    TaskTransationChainBeanPostProcessor getTaskTransationChainBeanPostProcessor(){
        return new TaskTransationChainBeanPostProcessor();
    }

}
