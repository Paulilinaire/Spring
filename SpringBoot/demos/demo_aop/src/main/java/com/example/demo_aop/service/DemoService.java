package com.example.demo_aop.service;

import com.example.demo_aop.annotation.CustomAnnotation;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    public void method(){
        System.out.println("Method demoService");
        throw new RuntimeException();
    }

    public void methodReturnBoolean(){
        System.out.println("Boolean Method demoService");
    }

    @CustomAnnotation
    public void methodWithCustomAnnotation(){
        System.out.println("custom annotation");
    }
}
