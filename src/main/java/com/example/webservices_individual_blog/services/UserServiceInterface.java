package com.example.webservices_individual_blog.services;

import com.example.webservices_individual_blog.entities.User;
import java.util.List;

public interface UserServiceInterface {

    List <User> getAllUsers();
    User getUserById(int id);
    User addNewUser(User user);

}
