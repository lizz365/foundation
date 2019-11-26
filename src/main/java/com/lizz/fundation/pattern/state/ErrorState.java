package com.lizz.fundation.pattern.state;
/**
 * 初始化状态实现类
 */
public class ErrorState extends State{
    @Override
    public boolean exe(StateContext stateContext) {
        System.out.println("ErrorState exe");
        stateContext.setState(new StartState());
        return false;
    }

    @Override
    public boolean stop(StateContext stateContext) {
        System.out.println("ErrorState stop");
        return false;
    }

    @Override
    public int state() {
        return this.ERROR;
    }
}
