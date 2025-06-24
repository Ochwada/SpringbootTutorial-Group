package com.example.tutorial.exception;


import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * *******************************************************
 * Package: com.example.tutorial.exception
 * File: RestExceptionHandler.java
 * Author: Ochwada
 * Date: Tuesday, 24.Jun.2025, 10:34 AM
 * Description: RestExceptionHandler provides centralized exception handling for all REST controllers.
 * * This class uses {@link ControllerAdvice} to globally manage exceptions and extend
 * * {@link ResponseEntityExceptionHandler} to handle specific exceptions for your application.
 * Objective:
 * *******************************************************
 */

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handles {@link BookNotFoundException} when a requested book is not found in the system.
     *
     * @param ex      the exception thrown
     * @param request the current web request
     * @return a {@link ResponseEntity} with status 404 NOT FOUND and a custom message
     */
    @ExceptionHandler({BookNotFoundException.class})
    protected ResponseEntity<Object> handleNotFound(
            Exception ex, WebRequest request) {

        return handleExceptionInternal(
                ex,
                "Book Not Found",
                new HttpHeaders(),
                HttpStatus.NOT_FOUND, request
        );
    }

    /**
     * Handles bad request scenarios such as:
     * <ul>
     *     <li>{@link BookIdMismatchException} – when a book ID in the path doesn't match the request body</li>
     *     <li>{@link ConstraintViolationException} – when validation rules are violated</li>
     *     <li>{@link DataIntegrityViolationException} – when database constraints are violated</li>
     * </ul>
     *
     * @param ex the exception thrown
     * @param request the current web request
     * @return a {@link ResponseEntity} with status 400 BAD REQUEST and the exception's localized message
     */

    @ExceptionHandler({ BookIdMismatchException.class,
            ConstraintViolationException.class,
            DataIntegrityViolationException.class
    })

    public ResponseEntity<Object> handleBadRequest(
            Exception ex,
            WebRequest request) {
        return handleExceptionInternal(
                ex,
                ex.getLocalizedMessage(),
                new HttpHeaders(),
                HttpStatus.BAD_REQUEST,
                request);
    }
}
