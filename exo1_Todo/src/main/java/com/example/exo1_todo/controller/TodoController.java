package com.example.exo1_todo.controller;

import com.example.exo1_todo.model.Todo;
import com.example.exo1_todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TodoController {

    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/")
    public String homePage(){
        System.out.println("page d'accueil");
        return "homepage";
    }

    @RequestMapping("/todo")
    public String showTodo(Model model){
        Todo todo = new Todo("test5","description5",true);
        model.addAttribute("titre",todo.getTitle());
        model.addAttribute("description",todo.getDescription());
        if (todo.isDone()){
            model.addAttribute("status","Fini");
        }else {
            model.addAttribute("status","en cours");
        }
        model.addAttribute("todo",new Todo("test6","description6",false));
        return "todo/todo";
    }


}
