package com.learn.todoapp.service;

import com.learn.todoapp.dto.TodoRequest;
import com.learn.todoapp.dto.TodoResponse;
import com.learn.todoapp.entity.Todo;
import com.learn.todoapp.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepository  ;



    public List<TodoResponse> getTodos(){
         List<Todo> todos= todoRepository.findAll();

        return todos.stream().map(todo -> new TodoResponse(todo.getId(), todo.getTitle(), todo.getDescription(), todo.isCompleted())).toList() ;
    }

    public  TodoResponse createTodo(TodoRequest request){
         Todo todo =new Todo();

         todo.setTitle(request.getTitle());
         todo.setDescription(request.getDescription());
         todo.setCompleted(false);

        Todo savedEntity= todoRepository.save(todo);

        TodoResponse response = new  TodoResponse();
        response.setId(savedEntity.getId());
        response.setDescription(savedEntity.getDescription());
        response.setTitle(savedEntity.getTitle());
        response.setCompleted(savedEntity.isCompleted());

       return response;
    }
}
