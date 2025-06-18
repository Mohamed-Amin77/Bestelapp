package com.ehb.bestelapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.cglib.core.Local;

@Entity
@Table(name = "bestellingen")
public class Bestelling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Datum is verplicht")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate datum;
<<<<<<< HEAD

    //    @NotBlank(message = "Omschrijving is verplicht")
//    private String omschrijving;

=======

//    @NotBlank(message = "Omschrijving is verplicht")
//    private String omschrijving;
>>>>>>> d896d09 (Laatste backend aanpassingen: security geoptimaliseerd, user- en bestelling-controllers afgerond)

    // Technieker is nu een echte relatie naar User
    @ManyToOne(optional = false)
    @JoinColumn(name = "technieker_id", nullable = false)
    private User technieker;

    private String status;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate leverdatum;
<<<<<<< HEAD
=======


>>>>>>> d896d09 (Laatste backend aanpassingen: security geoptimaliseerd, user- en bestelling-controllers afgerond)

    public Bestelling() {
    }

    public Bestelling(LocalDate datum, String omschrijving, User technieker) {
        this.datum = datum;
//        this.omschrijving = omschrijving;
        this.technieker = technieker;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

<<<<<<< HEAD
    //    public String getOmschrijving() {
=======
//    public String getOmschrijving() {
>>>>>>> d896d09 (Laatste backend aanpassingen: security geoptimaliseerd, user- en bestelling-controllers afgerond)
//        return omschrijving;
//    }
//
//    public void setOmschrijving(String omschrijving) {
//        this.omschrijving = omschrijving;
//    }

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

    public LocalDate getLeverdatum() {
        return leverdatum;
    }

    public void setLeverdatum(LocalDate leverdatum) {
        this.leverdatum = leverdatum;
    }
}
