package com.example.backendspringsecurity.repository;

import com.example.backendspringsecurity.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Long> {
}
