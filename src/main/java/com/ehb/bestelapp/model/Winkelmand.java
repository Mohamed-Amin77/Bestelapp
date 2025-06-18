package com.ehb.bestelapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "winkelmand")
public class Winkelmand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User technieker;

    @ManyToOne
    private Materiaal materiaal;

    @Min(1)
    private int aantal;

    public Winkelmand(Long id, User technieker, Materiaal materiaal, int aantal) {
        this.id = id;
        this.technieker = technieker;
        this.materiaal = materiaal;
        this.aantal = aantal;
    }

    public Winkelmand() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getTechnieker() {
        return technieker;
    }

    public void setTechnieker(User technieker) {
        this.technieker = technieker;
    }

    public Materiaal getMateriaal() {
        return materiaal;
    }

    public void setMateriaal(Materiaal materiaal) {
        this.materiaal = materiaal;
    }

    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }
}
