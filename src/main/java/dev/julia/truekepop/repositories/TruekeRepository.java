package dev.julia.truekepop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.julia.truekepop.models.Trueke;

@Repository
public interface TruekeRepository extends JpaRepository<Trueke, Long> {
    List<Trueke> findByCategoriaId(Long categoriaId); // Método existente para buscar por categoría
    List<Trueke> findByType(String type); // Método para buscar por tipo
}
