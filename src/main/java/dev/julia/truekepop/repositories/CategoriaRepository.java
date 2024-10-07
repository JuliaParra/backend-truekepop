package dev.julia.truekepop.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import dev.julia.truekepop.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}

