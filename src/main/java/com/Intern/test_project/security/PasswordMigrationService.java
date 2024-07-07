//package com.Intern.test_project.security;
//
//import com.Intern.test_project.domain.entities.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.Intern.test_project.repository.UserRepository;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.util.List;
//
//@Service
//public class PasswordMigrationService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    public void migratePasswords() {
//        List<User> users = userRepository.findAll(); // Fetch all users from your repository
//
//        for (User user : users) {
//            if (!passwordEncoder.matches(user.getPassword(), user.getPassword())) {
//                String hashedPassword = passwordEncoder.encode(user.getPassword());
//                user.setPassword(hashedPassword);
//                userRepository.save(user);
//            }
//        }
//    }
//}
