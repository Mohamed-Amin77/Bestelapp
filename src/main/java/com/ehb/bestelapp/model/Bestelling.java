
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

<<<<<<< HEAD
    // Technieker als relatie naar User in plaats van alleen een Long id
    @ManyToOne(optional = false)
    @JoinColumn(name = "technieker_id")
    private User technieker;
=======
    @NotNull(message = "Technieker is verplicht")
    private Long technieker;
    private String status;
    private String leverdatum;

>>>>>>> 7561452d70749d63b565b718ae0d6f04294c3efc

    private String status;

    public Bestelling() {
    }

    public Bestelling(String datum, String omschrijving, User technieker) {
        this.datum = datum;
        this.omschrijving = omschrijving;
        this.technieker = technieker;
    }

    // GETTERS EN SETTERS


    public String getLeverdatum() {
        return leverdatum;
    }

    public void setLeverdatum(String leverdatum) {
        this.leverdatum = leverdatum;
    }

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
}
