package com.learn.todoapp.user.dto;

import com.learn.todoapp.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponse {
    private Long id;
    private String name;
    private String email;

    public static UserResponse from(User user){
        return new UserResponse(user.getId(), user.getName(), user.getEmail());

    }
}