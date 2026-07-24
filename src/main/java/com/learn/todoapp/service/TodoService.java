package com.learn.todoapp.service;

import com.learn.todoapp.dto.TodoRequest;
import com.learn.todoapp.dto.TodoResponse;
import com.learn.todoapp.entity.Todo;
import com.learn.todoapp.exception.ResourceNotFoundException;
import com.learn.todoapp.mapper.PageMapper;
import com.learn.todoapp.mapper.TodoMapper;
import com.learn.todoapp.repository.TodoRepository;
import com.learn.todoapp.utils.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public PageResponse<TodoResponse> getTodos(int page, int size) {
        Page<TodoResponse> pageTodos = todoRepository.findAll(PageRequest.of(page, size)).map(TodoMapper::toResponse);
        //create from constructor in page response dto;
        return PageResponse.from(pageTodos);

        //con create mapper and map response
        // List<TodoResponse> todos = pageTodos.getContent().stream().toList();
        // return PageMapper.toPageResponse(pageTodos, todos);
    }

    public TodoResponse getTodoById(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found with id " + id));
        return TodoMapper.toResponse(todo);
    }

    public TodoResponse createTodo(TodoRequest request) {
        Todo todo = new Todo();

        todo.setTitle(request.getTitle());
        todo.setDescription(request.getDescription());
        todo.setCompleted(false);

        return TodoMapper.toResponse(todoRepository.save(todo));
    }

    public TodoResponse updateTodo(Long id, TodoRequest request) {
        Todo todo = todoRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id " + id));
        todo.setTitle(request.getTitle());
        todo.setDescription(request.getDescription());
        todo.setCompleted(Boolean.TRUE.equals(request.getCompleted()));

        return TodoMapper.toResponse(todoRepository.save(todo));
    }

    public void deleteTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found with id " + id));
        todoRepository.delete(todo);
    }

}
