package com.learn.todoapp.controller;

import com.learn.todoapp.dto.TodoRequest;
import com.learn.todoapp.dto.TodoResponse;
import com.learn.todoapp.entity.Todo;
import com.learn.todoapp.service.TodoService;
import com.learn.todoapp.utils.PageResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
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
    public ResponseEntity<PageResponse<TodoResponse>> getTodos(
            @RequestParam (defaultValue = "0") int page,
            @RequestParam (defaultValue = "10") int size) {
        return ResponseEntity.ok().body(todoService.getTodos(page ,size));
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
