package com.ehb.bestelapp.controller;

import com.ehb.bestelapp.model.Bestelling;
import com.ehb.bestelapp.repository.BestellingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bestelling")
public class BestellingController {

    @Autowired
    private BestellingRepository bestellingRepository;

    // Alle bestellingen opvragen
    @GetMapping
    public List<Bestelling> getAll() {
        return bestellingRepository.findAll();
    }

    // Eén bestelling opvragen (ID)
    @GetMapping("/{id}")
    public Optional<Bestelling> getById(@PathVariable Long id) {
        return bestellingRepository.findById(id);
    }

    // Nieuwe bestelling toevoegen
    @PostMapping
    public Bestelling create(@RequestBody Bestelling bestelling) {
        return bestellingRepository.save(bestelling);
    }

    // Bestelling bijwerken
    @PutMapping("/{id}")
    public Bestelling update(@PathVariable Long id, @RequestBody Bestelling updated) {
        return bestellingRepository.findById(id).map(b -> {
            b.setBestellerNaam(updated.getBestellerNaam());
            b.setDatum(updated.getDatum());
            b.setStatus(updated.getStatus());
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
}
