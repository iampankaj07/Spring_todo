package com.learn.todoapp.controller;

import com.learn.todoapp.dto.TodoRequest;
import com.learn.todoapp.dto.TodoResponse;
import com.learn.todoapp.entity.Todo;
import com.learn.todoapp.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/todos")
    public ResponseEntity<List<TodoResponse>> getTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.getTodos());
    }

    @PostMapping("/todos")
    public ResponseEntity<TodoResponse> createTodo(@Valid @RequestBody TodoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.createTodo(request));
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<TodoResponse> getTodoById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.getTodoById(id));
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<TodoResponse> updateTodo(@PathVariable Long id,@Valid @RequestBody TodoRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.updateTodo(id,request));
    }

    @DeleteMapping("todos/{id}")
    public  ResponseEntity<Map<String,String>> deleteTodo(@PathVariable Long id){
        todoService.deleteTodo(id);
        return  ResponseEntity.status(HttpStatus.OK).body(Map.of("message","Todo deleted successfully"));
    }
}
