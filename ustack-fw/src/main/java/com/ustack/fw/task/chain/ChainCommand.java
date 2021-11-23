package com.ustack.fw.task.chain;

import com.ustack.fw.task.core.ICommand;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

/**
 * Description: ChainCommand
 *
 * @author ferris
 * @date 2018/4/26 17:06
 */
public class ChainCommand implements Command {

    private ICommand command;

    public ChainCommand(ICommand command) {
        this.command = command;
    }

    @Override
    public boolean execute(Context context) throws Exception {
        ChainContext chainContext = (ChainContext) context;
        return command.exec(chainContext.getContext());
    }

}
