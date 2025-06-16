package com.ehb.bestelapp.controller;

import com.ehb.bestelapp.dto.LoginRequest;
import com.ehb.bestelapp.model.User;
import com.ehb.bestelapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Om wachtwoorden te checken (encryptie)

    @PostMapping("/login")
    public Map<String, Object> login(@Valid @RequestBody LoginRequest loginRequest) {
        Map<String, Object> response = new HashMap<>();

        // Zoek gebruiker op via email
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElse(null);

        // Check of gebruiker bestaat en wachtwoord klopt
        if (user == null || !passwordEncoder.matches(loginRequest.getWachtwoord(), user.getWachtwoord())) {
            response.put("success", false);
            response.put("message", "Ongeldige inloggegevens");
            return response;
        }

        // Login succesvol
        response.put("success", true);
        response.put("message", "Login succesvol");
        response.put("rol", user.getRol());
        response.put("gebruikerId", user.getId());

        return response;
    }
}
