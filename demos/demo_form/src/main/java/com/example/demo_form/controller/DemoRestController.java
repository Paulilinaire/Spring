package com.example.demo_form.controller;

import com.example.demo_form.Service.BunnyService;
import com.example.demo_form.model.Bunny;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/demo")
@RequiredArgsConstructor
public class DemoRestController {

    private final BunnyService bunnyService;


    @GetMapping
    public List<Bunny> getAllBunnies(){
        return bunnyService.getBunnies();
    }

    @GetMapping("/{id}")
    public Bunny getBunnyById(@PathVariable UUID id){
        return bunnyService.getBunnyById(id);
    }

    @PostMapping
    public Bunny createBunny(@RequestBody Bunny bunny){
        bunnyService.addBunny(bunny);
        return bunny;
    }

    @DeleteMapping("/{id}")
    public void deleteRabbit(@PathVariable UUID id){
        bunnyService.deleteBunny(id);
    }

    @PutMapping("/{id}")
    public void updateRabbit(@PathVariable UUID id){
        System.out.println("Put");
        System.out.println(id);
    }



}
