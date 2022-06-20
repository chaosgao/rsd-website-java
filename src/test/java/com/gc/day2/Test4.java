package com.gc.day2;

import org.junit.jupiter.api.Test;

public class Test4 {

    @Test
    public void aa(){
        Apple apple = new Apple();
        Banana banana = new Banana();

        IFruits fruits = new FruitsProxy(banana);
        fruits.sell();
    }
}
