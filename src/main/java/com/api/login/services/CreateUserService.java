package com.api.login.services;

import java.util.Optional;

import com.api.login.dto.UserDto;
import com.api.login.model.User;
import com.api.login.repositories.UserRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService {
    @Autowired
    private UserRepositories repository;

    @Autowired
    private PasswordEncoder encoder;
        
    public User save(UserDto userDto){
        Optional<User> userRepository = repository.findByEmail(userDto.getEmail());

        if(!userRepository.isEmpty()){
            throw new Error("Email '" + userRepository.get().getEmail() + "' already exists!");
        }

        if(userDto.getName().isEmpty() || userDto.getPassword().isEmpty()){
            throw new Error("Name and/or password not defined!");
        }

        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(encoder.encode(userDto.getPassword()));

        repository.save(user);

        return user;
    }
}
