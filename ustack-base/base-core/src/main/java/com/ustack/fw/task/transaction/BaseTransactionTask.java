package com.ustack.fw.task.transaction;

import com.ustack.fw.task.core.ICommand;
import com.ustack.fw.task.core.IContext;
import com.ustack.fw.task.core.BaseContext;
import com.ustack.fw.task.chain.BaseChain;
import com.ustack.fw.task.chain.ChainContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Description: 支持事物
 *
 * @author ferris
 * @date 2018/5/8 10:39
 */
public abstract class BaseTransactionTask<T extends BaseContext> implements TransationTask {

    private BaseChain chain = new BaseChain();
    private BaseChain preChain = new BaseChain();
    private BaseChain postChain = new BaseChain();


    @Override
    public void addCommand(ICommand ICommand) {
        chain.addCommand(ICommand);
    }
    @Override
    public void addPreCommand(ICommand ICommand) {
        preChain.addCommand(ICommand);
    }
    @Override
    public void addPostCommand(ICommand ICommand) {
        postChain.addCommand(ICommand);
    }

    @Override
    public boolean execute(IContext IContext) {

        T t = (T) IContext;
        beforeExecute(t);
        boolean result = false;
        try {
            doPreExecute(t);
            result = doExecute(t);
            doPostExecute(t);
        } catch (Exception e) {
            checkException (t, e);
        }
        afterExecute(t);
        return result;
    }


    @Transactional
    protected boolean doExecute(T t) throws Exception {
        ChainContext context = new ChainContext(t);
        return chain.execute(context);
    }

    private boolean doPreExecute(T t) throws Exception {
        ChainContext context = new ChainContext(t);
        return preChain.execute(context);
    }

    private boolean doPostExecute(T t) throws Exception {
        ChainContext context = new ChainContext(t);
        return postChain.execute(context);
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
    }
}
