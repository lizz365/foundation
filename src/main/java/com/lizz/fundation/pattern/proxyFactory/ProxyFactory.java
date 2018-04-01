package com.lizz.fundation.pattern.proxyFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lizz365
 */
public class ProxyFactory {
    private Object pObj;
    public ProxyFactory(Object obj){
        this.pObj = obj;
    }

    /**
     * 创建代理方法
     * @return
     */
    public Object getProxy(){
       return Proxy.newProxyInstance(pObj.getClass().getClassLoader(),
                pObj.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("进入代理方法");
                        //执行原始方法
                        Object rsObj = method.invoke(pObj,args);
                        System.out.println("代理方法结束");
                        return rsObj;
                    }
                });
    }

}
