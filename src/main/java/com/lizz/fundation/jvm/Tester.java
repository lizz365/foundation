package com.lizz.fundation.jvm;

import org.junit.Test;
import sun.net.spi.nameservice.dns.DNSNameService;

public class Tester {


    @Test
    public void newObject(){
        System.out.println("line 1.........");
        NewObject newObject;
        System.out.println("line 2.........");
        newObject = new NewObject();
        newObject.getClass();
        newObject.getClass().getClassLoader();
        System.out.println("line 3.........newObject =" + newObject);
//        line 1.........
//        line 2.........
//        static Logging....
//        structure Logging....
//        function Logging....
//        line 3.........newObject =com.lizz.fundation.jvm.NewObject@68f7aae2
    }
    @Test
    public void readStaticVar(){
        System.out.println("line 1.........");
        NewObject newObject;
        System.out.println("line 2.........");
        int num = NewObject.num;
        System.out.println("line 3.........num=" + num);
//        line 1.........
//        line 2.........
//        static Logging....
//        line 3.........num=0
    }
    @Test
    public void readStaticFun(){
        System.out.println("line 1.........");
        NewObject.print();
        System.out.println("line 2.........");

//        line 1.........
//        static Logging....
//        printing.....
//        line 2.........
    }
    @Test
    public void invokeClass(){
        System.out.println("line 1.........");
        try {
            Class.forName("com.lizz.fundation.jvm.NewObject");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("line 2.........");

//        line 1.........
//        static Logging....
//        line 2.........
    }

    @Test
    public void  printClassLoader(){
        System.out.println("line 1.........");
        //当前类加载器
        System.out.println("ClassLoader1 is " + Tester.class.getClassLoader());
        //当前类加载器的父级加载器
        System.out.println("ClassLoader2 is " + Tester.class.getClassLoader().getParent());
        //当前类加载器的父级加载器的父级加载器
        System.out.println("ClassLoader3 is " + Tester.class.getClassLoader().getParent().getParent());
        System.out.println("line 2.........");
        System.out.println("DNSNameService ClassLoader is " + DNSNameService.class.getClassLoader());
        System.out.println("String ClassLoader is " + String.class.getClassLoader());
        System.out.println("line 3.........");

//        line 1.........
//        ClassLoader1 is sun.misc.Launcher$AppClassLoader@18b4aac2
//        ClassLoader2 is sun.misc.Launcher$ExtClassLoader@21b8d17c
//        ClassLoader3 is null
//        line 2.........
//        DNSNameService ClassLoader is sun.misc.Launcher$ExtClassLoader@21b8d17c
//        String ClassLoader is null
//        line 3.........

    }
    @Test
    public void  threadClassLoader(){
        System.out.println("line 1.........");
        Thread thread = Thread.currentThread();
        System.out.println("Thread ClassLoader" + thread.getContextClassLoader());
    }

}