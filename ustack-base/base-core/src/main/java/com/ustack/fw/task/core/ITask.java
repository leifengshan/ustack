package com.ustack.fw.task.core;

/**
 * Description: 任务接口
 *
 * @author ferris
 * @date 2018/4/26 15:48
 */
public interface ITask<T extends IContext> {

    void addCommand(ICommand ICommand);

    boolean execute(T context) throws Exception;

}
