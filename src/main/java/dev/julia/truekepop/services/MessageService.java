package dev.julia.truekepop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; // Importa la clase List

import dev.julia.truekepop.models.Message;
import dev.julia.truekepop.repositories.MessageRepository;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message sendMessage(Message message) {
        return messageRepository.save(message);
    }

    // Nuevo método para obtener todos los mensajes
    public List<Message> getAllMessages() {
        return messageRepository.findAll(); // Devuelve la lista de todos los mensajes
    }

    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }
}
