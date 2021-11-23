package com.ustack.fw.task.core;

/**
 * Description: 任务职责命令对象
 *
 * @author ferris
 * @date 2018/4/26 16:50
 */
public abstract class BaseCommand<T extends BaseContext> implements ICommand<T> {

    @Override
    public boolean exec(T context) throws Exception {
        boolean result;
        preExec(context);
        result = execute(context);
        postExec(context);
        return result;
    }

    public void preExec(T context) {}

    public void postExec(T context) {}

    public abstract boolean execute(T context) throws Exception ;

}
