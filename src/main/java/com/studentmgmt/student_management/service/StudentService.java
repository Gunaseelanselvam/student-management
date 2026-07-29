package com.studentmgmt.student_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmgmt.student_management.exception.StudentNotFoundException;
import com.studentmgmt.student_management.model.Student;
import com.studentmgmt.student_management.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student updatedStudent){
        Optional<Student> existingStudent =  studentRepository.findById(id );
        if(!existingStudent.isPresent()){
            return null;
        }
        Student student = existingStudent.get();
        student.setFirstName(updatedStudent.getFirstName());
        student.setLastName(updatedStudent.getLastName());
        student.setEmail(updatedStudent.getEmail());
        student.setDepartment(updatedStudent.getDepartment());
        student.setCgpa(updatedStudent.getCgpa());

        return studentRepository.save(student);
    }
    

    public boolean deleteStudent(Long id){
     if(!studentRepository.existsById(id)){
        return false ;
     }
     studentRepository.deleteById(id);
     return true;
    }

    // public Optional<Student> getStudentById(Long id){
    //    return studentRepository.findById(id);
      
    // }


   public Student getStudentById(Long id){
    Optional<Student> student = studentRepository.findById(id);
    if(!student.isPresent()){
        throw new StudentNotFoundException("Student not found with id " + id);
    }
    return student.get();
    }

    

}
