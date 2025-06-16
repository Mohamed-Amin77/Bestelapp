package com.ehb.bestelapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Bestelling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Datum is verplicht")
    private String datum;

    @NotBlank(message = "Omschrijving is verplicht")
    private String omschrijving;

    @NotNull(message = "Technieker is verplicht")
    private Long technieker;
    private String status;


    public Bestelling() {
    }

    public Bestelling(String datum, String omschrijving, Long technieker) {
        this.datum = datum;
        this.omschrijving = omschrijving;
        this.technieker = technieker;
    }

    // GETTERS EN SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public Long getTechnieker() {
        return technieker;
    }

    public void setTechnieker(Long technieker) {
        this.technieker = technieker;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
