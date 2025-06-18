package com.ehb.bestelapp.controller;


import com.ehb.bestelapp.model.User;
import com.ehb.bestelapp.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/auth")
public class RegistrationLoginController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "auth/register";  // --> templates/auth/register.html
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, BindingResult result, Model model){
        if (userRepository.findByEmail(user.getEmail()) != null) {
            result.rejectValue("email", null, "Email bestaat al");
        }

        if (result.hasErrors()) {
            return "auth/register";
        }

        user.setWachtwoord(passwordEncoder.encode(user.getWachtwoord()));
        userRepository.save(user);

        model.addAttribute("success", true);
        return "redirect:/";
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user, HttpSession session){ //Store the user in session
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getWachtwoord()));
            return ResponseEntity.ok("Login successfull !");
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password !");
        }
    }

}
