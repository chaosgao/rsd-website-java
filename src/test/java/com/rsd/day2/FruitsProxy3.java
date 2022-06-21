package com.rsd.day2;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * GCLib 动态代理
 */
public class FruitsProxy3 implements MethodInterceptor {
    // 被代理对象
    private IFruits fruits;

    public IFruits getProxy(IFruits iFruits){
        this.fruits = iFruits;

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(IFruits.class);
        enhancer.setCallback(this);
        return (IFruits) enhancer.create();
    }

    /**
     * 被代理对象执行的方法
     * @param o 代理对象
     * @param method 代理类的方法
     * @param objects 代理类的方法参数
     * @param methodProxy 代理对象的方法
     * @return 代理对象的结果
     * @throws Throwable 异常
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始");
        Object invoke = method.invoke(fruits, objects);
        System.out.println(invoke);
        System.out.println("结束");
        return invoke;
    }
}
