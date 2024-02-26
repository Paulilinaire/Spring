package com.example.exo_spring_reactive.controller;

import com.example.exo_spring_reactive.model.Message;
import com.example.exo_spring_reactive.service.ChatService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/send")
    public Message sendMessage(@RequestBody Message message) {
        chatService.sendMessage(message);
        return message;
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Message> subscribeToChat() {
        return chatService.getChatMessages();
    }
}
