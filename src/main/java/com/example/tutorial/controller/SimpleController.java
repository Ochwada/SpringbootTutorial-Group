package com.example.tutorial.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * *******************************************************
 * Package: com.example.tutorial.controller
 * File: SimpleController.java
 * Author: Ochwada
 * Date: Tuesday, 24.Jun.2025, 9:44 AM
 * Description: Handles webRequests
 * Objective:
 * *******************************************************
 */


/**
 * SimpleController is a Spring MVC Controller that handles HTTP GET requests
 * to the root path ("/"). It injects the application name from the properties
 * file and passes it to the view for rendering.
 *
 * This controller uses Thymeleaf as the view technology.
 */
@Controller
public class SimpleController {

    /**
     * Injects the application name from the application.properties file.
     * The value is read from the property: spring.application.name
     */
    @Value("${spring.application.name}")
    String appName;


    /**
     * Handles GET requests to the root URL ("/") and returns the "home" view.
     * The method adds the application name to the model so it can be displayed
     * in the rendered view.
     *
     * @param model the Spring Model object used to pass data to the view
     * @return the name of the view template to render ("home")
     */
    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("appName", appName);
        return "home";
    }
}
