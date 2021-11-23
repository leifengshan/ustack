package com.ustack.fw.fsm;

import com.ustack.fw.fsm.domain.ActionBuilder;

/**
 * Description: Abc
 *
 * @author Ferris
 * @date 2021/11/19 17:01
 * @Version 1.0
 */
public class Abc {

    public static void main(String[] args) {

        MachineTemplate template = MachineTemplate.init()
                .addAction(ActionBuilder.builder()
                        .currentState(AbcState.LOCKED)
                        .action(AbcAction.INSERT_COIN)
                        .nextState(AbcState.UNLOCKED)
                        .build())
                .addAction(ActionBuilder.builder()
                        .currentState(AbcState.LOCKED)
                        .action(AbcAction.INSERT_COIN)
                        .nextState(AbcState.UNLOCKED)
                        .build());

        FsmMachine fsmMachine = FsmMachine.instance(template, AbcState.LOCKED);

        fsmMachine.execute(AbcAction.INSERT_COIN);
        fsmMachine.getState();
    }
}
