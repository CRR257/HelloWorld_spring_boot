package com.example.HelloWorld;

import com.example.HelloWorld.entities.User;
import com.example.HelloWorld.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @Value("${demo-application.message}")
    private String message;

    @Autowired
    private UserRepository userRepository;

    public String myMethod() {
        return message.toUpperCase();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
