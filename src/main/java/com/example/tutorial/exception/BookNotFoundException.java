package com.example.tutorial.exception;


/**
 * *******************************************************
 * Package: com.example.tutorial.exception
 * File: BookNotFoundException.java
 * Author: Ochwada
 * Date: Tuesday, 24.Jun.2025, 10:41 AM
 * Description:
 * Objective:
 * *******************************************************
 */


public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException() {
        super("Book not found");
    }

    public BookNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
