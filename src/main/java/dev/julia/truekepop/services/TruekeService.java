package dev.julia.truekepop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.julia.truekepop.models.Categoria;
import dev.julia.truekepop.models.Trueke;
import dev.julia.truekepop.repositories.CategoriaRepository;
import dev.julia.truekepop.repositories.TruekeRepository;

@Service
public class TruekeService {

    @Autowired
    private TruekeRepository truekeRepository;

    @Autowired
    private CategoriaRepository categoriaRepository; // Inyección del repositorio de Categoria

    public List<Trueke> getAllTruekes() {
        return truekeRepository.findAll();
    }

    // Método para encontrar truekes por tipo
    public List<Trueke> findByType(String type) {
        return truekeRepository.findByType(type);
    }

    // Método para encontrar truekes por categoriaId
    public List<Trueke> findByCategoriaId(Long categoriaId) {
        return truekeRepository.findByCategoriaId(categoriaId);
    }

    // Método para guardar el trueke
    public void saveTrueke(Trueke trueke) {
        truekeRepository.save(trueke);
    }

    // Nuevo método para buscar una categoría por su ID
    public Categoria findCategoriaById(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }
}
