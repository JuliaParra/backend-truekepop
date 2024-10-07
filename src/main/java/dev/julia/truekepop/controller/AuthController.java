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
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.julia.truekepop.models.LoginRequest; 
import dev.julia.truekepop.models.User;
import dev.julia.truekepop.services.UserService;

@RestController
@RequestMapping(path = "${api-endpoint}")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager; 

    @PostMapping(path = "/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest loginRequest) { 
        try {
            
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );

            
            SecurityContextHolder.getContext().setAuthentication(authentication);

            User user = userService.findByEmail(loginRequest.getEmail());

            
            Map<String, Object> json = new HashMap<>();
            json.put("message", "Logged");
            json.put("email", user.getEmail());

            
            List<String> roles = authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());
            json.put("roles", roles);

            return ResponseEntity.status(HttpStatus.OK).body(json); 
        } catch (Exception e) {
            
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Invalid credentials"));
        }

        
    }

    @PostMapping(path = "/register")
public ResponseEntity<Map<String, String>> register(@RequestBody User user) {
    Map<String, String> response = new HashMap<>();
    
    try {
       
        userService.saveUser(user);
        
        
        response.put("message", "User registered successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(response); 
    } catch (Exception e) {
        
        response.put("message", "Error registering user: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response); 
    }
}


    
}
