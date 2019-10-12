package com.lizz.fundation.jdk.lang.threadlocal;

public class Num {
    private  ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
        public Integer initialValue() {
            return 0;
        }
    };

    private int code;

    public Integer get() {
        return seqNum.get();
    }

    public Integer setAndGet(Integer num) {
        this.seqNum.set(num);
        return this.seqNum.get();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
