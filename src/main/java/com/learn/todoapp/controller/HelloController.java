package com.learn.todoapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {
    @GetMapping("/greet")
    public String greet(){
        return  "Namaste ,Good Morning";
    }
    @GetMapping("/greetUser")
    public Map<String,String> greetByUser(){
        return  Map.of(
                "message", "Hi this is pankaj",
                "author","Pankaj",
                "status","Learning"

        );
    }
}
