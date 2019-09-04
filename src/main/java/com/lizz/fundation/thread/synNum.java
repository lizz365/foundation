package com.lizz.fundation.thread;

/**
 * @author lizz365
 */
public class synNum {
    static int num = 0;
    public static void main(String[] args) {
        for (int i=0;i<10;i++ ){
            new Thread(new Runnable() {
                @Override
                public void run() {
                        System.out.println(add());
                }
            }).start();
        }
    }
    public static int add(){
       return num++;
    }
}
