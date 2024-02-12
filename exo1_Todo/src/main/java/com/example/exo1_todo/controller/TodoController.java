package com.example.exo1_todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodoController {

    @RequestMapping("/")
    public String homePage(){
        System.out.println("page d'accueil");
        return "homepage";
    }

    @RequestMapping("/todo")
    public String showTodo(Model model){
        model.addAttribute("title", "faire les coures");
        model.addAttribute("description", "blabla");
        model.addAttribute("done", false);

        return "todo";
    }
}
