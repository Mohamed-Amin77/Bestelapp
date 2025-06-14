package com.ehb.bestelapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;


//Deze klasse stelt een materiaal-item voor in de database
@Entity
public class Materiaal {

    //Uniek ID dat automatisch gegenereerd wordt
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Eigenschappen van materiaal
    @NotBlank(message = "Naam is verplicht")
    private String naam;
    @NotBlank(message = "Categorie is verplicht")
    private String categorie;

    @Min(value = 0, message = "Voorraad moet minimaal 0 zijn")
    private int voorraad;

    @NotBlank(message = "Omschrijving is verplicht")
    private String omschrijving;

    //Lege constructor (voor jpa)
    public Materiaal() {}

    //Constructor met velden
    public Materiaal(String naam, String categorie, int voorraad, String omschrijving) {
        this.naam = naam;
        this.categorie = categorie;
        this.voorraad = voorraad;
        this.omschrijving = omschrijving;
    }

    //Getters en setters
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

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getVoorraad() {
        return voorraad;
    }

    public void setVoorraad(int voorraad) {
        this.voorraad = voorraad;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }
}
