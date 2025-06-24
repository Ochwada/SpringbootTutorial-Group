package com.example.tutorial;


import com.example.tutorial.model.Book;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

/**
 * *******************************************************
 * Package: com.example.tutorial
 * File: SpringBootBootstrapLiveTest.java
 * Author: Ochwada
 * Date: Tuesday, 24.Jun.2025, 11:08 AM
 * Description:
 * Objective:
 * *******************************************************
 */

/**
 * Integration test class that boots the full Spring Boot application and tests
 * the REST API endpoints for the {@link Book} resource using RestAssured.
 * <p>
 * This test runs with a random port to avoid port conflicts and ensures the web layer is fully initialized.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootBootstrapLiveTest {

    /**
     * Injects the randomly assigned port that the application runs on during the test.
     */
    @LocalServerPort
    private int port;

    /**
     * Base URL for the /api/books endpoint, initialized with the random port before each test.
     */
    private String API_ROOT;

    /**
     * Sets up the API root URL and configures RestAssured to use the random port.
     */
    @BeforeEach
    public void setUp() {
        API_ROOT = "http://localhost:" + port + "/api/books";
        RestAssured.port = port;
    }

    /**
     * Helper method that creates a new {@link Book} object with a random title and author.
     *
     * @return a {@link Book} with randomly generated title and author
     */
    private Book createRandomBook() {
        final Book book = new Book();
        book.setTitle(randomAlphabetic(10));
        book.setAuthor(randomAlphabetic(15));
        return book;
    }

    /**
     * Sends a POST request to create a new book via the API and returns the URI to access it.
     *
     * @param book the {@link Book} to be created
     * @return the full URI of the created book
     */
    private String createBookAsUri(Book book) {
        final Response response = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(book)
                .post(API_ROOT);
        return API_ROOT + "/" + response.jsonPath().get("id");
    }

}
