package dev.julia.truekepop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody; // Cambiar aquí
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.julia.truekepop.models.LoginRequest; // Clase que contiene email y password
import dev.julia.truekepop.models.User;
import dev.julia.truekepop.services.UserService;

@RestController
@RequestMapping(path = "${api-endpoint}")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager; // Necesario para la autenticación

    @PostMapping(path = "/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest loginRequest) { // Cambiar aquí
        try {
            // Autenticación del usuario con las credenciales proporcionadas
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );

            // Si la autenticación fue exitosa, se establece en el contexto de seguridad
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Obtener el usuario autenticado
            User user = userService.findByEmail(loginRequest.getEmail());

            // Crear un mapa para la respuesta
            Map<String, Object> json = new HashMap<>();
            json.put("message", "Logged");
            json.put("email", user.getEmail());

            // Obtener todos los roles del usuario y agregarlos al JSON
            List<String> roles = authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());
            json.put("roles", roles);

            return ResponseEntity.status(HttpStatus.OK).body(json); // Cambia el estado a 200 OK
        } catch (Exception e) {
            // Manejo de errores: usuario no autenticado
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Invalid credentials"));
        }
    }
}
