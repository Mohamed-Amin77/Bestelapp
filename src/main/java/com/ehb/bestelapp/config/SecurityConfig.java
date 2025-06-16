package com.ehb.bestelapp.config;

import com.ehb.bestelapp.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService userDetailsService; // Haalt gebruikersgegevens uit de database

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // CSRF-bescherming tijdelijk uitgeschakeld (alleen voor testen)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/dashboard").hasRole("ADMIN") // Alleen ADMIN mag dashboard bekijken
                        .requestMatchers("/home").hasAnyRole("TECHNIEKER", "MAGAZIJNIER") // TECHNIEKER en MAGAZIJNIER mogen home zien
                        .requestMatchers("/api/**").authenticated() // Alle API's vereisen login
                        .requestMatchers("/api/users/**").hasRole("ADMIN") // Alleen ADMIN kan gebruikers-API gebruiken
                        .anyRequest().permitAll() // pagina's vrij toegankelijk
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/redirect", true) // Na login doorverwijzen op basis van rol
                        .failureUrl("/login?error=true") // Bij foutief inloggen terug naar login met foutmelding
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login") // Na uitloggen terug naar loginpagina
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {

        AuthenticationManagerBuilder authBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder()); // Versleutel wachtwoorden met BCrypt
        return authBuilder.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // BCrypt wachtwoord versleutelaar maken
        return new BCryptPasswordEncoder();
    }
}
