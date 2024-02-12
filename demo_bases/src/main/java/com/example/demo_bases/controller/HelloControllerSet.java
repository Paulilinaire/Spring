package com.example.demo_bases.controller;

import com.example.demo_bases.service.GreetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloControllerSet {

    // Injection de dépendances via le constructeur
    private final GreetingsService greetingsService;

    @Autowired
    public HelloControllerSet(@Qualifier("salutations") GreetingsService greetingsService) { // salutations étant le frenchService, on donne en "qualifier" le nom du service que l'on veut utiliser
        this.greetingsService = greetingsService;
    }

    @RequestMapping(value = "/hello-set")
    public String sayHello(){
        System.out.println(greetingsService.sayHello());
        return "home";
    }
}
