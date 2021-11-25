package com.ustack.fw.fsm;

import com.ustack.fw.fsm.domain.Action;
import com.ustack.fw.fsm.domain.ActionBuilder;
import com.ustack.fw.fsm.domain.Event;
import com.ustack.fw.fsm.domain.State;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

/**
 * Description: Machine
 *
 * @author Ferris
 * @date 2021/11/19 15:56
 * @Version 1.0
 */
public class MachineTemplate {

    private Map<State, Map<Action, MachineTransaction>> machineMap = new HashMap<>();

    /**
     * Description: MachineTransaction
     *
     * @author Ferris
     * @date 2021/11/19 16:39
     * @Version 1.0
     */
    @Getter
    @Setter
    public class MachineTransaction {

        private State state;

        private Event event;
    }

    public MachineTransaction transaction(State state, Event event){
        MachineTransaction transaction = new MachineTransaction();
        transaction.setState(state);
        transaction.setEvent(event);
        return transaction;
    }



    public static MachineTemplate init(){
        return new MachineTemplate();
    }

    public MachineTemplate addAction(ActionBuilder builder){
        Map<Action, MachineTransaction> actionMap = machineMap.get(builder.getCurrentState());
        if (actionMap == null) {
            actionMap = new HashMap<>();
        }
        actionMap.put(builder.getAction(), this.transaction(builder.getNextState(), builder.getEvent()));
        return this;
    }


    public MachineTransaction action(State state, Action action){
        Map<Action, MachineTransaction> actionMap = machineMap.get(state);
        if (actionMap != null) {
           return actionMap.get(action);
        }
        return null;
    }


}
