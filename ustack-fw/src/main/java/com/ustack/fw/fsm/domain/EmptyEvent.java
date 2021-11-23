package com.ustack.fw.fsm.domain;

/**
 * Description: EmptyEvent
 *
 * @author Ferris
 * @date 2021/11/19 17:00
 * @Version 1.0
 */
public class EmptyEvent implements Event {

    @Override
    public boolean execute() {
        return Boolean.TRUE;
    }
}
