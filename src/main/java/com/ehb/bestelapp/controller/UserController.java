package com.ehb.bestelapp.controller;

import com.ehb.bestelapp.model.User;
import com.ehb.bestelapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

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
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    // Gebruiker bijwerken
    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User updated) {
        return userRepository.findById(id).map(u -> {
            u.setNaam(updated.getNaam());
            u.setEmail(updated.getEmail());
            u.setWachtwoord(updated.getWachtwoord());
            u.setRol(updated.getRol());
            return userRepository.save(u);
        }).orElseGet(() -> {
            updated.setId(id);
            return userRepository.save(updated);
        });
    }

    // Gebruiker verwijderen
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
