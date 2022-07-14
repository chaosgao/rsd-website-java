package com.rsd.service.impl;

import com.rsd.bean.Student;
import com.rsd.dao.IStudentDAO;
import com.rsd.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentDAO studentDAO;

    @Override
    public List<Student> list() {

        return studentDAO.queryList();

    }

    @Override
    public Student getById(Integer id) {
        return studentDAO.getById(id);
    }

    @Override
    public void insert(Student student) {
//        student.setCreateTime(new Date());
        studentDAO.insert(student);
    }

    @Override
    public void update(Student student) {
        studentDAO.update(student);
    }

    @Override
    public void deleteById(Integer id) {
        studentDAO.deleteById(id);
    }
}
