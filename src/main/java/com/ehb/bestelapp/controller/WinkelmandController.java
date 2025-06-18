package com.ehb.bestelapp.controller;


import com.ehb.bestelapp.model.Materiaal;
import com.ehb.bestelapp.model.User;
import com.ehb.bestelapp.model.Winkelmand;
import com.ehb.bestelapp.repository.MateriaalRepository;
import com.ehb.bestelapp.repository.UserRepository;
import com.ehb.bestelapp.repository.WinkelmandRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/winkelmand")
public class WinkelmandController {

    @Autowired
    private WinkelmandRepository winkelmandRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MateriaalRepository materiaalRepository;

    @GetMapping("/{userId}")
    public List<Winkelmand> getWinkelMandByUser(@PathVariable Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User met id: " + userId + " niet gevonden"));

        return winkelmandRepository.findByTechnieker(user);
    }

    @PostMapping
    public Winkelmand createWinkelMand(@Valid @RequestBody Winkelmand winkelmand){
        //Fetch the material and user object from DB
        Materiaal materiaal = materiaalRepository.findById(winkelmand.getMateriaal().getId())
                .orElseThrow(() -> new RuntimeException("Materiaal niet gevonden"));
        User user = userRepository.findById(winkelmand.getTechnieker().getId())
                .orElseThrow(() -> new RuntimeException("Gebruiker niet gevonden"));

        winkelmand.setMateriaal(materiaal);
        winkelmand.setTechnieker(user);

        return winkelmandRepository.save(winkelmand);
    }

    @PutMapping("/{id}")
    public Winkelmand updateWinkelMand(@PathVariable Long id, @RequestBody Winkelmand updated){
        return winkelmandRepository.findById(id).map(item -> {
            item.setAantal(updated.getAantal());
            return winkelmandRepository.save(item);
        }).orElseThrow(() -> new RuntimeException("Item met id: " + id + " niet gevonden"));
    }

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

    //For one specific user
    @DeleteMapping("/user/{userId}")
    public void deleteAllItemsFromUserCart(@PathVariable Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Gebruiker niet gevonden"));

        List<Winkelmand> items = winkelmandRepository.findByTechnieker(user);
        winkelmandRepository.deleteAll(items);
    }





}
