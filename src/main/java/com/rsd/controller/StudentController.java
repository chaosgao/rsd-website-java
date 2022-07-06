package com.rsd.controller;

import com.rsd.bean.Student;
import com.rsd.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @ResponseBody
    @GetMapping("list")
    public List<Student> list(){
        return studentService.list();
    }

    @ResponseBody
    @PostMapping("insert")
    public void insert(Student student){
        studentService.insert(student);
    }

    @ResponseBody
    @GetMapping("getById/{id}")
    public Student getById(@PathVariable Integer id){
       return studentService.getById(id);
    }

    @ResponseBody
    @PostMapping("update")
    public void update(Student student){
     studentService.update(student);
    }

    @ResponseBody
    @GetMapping("deleteById/{id}")
    public void deleteById(@PathVariable Integer id){
        studentService.deleteById(id);
    }

}
