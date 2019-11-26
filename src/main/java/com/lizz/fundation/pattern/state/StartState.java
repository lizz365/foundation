package com.lizz.fundation.pattern.state;

/**
 * 开始状态实现类
 */
public class StartState extends State{

    @Override
    public boolean exe(StateContext stateContext) {
        System.out.println("StartState exe");
        if(System.currentTimeMillis()%2 == 1) {
            stateContext.setState(new FinishState());
        }else{
            stateContext.setState(new StopState());
        }
        return true;
    }

    @Override
    public boolean stop(StateContext stateContext) {
        System.out.println("StartState stop");
        stateContext.setState(new StopState());
        return true;
    }

    @Override
    public int state() {
        return this.START;
    }
}
