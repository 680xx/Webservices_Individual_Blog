package com.example.webservices_individual_blog.services;

import com.example.webservices_individual_blog.entities.Post;
import com.example.webservices_individual_blog.exceptions.ResourceNotFoundException;
import com.example.webservices_individual_blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostService implements PostServiceInterface{

    @Autowired
    private PostRepository postRepository;

    // Get all posts
    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // Get post by id
    @Override
    public Post getPostById(int id) {
        return postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "Id", id));
    }

    // Create a new post
    @Override
    public Post addNewPost(Post post) {
        return postRepository.save(post);
    }

    // Update a post by id
    @Override
    public Post updatePost(int id, Post post) {
        Post updatedPost = postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "Id", id));
        updatedPost.setMessage(post.getMessage());
        return postRepository.save(updatedPost);
    }

    // Delete a post by id
    @Override
    public void deletePost(int id) {
        postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "Id", id));
        postRepository.deleteById(id);
    }
}
