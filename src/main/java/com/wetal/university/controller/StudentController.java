package com.wetal.university.controller;

import com.wetal.university.models.Student;
import com.wetal.university.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @CrossOrigin
    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @CrossOrigin
    @GetMapping("{id}")
    public ResponseEntity<Student> getOne(@PathVariable("id") Long id) {
        return new ResponseEntity<Student>(studentService.getOne(id), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student) {
        return new ResponseEntity<Student>(studentService.saveNew(student), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> update(@PathVariable("id") Long id, @RequestBody Student student) {
        return new ResponseEntity<Student>(studentService.update(student, id), HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        studentService.delete(id);
        return new ResponseEntity<String>(
                "student info with id: " + id + " was successfully deleted.", HttpStatus.OK);
    }

}
