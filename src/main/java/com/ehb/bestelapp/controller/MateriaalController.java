package com.ehb.bestelapp.controller;

import com.ehb.bestelapp.model.Materiaal;
import com.ehb.bestelapp.repository.MateriaalRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/materiaal")
public class MateriaalController {

    @Autowired
    private MateriaalRepository materiaalRepository;

    // Alles opvragen
    @GetMapping
    public List<Materiaal> getAll() {
        return materiaalRepository.findAll();
    }

    // Specifiek materiaal opvragen
    @GetMapping("/{id}")
    public Optional<Materiaal> getById(@PathVariable Long id) {
        return materiaalRepository.findById(id);
    }

    // Nieuw materiaal toevoegen
    @PostMapping
    public Materiaal create(@Valid @RequestBody Materiaal materiaal) {
        return materiaalRepository.save(materiaal);
    }

    // Materiaal bijwerken (categorie toevoegen)
    @PutMapping("/{id}")
    public Materiaal update(@PathVariable Long id, @Valid @RequestBody Materiaal updated) {
        return materiaalRepository.findById(id).map(m -> {
            m.setNaam(updated.getNaam());
            m.setAantal(updated.getAantal());
            m.setCategorie(updated.getCategorie());
            return materiaalRepository.save(m);
        }).orElseGet(() -> {
            updated.setId(id);
            return materiaalRepository.save(updated);
        });
    }

    // Materiaal verwijderen
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        materiaalRepository.deleteById(id);
    }

    // Nieuw toegevoegd: filteren op categorie
    @GetMapping("/categorie/{categorie}")
    public List<Materiaal> getByCategorie(@PathVariable String categorie) {
        return materiaalRepository.findByCategorie(categorie);
    }
}
