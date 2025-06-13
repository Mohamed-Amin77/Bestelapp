package com.ehb.bestelapp.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Bestelling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bestellerNaam;
    private LocalDate datum;
    private String status;

    // Lege constructor (voor JPA)
    public Bestelling() {}

    // Constructor
    public Bestelling(String bestellerNaam, LocalDate datum, String status) {
        this.bestellerNaam = bestellerNaam;
        this.datum = datum;
        this.status = status;
    }

    // Getters en setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBestellerNaam() { return bestellerNaam; }
    public void setBestellerNaam(String bestellerNaam) { this.bestellerNaam = bestellerNaam; }

    public LocalDate getDatum() { return datum; }
    public void setDatum(LocalDate datum) { this.datum = datum; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
