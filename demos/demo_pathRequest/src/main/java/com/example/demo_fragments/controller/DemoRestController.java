package com.example.demo_fragments.controller;

import com.example.demo_fragments.Service.BunnyService;
import com.example.demo_fragments.model.Bunny;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/demo")
@RequiredArgsConstructor
public class DemoRestController {

    private final BunnyService bunnyService;


    @GetMapping
    public List<Bunny> getAllBunnies(){
        return bunnyService.getBunnies();
    }



}
