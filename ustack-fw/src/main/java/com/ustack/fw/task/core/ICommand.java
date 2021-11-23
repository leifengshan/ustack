package com.ustack.fw.task.core;

/**
 * Description: 任务职责命令对象接口
 *
 * @author ferris
 * @date 2018/4/26 16:22
 */
public interface ICommand<T extends IContext> {

    boolean exec(T context) throws Exception ;
}
