package com.ehb.bestelapp.controller;

import com.ehb.bestelapp.model.Rol;
import com.ehb.bestelapp.model.User;
import com.ehb.bestelapp.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/gebruikers")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Alle gebruikers opvragen
    @GetMapping
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/list")
    public String showUserList(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "gebruiker/lijst";
    }

    @GetMapping("/bewerken/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gebruiker niet gevonden"));
        model.addAttribute("user", user);
        return "gebruiker/bewerken"; // e.g. templates/gebruikers/bewerken.html
    }

    //Save user update
//    @PostMapping("/bewerken/{id}")
//    public String updateUser(@PathVariable Long id, @ModelAttribute("user") User updated) {
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Gebruiker niet gevonden"));
//
//        user.setNaam(updated.getNaam());
//        user.setEmail(updated.getEmail());
//        user.setRol(updated.getRol());
//
//        userRepository.save(user);
//        return "redirect:/gebruikers";
//    }

    @PostMapping("/{id}/bewerken")
    public String updateUser(@PathVariable Long id, @ModelAttribute("user") User updatedUser) {
        userRepository.findById(id).ifPresent(user -> {
            user.setNaam(updatedUser.getNaam());
            user.setEmail(updatedUser.getEmail());

            if (!updatedUser.getWachtwoord().isBlank()) {
                user.setWachtwoord(passwordEncoder.encode(updatedUser.getWachtwoord()));
            }

            user.setRol(updatedUser.getRol());
            userRepository.save(user);
        });

        return "redirect:/gebruikers/list";
    }

    // Delete user
    @PostMapping("/verwijderen/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "redirect:/gebruikers/list";
    }

//    // Eén gebruiker opvragen (ID)
//    @GetMapping("/{id}")
//    public Optional<User> getById(@PathVariable Long id) {
//        return userRepository.findById(id);
//    }
//
//    // Nieuwe gebruiker toevoegen
//    @PostMapping
//    public User create(@Valid @RequestBody User user) {
////        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
////            throw new RuntimeException("Email is al in gebruik");
////        }
//
//        user.setWachtwoord(passwordEncoder.encode(user.getWachtwoord()));
//
//        return userRepository.save(user);
//    }
//
//    // Gebruiker bijwerken
//    @PutMapping("/{id}")
//    public User update(@PathVariable Long id, @RequestBody User updated) {
//        return userRepository.findById(id).map(u -> {
//            u.setNaam(updated.getNaam());
//            u.setEmail(updated.getEmail());
//
//            if (!updated.getWachtwoord().isBlank()) {
////                u.setWachtwoord(passwordEncoder.encode(updated.getWachtwoord()));
//            }
//
//            //u.setRol(updated.getRol());
//            return userRepository.save(u);
//
//        // Als er geen gebruiker met dat ID is, wordt er een nieuwe gebruiker aangemaakt met die ID
//        }).orElseGet(() -> {
//            updated.setId(id);
////            updated.setWachtwoord(passwordEncoder.encode(updated.getWachtwoord()));
//            return userRepository.save(updated);
//        });
//    }
//
//
//    @PutMapping("/{id}/make-admin")
//    public User makeUserAdmin(@PathVariable Long id) {
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Gebruiker niet gevonden"));
//
//        user.setRol(Rol.ADMIN);
//        return userRepository.save(user);
//    }
//
//    // Gebruiker verwijderen
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id) {
//        userRepository.deleteById(id);
//    }
}
