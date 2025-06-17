package com.ehb.bestelapp.controller;

import org.springframework.stereotype.Controller;
<<<<<<< HEAD
=======
import org.springframework.ui.Model;
>>>>>>> 8045d65 (Thymfeleaf toegvoegd en admincontroller aangemaakt)
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

<<<<<<< HEAD
    @GetMapping("/admin/dashboard")
    public String dashboard() {
        return "admin/dashboard";
    }

    @GetMapping("/admin/medewerker/toevoegen")
    public String addMedewerker() {
        return "admin/add-medewerker";
    }

    @GetMapping("/admin/medewerker/bewerken")
    public String editMedewerker() {
        return "admin/edit-medewerker";
    }

    @GetMapping("/admin/personelen")
    public String allePersonelen() {
        return "admin/alle-personelen";
    }
=======
    @GetMapping("/admin/edit")
    public String toonEditPagina(Model model) {

        return "admin/edit-medewerker";
    }
>>>>>>> 8045d65 (Thymfeleaf toegvoegd en admincontroller aangemaakt)
}
