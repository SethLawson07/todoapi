package com.todo.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.api.models.Todo;
import com.todo.api.services.TodoService;

import lombok.Data;

@RestController
@RequestMapping("/api/todo")
@Data
public class TodoController {
    
    @Autowired
    private TodoService todoService;

   

    @GetMapping
    public ResponseEntity<List<Todo>> getAll(){
        return new ResponseEntity<>(todoService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Optional<Todo> todo = todoService.getById(id);

        if(todo.isPresent()){
            return new ResponseEntity<>(todo.get(),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{title}")
    public ResponseEntity<?> getByTitle(@PathVariable String title){
        Optional<Todo> todo = todoService.getByTitle(title);

        if(todo.isPresent()){
            return new ResponseEntity<>(todo.get(),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Todo todo){

        try {
            Todo newTodo = todoService.create(todo);
            return new ResponseEntity<>(newTodo,HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Todo todo){
        try {
            Todo updatedTodo = todoService.update(id, todo);
            return new ResponseEntity<>(updatedTodo,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_MODIFIED);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            todoService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);

        }
    }
}
