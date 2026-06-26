package com.studentmgmt.student_management.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentmgmt.student_management.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    
}
