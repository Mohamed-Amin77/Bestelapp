package com.ehb.bestelapp.controller;


import com.ehb.bestelapp.model.Materiaal;
import com.ehb.bestelapp.model.User;
import com.ehb.bestelapp.model.Winkelmand;
import com.ehb.bestelapp.repository.MateriaalRepository;
import com.ehb.bestelapp.repository.UserRepository;
import com.ehb.bestelapp.repository.WinkelmandRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/winkelmand")
public class WinkelmandController {

    @Autowired
    private WinkelmandRepository winkelmandRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MateriaalRepository materiaalRepository;



    // Geeft de winkelmand-items terug die gekoppeld zijn aan een specifieke gebruiker
    @GetMapping("/{userId}")
    public List<Winkelmand> getWinkelMandByUser(@PathVariable Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User met id: " + userId + " niet gevonden"));

        return winkelmandRepository.findByTechnieker(user);
    }


    // Voegt een nieuw item toe aan de winkelmand, gekoppeld aan een gebruiker en materiaal
    @PostMapping
    public Winkelmand createWinkelMand(@Valid @RequestBody Winkelmand winkelmand){
        //Haal het materiaal- en gebruikersobject op uit de database

        Materiaal materiaal = materiaalRepository.findById(winkelmand.getMateriaal().getId())
                .orElseThrow(() -> new RuntimeException("Materiaal niet gevonden"));
        User user = userRepository.findById(winkelmand.getTechnieker().getId())
                .orElseThrow(() -> new RuntimeException("Gebruiker niet gevonden"));

        winkelmand.setMateriaal(materiaal);

        winkelmand.setTechnieker(user);

        return winkelmandRepository.save(winkelmand);
    }

    // Werk het aantal bij van een bestaand winkelmand-item
    @PutMapping("/{id}")
    public Winkelmand updateWinkelMand(@PathVariable Long id, @RequestBody Winkelmand updated){
        return winkelmandRepository.findById(id).map(item -> {
            item.setAantal(updated.getAantal());
            return winkelmandRepository.save(item);
        }).orElseThrow(() -> new RuntimeException("Item met id: " + id + " niet gevonden"));
    }

    // Verwijder een specifiek item uit de winkelmand op basis van ID
    @DeleteMapping("/{id}")
    public void deleteWinkelMandItem(@PathVariable Long id) {
        if (!winkelmandRepository.existsById(id)) {
            throw new RuntimeException("Item met id: " + id + " niet gevonden");
        }
        winkelmandRepository.deleteById(id);
    }


    @DeleteMapping("/all")
    public void deleteAll(){
        winkelmandRepository.deleteAll();
    }


    // Verwijder alle winkelmand-items die gekoppeld zijn aan een specifieke gebruiker
    @DeleteMapping("/user/{userId}")
    public void deleteWinkelmandByUser(@PathVariable Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Gebruiker met id: " + userId + " niet gevonden"));

        winkelmandRepository.deleteByTechnieker(user);
    }




}
