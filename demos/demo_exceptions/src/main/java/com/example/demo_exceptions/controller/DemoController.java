package com.example.demo_exceptions.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class DemoController {

    @GetMapping("/salut")
    public String handlerError(Model model){
        Integer error = 12/0;
        return "salut";
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handlerArithmeticException(ArithmeticException ex, Model model){
        model.addAttribute("errorMessage", ex.getMessage());
        return "oups";
    }
}
