package com.ustack.fw.fsm;

import com.ustack.fw.fsm.domain.Event;

/**
 * Description: OpenEvent
 *
 * @author Ferris
 * @date 2021/11/19 15:59
 * @Version 1.0
 */
public class OpenEvent implements Event {

    @Override
    public boolean execute() {
        return Boolean.TRUE;
    }
}
