package com.ehb.bestelapp.controller;


import com.ehb.bestelapp.model.User;
import com.ehb.bestelapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RegistrationLoginController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){ //Use of wildcard <?> because sometimes we return the BR sometomes the HTTP REQUEST OK
        if(userRepository.findByEmail(user.getEmail()) != null){
            return ResponseEntity.badRequest().body("Username exists already");
        }

        user.setWachtwoord(passwordEncoder.encode(user.getWachtwoord()));
        return ResponseEntity.ok(userRepository.save(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user){
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getWachtwoord()));
            return ResponseEntity.ok("Login successfull !");
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password !");
        }
    }

}
