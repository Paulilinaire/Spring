package com.example.exo1_todo.service;

import com.example.exo1_todo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TodoService {

    private ArrayList<Todo> todos = new ArrayList<>();

    public TodoService() {
        this.todos.add(new Todo("test6","description6",true));
        this.todos.add(new Todo("test7","description7",false));
    }

    public ArrayList<Todo> getTodos() {
        return todos;
    }

    public void setTodos(ArrayList<Todo> todos) {
        this.todos = todos;
    }
}
