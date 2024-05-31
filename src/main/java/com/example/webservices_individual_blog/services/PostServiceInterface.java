package com.example.webservices_individual_blog.services;

import com.example.webservices_individual_blog.entities.Post;
import java.util.List;

public interface PostServiceInterface {

    List <Post> getAllPosts();
    Post getPostById(int id);
    Post addNewPost(Post post);
    Post updatePost(int id, Post post);
    void deletePost(int id);

}
