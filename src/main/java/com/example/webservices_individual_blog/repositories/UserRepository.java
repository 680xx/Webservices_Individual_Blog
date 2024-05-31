package com.example.webservices_individual_blog.repositories;

import com.example.webservices_individual_blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
