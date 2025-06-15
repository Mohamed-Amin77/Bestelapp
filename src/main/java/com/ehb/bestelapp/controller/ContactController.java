package com.ehb.bestelapp.controller;

import com.ehb.bestelapp.model.ContactForm;
import com.ehb.bestelapp.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/gebruiker")
public class ContactController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/contact")
    public String toonContactFormulier(Model model) {
        model.addAttribute("contact", new ContactForm());
        return "gebruiker/contact";
    }
    @PostMapping("/contact")
    public String verwerkContactFormulier(@Valid @ModelAttribute("contact") ContactForm contactForm,
                                          BindingResult result,
                                          Model model) {
        if (result.hasErrors()) {
            return "gebruiker/contact";
        }

        try {
            emailService.sendContactMail(
                    contactForm.getEmail(),
                    contactForm.getCategorie(),
                    contactForm.getBericht()
            );
            model.addAttribute("success", "Je bericht werd succesvol verzonden naar de magazijnier.");
        } catch (Exception e) {
            model.addAttribute("fout", "Er trad een fout op bij het verzenden: " + e.getMessage());
        }


        return "gebruiker/contact";
    }
}
