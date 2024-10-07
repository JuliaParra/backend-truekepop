package dev.julia.truekepop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.julia.truekepop.models.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    
}
