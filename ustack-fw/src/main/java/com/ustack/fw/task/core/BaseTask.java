package com.ustack.fw.task.core;

import com.ustack.fw.task.chain.BaseChain;
import com.ustack.fw.task.chain.ChainContext;
import com.ustack.fw.task.exception.TaskRuntimeException;

import java.util.Date;

/**
 * Description: 任务
 *
 * @author ferris
 * @date 2018/4/26 16:44
 */
public abstract class BaseTask<T extends BaseContext> implements ITask<T> {


    private BaseChain chain = new BaseChain();


    @Override
    public void addCommand(ICommand command) {
        chain.addCommand(command);
    }

    @Override
    public boolean execute(T t) {

        boolean result = false;
        try {
            beforeExecute(t);
            result = doExecute(t);
            afterExecute(t);
        } catch (Exception e) {
            checkException (t, e);
        }
        return result;
    }


    private boolean doExecute(T t) throws Exception {
        ChainContext context = new ChainContext(t);
        return chain.execute(context);
    }


    protected void beforeExecute (T context) {
        BaseContext baseContext = context;
        baseContext.set_beginTime(new Date());
    }

    protected void afterExecute (T context) {
        BaseContext baseContext = context;
        baseContext.set_endTime(new Date());
    }

    protected void checkException (T context, Exception e) {
        BaseContext baseContext = context;
        baseContext.setResult(Boolean.FALSE);
        if (e instanceof TaskRuntimeException) {
            throw (TaskRuntimeException) e;
        } else {
            throw new TaskRuntimeException(e.getMessage(), e);
        }
    }

}
