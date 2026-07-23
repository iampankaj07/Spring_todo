package com.learn.todoapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
    @GetMapping("/todos")
    public String getTodos(){
        return "This is get endpoint";
    }
}
