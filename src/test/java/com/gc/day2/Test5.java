package com.gc.day2;

import org.junit.jupiter.api.Test;

public class Test5 {

    @Test
    public void aa(){
        Apple apple = new Apple();
        Banana banana = new Banana();
        FruitsProxy2 fruits2 = FruitsProxy2.getAgency(apple);
        fruits2.sell();
    }


    @Test
    public void bb(){
        Apple apple = new Apple();

        FruitsProxy3 proxy3 = new FruitsProxy3();
        IFruits fruits = proxy3.getProxy(apple);
        fruits.sell();
    }

}
