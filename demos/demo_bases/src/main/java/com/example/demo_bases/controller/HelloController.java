package com.example.demo_bases.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloController {

    @RequestMapping(value = "/")
    public String sayHello(){
        System.out.println("Hiiiii girls !!");
        return "hi";
    }

    @RequestMapping(value = "/fortune_cookies")
    @ResponseBody // renvoie du Json
    public List<String> getFortunesCookies(){
        return List.of("Vous avez un admirateur secret", "Ceci est un porte-bonheur, gardez-le avec vous", "Repoussez vos limites");
    }

    @RequestMapping(value = "newyear")
    public String showNewYear(){
        return "newyear";
    }

    @RequestMapping("/home/person")
    public String personName(Model model){
        model.addAttribute("firstName", "Eric");
        model.addAttribute("lastName", "Laout");

        List<String> persons = List.of("Marie Laout", "Amelie Laout", "Thomas Henriet");

        model.addAttribute("persons", persons);

        return "person/details";
    }

}
