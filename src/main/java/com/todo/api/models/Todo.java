package com.todo.api.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "todos")
@Data
public class Todo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Boolean status = false;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime createAt;

    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime updateAt;


}
