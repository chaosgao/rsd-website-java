package com.gc.day2;

/**
 * 静态代理   静态属性和静态方法
 *
 */
public class FruitsProxy1_2 implements IFruits{

    private static IFruits fruits;

    public static FruitsProxy1_2 getAgency(IFruits iFruits){
       fruits = iFruits;
        return new FruitsProxy1_2();
    }

    @Override
    public void sell() {
        System.out.println("开启事务");
        fruits.sell();
        System.out.println("关闭事务");
    }
}
