package com.example.tutorial;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * *******************************************************
 * Package: com.example.tutorial
 * File: SpringContextTest.java
 * Author: Ochwada
 * Date: Tuesday, 24.Jun.2025, 11:05 AM
 * Description: Basic integration test to ensure the Spring application context loads successfully.
 * Objective:
 * *******************************************************
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SpringContextTest {

    @Test
    public void contextLoads() {
        //If the application context fails to load, this test will fail.
    }
}
