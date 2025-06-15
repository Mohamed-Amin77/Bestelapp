package com.ehb.bestelapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "materialen")
public class Materiaal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Naam is verplicht")
    private String naam;

    @NotNull(message = "Aantal is verplicht")
    @Min(value = 0, message = "Aantal moet 0 of meer zijn")
    private Integer aantal;

    // Constructors
    public Materiaal() {}

    public Materiaal(String naam, Integer aantal) {
        this.naam = naam;
        this.aantal = aantal;
    }

    // Getters en Setters
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

    public Integer getAantal() {
        return aantal;
    }

    public void setAantal(Integer aantal) {
        this.aantal = aantal;
    }
}
