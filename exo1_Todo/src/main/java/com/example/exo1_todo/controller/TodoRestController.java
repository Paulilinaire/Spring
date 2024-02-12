package com.example.exo1_todo.controller;

import com.example.exo1_todo.entity.Todo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "api/v1/base")
public class TodoRestController {

    @GetMapping("todo")
    public Todo getTodo(){
        return (Todo.builder().title("test1").description("blabla2").done(false).build());
    }

    @GetMapping("todos")
    public List<Todo> getTodos(){
        return List.of(Todo.builder().title("faire les courses").description("blabla").done(false).build(),
                Todo.builder().title("test2").description("blabla2").done(true).build());
    }

}
