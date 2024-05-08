package com.example.AuthApi.controllers;

import com.example.AuthApi.dtos.UserDto;
import com.example.AuthApi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDto> listAll() {
        return userService.listAll();
    }

    @PostMapping
    public void insert(@RequestBody UserDto user) {
        userService.insert(user);
    }

    @PutMapping
    public UserDto update(@RequestBody UserDto user) {
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
