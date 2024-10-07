package dev.julia.truekepop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.julia.truekepop.models.Trueke;

@Repository
public interface TruekeRepository extends JpaRepository<Trueke, Long> {
    List<Trueke> findByCategoriaId(Long categoriaId); 
    List<Trueke> findByType(String type); 
}
