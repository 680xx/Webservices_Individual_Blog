package com.example.webservices_individual_blog.services;

import com.example.webservices_individual_blog.entities.User;
import com.example.webservices_individual_blog.exceptions.ResourceNotFoundException;
import com.example.webservices_individual_blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    UserRepository userRepository;

    // Get all users
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by id
    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
    }

    // Create a new user
    @Override
    public User addNewUser(User user) {
        return userRepository.save(user);
    }

}
