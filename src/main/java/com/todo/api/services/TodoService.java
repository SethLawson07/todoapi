package com.todo.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.api.models.Todo;
import com.todo.api.repository.ITodoRepository;
import com.todo.api.validator.ITodoValidator;

import lombok.Data;
@Service
@Data
public class TodoService {

    @Autowired
    private ITodoRepository todoRepository;

    @Autowired
    private ITodoValidator todoValidator;


    public List<Todo> getAll(){
        return todoRepository.findAll();
    }

    public Optional<Todo> getById(Long id){
        return todoRepository.findById(id);
    }

    public Optional<Todo> getByTitle(String title){
        return todoRepository.findByTitle(title);
    }

    public Todo create(Todo todo){
        todoValidator.validate(todo);
        return todoRepository.save(todo);
    }

    public Todo update(Long id,Todo todo){
        todoValidator.validate(todo);
        Optional<Todo> existingTodo = todoRepository.findById(id);
        
        if(existingTodo.isPresent()){
            Todo todo2 = existingTodo.get();
            todo2.setTitle(todo.getTitle());
            todo2.setDescription(todo.getDescription());
            todo2.setStatus(todo.getStatus());
            todoRepository.save(todo2);
            return todo2;
        }
            throw new RuntimeException("Todo not found");
    }

    public void delete(Long id){
        todoRepository.deleteById(id);
    }


}
