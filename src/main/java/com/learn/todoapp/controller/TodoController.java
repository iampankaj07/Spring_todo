package com.learn.todoapp.controller;

import com.learn.todoapp.dto.TodoRequest;
import com.learn.todoapp.dto.TodoResponse;
import com.learn.todoapp.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/todos")
    public ResponseEntity<List<TodoResponse>> getTodos(){
        return  ResponseEntity.status(HttpStatus.OK).body(todoService.getTodos());
    }
    @PostMapping("/todos")
    public ResponseEntity<TodoResponse> createTodo(@Valid @RequestBody TodoRequest request){
        return  ResponseEntity.status(HttpStatus.CREATED).body(todoService.createTodo(request));
    }
}
