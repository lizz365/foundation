package com.lizz.fundation.jdk.lambda;

/**
 * @description: todo
 * @author: lizz
 * @date: 2020/5/13 17:41
 */
public class InnerClass {

    public static void main(String[] args) {
        //原始写法
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(" old is running ");
            }
        }).start();

        // lambda写法
        // 自动匹配类和方法
        // ()替代new Runnable()
        // -> 替代{}
        new Thread(() -> System.out.println(" lambda is running")).start();


//        new A(()).print();



    }

    static class A{
        private String a;

        public A(B a){
            this.a = "string :"+a;
        }

        public A(C a){
            this.a = "int :"+a;
        }

        public void print(){
            System.out.println(a);
        }
    }

    abstract class B{
        public abstract void print1(String a);

        public abstract void print2(String b);

        public abstract void print3(int c);
    }
    abstract class C{
    }
}
