package com.example.demo.Config;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import com.example.demo.Modal.Student;
import com.example.demo.Repos.StudentRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student mary = new Student(
                "Mary",
                "mary@test.com",
                LocalDate.of(2000, Month.JANUARY, 14)
            );
            Student phil = new Student(
                "Phil",
                "phil@test.com",
                LocalDate.of(2010, Month.FEBRUARY, 16)
            );
            Student bob = new Student(
                "Bob",
                "Bobert@test.com",
                LocalDate.of(2002, Month.FEBRUARY, 15)
            );
            repository.saveAll(
                List.of(mary,phil,bob)
            );
            
        };
    }
}
