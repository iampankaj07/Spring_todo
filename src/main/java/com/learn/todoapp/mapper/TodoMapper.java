package com.learn.todoapp.mapper;

import com.learn.todoapp.dto.TodoResponse;
import com.learn.todoapp.entity.Todo;

public class TodoMapper {
    public static TodoResponse toResponse(Todo todo) {
        TodoResponse response = new TodoResponse();
        response.setId(todo.getId());
        response.setDescription(todo.getDescription());
        response.setTitle(todo.getTitle());
        response.setCompleted(todo.isCompleted());

        return response;
    }
}
