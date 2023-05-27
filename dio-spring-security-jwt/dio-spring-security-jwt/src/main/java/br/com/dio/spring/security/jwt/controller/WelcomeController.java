package br.com.dio.spring.security.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class WelcomeController {

    @GetMapping
    public String welcome(){
        return "Welcome to my Spring Boot Web API";
    }

    @GetMapping("/users")
    public String users(){
        return "Authorized user";
    }

    @GetMapping("/managers")
    public String managers(){
        return "Authorized manager";
    }
}
