package com.gc.day2;

/**
 * 静态代理
 *
 */
public class FruitsProxy1_1 implements IFruits{

    private IFruits fruits;

    public FruitsProxy1_1(IFruits fruits){
        this.fruits = fruits;
    }
    @Override
    public void sell() {

        System.out.println("·····开启事务·····");
        fruits.sell();
        System.out.println("·····关闭事务·····");
    }
}
