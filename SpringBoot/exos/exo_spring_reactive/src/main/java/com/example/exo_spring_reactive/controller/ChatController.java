package com.example.exo_spring_reactive.controller;

import com.example.exo_spring_reactive.model.Message;
import com.example.exo_spring_reactive.service.ChatService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;


    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/send")
    public Mono<Message> sendMessage(@RequestBody Message message) {
        return chatService.sendMessage(message.getContent(), message.getUsername());
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Message> subscribeToChat() {
        return chatService.getAllChatMessages();
    }

    @GetMapping("/message/{id}")
    public Mono<Message> getMessageById(@PathVariable long id) {
        return chatService.getMessageById(id);
    }

    @PutMapping("/update/{id}")
    public Mono<Message> updateMessage(@RequestBody Message message, @PathVariable long id) {
        return chatService.updateMessage(message, id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteMessage(@PathVariable Long id) {
        return chatService.deleteMessage(id);
    }


}
