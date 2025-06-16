package com.ehb.bestelapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

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
}
