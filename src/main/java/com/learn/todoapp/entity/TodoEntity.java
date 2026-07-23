package com.learn.todoapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Entity
public class TodoEntity {
    @Id
    private  Long id;
    @NotBlank
    private String title;
    private String   description;
    private boolean isCompleted;
}
