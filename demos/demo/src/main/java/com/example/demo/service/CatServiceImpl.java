package com.example.demo.service;

import com.example.demo.dao.CatRepository;
import com.example.demo.entity.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatServiceImpl implements CatService{

    private CatRepository catRepository;

    @Autowired
    public CatServiceImpl(CatRepository catRepository){
        this.catRepository = catRepository;
    }

    @Override
    public List<Cat> findAll() {
        return catRepository.findAll();
    }

    @Override
    public Cat findById(Long id) {
        return catRepository.getReferenceById(id);
    }

    @Override
    public Cat save(Cat cat) {
        catRepository.save(cat);
        return cat;
    }

    @Override
    public void delete(Long id) {
        catRepository.deleteById(id);
    }

    @Override
    public Cat update(Long id, Cat updatedCat) {
        Cat catExists = catRepository.getReferenceById(id);
        catExists.setName(updatedCat.getName());
        catExists.setBreed(updatedCat.getBreed());
        catExists.setColor(updatedCat.getColor());
        return catExists;
    }


}
