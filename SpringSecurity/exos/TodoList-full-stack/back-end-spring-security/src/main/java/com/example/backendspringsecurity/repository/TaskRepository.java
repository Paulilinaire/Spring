package com.example.backendspringsecurity.repository;

import com.example.backendspringsecurity.model.Roles;
import com.example.backendspringsecurity.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Override
    Optional<Task> findById(Long id);


}
