package com.example.gestioncommercial.controller;

import com.example.gestioncommercial.Entity.Users;
import com.example.gestioncommercial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/users")
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }



    @PostMapping("/register")
    public ResponseEntity<Users> createUser(@RequestBody Users user) throws Exception {
        Users createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Users> login(@RequestBody Users user) {
        try {
            Users loggedInUser = userService.login(user);
            return new ResponseEntity<>(loggedInUser, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    }

