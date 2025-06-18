package com.ehb.bestelapp.controller.templates;

import com.ehb.bestelapp.model.User;
import com.ehb.bestelapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName(); // Email is used as username
        User user = userRepository.findByEmail(email); // Now get your actual User object

        model.addAttribute("user", user);
        return "index"; // thymeleaf template name
    }
}