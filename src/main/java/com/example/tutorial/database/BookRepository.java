package com.example.tutorial.database;


import com.example.tutorial.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * *******************************************************
 * Package: com.example.tutorial.database
 * File: BookRepository.java
 * Author: Ochwada
 * Date: Tuesday, 24.Jun.2025, 10:14 AM
 * Description:
 * Objective:
 * *******************************************************
 */


public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
}
