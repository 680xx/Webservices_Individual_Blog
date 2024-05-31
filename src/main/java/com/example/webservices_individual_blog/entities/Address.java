package com.example.webservices_individual_blog.entities;

import jakarta.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Attributes
    @Column(length = 100, nullable = false)
    private String street;
    @Column(length = 10, nullable = false)
    private int postal;
    @Column(length = 40, nullable = false)
    private String city;
    @Column(length = 40, nullable = false)
    private String country;

    // Constructors
    public Address() {
    }
    public Address(String street, int postal, String city, String country) {
        this.street = street;
        this.postal = postal;
        this.city = city;
        this.country = country;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public int getPostal() {
        return postal;
    }
    public void setPostal(int postal) {
        this.postal = postal;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
}
