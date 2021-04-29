package com.example.demo.Repos;

import java.util.Optional;

import com.example.demo.Modal.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
   Optional<Student> findStudentByEmail(String email);

}
