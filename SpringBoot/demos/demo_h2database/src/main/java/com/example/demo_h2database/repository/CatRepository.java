package com.example.demo_h2database.repository;

import com.example.demo_h2database.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CatRepository extends JpaRepository<Cat, UUID> {
    List<Cat> findAllByNameStartingWith(String value);

    Long countAllByNameStartingWith(String value);

}
