package com.klef.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.dto.UserResponse;
import com.klef.entity.User;
import com.klef.repository.UserRepository;
import com.klef.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository repository;

    @Override
    public UserResponse getUserByUsername(String username)
    {
        User user = repository.findByUsername(username)
                .orElseThrow(() ->
                        new RuntimeException("User not found with username: " + username));

        return mapToResponse(user);
    }

    @Override
    public UserResponse getUserById(Long id)
    {
        User user = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found with id: " + id));

        return mapToResponse(user);
    }

    private UserResponse mapToResponse(User user)
    {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .name(user.getName())
                .email(user.getEmail())
                .contact(user.getContact())
                .build();
    }
}
