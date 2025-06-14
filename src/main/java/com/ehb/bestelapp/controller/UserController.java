package com.ehb.bestelapp.controller;

import com.ehb.bestelapp.model.User;
import com.ehb.bestelapp.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Alle gebruikers opvragen
    @GetMapping
    public List<User> getAll() {
        return userRepository.findAll();
    }

    // Eén gebruiker opvragen (ID)
    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    // Nieuwe gebruiker toevoegen
    @PostMapping
    public User create(@Valid @RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email is al in gebruik");
        }

        user.setWachtwoord(passwordEncoder.encode(user.getWachtwoord()));

        if (user.getRol() == null || user.getRol().isBlank()) {
            user.setRol("TECHNIEKER");
        }

        return userRepository.save(user);
    }

    // Gebruiker bijwerken
    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User updated) {
        return userRepository.findById(id).map(u -> {
            u.setNaam(updated.getNaam());
            u.setEmail(updated.getEmail());

            if (!updated.getWachtwoord().isBlank()) {
                u.setWachtwoord(passwordEncoder.encode(updated.getWachtwoord()));
            }

            u.setRol(updated.getRol());
            return userRepository.save(u);
        }).orElseGet(() -> {
            updated.setId(id);
            updated.setWachtwoord(passwordEncoder.encode(updated.getWachtwoord()));
            return userRepository.save(updated);
        });
    }

    // Gebruiker verwijderen
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
