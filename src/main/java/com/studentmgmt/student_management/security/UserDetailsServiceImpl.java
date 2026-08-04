package com.studentmgmt.student_management.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.studentmgmt.student_management.model.User;
import com.studentmgmt.student_management.repository.UserRespository;


@Service

public class UserDetailsServiceImpl implements UserDetailsService{

    private final UserRespository userRespository;

    public UserDetailsServiceImpl(UserRespository userRespository){
        this.userRespository = userRespository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<User> userInformation = userRespository.findByUsername(username);
        if(!userInformation.isPresent()){
            throw new UsernameNotFoundException("User not found");
        } 
        User user = userInformation.get();
        return new CustomUserDetails(user);
    
    }
    }
    
