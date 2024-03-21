package com.example.backendspringsecurity.repository;

import com.example.backendspringsecurity.model.Roles;
import com.example.backendspringsecurity.model.Task;
import com.example.backendspringsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    Optional<User> findById(Long id);

    Optional<User> findByName(String name);

}
