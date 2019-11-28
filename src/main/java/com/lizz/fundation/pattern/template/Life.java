package com.lizz.fundation.pattern.template;

/**
 * 人的一生模板
 */
public abstract class Life {
    public final void live(){
        study();
        work();
        marry();
        die();
    }
    //学习
    abstract void study();
    //工作
    abstract void work();
    //成家
    abstract void marry();
    //死亡
    abstract void die();
}
