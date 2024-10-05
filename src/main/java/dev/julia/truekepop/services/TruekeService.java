package dev.julia.truekepop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.julia.truekepop.models.Trueke;
import dev.julia.truekepop.repositories.TruekeRepository;

@Service
public class TruekeService {

    @Autowired
    private TruekeRepository truekeRepository;

    public List<Trueke> getAllTruekes() {
        return truekeRepository.findAll();
    }
}

