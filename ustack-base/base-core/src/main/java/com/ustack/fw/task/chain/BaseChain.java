package com.ustack.fw.task.chain;

import com.ustack.fw.task.core.ICommand;
import org.apache.commons.chain.impl.ChainBase;

/**
 * Description: BaseChain
 *
 * @author ferris
 * @date 2018/4/26 16:57
 */
public class BaseChain extends ChainBase {

    public void addCommand (ICommand cmmand) {
        ChainCommand command = new ChainCommand(cmmand);
        super.addCommand(command);
    }
}
