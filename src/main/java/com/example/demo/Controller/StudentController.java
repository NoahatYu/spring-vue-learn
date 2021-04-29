package com.example.demo.Controller;

import java.util.List;

import com.example.demo.DTOs.StudentDTO;
import com.example.demo.Modal.Student;
import com.example.demo.Service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

   @PostMapping 
    public StudentDTO registerNewStudent(@RequestBody StudentDTO student){
        return studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public StudentDTO deleteStudent(@PathVariable("studentId") Long studentId){
        return studentService.deleteStudent(studentId);
    }
}
