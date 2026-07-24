package com.learn.todoapp.service;

import com.learn.todoapp.dto.TodoRequest;
import com.learn.todoapp.dto.TodoResponse;
import com.learn.todoapp.dto.TodoUpdateRequest;
import com.learn.todoapp.entity.Todo;
import com.learn.todoapp.exception.ResourceNotFoundException;
import com.learn.todoapp.mapper.PageMapper;
import com.learn.todoapp.mapper.TodoMapper;
import com.learn.todoapp.repository.TodoRepository;
import com.learn.todoapp.utils.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public PageResponse<TodoResponse> getTodos(int page, int size, String sortBy, String direction, Boolean completed) {
        // this Manual
        // Sort sort = direction.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy);
        Page<Todo> pageTodos;
        if (completed == null) {
            pageTodos = todoRepository.findAll(PageRequest.of(page, size, sort));
        } else {
            pageTodos = todoRepository.findByCompleted(completed, PageRequest.of(page, size, sort));

        }
        Page<TodoResponse> pageTodoResponse = pageTodos.map(TodoMapper::toResponse);
        //create from constructor in page response dto;s
        return PageResponse.from(pageTodoResponse);

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

    public TodoResponse updateTodo(Long id, TodoUpdateRequest request) {
        Todo todo = todoRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id " + id));
        if (request.getTitle() != null) {
            todo.setTitle(request.getTitle());
        }
        if (request.getDescription() != null) {
            todo.setDescription(request.getDescription());
        }
        if (request.getCompleted() != null) {
            todo.setCompleted(request.getCompleted());
        }

        return TodoMapper.toResponse(todoRepository.save(todo));
    }

    public void deleteTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found with id " + id));
        todoRepository.delete(todo);
    }

}
