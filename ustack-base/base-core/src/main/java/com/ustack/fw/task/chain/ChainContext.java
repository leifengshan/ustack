package com.ustack.fw.task.chain;

import com.ustack.fw.task.core.IContext;
import org.apache.commons.chain.impl.ContextBase;

/**
 * Description: ChainContext
 *
 * @author ferris
 * @date 2018/4/26 17:08
 */
public class ChainContext extends ContextBase {

    private IContext context;

    public ChainContext(IContext context) {
        this.context = context;
    }

    public IContext getContext() {
        return context;
    }

}
