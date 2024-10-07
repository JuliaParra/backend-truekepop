package dev.julia.truekepop.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import dev.julia.truekepop.facades.encryptations.Base64Encoder;
import dev.julia.truekepop.services.JpaUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${api-endpoint}")
    String endpoint;

    MyBasicAuthenticationEntryPoint myBasicAuthenticationEntryPoint;
    JpaUserDetailsService jpaUserDetailsService;

    public SecurityConfig(JpaUserDetailsService jpaUserDetailsService,
                          MyBasicAuthenticationEntryPoint basicEntryPoint) {
        this.jpaUserDetailsService = jpaUserDetailsService;
        this.myBasicAuthenticationEntryPoint = basicEntryPoint;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .cors(cors -> cors.configurationSource(corsConfiguration()))
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
            .requestMatchers(HttpMethod.POST, endpoint + "/register").permitAll()
                .requestMatchers(HttpMethod.POST, endpoint + "/login").permitAll()
                .requestMatchers(HttpMethod.POST, endpoint + "/login").permitAll()
                .requestMatchers(HttpMethod.GET, endpoint + "/trueke").permitAll()
                .requestMatchers(HttpMethod.POST, endpoint + "/trueke").permitAll()
                .requestMatchers(HttpMethod.PUT, endpoint + "/trueke/{id}").permitAll() 
                .requestMatchers(HttpMethod.POST, endpoint + "/messages").permitAll()
                .requestMatchers(HttpMethod.DELETE, endpoint + "/trueke/{id}").permitAll()
                .requestMatchers(HttpMethod.GET, endpoint + "/admin/**").hasRole("ADMIN")
                .anyRequest().permitAll()
            )
            .userDetailsService(jpaUserDetailsService)
            .httpBasic(basic -> basic.authenticationEntryPoint(myBasicAuthenticationEntryPoint))
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));
    
        http.headers(header -> header.frameOptions(frame -> frame.sameOrigin()));
    
        return http.build();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(jpaUserDetailsService).passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }

    @Bean
    CorsConfigurationSource corsConfiguration() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("*"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    Base64Encoder base64Encoder() {
        return new Base64Encoder();
    }
}
