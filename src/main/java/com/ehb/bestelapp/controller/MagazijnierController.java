package com.ehb.bestelapp.controller;

import com.ehb.bestelapp.model.Bestelling;
import com.ehb.bestelapp.repository.BestellingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/magazijnier")
public class MagazijnierController {

    @Autowired
    private BestellingRepository bestellingRepository;

    // Dashboard-pagina
    @GetMapping("/dashboard")
    public String dashboard() {
        return "magazijnier/dashboard";
    }

    // Bestellingen bekijken (alle bestellingen voor magazijnier)
    @GetMapping("/bestellingen")
    public String bestellingenBekijken(Model model) {
        model.addAttribute("bestellingen", bestellingRepository.findAll());
        return "magazijnier/alle-bestellingen";
    }
}



