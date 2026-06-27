package com.studentmgmt.student_management.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentmgmt.student_management.model.Student;
import com.studentmgmt.student_management.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }


    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();

    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student savedStudent = studentService.createStudent(student);
        return ResponseEntity.status(201).body(savedStudent);
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent){
        Student student = studentService.updateStudent(id, updatedStudent);
        if(student == null){
            return ResponseEntity.status(404).body("Student not found with id " + id);
        }
        return ResponseEntity.ok(student);
    }
    
}
