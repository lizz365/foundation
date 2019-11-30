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
    }
    @Test
    public void readStaticVar(){
        System.out.println("line 1.........");
        NewObject newObject;
        System.out.println("line 2.........");
        int num = NewObject.num;
        System.out.println("line 3.........num=" + num);
    }
    @Test
    public void readStaticFun(){
        System.out.println("line 1.........");
        NewObject.print();
        System.out.println("line 2.........");
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
    }
    @Test
    public void  threadClassLoader(){
        System.out.println("line 1.........");
        Thread thread = Thread.currentThread();
        System.out.println("Thread ClassLoader" + thread.getContextClassLoader());
    }

}