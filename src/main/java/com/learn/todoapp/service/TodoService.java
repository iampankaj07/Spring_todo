package com.learn.todoapp.service;

import com.learn.todoapp.dto.TodoRequest;
import com.learn.todoapp.dto.TodoResponse;
import com.learn.todoapp.entity.TodoEntity;
import com.learn.todoapp.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepository  ;



    public List<TodoResponse> getTodos(){
         List<TodoEntity> todos= todoRepository.findAll();

        return todos.stream().map(todoEntity -> new TodoResponse(todoEntity.getId(),todoEntity.getTitle(),todoEntity.getDescription(),todoEntity.isCompleted())).toList() ;
    }

    public  TodoResponse createTodo(TodoRequest request){
         TodoEntity todoEntity=new TodoEntity();

         todoEntity.setTitle(request.getTitle());
         todoEntity.setDescription(request.getDescription());
         todoEntity.setCompleted(false);

        TodoEntity savedEntity= todoRepository.save(todoEntity);

        TodoResponse response = new  TodoResponse();
        response.setId(savedEntity.getId());
        response.setDescription(savedEntity.getDescription());
        response.setTitle(savedEntity.getTitle());
        response.setCompleted(savedEntity.isCompleted());

       return response;
    }
}
