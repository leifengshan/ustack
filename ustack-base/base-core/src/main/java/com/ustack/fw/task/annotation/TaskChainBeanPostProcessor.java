package com.ustack.fw.task.annotation;

import com.ustack.fw.task.core.ICommand;
import com.ustack.fw.task.core.ITask;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Description: 任务职责连注解实现
 *
 * @author ferris
 * @date 17/03/2018 17:06
 */
public class TaskChainBeanPostProcessor implements BeanPostProcessor, ApplicationContextAware {


    private ApplicationContext applicationContext = null;


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if (bean instanceof ITask) {
            ITask ITask = (ITask) bean;
            TaskChain taskChain = bean.getClass().getAnnotation(TaskChain.class);
            if (taskChain != null) {
                if (ArrayUtils.isNotEmpty(taskChain.value())) {
                    String[] commandNames = taskChain.value();
                    for (String commandName : commandNames) {
                        ICommand ICommand = (ICommand) applicationContext.getBean(commandName);
                        ITask.addCommand(ICommand);
                    }
                } else if(ArrayUtils.isNotEmpty(taskChain.types())) {
                    Class[] commandTypes = taskChain.types();
                    for (Class commandType : commandTypes) {
                        ICommand ICommand = (ICommand) applicationContext.getBean(commandType);
                        ITask.addCommand(ICommand);
                    }
                }
            }
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
