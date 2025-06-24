package com.example.tutorial.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * *******************************************************
 * Package: com.example.tutorial
 * File: SecurityConfig.java
 * Author: Ochwada
 * Date: Tuesday, 24.Jun.2025, 10:01 AM
 * Description: SecurityConfig is a Spring Security configuration class that defines the
 *  * security behavior for the application.
 * Objective:
 * *******************************************************
 */


/**

 * This configuration:
 *  Allows all incoming HTTP requests without requiring authentication.
 *  Disables Cross-Site Request Forgery (CSRF) protection.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Configures the security filter chain for the application.
     *
     * - All HTTP requests are permitted without authentication.
     * - CSRF protection is disabled.
     *
     * @param http the HttpSecurity object used to customize security settings
     * @return a configured SecurityFilterChain instance
     * @throws Exception if an error occurs during configuration
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(expressionInterceptUrlRegistry ->
                        expressionInterceptUrlRegistry
                                .anyRequest()
                                .permitAll())
                .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }
}
