package com.ehb.bestelapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/magazijnier")
public class MagazijnierController {

    // Dashboard-pagina
    @GetMapping("/dashboard")
    public String dashboard() {
        return "magazijnier/dashboard";
    }

    // Bestellingen bekijken (alle bestellingen voor magazijnier)
    @GetMapping("/bestellingen")
    public String bestellingenBekijken() {
        return "magazijnier/alle-bestellingen";
    }

}
