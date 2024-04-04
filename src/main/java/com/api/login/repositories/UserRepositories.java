package com.api.login.repositories;

import java.util.Optional;
import java.util.UUID;

import com.api.login.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositories extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}
