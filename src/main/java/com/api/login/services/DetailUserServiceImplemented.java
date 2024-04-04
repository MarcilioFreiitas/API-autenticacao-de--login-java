package com.api.login.services;

import java.util.Optional;

import com.api.login.data.DetailUserData;
import com.api.login.model.User;
import com.api.login.repositories.UserRepositories;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class DetailUserServiceImplemented implements UserDetailsService {

    private final UserRepositories repository;

    public DetailUserServiceImplemented(UserRepositories repository){
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByEmail(username);
        if(user.isEmpty()){
            throw new UsernameNotFoundException("User [" + username + "] not find");
        }

        return new DetailUserData(user);
    }
    
}
