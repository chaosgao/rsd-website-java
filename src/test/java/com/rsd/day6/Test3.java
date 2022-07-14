package com.rsd.day6;


import com.rsd.bean.Student;
import com.rsd.dao.IStudentDAO;
import com.rsd.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@ContextConfiguration("classpath:spring.xml")
public class Test3 {

    @Autowired
    private IStudentDAO studentDAO;

    @Test
    public void test1(){
        Student student = new Student();
        student.setName("小明");
        student.setAge(15);
        student.setSex("男");

        studentDAO.insert(student);
    }
}
