package com.lizz.fundation.pattern.state;

/**
 * 完成状态实现类
 */
public class FinishState extends State{
    @Override
    public boolean exe(StateContext stateContext) {
        System.out.println("FinishState exe");
        return false;
    }

    @Override
    public boolean stop(StateContext stateContext) {
        System.out.println("FinishState stop");
        return false;
    }

    @Override
    public int state() {
        return this.FINISH;
    }
}
