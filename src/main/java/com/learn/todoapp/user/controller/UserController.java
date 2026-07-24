package com.learn.todoapp.user.controller;

import com.learn.todoapp.user.dto.UserRequest;
import com.learn.todoapp.user.dto.UserResponse;
import com.learn.todoapp.user.entity.User;
import com.learn.todoapp.user.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("register")
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest user) {
        return ResponseEntity.ok(userService.createUser(user));
    }
}
