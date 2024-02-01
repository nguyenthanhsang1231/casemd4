package com.example.casemd4.service;

import com.example.casemd4.model.User;
import com.example.casemd4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public boolean changePassword( String Password,String username, String currentPassword) {
    User user = userRepository.findByUsername(username);

    if (user != null && user.getPassword().equals(currentPassword)) {
        user.setPassword(Password);
        userRepository.save(user);
        return true;
    }

    return false;
}
}
