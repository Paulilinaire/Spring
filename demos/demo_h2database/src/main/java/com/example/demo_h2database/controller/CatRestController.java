package com.example.demo_h2database.controller;

import com.example.demo_h2database.service.CatService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatRestController {

    private final CatService catService;

    public CatRestController(CatService catService) {
        this.catService = catService;
    }

    @Get
}
