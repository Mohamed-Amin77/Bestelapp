package com.ehb.bestelapp.controller;

import com.ehb.bestelapp.model.Bestelling;
import com.ehb.bestelapp.repository.BestellingRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bestellingen")
public class BestellingController {

    @Autowired
    private BestellingRepository bestellingRepository;

    // Alle bestellingen opvragen
    @GetMapping
    public List<Bestelling> getAll() {
        return bestellingRepository.findAll();
    }

    // Eén bestelling opvragen (via ID)
    @GetMapping("/{id}")
    public Optional<Bestelling> getById(@PathVariable Long id) {
        return bestellingRepository.findById(id);
    }

    // Nieuwe bestelling toevoegen
    @PostMapping
    public Bestelling create(@Valid @RequestBody Bestelling bestelling) {
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

    // Bestelling verwijderen
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bestellingRepository.deleteById(id);
    }

    // Alleen eigen bestellingen (voor ingelogde technieker)
    @GetMapping("/mijn")
    public List<Bestelling> getEigenBestellingen(Authentication auth) {
        String email = auth.getName(); // haalt de e-mail op van de ingelogde gebruiker
        return bestellingRepository.findByTechniekerEmail(email);
    }

    @GetMapping("/bestellingen")
    public String alleBestellingen(Model model) {
        return "gebruiker/alle-bestellingen";
        // verwijst naar alle-bestellingen.html
    }
}


