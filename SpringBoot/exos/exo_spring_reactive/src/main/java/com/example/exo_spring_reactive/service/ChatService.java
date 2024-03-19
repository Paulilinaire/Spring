package com.example.exo_spring_reactive.service;

import com.example.exo_spring_reactive.model.Message;
import com.example.exo_spring_reactive.repository.MessageRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Service
public class ChatService {

    private final Sinks.Many<Message> chatSink;

    private final MessageRepository messageRepository;

    private long currendId;


    public ChatService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
        chatSink = Sinks.many().multicast().onBackpressureBuffer();
    }


    public Flux<Message> getAllChatMessages(){
        return chatSink.asFlux();
    }

    public Mono<Message> getMessageById(long id){
        return messageRepository.findById(id);
    }


    public Mono<Message> sendMessage(String content, String username) {
        Message message = Message.builder().content(content).username(username).time(LocalDateTime.now()).build();
        chatSink.tryEmitNext(message);
        return messageRepository.save(message);
    }


    public Mono<Void> deleteMessage(Long id){
       return messageRepository.deleteById(id);
    }

    public Mono<Message> updateMessage(Message message, long id) {
        Mono<Message> messageMono = messageRepository.findById(id);
        return messageMono.flatMap(existingMessage -> {
            existingMessage.setUsername(message.getUsername());
            existingMessage.setTime(LocalDateTime.now());
            existingMessage.setContent(message.getContent());
            return messageRepository.save(existingMessage);
        });
    }

}
