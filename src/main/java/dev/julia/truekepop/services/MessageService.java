package dev.julia.truekepop.services;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.julia.truekepop.models.Message; // Importa la clase List
import dev.julia.truekepop.repositories.MessageRepository;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message sendMessage(Message message) {
        return messageRepository.save(message);
    }

    
    public List<Message> getAllMessages() {
        return messageRepository.findAll(); 
    }

    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }
}
