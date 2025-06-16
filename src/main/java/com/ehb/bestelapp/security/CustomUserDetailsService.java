package com.ehb.bestelapp.security;

import com.ehb.bestelapp.model.User;
import com.ehb.bestelapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User gebruiker = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Gebruiker niet gevonden"));

        return new org.springframework.security.core.userdetails.User(
                gebruiker.getEmail(),
                gebruiker.getWachtwoord(),
                // Rol wordt toegevoegd in juiste vorm: "ROLE_ROLNAAM"
                Collections.singleton(() -> "ROLE_" + gebruiker.getRol().toUpperCase())
        );
    }
}
