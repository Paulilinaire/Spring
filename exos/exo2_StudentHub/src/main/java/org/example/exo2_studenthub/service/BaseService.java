package org.example.exo2_studenthub.service;

import org.example.exo2_studenthub.model.Student;

import java.util.List;
import java.util.UUID;

public interface BaseService<T> {

    List<T> getAll();
    T getByID(UUID id);
    boolean add(T element);
    List<Student> getByLastNameIgnoreCase(String lastname);

    List<Student> getByLastNameAndFirstNameIgnoreCase(String search);
}
