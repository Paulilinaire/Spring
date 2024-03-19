package com.example.exo_spring_reactive.repository;

import com.example.exo_spring_reactive.model.Message;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends R2dbcRepository<Message, Long> {
}
