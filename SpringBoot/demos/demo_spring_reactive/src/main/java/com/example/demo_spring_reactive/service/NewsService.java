package com.example.demo_spring_reactive.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Service
public class NewsService {

    // Un sink multicast qui permet de pousser des éléments vers plusieurs suscribers.
    private final Sinks.Many<String> sink;


    public NewsService() {
        sink = Sinks.many().multicast().onBackpressureBuffer(); // onBackpressureBuffer() permet de revenir sur tous les élements du sink donc le suscriber aura l'historique du sink
        // en initialisant le sink dans le service, quand le service sera créé dans le controller le sink sera créé aussi
    }


    public void sendNews(String news){
        sink.tryEmitNext(news);
    }


    public Flux<String> getFlux(){
        return  sink.asFlux();
    }



}
