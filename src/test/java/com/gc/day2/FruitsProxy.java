package com.gc.day2;

/**
 * 静态代理
 *
 */
public class FruitsProxy implements IFruits{

    private IFruits fruits;

    public FruitsProxy(IFruits fruits){
        this.fruits = fruits;
    }
    @Override
    public void sell() {

        System.out.println("·····开启事务·····");
        fruits.sell();
        System.out.println("·····关闭事务·····");
    }
}
