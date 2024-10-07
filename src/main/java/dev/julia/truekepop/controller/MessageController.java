package dev.julia.truekepop.controller;

import dev.julia.truekepop.models.Message;
import dev.julia.truekepop.services.MessageService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public ResponseEntity<Message> sendMessage(@RequestBody Message message) {
        Message savedMessage = messageService.sendMessage(message);
        return ResponseEntity.ok(savedMessage);
    }

    @GetMapping
    public ResponseEntity<List<Message>> getAllMessages() {
        
        List<Message> messages = messageService.getAllMessages();
        return ResponseEntity.ok(messages);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id); 
        return ResponseEntity.noContent().build();
    }
}

