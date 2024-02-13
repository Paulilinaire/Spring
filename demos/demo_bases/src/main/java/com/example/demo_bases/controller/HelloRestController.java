package com.example.demo_bases.controller;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/home")
public class HelloRestController {

    // @RequestMapping(method = RequestMethod.GET ) // fait la même chose que GetMapping
    @GetMapping
    public String sayHello(){
        System.out.println("Hello");
        return "Hello World !!!";
    }

    @GetMapping(value = "fortune_cookies") // si je ne met pas de valeur, erreur, car aura la meme adresse par défaut que le 1er get ("/api/v1/home")
    public List<String> fortuneCookieJson(){
        return List.of("Vous avez un admirateur secret", "Une nouvelle amitié vous apportera beaucoup de bonheur", "Repoussez vos limites");
    }

}
