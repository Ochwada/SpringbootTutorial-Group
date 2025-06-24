package com.example.tutorial.exception;


/**
 * *******************************************************
 * Package: com.example.tutorial.exception
 * File: BookIdMismatchException.java
 * Author: Ochwada
 * Date: Tuesday, 24.Jun.2025, 10:50 AM
 * Description:
 * Objective:
 * *******************************************************
 */


public class BookIdMismatchException extends RuntimeException {

    public BookIdMismatchException() {
        super("Book ID is Mismatched");
    }

    public BookIdMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
}
