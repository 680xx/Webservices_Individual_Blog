package com.example.webservices_individual_blog.controllers;

import com.example.webservices_individual_blog.entities.User;
import com.example.webservices_individual_blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    // List all users
    @GetMapping("users")

    public ResponseEntity<List<User>> getAllMembers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // List user by id
    @GetMapping("users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    // Create a new user
    @PostMapping("newuser")
    public ResponseEntity<User> addNewMember(@RequestBody User user) {
        return new ResponseEntity<>(userService.addNewUser(user), HttpStatus.CREATED);
    }

}
