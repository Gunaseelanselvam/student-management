package com.studentmgmt.student_management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentmgmt.student_management.model.User;

public interface UserRespository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);
}