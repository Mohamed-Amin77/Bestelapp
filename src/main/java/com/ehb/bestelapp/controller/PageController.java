package com.ehb.bestelapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/index")
    public String home() {
        return "index"; // resolves to templates/index.html
    }
}
