package com.example.webservices_individual_blog.repositories;

import com.example.webservices_individual_blog.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
