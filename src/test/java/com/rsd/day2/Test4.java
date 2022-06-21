package com.rsd.day2;

import org.junit.jupiter.api.Test;

public class Test4 {

    @Test
    public void aa(){
        Apple apple = new Apple();
        Banana banana = new Banana();

        IFruits fruits = new FruitsProxy1_1(banana);
        fruits.sell();
    }
    @Test
    public void bb(){
        Apple apple = new Apple();
        Banana banana = new Banana();
        FruitsProxy1_2 fruits2 = FruitsProxy1_2.getAgency(apple);
        fruits2.sell();
    }

    @Test
    public void cc(){
        Apple apple = new Apple();

        FruitsProxy2 proxy3 = new FruitsProxy2();
        IFruits fruits = proxy3.getProxy(apple);
        fruits.sell();
    }
@Test
    public void dd(){
        Apple apple = new Apple();
        FruitsProxy3 proxy = new FruitsProxy3();
        IFruits fruit = proxy.getProxy(apple);
        fruit.sell();
    }
}
