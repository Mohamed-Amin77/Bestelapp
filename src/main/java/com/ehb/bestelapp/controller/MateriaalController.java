package com.ehb.bestelapp.controller;

import com.ehb.bestelapp.model.Categorie;
import com.ehb.bestelapp.model.Materiaal;
import com.ehb.bestelapp.model.User;
import com.ehb.bestelapp.repository.MateriaalRepository;
import com.ehb.bestelapp.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/materiaal")
public class MateriaalController {

    @Autowired
    private MateriaalRepository materiaalRepository;
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/lijst")
    public String toonMateriaalLijst(@RequestParam(required = false) String categorie,
                                     @RequestParam(required = false) String zoekterm,
                                     Model model, Principal principal) {
        List<Materiaal> materiaalLijst;

        if (principal != null) { //for the conditional role -> Thymeleaf
            String email = principal.getName();
            User currentUser = userRepository.findByEmail(email);
            model.addAttribute("currentUser", currentUser);
        }


        // Eerst kijken we of er een zoekterm is
        if (zoekterm != null && !zoekterm.trim().isEmpty()) {
            // Zoeken op naam
            materiaalLijst = materiaalRepository.findByNaamContainingIgnoreCase(zoekterm.trim());
            model.addAttribute("zoekterm", zoekterm);
        }
        // Anders kijken we naar categorie filter
        else if (categorie != null && !categorie.isEmpty()) {

            try {
                Categorie selected = Categorie.valueOf(categorie);
                materiaalLijst = materiaalRepository.findByCategorie(selected);
                model.addAttribute("selectedCategorie", categorie);
            } catch (IllegalArgumentException e) {
                materiaalLijst = materiaalRepository.findAll(); // fallback if wrong category name
            }
        } else {
            materiaalLijst = materiaalRepository.findAll();
        }

        model.addAttribute("materiaalLijst", materiaalLijst);
        model.addAttribute("categorien", Categorie.values());

        return "materiaal/lijst";
    }

    @GetMapping("/bewerken/{id}")
    public String toonBewerkFormulier(@PathVariable Long id, Model model) {
        Materiaal materiaal = materiaalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id niet gevonden"));

        model.addAttribute("materiaal", materiaal);
        model.addAttribute("categorien", Categorie.values());
        return "materiaal/bewerken";
    }
    @GetMapping("/nieuw")
    public String toonNieuwMateriaalFormulier(Model model) {
        model.addAttribute("materiaal", new Materiaal());
        model.addAttribute("categorien", Categorie.values());
        return "materiaal/nieuw";
    }
    @PostMapping("/nieuw")
    public String voegMateriaalToe(@ModelAttribute Materiaal materiaal) {
        materiaalRepository.save(materiaal);
        return "redirect:/materiaal/lijst";
    }

    @PostMapping("/bewerken/{id}")
    public String updateMateriaal(@PathVariable Long id, @ModelAttribute Materiaal updated) {
        materiaalRepository.findById(id).map(m -> {
            m.setNaam(updated.getNaam());
            m.setAantal(updated.getAantal());
            m.setCategorie(updated.getCategorie());
            return materiaalRepository.save(m);
        }).orElseThrow(() -> new IllegalArgumentException("Materiaal-ID niet gevonden"));

        return "redirect:/materiaal/lijst";
    }

    @PostMapping("/verwijder/{id}")
    public String deleteMateriaal(@PathVariable Long id) {
        materiaalRepository.deleteById(id);
        return "redirect:/materiaal/lijst";
    }



}
