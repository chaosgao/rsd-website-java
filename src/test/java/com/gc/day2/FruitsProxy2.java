package com.gc.day2;

public class FruitsProxy2 implements IFruits{

    private static IFruits fruits;

    public static FruitsProxy2 getAgency(IFruits iFruits){
       fruits = iFruits;
        return new FruitsProxy2();
    }

    @Override
    public void sell() {
        System.out.println("开启事务");
        fruits.sell();
        System.out.println("关闭事务");
    }
}
