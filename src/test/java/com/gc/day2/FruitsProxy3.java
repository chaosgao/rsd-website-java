package com.gc.day2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class FruitsProxy3 implements InvocationHandler {

    private IFruits fruits;

    /**
     *
     * @param iFruits
     * @return
     */
    public IFruits getProxy(IFruits iFruits){
        this.fruits = iFruits;

        IFruits o = (IFruits)Proxy.newProxyInstance(fruits.getClass().getClassLoader(), fruits.getClass().getInterfaces(), this);
        return o;
    }

    /**
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("·····之前有东西·····");
        Object obj = method.invoke(fruits, args);
        System.out.println("·····之后也有东西·····");
        return obj;
    }
}
