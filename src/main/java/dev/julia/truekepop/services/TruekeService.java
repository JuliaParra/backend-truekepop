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
    private CategoriaRepository categoriaRepository; 

    public List<Trueke> getAllTruekes() {
        return truekeRepository.findAll();
    }

 
    public List<Trueke> findByType(String type) {
        return truekeRepository.findByType(type);
    }

    
    public List<Trueke> findByCategoriaId(Long categoriaId) {
        return truekeRepository.findByCategoriaId(categoriaId);
    }

   
    public void saveTrueke(Trueke trueke) {
        truekeRepository.save(trueke);
    }

    public void deleteTrueke(Long id) {
        truekeRepository.deleteById(id);
    }

   
    public Categoria findCategoriaById(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

   
    public Trueke findTruekeById(Long id) {
        return truekeRepository.findById(id).orElse(null);
    }
    
   
    public Trueke updateTrueke(Long id, Trueke updatedTrueke) {
        Trueke existingTrueke = findTruekeById(id);
        if (existingTrueke != null) {
            existingTrueke.setName(updatedTrueke.getName());
            existingTrueke.setDescription(updatedTrueke.getDescription());
            existingTrueke.setLocation(updatedTrueke.getLocation());
            existingTrueke.setDesiredItem(updatedTrueke.getDesiredItem());
            existingTrueke.setType(updatedTrueke.getType());
            existingTrueke.setCategoria(updatedTrueke.getCategoria());
            existingTrueke.setImage(updatedTrueke.getImage());
            return truekeRepository.save(existingTrueke);
        }
        return null;
    }
}
