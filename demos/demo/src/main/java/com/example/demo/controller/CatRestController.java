package com.example.demo.controller;

import com.example.demo.entity.Cat;
import com.example.demo.service.CatService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CatRestController {

    private CatService catService;

    @GetMapping("/list")
    public List<Cat> getAllCats(){
        return catService.findAll();
    }

    @GetMapping("/cat/{id}")
    public Cat getCatById(@PathVariable("id")Long id){
        return catService.findById(id);
    }

    @PostMapping("/add")
    public Cat createCat(@RequestBody Cat cat){
        return catService.save(cat);
    }

    @DeleteMapping("/cat/{id}")
    public void deleteCat(@PathVariable Long id){
        catService.delete(id);
    }

    @PutMapping("/cat/{id}")
    public Cat updateCat(@PathVariable Long id, @RequestBody Cat updateCat){
        return catService.update(id, updateCat);
    }

}
