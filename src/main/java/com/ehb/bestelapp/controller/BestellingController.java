package com.ehb.bestelapp.controller;

import com.ehb.bestelapp.model.Bestelling;
import com.ehb.bestelapp.model.User;
import com.ehb.bestelapp.repository.BestellingRepository;
import com.ehb.bestelapp.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bestelling")
public class BestellingController {

    @Autowired
    private BestellingRepository bestellingRepository;
    @Autowired
    private UserRepository userRepository;

    // Alle bestellingen opvragen voor één user
    @GetMapping("/{userId}")
    public List<Bestelling> getBestellingByUser(@PathVariable Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Technieker met id: " + userId + " niet gevonden."));
        return bestellingRepository.findByTechnieker(user);
    }

    //Only admins
    @GetMapping("/all")
    public List<Bestelling> getAllBestellingen(@RequestParam Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Gebruiker niet gevonden"));
        if (!user.getRol()) {
            throw new RuntimeException("Toegang geweigerd: alleen admins mogen alle bestellingen bekijken.");
        }
        return bestellingRepository.findAll();
    }



    // Nieuwe bestelling toevoegen
    @PostMapping
    public Bestelling createBestelling(@Valid @RequestBody Bestelling bestelling) {
        //Check if user exists
        User user = userRepository.findById(bestelling.getTechnieker().getId())
                .orElseThrow(() -> new RuntimeException("Technieker niet gevonden."));
        bestelling.setTechnieker(user);
        bestelling.setDatum(LocalDate.now());
        // Status standaard naar AANGEMAAKT
        bestelling.setStatus("AANGEMAAKT");

        return bestellingRepository.save(bestelling);
    }

    // Bestaande bestelling updaten
    @PutMapping("/{id}")
    public Bestelling update(@PathVariable Long id, @Valid @RequestBody Bestelling updated) {
        return bestellingRepository.findById(id).map(b -> {
            b.setDatum(updated.getDatum());
            b.setStatus(updated.getStatus());
            b.setTechnieker(updated.getTechnieker());
            return bestellingRepository.save(b);
        }).orElseGet(() -> {
            updated.setId(id);
            return bestellingRepository.save(updated);
        });
    }


//    // Alleen eigen bestellingen (voor ingelogde technieker)
//    @GetMapping("/mijn")
//    public List<Bestelling> getEigenBestellingen(Authentication auth) {
//        String email = auth.getName(); // haalt de e-mail op van de ingelogde gebruiker
//        return bestellingRepository.findByTechnieker(email);
//    }

    //only admin is able to delete
    @DeleteMapping("/{id}")
    public void deleteBestelling(@PathVariable Long id) {
        Bestelling bestelling = bestellingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bestelling niet gevonden"));

        User user = bestelling.getTechnieker();
        if (!user.getRol()) {
            throw new RuntimeException("Toegang geweigerd: alleen admins mogen bestellingen verwijderen.");
        }

        bestellingRepository.deleteById(id);
    }

    //Only admin is able to do this -> rol 1/true = admin and rol 0/false = technieker
    @DeleteMapping("/all/{id}")
    public void deleteAllBestellingenIfAdmin(@PathVariable Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gebruiker niet gevonden"));

        if (!user.getRol()) {
            throw new RuntimeException("Toegang geweigerd: alleen admins mogen alle bestellingen verwijderen.");
        }

        bestellingRepository.deleteAll();
    }

    //Method to change the bestelstatus ???


    @GetMapping("/bestellingen")
    public String alleBestellingen(Model model) {
        return "gebruiker/alle-bestellingen";
        // verwijst naar alle-bestellingen.html
    }
}


