package com.rsd.service;

import com.rsd.bean.Student;

import java.util.List;

public interface IStudentService {

     List<Student> list();

     Student getById(Integer id);

     void insert(Student student);

     void update(Student student);

     void deleteById(Integer id);
}
