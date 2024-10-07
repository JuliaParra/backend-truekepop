package dev.julia.truekepop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.julia.truekepop.models.Role;
import dev.julia.truekepop.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    List<User> findByRolesIn(List<Role> role);
}
