package com.example.webservices_individual_blog.controllers;

import com.example.webservices_individual_blog.entities.Post;
import com.example.webservices_individual_blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    // List all blog posts
    @GetMapping("posts")
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    // List blog post by id
    @GetMapping("posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable int id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    // Create a new blog post
    @PostMapping("newpost")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Post> addNewPost(@RequestBody Post post) {
        return new ResponseEntity<>(postService.addNewPost(post), HttpStatus.CREATED);
    }

    // Update blog post by id
    @PutMapping("updatepost/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Post> updatePost(@PathVariable int id, @RequestBody Post post) {
        return ResponseEntity.ok(postService.updatePost(id, post));
    }

    // Delete blog post by id
    @DeleteMapping("deletepost/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<String> deletePostById(@PathVariable int id) {
        postService.deletePost(id);
        return ResponseEntity.ok("Deleted post with id " + id);
    }

}
