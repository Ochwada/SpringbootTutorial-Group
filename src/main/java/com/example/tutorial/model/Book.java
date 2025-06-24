package com.example.tutorial.model;


import jakarta.persistence.*;

/**
 * *******************************************************
 * Package: com.example.tutorial.model
 * File: Book.java
 * Author: Ochwada
 * Date: Tuesday, 24.Jun.2025, 10:10 AM
 * Description:
 * Objective:
 * *******************************************************
 */

@Entity
public class Book {
   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

   @Column(nullable = false, unique = true)
    private String title;

   @Column(nullable = false)
    private String author;

    public long getId() {
        return id;
    }
}
