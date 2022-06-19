package com.wetal.university.service.impl;

import com.wetal.university.exception.ResourceNotFoundException;
import com.wetal.university.models.Student;
import com.wetal.university.repository.StudentRepository;
import com.wetal.university.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student getOne(Long id) {
        return studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Student", "id", id)
        );
    }

    @Override
    public Student saveNew(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(Student student, Long id) {
        Student targetStudent = studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Student", "ID", id));
        targetStudent.setFirstName(student.getFirstName());
        targetStudent.setLastName(student.getLastName());
        targetStudent.setEmail(student.getEmail());
        studentRepository.save(targetStudent);
        return targetStudent;
    }

    @Override
    public void delete(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Student", "ID", id)
        );
        studentRepository.deleteById(id);
    }
}
