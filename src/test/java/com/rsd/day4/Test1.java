package com.rsd.day4;

import com.rsd.bean.Dog;
import com.rsd.dao.IDogDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Date;
import java.util.List;

@SpringJUnitConfig
@ContextConfiguration("classpath:spring.xml")
public class Test1 {

    @Autowired
    private IDogDAO dogDAO;

    @Test
    public void test1(){
        List<Dog> list = dogDAO.queryList();

        System.out.println(list);
    }
    @Test
    public void test2(){
        Dog dog = dogDAO.getById(5);

        System.out.println(dog);
    }
    @Test
    public void test3(){
        Dog dog = new Dog();
        dog.setName("花姑娘");
        dog.setSex("女");
        dog.setAge(18);
        dog.setBirthTime(new Date());

        dogDAO.insert(dog);
    }
    @Test
    public void test4(){
        Dog dog = new Dog();
        dog.setId(24);
        dog.setName("花姑娘");
        dog.setSex("男");
        dog.setAge(18);
        dog.setBirthTime(new Date());

        dogDAO.update(dog);
    }
    @Test
    public void test5(){

        dogDAO.deleteById(24);
    }
}
