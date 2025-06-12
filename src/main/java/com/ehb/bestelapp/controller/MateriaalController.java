package com.ehb.bestelapp.controller;

import com.ehb.bestelapp.model.Materiaal;
import com.ehb.bestelapp.repository.MateriaalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//REST-controller voor Materiaal
@RestController
@RequestMapping("/api/materiaal")
public class MateriaalController {

    @Autowired
    private MateriaalRepository materiaalRepository;

    //Alles opvragen
    @GetMapping
    public List<Materiaal> getAll() {
        return materiaalRepository.findAll();
    }

    //specifiek materiaal opvragen (ID)
    @GetMapping("/{id}")
    public Optional<Materiaal> getById(@PathVariable Long id) {
        return materiaalRepository.findById(id);
    }

    //Nieuw materiaal toevoegen
    @PostMapping
    public Materiaal createMateriaal(@RequestBody Materiaal materiaal) {
        return materiaalRepository.save(materiaal);
    }

    //Bestaand materiaal updaten
    @PutMapping("/{id}")
    public ResponseEntity<Materiaal> updateMateriaal(@PathVariable Long id, @RequestBody Materiaal updated) {
        Optional<Materiaal> optional = materiaalRepository.findById(id);

        if (optional.isPresent()) {
            Materiaal m = optional.get();
            m.setNaam(updated.getNaam());
            m.setCategorie(updated.getCategorie());
            m.setVoorraad(updated.getVoorraad());
            m.setOmschrijving(updated.getOmschrijving());

            Materiaal opgeslagen = materiaalRepository.save(m);
            return ResponseEntity.ok(opgeslagen);
        } else {
            return ResponseEntity.notFound().build(); // Geen materiaal met dit ID
        }
    }

    //Materiaal verwijderen
    @DeleteMapping("/{id}")
    public void deleteMateriaal(@PathVariable Long id) {
        materiaalRepository.deleteById(id);
    }
}
