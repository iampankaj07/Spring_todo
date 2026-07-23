package com.learn.todoapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Entity
@Table(name = "todos")
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @NotBlank
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String   description;
    @Column(nullable = false)
    private boolean isCompleted;
}
