package com.lizz.fundation.pattern.state;
/**
 * 暂停状态实现类
 */
public class StopState extends State{

    @Override
    public boolean exe(StateContext stateContext) {
        System.out.println("StopState exe");
        if(System.currentTimeMillis()%2==1) {
            stateContext.setState(new StartState());
        }else{
            stateContext.setState(new ErrorState());
        }
        return true;
    }

    @Override
    public boolean stop(StateContext stateContext) {
        System.out.println("StopState stop");
        return false;
    }

    @Override
    public int state() {
        return this.STOP;
    }
}
