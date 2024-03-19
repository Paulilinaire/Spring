package com.example.demo.service;

import com.example.demo.entity.Cat;

import java.util.List;

public interface CatService {

    List<Cat> findAll();

    Cat findById(Long id);

    Cat save(Cat cat);

    void delete(Long id);

    Cat update(Long id, Cat updatedCat);

}
