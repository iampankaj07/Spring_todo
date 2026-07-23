package com.learn.todoapp.controller;

import com.learn.todoapp.dto.TodoRequest;
import com.learn.todoapp.dto.TodoResponse;
import com.learn.todoapp.entity.TodoEntity;
import com.learn.todoapp.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
    public List<TodoResponse> getTodos(){
        return  todoService.getTodos();
    }
    @PostMapping("/todos")
    public TodoResponse createTodos(@Valid @RequestBody TodoRequest todoEntity){
        return  todoService.createTodo(todoEntity);
    }
}
