package org.example.exo2_studenthub.service;

import org.example.exo2_studenthub.model.Student;

import java.util.List;
import java.util.UUID;

public interface BaseService<T> {

    List<T> getAll();
    T getById(UUID id);
    boolean add(T element);
    boolean delete(UUID id);
    boolean update(UUID id, T element);
    List<T> getByLastName(String lastname);
    List<T> searchStudent(String search);
}
