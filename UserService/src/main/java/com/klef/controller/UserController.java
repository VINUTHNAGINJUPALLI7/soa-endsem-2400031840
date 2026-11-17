
package com.klef.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.dto.UserResponse;
import com.klef.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController
{
    @Autowired
    private UserService service;

    @GetMapping("/{username}")
    public ResponseEntity<UserResponse> getUserByUsername(@PathVariable String username)
    {
        return ResponseEntity.ok(service.getUserByUsername(username));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id)
    {
        return ResponseEntity.ok(service.getUserById(id));
    }
}
