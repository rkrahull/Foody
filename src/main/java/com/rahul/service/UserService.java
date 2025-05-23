package com.rahul.service;

import com.rahul.entity.User;
import com.rahul.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public UUID saveUser(User user){
        user.setCreated(LocalDateTime.now());
        User savedUser = userRepository.save(user);
        return savedUser.getId();
    }
}
