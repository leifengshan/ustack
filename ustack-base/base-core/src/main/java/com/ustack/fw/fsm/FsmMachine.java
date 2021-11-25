package com.ustack.fw.fsm;

import com.ustack.fw.fsm.domain.Action;
import com.ustack.fw.fsm.domain.State;
import lombok.Getter;
import lombok.Setter;

/**
 * Description: MachineInstance
 *
 * @author Ferris
 * @date 2021/11/19 16:35
 * @Version 1.0
 */
public class FsmMachine {

    @Getter
    @Setter
    private MachineTemplate machineTemplate;

    @Getter
    @Setter
    private State state;

    public static FsmMachine instance(MachineTemplate template, State state){
        FsmMachine instance = new FsmMachine();
        instance.setMachineTemplate(template);
        instance.setState(state);
        return instance;
    }


    public void state(State state) {
        setState(state);
    }

    public boolean execute(Action action){

        MachineTemplate.MachineTransaction transaction = machineTemplate.action(this.state, action);

        setState(transaction.getState());

        return transaction.getEvent().execute();
    }
}
