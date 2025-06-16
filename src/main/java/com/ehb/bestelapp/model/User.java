package com.ehb.bestelapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "gebruikers", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Naam is verplicht")
    private String naam;

    @NotBlank(message = "Email is verplicht")
    @Email(message = "Ongeldig emailadres")
    private String email;

    @NotBlank(message = "Wachtwoord is verplicht")
    @Size(min = 6, message = "Wachtwoord moet minstens 6 tekens bevatten")
    private String wachtwoord;

    @NotBlank(message = "Rol is verplicht")
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
