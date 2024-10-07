package dev.julia.truekepop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.julia.truekepop.models.Role;
import dev.julia.truekepop.repositories.RoleRepository;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role findByName(String roleName) {
        return roleRepository.findByName(roleName);
    }
}
