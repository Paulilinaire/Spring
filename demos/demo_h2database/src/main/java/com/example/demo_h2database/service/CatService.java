package com.example.demo_h2database.service;

import com.example.demo_h2database.entity.Cat;
import com.example.demo_h2database.mapper.CatMapper;
import com.example.demo_h2database.model.CatDto;
import com.example.demo_h2database.repository.CatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatService {

    private final CatRepository catRepository;
    private final CatMapper catMapper;


    public CatService(CatRepository catRepository, CatMapper catMapper) {
        this.catRepository = catRepository;
        this.catMapper = catMapper;
    }

    public List<CatDto> listCats(){
        return catRepository.findAll()
                .stream()
                .map(catMapper::catToCatDto) // demande a CatMapper de transformer tous les Cat en CatDTO grâce à catToCatDto
                .collect(Collectors.toList());
    }


    public CatDto addCat(CatDto catDto){
//        Cat cat = catMapper.catDtoToCat(catDto);
//        Cat savedCat = catRepository.save(cat);
//        CatDto savedDto = catMapper.catToCatDto(savedCat);
//        return savedDto;
        // 2 conversions car ce qu'on reçoit est un catDto, qu'on converti en cat pour sauvegarder dans la bdd
        // et recup id puis on reconvertit en catDto pour pouvoir l'afficher en front
        // notre front ne communique pas avec nos entity, seulement dto
        return catMapper.catToCatDto(catRepository.save(catMapper.catDtoToCat(catDto)));
    }
}
