package com.lizz.fundation.jvm;

import com.lizz.fundation.socket.io.IOClient;
import com.sun.jndi.dns.DnsName;
import org.junit.Test;
import sun.net.spi.nameservice.dns.DNSNameService;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.ws.spi.http.HttpContext;

import static org.junit.Assert.*;

public class ClassLoaderTesterTest {


    @Test
    public void newObject(){
        System.out.println("line 1.........");
        ClassLoaderTester tester;
        System.out.println("line 2.........");
        tester = new ClassLoaderTester();
        tester.getClass();
        tester.getClass().getClassLoader();
        System.out.println("line 3.........tester =" + tester);
    }
    @Test
    public void readStaticVar(){
        System.out.println("line 1.........");
        ClassLoaderTester tester;
        System.out.println("line 2.........");
        int num = ClassLoaderTester.num;
        System.out.println("line 3.........num=" + num);
    }
    @Test
    public void readStaticFun(){
        System.out.println("line 1.........");
        ClassLoaderTester.print();
        System.out.println("line 2.........");
    }
    @Test
    public void invokeClass(){
        System.out.println("line 1.........");
        try {
            Class.forName("com.lizz.fundation.jvm.ClassLoaderTester1");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("line 2.........");
    }

    @Test
    public void  printClassLoader(){
        System.out.println("line 1.........");
        //当前类加载器
        System.out.println("ClassLoader1 is " + ClassLoaderTesterTest.class.getClassLoader());
        //当前类加载器的父级加载器
        System.out.println("ClassLoader2 is " + ClassLoaderTesterTest.class.getClassLoader().getParent());
        //当前类加载器的父级加载器的父级加载器
        System.out.println("ClassLoader3 is " + ClassLoaderTesterTest.class.getClassLoader().getParent().getParent());
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
        try {
            Context context = new InitialContext();
            Object ds=context.lookup("java:MySqlDS"); //引用数据源
        } catch (NamingException e) {
            e.printStackTrace();
        }
        System.out.println("line 2.........");
    }

}