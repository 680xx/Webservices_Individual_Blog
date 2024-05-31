package com.example.webservices_individual_blog.entities;

import jakarta.persistence.*;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Attributes
    @Column(length = 1000, nullable = false)
    private String message;

    // Constructors
    public Post() {
    }
    public Post(String message) {
        this.message = message;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
