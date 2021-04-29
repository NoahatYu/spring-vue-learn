package com.example.demo.DTOs;

import java.time.LocalDate;

import javax.persistence.Transient;

public class StudentDTO {
    private String name;
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return this.dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", dob='" + getDob() + "'" +
            ", age='" + getAge() + "'" +
            "}";
    }

    
}
