package org.example.exo2_studenthub.service;

import java.util.List;
import java.util.UUID;

public interface BaseService<T> {

    List<T> getAll();
    T getByID(UUID id);
    boolean add(T element);
    T getByName(String lastname);

}
