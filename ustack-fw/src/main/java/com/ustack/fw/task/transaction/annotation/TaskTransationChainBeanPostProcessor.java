package com.ustack.fw.task.transaction.annotation;

import com.ustack.fw.task.core.ICommand;
import com.ustack.fw.task.transaction.TransationTask;
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
public class TaskTransationChainBeanPostProcessor implements BeanPostProcessor, ApplicationContextAware {


    private static ApplicationContext applicationContext = null;


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if (bean instanceof TransationTask) {

            TransationTask task = (TransationTask) bean;
            TaskTransationChain taskChain = bean.getClass().getAnnotation(TaskTransationChain.class);

            if (taskChain != null) {

                if (ArrayUtils.isNotEmpty(taskChain.transation())) {
                    String[] commandNames = taskChain.transation();
                    for (String commandName : commandNames) {
                        ICommand ICommand = (ICommand) applicationContext.getBean(commandName);
                        task.addCommand(ICommand);
                    }
                } else if(ArrayUtils.isNotEmpty(taskChain.transationTypes())) {
                    Class[] commandTypes = taskChain.transationTypes();
                    for (Class commandType : commandTypes) {
                        ICommand ICommand = (ICommand) applicationContext.getBean(commandType);
                        task.addCommand(ICommand);
                    }
                }

                if (ArrayUtils.isNotEmpty(taskChain.pre())) {
                    String[] commandNames = taskChain.pre();
                    for (String commandName : commandNames) {
                        ICommand ICommand = (ICommand) applicationContext.getBean(commandName);
                        task.addPreCommand(ICommand);
                    }
                } else if(ArrayUtils.isNotEmpty(taskChain.preTypes())) {
                    Class[] commandTypes = taskChain.preTypes();
                    for (Class commandType : commandTypes) {
                        ICommand ICommand = (ICommand) applicationContext.getBean(commandType);
                        task.addPreCommand(ICommand);
                    }
                }

                if (ArrayUtils.isNotEmpty(taskChain.post())) {
                    String[] commandNames = taskChain.post();
                    for (String commandName : commandNames) {
                        ICommand ICommand = (ICommand) applicationContext.getBean(commandName);
                        task.addPostCommand(ICommand);
                    }
                } else if(ArrayUtils.isNotEmpty(taskChain.postTypes())) {
                    Class[] commandTypes = taskChain.postTypes();
                    for (Class commandType : commandTypes) {
                        ICommand ICommand = (ICommand) applicationContext.getBean(commandType);
                        task.addPostCommand(ICommand);
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
