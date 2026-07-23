package com.learn.todoapp.service;

import com.learn.todoapp.dto.TodoRequest;
import com.learn.todoapp.dto.TodoResponse;
import com.learn.todoapp.entity.Todo;
import com.learn.todoapp.exception.ResourceNotFoundException;
import com.learn.todoapp.mapper.TodoMapper;
import com.learn.todoapp.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepository  ;

    public List<TodoResponse> getTodos(){
        return todoRepository.findAll().stream().map(TodoMapper::toResponse).toList() ;
    }

    public  TodoResponse getTodoById(Long id){
        Todo  todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found eith id" +id));
        return  TodoMapper.toResponse(todo);
    }

    public  TodoResponse createTodo(TodoRequest request){
         Todo todo =new Todo();

         todo.setTitle(request.getTitle());
         todo.setDescription(request.getDescription());
         todo.setCompleted(false);

       return TodoMapper.toResponse(todoRepository.save(todo));
    }
}
