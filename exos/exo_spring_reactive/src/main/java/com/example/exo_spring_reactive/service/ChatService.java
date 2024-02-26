package com.example.exo_spring_reactive.service;

import com.example.exo_spring_reactive.model.Message;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.time.ZonedDateTime;

@Service
public class ChatService {

    private final Sinks.Many<Message> chatSink;

    private long currendId;


    public ChatService() {
        chatSink = Sinks.many().multicast().onBackpressureBuffer();
    }


    public Flux<Message> getChatMessages(){
        return chatSink.asFlux();
    }


    public void sendMessage(Message message){
        message.setTime(ZonedDateTime.now());
        message.setId(currendId++);
        chatSink.tryEmitNext(message);
    }
}
