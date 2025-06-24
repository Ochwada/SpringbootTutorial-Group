package com.example.tutorial.controller;


import com.example.tutorial.database.BookRepository;
import com.example.tutorial.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.tutorial.exception.*;
import java.util.List;

/**
 * *******************************************************
 * Package: com.example.tutorial.controller
 * File: BookController.java
 * Author: Ochwada
 * Date: Tuesday, 24.Jun.2025, 10:20 AM
 * Description: ookController is a REST controller that provides CRUD operations for managing {@link Book} entities.
 *  * It exposes RESTful endpoints under the base path <strong>/api/books</strong>.
 * Objective:
 * *******************************************************
 */

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    /**
     * Retrieves all books in the repository.
     *
     * @return an {@link Iterable} collection of all books
     */
    @GetMapping
    public Iterable findAll(){
        return bookRepository.findAll();
    }

    /**
     * Finds a list of books by their title.
     *
     * @param bookTitle the title of the book(s) to search
     * @return a {@link List} of books with the given title
     */
    @GetMapping("/title/{bookTitle}")
    public List findByTitle(@PathVariable String bookTitle){
        return  bookRepository.findByTitle(bookTitle);
    }

    /**
     * Retrieves a book by its unique ID.
     *
     * @param id the ID of the book to retrieve
     * @return the {@link Book} with the specified ID
     * @throws BookNotFoundException if the book is not found
     */
    @GetMapping("/{id}")
    public Book findOne(@PathVariable Long id){
        return bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
    }

    /**
     * Creates a new book and saves it in the repository.
     *
     * @param book the {@link Book} object to be created
     * @return the created book with an assigned ID
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    /**
     * Deletes a book with the given ID.
     *
     * @param id the ID of the book to delete
     * @throws BookNotFoundException if the book is not found
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        bookRepository.deleteById(id);
    }

    /**
     * Updates an existing book with the provided data.
     *
     * @param book the updated {@link Book} object
     * @param id   the ID of the book to update
     * @return the updated book object
     * @throws BookIdMismatchException if the book ID in the path does not match the body
     * @throws BookNotFoundException   if the book does not exist
     */
    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long id) {
        if (book.getId() != id) {
            throw new BookIdMismatchException();
        }
        bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        return bookRepository.save(book);
    }
}
