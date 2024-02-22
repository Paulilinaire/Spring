package com.example.demo_aop.controller;

import com.example.demo_aop.service.DemoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("")
public class HomeController {

    private final DemoService demoService;

    public HomeController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/demo")
    public ResponseEntity<String> get(){
//        System.out.println("------------ Boolean method ------------");
//        demoService.methodReturnBoolean();
//        System.out.println("------------ Void method with exception ------------");
//        demoService.method();

        demoService.methodWithCustomAnnotation();

        return ResponseEntity.ok("ok");
    }


}
