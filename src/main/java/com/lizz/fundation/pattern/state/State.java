package com.lizz.fundation.pattern.state;

/**
 * 抽象状态类，与StateContext特定状态相关的行为
 */
public abstract class State {

    public static final int START = 1;
    public static final int STOP = 2;
    public static final int FINISH = 3;
    public static final int ERROR = 9;

    public abstract boolean exe(StateContext stateContext);

    public abstract boolean stop(StateContext stateContext);

    public abstract int state();
}
