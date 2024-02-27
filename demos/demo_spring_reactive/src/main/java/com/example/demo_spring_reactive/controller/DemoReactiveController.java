package com.example.demo_spring_reactive.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("reactives")
public class DemoReactiveController {

    @GetMapping
    public Mono<String> get(){ // Une méthode qui renvoie un mono (objet asychrone de reactor)
        return Mono.just("Hello from get method");
    }

    @GetMapping(value = "flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getFlux(){ // Une méthode qui renvoie un flux de données (object flux de reactor) à un client qui accepte le stream, avec un delay de 2 secondes entre chaque réponse
        return Flux.just("toto", "tata", "titi").delayElements(Duration.ofSeconds(2));
    }




}
