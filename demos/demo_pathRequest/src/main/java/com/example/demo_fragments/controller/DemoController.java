package com.example.demo_fragments.controller;

import com.example.demo_fragments.Service.BunnyService;
import com.example.demo_fragments.model.Bunny;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor // car le bunnyService est requis dans le constructeur
public class DemoController {

    private final BunnyService bunnyService;


    @GetMapping
    public String homePage(){
        return "pageA";
    }


    @GetMapping("/pageb")
    public String pageB(Model model){
        List<Bunny> bunnies = bunnyService.getBunnies();
        Bunny bunny = bunnies.get(0); // on récupère le 1er lapin du tableau
        model.addAttribute("idBunny", bunny.getId()); // on transmet l'id par un model.add attribut et un système de clé valeur. Maintenant bunny a un attribut idBunny
        Bunny bunny2 = bunnies.get(1);
        model.addAttribute("idBunny2", bunny2.getId());
        Bunny bunny3 = bunnies.get(2);
        model.addAttribute("idBunny3", bunny3.getId());
        model.addAttribute("bunnies", bunnies);
        return "pageB";
    }


    @GetMapping("/detail/{bunnyId}")
    public String detailBunny(@PathVariable("bunnyId")UUID id, Model model){
        Bunny bunny = bunnyService.getBunnyById(id);
        model.addAttribute("myBunny", bunny);
        return "pageC";
    }
}
