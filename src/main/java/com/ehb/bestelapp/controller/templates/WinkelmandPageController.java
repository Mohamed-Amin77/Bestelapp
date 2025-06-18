package com.ehb.bestelapp.controller.templates;

import com.ehb.bestelapp.model.Bestelling;
import com.ehb.bestelapp.model.Materiaal;
import com.ehb.bestelapp.model.User;
import com.ehb.bestelapp.model.Winkelmand;
import com.ehb.bestelapp.repository.BestellingRepository;
import com.ehb.bestelapp.repository.MateriaalRepository;
import com.ehb.bestelapp.repository.UserRepository;
import com.ehb.bestelapp.repository.WinkelmandRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authorization.method.AuthorizeReturnObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/winkelmand")
public class WinkelmandPageController {
    @Autowired
    private WinkelmandRepository winkelmandRepository;

    @Autowired
    private MateriaalRepository materiaalRepository;

    @Autowired
    private BestellingRepository bestellingRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/toevoegen/{materiaalId}")
    public String voegToe(@PathVariable Long materiaalId, @RequestParam(defaultValue = "1") int aantal, Principal principal) {
        User user = userRepository.findByEmail(principal.getName());

        Materiaal materiaal = materiaalRepository.findById(materiaalId).orElseThrow();

        Winkelmand item = new Winkelmand();
        item.setMateriaal(materiaal);
        item.setTechnieker(user);
        item.setAantal(aantal);

        winkelmandRepository.save(item);
        return "redirect:/materiaal/lijst";
    }

    @GetMapping
    public String toonWinkelmand(Model model, Principal principal) {
        User user = userRepository.findByEmail(principal.getName());

        List<Winkelmand> mandItems = winkelmandRepository.findByTechnieker(user);
        model.addAttribute("mandItems", mandItems);
        return "winkelmand/lijst";
    }

    @GetMapping("/bestellen/overzicht")
    public String afrekenen(Principal principal) {
        User user = userRepository.findByEmail(principal.getName());
        System.out.println("TESTING EMAIL : " + principal.getName());

        List<Winkelmand> mandItems = winkelmandRepository.findByTechnieker(user);
        if (mandItems.isEmpty()) {
            return "redirect:/winkelmand"; // Geen items, geen bestelling
        }


        Bestelling bestelling = new Bestelling();
        bestelling.setTechnieker(user);
        bestelling.setDatum(LocalDate.now());
        bestelling.setStatus("Aangemaakt");
        bestelling.setLeverdatum(LocalDate.now().plusDays(3));
        bestellingRepository.save(bestelling);

        winkelmandRepository.deleteAll(mandItems);

        return "redirect:/bestellingen";
    }

    @PostMapping("/verwijder/{id}")
    public String verwijderItem(@PathVariable Long id, Principal principal) {
        User user = userRepository.findByEmail(principal.getName());
        Winkelmand item = winkelmandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item niet gevonden"));

        if (item.getTechnieker().getId().equals(user.getId())) {
            winkelmandRepository.deleteById(id);
        }

        return "redirect:/winkelmand";
    }


}
