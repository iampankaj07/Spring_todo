package com.learn.todoapp.service;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
    public String getMessage(){
        return "Hello from services";
    }
}
