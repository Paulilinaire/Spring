package com.example.demo_exceptions.controller;

import com.example.demo_exceptions.exception.CustomException;
import com.example.demo_exceptions.exception.SecondCustomException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondRestController {

    @GetMapping("/bye")
    public String hello(){
        Integer error = 25/0;
        return "bye world !!";
    }

    @GetMapping("/byebye")
    public String byebye(){
        if (true) {
            throw new CustomException("Oops !!!!");
        }
        return "byyyyye";
    }

    @GetMapping("/hellothere")
    public String helloThere(){
        if (true) {
            throw new SecondCustomException("Général Kenobi");
        }
        return "hello there";
    }

}
