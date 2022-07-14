package com.rsd.day4;

import com.rsd.bean.Student;
import com.rsd.dao.IStudentDAO;
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
    private IStudentDAO dogDAO;

    @Test
    public void test1(){
        List<Student> list = dogDAO.queryList();

        System.out.println(list);
    }
    @Test
    public void test2(){
        Student dog = dogDAO.getById(5);

        System.out.println(dog);
    }
    @Test
    public void test3(){
        Student dog = new Student();
        dog.setName("花姑娘");
        dog.setSex("女");
        dog.setAge(18);
        dog.setCreateTime(new Date());

        dogDAO.insert(dog);
    }
    @Test
    public void test4(){
        Student dog = new Student();
        dog.setId(24);
        dog.setName("花姑娘");
        dog.setSex("男");
        dog.setAge(18);
        dog.setCreateTime(new Date());

        dogDAO.update(dog);
    }
    @Test
    public void test5(){

        dogDAO.deleteById(24);
    }
}
