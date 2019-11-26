package com.lizz.fundation.pattern.state;

import org.junit.Test;

public class StateTest {
    @Test
    public void State1(){
        StateContext context = new StateContext();
        context.setState(new StartState());
        while(context.getState().state() != State.FINISH ) {
            context.exe();
            System.out.println(context.getState() + " : " + context.getState().state());
        }
    }
}
