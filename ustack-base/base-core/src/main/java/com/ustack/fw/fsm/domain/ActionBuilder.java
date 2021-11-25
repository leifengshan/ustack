package com.ustack.fw.fsm.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description: EntranceMachineTransaction
 *
 * @author Ferris
 * @date 2021/11/19 15:53
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActionBuilder {

    private State currentState;

    private Action action;

    private State nextState;

    private Event event = new EmptyEvent();
}
