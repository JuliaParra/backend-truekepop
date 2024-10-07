package dev.julia.truekepop.services;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dev.julia.truekepop.models.SecurityUser;
import dev.julia.truekepop.models.User;
import dev.julia.truekepop.repositories.UserRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    UserRepository repository;

    public JpaUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user = repository.findByEmail(email); 

    if (user == null) {
        throw new UsernameNotFoundException("Usuario no encontrado con el email: " + email);
    }

    // Convertir `User` a `UserDetails`
    return new SecurityUser(user);
}
}