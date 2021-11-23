package com.ustack.fw.task;

import com.ustack.fw.task.core.BaseCommand;
import lombok.extern.slf4j.Slf4j;

/**
 * Description: TaskCommand
 *
 * @author Ferris
 * @date 2021/11/19 11:44
 * @Version 1.0
 */
@Slf4j
public abstract class TaskCommand<T extends TaskContext> extends BaseCommand<T> {

    @Override
    public void preExec(T context) {
        log.info("TaskCommand " + this.getClass().getSimpleName() + " =begin=");
    }

    @Override
    public void postExec(T context) {
        log.info("TaskCommand " + this.getClass().getSimpleName() + " =end=");
    }
}
