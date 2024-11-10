package com.todo.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.api.models.Todo;

public interface ITodoRepository extends JpaRepository<Todo,Long>{

    Optional<Todo> findByTitle(String title);
    
}
