package com.lizz.fundation.jvm;

public class ClassLoaderTester {
    //加载顺序1
    static{
        System.out.println("static Logging....");
    }
    //加载顺序2,new时调用
    {
        System.out.println("structure Logging....");
    }
    //加载顺序3,new时调用
    ClassLoaderTester(){
        System.out.println("function Logging....");
    }

    public static int num = 0;

    public static void print(){
        System.out.println(" printing..... ");
    }
}
