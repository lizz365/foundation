package com.lizz.fundation.pattern.state;

/**
 * 环境类，用于控制状态过程，State类型与定义方法相关
 */
public class StateContext {
    //当前状态
    private State state;

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return state;
    }

    /**
     * 执行状态方法，参考State抽象方法
     */
    public boolean exe(){
        return state.exe(this);
    }
    /**
     * 执行状态方法，参考State抽象方法
     */
    public boolean stop(){
        return state.stop(this);
    }
}
