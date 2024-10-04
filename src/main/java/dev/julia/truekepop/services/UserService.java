// package dev.julia.truekepop.services;

// import java.util.Collections;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// import dev.julia.truekepop.facades.encryptations.Base64Encoder;
// import dev.julia.truekepop.models.Role;
// import dev.julia.truekepop.models.User;
// import dev.julia.truekepop.repositories.UserRepository;

// @Service
// public class UserService {

//     @Autowired
//     private UserRepository userRepository;

//     @Autowired
//     private RoleService roleService;

//     @Autowired
//     private PasswordEncoder passwordEncoder;

//     @Autowired
//     private Base64Encoder base64Encoder;

//     public List<User> getAllAdminUsers() {
//         System.out.println("Obteniendo todos los usuarios con rol de administrador...");
        
//         Role adminRole = roleService.findByName("ROLE_ADMIN");

//         if (adminRole == null) {
//             throw new IllegalArgumentException("Rol de administrador no encontrado");
//         }

//         List<User> admins = userRepository.findByRolesIn(Collections.singletonList(adminRole));
//         System.out.println("Cantidad de administradores encontrados: " + admins.size());
        
//         return admins;
//     }

//     public void updateUserPassword(String email, String newPassword) {
//         System.out.println("Actualizando contraseña para el usuario con email: " + email);

//         User user = userRepository.findByEmail(email);

//         // Verificar si el usuario existe
//         if (user == null) {
//             throw new IllegalArgumentException("Usuario no encontrado");
//         }

//         String decryptedPassword = base64Encoder.decode(newPassword);
//         user.setPassword(passwordEncoder.encode(decryptedPassword));
//         userRepository.save(user);

//         System.out.println("Contraseña actualizada correctamente para el usuario con email: " + email);
//     }

//     public User findByEmail(String email) {
//         System.out.println("Buscando usuario con email: " + email);

//         User user = userRepository.findByEmail(email);
//         if (user == null) {
//             throw new IllegalArgumentException("Usuario no encontrado");
//         }

//         System.out.println("Usuario encontrado con email: " + email);
//         return user;
//     }
// }

package dev.julia.truekepop.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.julia.truekepop.models.Role;
import dev.julia.truekepop.models.User;
import dev.julia.truekepop.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAllAdminUsers() {
        System.out.println("Obteniendo todos los usuarios con rol de administrador...");

        Role adminRole = roleService.findByName("ROLE_ADMIN");

        if (adminRole == null) {
            throw new IllegalArgumentException("Rol de administrador no encontrado");
        }

        List<User> admins = userRepository.findByRolesIn(Collections.singletonList(adminRole));
        System.out.println("Cantidad de administradores encontrados: " + admins.size());

        return admins;
    }

    public void updateUserPassword(String email, String newPassword) {
        System.out.println("Actualizando contraseña para el usuario con email: " + email);

        User user = userRepository.findByEmail(email);

        // Verificar si el usuario existe
        if (user == null) {
            throw new IllegalArgumentException("Usuario no encontrado");
        }

        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);

        System.out.println("Contraseña actualizada correctamente para el usuario con email: " + email);
    }

    public User findByEmail(String email) {
        System.out.println("Buscando usuario con email: " + email);

        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new IllegalArgumentException("Usuario no encontrado");
        }

        System.out.println("Usuario encontrado con email: " + email);
        return user;
    }
}

