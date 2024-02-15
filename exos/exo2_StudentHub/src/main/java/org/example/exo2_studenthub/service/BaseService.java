package org.example.exo2_studenthub.service;

import org.example.exo2_studenthub.model.Student;

import java.util.List;
import java.util.UUID;

public interface BaseService<T> {

    List<T> getAll();
    T getById(UUID id);
    boolean add(T element);
    boolean delete(UUID id);
    boolean update(UUID id, Student student);
    List<Student> getByLastName(String lastname);
    List<Student> searchStudent(String search);
}
