package com.learn.todoapp.user.entity;

import com.learn.todoapp.todo.entity.Todo;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false,unique = true)
    private String email;
    @OneToMany(mappedBy = "user",cascade = CascadeType.PERSIST)
    private List<Todo> todos = new ArrayList<>();
}
