package com.ehb.bestelapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "bestellingen")
public class Bestelling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Datum is verplicht")
    private String datum;

    @NotBlank(message = "Omschrijving is verplicht")
    private String omschrijving;

    // Technieker is nu een echte relatie naar User
    @ManyToOne(optional = false)
    @JoinColumn(name = "technieker_id", nullable = false)
    private User technieker;

    private String status;

    private String leverdatum;

    public Bestelling() {
    }

    public Bestelling(String datum, String omschrijving, User technieker) {
        this.datum = datum;
        this.omschrijving = omschrijving;
        this.technieker = technieker;
    }

    // ===== GETTERS & SETTERS =====

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

    public User getTechnieker() {
        return technieker;
    }

    public void setTechnieker(User technieker) {
        this.technieker = technieker;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLeverdatum() {
        return leverdatum;
    }

    public void setLeverdatum(String leverdatum) {
        this.leverdatum = leverdatum;
    }
}
