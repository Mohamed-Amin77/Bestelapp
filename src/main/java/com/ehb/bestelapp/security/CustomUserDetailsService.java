package com.ehb.bestelapp.security;

import com.ehb.bestelapp.model.User;
import com.ehb.bestelapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User gebruiker = userRepository.findByEmail(email);
        if(gebruiker == null){
            throw new UsernameNotFoundException("Gebruiker niet gevonden: " + email);
        }

        //To use for the Collections.singleton since the role is boolean
        String roleName = gebruiker.getRol() ? "ROLE_ADMIN" : "ROLE_TECHNIEKER";

        return new org.springframework.security.core.userdetails.User(
                gebruiker.getEmail(),
                gebruiker.getWachtwoord(),
                Collections.singleton(new SimpleGrantedAuthority(roleName)) //Rol is passed here
        );
    }
}
