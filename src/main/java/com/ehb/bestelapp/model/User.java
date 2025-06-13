package com.ehb.bestelapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "gebruikers") //
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naam;
    private String email;
    private String wachtwoord;
    private String rol; // admin, technieker

    public User() {}

    public User(String naam, String email, String wachtwoord, String rol) {
        this.naam = naam;
        this.email = email;
        this.wachtwoord = wachtwoord;
        this.rol = rol;
    }

    // Getters en setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
