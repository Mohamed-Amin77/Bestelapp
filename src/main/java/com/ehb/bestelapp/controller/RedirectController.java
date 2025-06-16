package com.ehb.bestelapp.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

    // Na succesvolle login wordt deze URL opgeroepen om door te sturen naar juiste pagina
    @GetMapping("/redirect")
    public String redirectAfterLogin(Authentication auth) {
        // Check of de gebruiker ADMIN rol heeft
        if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "redirect:/dashboard";  // Doorsturen naar admin dashboard

            // Check of de gebruiker TECHNIEKER rol heeft
        } else if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_TECHNIEKER"))) {
            return "redirect:/home";

            // Check of de gebruiker MAGAZIJNIER rol heeft
        } else if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_MAGAZIJNIER"))) {
            return "redirect:/home";

            // Als geen van bovenstaande rollen, stuur terug naar login met foutmelding
        } else {
            return "redirect:/login?error=true";
        }
    }
}
