package com.example.webservices_individual_blog.entities;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Attributes
    @Column(length = 50, nullable = false)
    private String firstName;
    @Column(length = 50, nullable = false)
    private String lastName;
    @Column(length = 100, nullable = false)
    private String email;
    @Column(length = 20, nullable = false)
    private int phone;
    @Column(length = 10, nullable = false)
    private String memberType;

    @ManyToOne()
    @JoinColumn(referencedColumnName = "id")
    private Address address;

    // Constructors
    public User() {
    }
    public User(Address address, String memberType, int phone, String email, String lastName, String firstName) {
        this.address = address;
        this.memberType = memberType;
        this.phone = phone;
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
    public String getMemberType() {
        return memberType;
    }
    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
}
