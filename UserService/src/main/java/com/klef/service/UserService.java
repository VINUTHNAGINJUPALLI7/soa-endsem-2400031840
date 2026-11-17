package com.klef.service;

import com.klef.dto.UserResponse;

public interface UserService
{
    UserResponse getUserByUsername(String username);

    UserResponse getUserById(Long id);
}
