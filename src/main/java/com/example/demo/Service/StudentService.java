package com.example.demo.Service;
import com.example.demo.DTOs.StudentDTO;
import com.example.demo.Modal.Student;
import com.example.demo.Repos.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {


    private final StudentRepository studentRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public StudentService(StudentRepository studentRepository, ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public StudentDTO addNewStudent(StudentDTO studentDTO){
        Student student = objectMapper.convertValue(studentDTO, Student.class);
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("Email already in use");
        }
        student = studentRepository.save(student);
        return student.toDTO();
    }

    public StudentDTO deleteStudent(Long studentId){
        boolean studentExists = studentRepository.existsById(studentId);
        if(!studentExists){
            throw new IllegalStateException("Student with id '" + studentId + "' does NOT exist");
        }
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        studentRepository.deleteById(studentId);
        return studentOptional.get().toDTO();
    }
}
