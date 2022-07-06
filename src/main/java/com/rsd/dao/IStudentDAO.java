package com.rsd.dao;

import com.rsd.bean.Student;

import java.util.List;

public interface IStudentDAO {

    List<Student> queryList();

    Student getById(Integer id);

    void insert(Student student);

    void deleteById(Integer id);

    void update(Student student);
}
