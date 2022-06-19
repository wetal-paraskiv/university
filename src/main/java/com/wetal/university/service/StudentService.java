package com.wetal.university.service;

import com.wetal.university.models.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    Student getOne(Long id);
    Student saveNew(Student student);
    Student update(Student student, Long id);
    void delete(Long id);
}
