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

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(int id) {
        return postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "Id", id));
    }

    @Override
    public Post addNewPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(int id, Post post) {
        Post updatedPost = postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "Id", id));
        updatedPost.setMessage(post.getMessage());
        return postRepository.save(updatedPost);
    }

    @Override
    public void deletePost(int id) {
        postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "Id", id));
        postRepository.deleteById(id);
    }
}
