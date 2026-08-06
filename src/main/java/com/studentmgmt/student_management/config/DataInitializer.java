package com.studentmgmt.student_management.config;
import org.springframework.context.annotation.Configuration;
import com.studentmgmt.student_management.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.studentmgmt.student_management.model.User;

@Configuration
public class DataInitializer {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(
        UserRepository userRepository,
        PasswordEncoder passwordEncoder
    ){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    CommandLineRunner initializeUser(){
        return args ->{

            if(userRepository.findByUsername("admin").isEmpty()){
                User user = new User();
                user.setUsername("admin");
                user.setPassword(passwordEncoder.encode("admin123"));
                user.setRole("ROLE_ADMIN");
                userRepository.save(user);
            }
        };
    }
}
