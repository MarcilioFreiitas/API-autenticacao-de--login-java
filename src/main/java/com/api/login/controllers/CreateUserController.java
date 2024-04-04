package com.api.login.controllers;

import java.util.List;

import com.api.login.dto.UserDto;
import com.api.login.model.User;
import com.api.login.repositories.UserRepositories;
import com.api.login.services.CreateUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class CreateUserController {
    @Autowired
    private UserRepositories repository;

    @Autowired
    private CreateUserService service;

    @GetMapping("list")
    public List<User> findAll(){
        return repository.findAll();
    }

    @PostMapping("add")
    public ResponseEntity<User> save(
        @RequestBody UserDto userDto
    ){
        return new ResponseEntity<User>(service.save(userDto), HttpStatus.OK);
    }
}
