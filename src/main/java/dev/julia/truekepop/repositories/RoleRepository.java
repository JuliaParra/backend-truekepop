package dev.julia.truekepop.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import dev.julia.truekepop.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
