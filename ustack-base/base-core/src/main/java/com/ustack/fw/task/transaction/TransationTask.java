package com.ustack.fw.task.transaction;

import com.ustack.fw.task.core.ICommand;
import com.ustack.fw.task.core.ITask;

/**
 * Description: 带事物任务接口
 *
 * @author ferris
 * @date 2018/5/8 10:47
 */
public interface TransationTask extends ITask {

    void addPreCommand(ICommand ICommand);

    void addPostCommand(ICommand ICommand);
}
