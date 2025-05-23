package com.rahul.controller;

import com.rahul.entity.User;
import com.rahul.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/sign-up")
    ResponseEntity<UUID> signUp(@Valid @RequestBody User user){
        UUID id = userService.saveUser(user);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }
}
