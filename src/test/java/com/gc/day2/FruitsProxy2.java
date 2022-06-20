package com.gc.day2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 */
public class FruitsProxy2 implements InvocationHandler {
    //被代理对象
    private IFruits fruits;

    /**
     *通过方法获得代理对象（proxy）
     * @param iFruits 代理对象和被代理对象必须为同一类型
     * @return
     */
    public IFruits getProxy(IFruits iFruits){
        this.fruits = iFruits;

        IFruits o = (IFruits)Proxy.newProxyInstance(fruits.getClass().getClassLoader(), fruits.getClass().getInterfaces(), this);
        return o;
    }

    /**
     *接口自动执行的方法，代理对象（proxy）在调用某一方法时，自动调用被代理对象(fruit)的相同方法。
     * @param proxy 代理对象
     * @param method 代理类的方法
     * @param args 代理类方法的参数集合
     * @return 代理类的结果
     * @throws Throwable
     */

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("·····之前有东西·····");
        Object obj = method.invoke(fruits, args); // 自动调用被代理对象(fruit)的相同方法
        System.out.println("·····之后也有东西·····");
        return obj;
    }
}
