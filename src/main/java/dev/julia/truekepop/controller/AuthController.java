// package dev.julia.truekepop.controller;

// import java.util.HashMap;
// import java.util.Map;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContext;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import dev.julia.truekepop.models.User;
// import dev.julia.truekepop.services.UserService;

// @RestController
// @RequestMapping(path = "${api-endpoint}")  
// public class AuthController {

//     @Autowired
//     private UserService userService;  

//     @GetMapping(path = "/login")
//     public ResponseEntity<Map<String, String>> login() {
//         SecurityContext contextHolder = SecurityContextHolder.getContext();
//         Authentication auth = contextHolder.getAuthentication();

       
//         String email = auth.getName(); // Esto obtiene el correo electrónico del usuario autenticado
//         User user = userService.findByEmail(email); // Utiliza la variable 'email' correctamente
        

        
//         Map<String, String> json = new HashMap<>();
// json.put("message", "Logged");
// json.put("email", email);

// // Simplificar la extracción del rol
// String role = auth.getAuthorities().stream()
//                   .map(grantedAuthority -> grantedAuthority.getAuthority())
//                   .filter(r -> r.equals("ROLE_USER") || r.equals("ROLE_ADMIN"))
//                   .findFirst()
//                   .orElse("ROLE_USER"); // Valor predeterminado si no encuentra ningún rol
// json.put("roles", role);
        

        

//         return ResponseEntity.status(HttpStatus.ACCEPTED).body(json);
//     }
// }


package dev.julia.truekepop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.julia.truekepop.models.User;
import dev.julia.truekepop.services.UserService;

@RestController
@RequestMapping(path = "${api-endpoint}")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/login")
    public ResponseEntity<Map<String, Object>> login() {
        SecurityContext contextHolder = SecurityContextHolder.getContext();
        Authentication auth = contextHolder.getAuthentication();

        // Obtener el email del usuario autenticado
        String email = auth.getName();
        User user = userService.findByEmail(email); // Verificar si el usuario existe

        // Crear un mapa para la respuesta
        Map<String, Object> json = new HashMap<>();
        json.put("message", "Logged");
        json.put("email", user.getEmail()); // Utilizar la información del objeto 'user'

        // Obtener todos los roles del usuario y agregarlo al JSON
        List<String> roles = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        json.put("roles", roles);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(json);
    }
}
