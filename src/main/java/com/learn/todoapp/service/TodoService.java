package com.learn.todoapp.service;

import com.learn.todoapp.dto.TodoRequest;
import com.learn.todoapp.dto.TodoResponse;
import com.learn.todoapp.entity.TodoEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    public List<TodoResponse> getTodos(){
        final List<TodoResponse> todos= List.of(new TodoResponse());
        return todos ;
    }
    public  TodoResponse createTodo(TodoRequest request){
        return  new TodoResponse(1L,request.getTitle(),request.getDescription(),false);
    }
}
