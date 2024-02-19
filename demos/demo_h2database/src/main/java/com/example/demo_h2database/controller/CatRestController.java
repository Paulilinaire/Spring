package com.example.demo_h2database.controller;

import com.example.demo_h2database.entity.Cat;
import com.example.demo_h2database.model.CatDto;
import com.example.demo_h2database.service.CatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CatRestController {

    private final CatService catService;

    public CatRestController(CatService catService) {
        this.catService = catService;
    }


    @GetMapping("/cats")
    public List<CatDto> getAllCats(){
        return catService.listCats();
    }


    @PostMapping("/add")
    public CatDto createCat(@RequestBody CatDto catDto){
        return catService.addCat(catDto);
    }

}
