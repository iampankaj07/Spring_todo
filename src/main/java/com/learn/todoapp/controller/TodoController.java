package com.learn.todoapp.controller;

import com.learn.todoapp.dto.TodoResponse;
import com.learn.todoapp.service.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {
    @GetMapping("/todos")
    public List<TodoResponse> getTodos(){
        final List<TodoResponse> todos = List.of(new TodoResponse(1L,"title","desc",false));
 return  todos;
    }

    @GetMapping("/todoservice")
    public String getFromService(TodoService todoService){
     return  todoService.getMessage();
    }
}
