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

@Controller
public class SimpleController {
    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("appName", appName);
        return "home";
    }
}
