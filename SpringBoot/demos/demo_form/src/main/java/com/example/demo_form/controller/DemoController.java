package com.example.demo_form.controller;

import com.example.demo_form.Service.BunnyService;
import com.example.demo_form.model.Bunny;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        return "pageB";
    }


    @GetMapping("/detail/{bunnyId}")
    public String detailBunny(@PathVariable("bunnyId")UUID id, Model model){
        Bunny bunny = bunnyService.getBunnyById(id);
        model.addAttribute("myBunny", bunny);
        return "pageC";
    }


    @GetMapping("/list")
    public String getList(Model model){
        List<Bunny> bunnies = bunnyService.getBunnies();
        Bunny bunny = bunnies.get(0); // on récupère le 1er lapin du tableau
        model.addAttribute("idBunny", bunny.getId()); // on transmet l'id par un model.add attribut et un système de clé valeur. Maintenant bunny a un attribut idBunny

        Bunny bunny2 = bunnies.get(1);
        model.addAttribute("idBunny2", bunny2.getId());
        Bunny bunny3 = bunnies.get(2);
        model.addAttribute("idBunny3", bunny3.getId());
        model.addAttribute("bunnies", bunnies);

        return "pageB"; // il y a 2 endpoints sur la même page, donc on met une condition sur la liste (voir pageB) afin que la liste s'affiche seulement quand on demande la liste
    }

    @GetMapping("/add")
    public String addBunny(Model model){
        model.addAttribute("bunny", new Bunny());
        return "form/form";
    }

    @PostMapping("/add")
    public String submitBunny(@ModelAttribute("bunny")Bunny bunny){
        System.out.println(bunny.getName());
        System.out.println(bunny.getBreed());
        bunnyService.addBunny(bunny);
        return "redirect:/";
    }

    @GetMapping("/addbunny") // formulaire en mode get
    public String submitBunnyTwo(@RequestParam("name") String name, @RequestParam("breed") String breed){
        System.out.println(name);
        System.out.println(breed);
        bunnyService.addBunny(new Bunny(null,name,breed));
        return "redirect:/";
    }

    @GetMapping("/look")
    public String showBunny(@RequestParam(value = "namebunny", required = false) String name, Model model){
        System.out.println(name);
        Bunny bunny = bunnyService.getBunnyByName(name);

        if(bunny != null){ // on vérifie q'il y a bien un lapin qui existe sous le nom qu'on recherche
            model.addAttribute("myBunny", bunny);
        return "pageC"; // adresse url de la page http://localhost:8080/look?namebunny=Bugs Bunny
        } else {
            return "pageD";
        }
    }

}
