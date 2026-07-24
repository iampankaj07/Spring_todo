package com.learn.todoapp.todo.mapper;

import com.learn.todoapp.todo.dto.TodoResponse;
import com.learn.todoapp.todo.entity.Todo;

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
