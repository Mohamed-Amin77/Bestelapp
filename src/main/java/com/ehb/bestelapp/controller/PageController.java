package com.ehb.bestelapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // resolves to templates/login.html
    }

    @GetMapping("/index")
    public String home() {
        return "index"; // resolves to templates/index.html
    }
}
