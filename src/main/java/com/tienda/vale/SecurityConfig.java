package com.tienda.vale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Deshabilita protección CSRF
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()); // Permite acceso sin autenticación
        return http.build();
    }
}