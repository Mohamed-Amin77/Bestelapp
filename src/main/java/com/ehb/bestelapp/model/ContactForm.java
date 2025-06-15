package com.ehb.bestelapp.model;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ContactForm {
    @NotBlank(message = "E-mail of personeelsnummer is verplicht")
    @Email(message = "Voer een geldige e-mail in")
    private String email;

    @NotBlank(message = "Categorie is verplicht")
    private String categorie;

    @NotBlank(message = "Bericht mag niet leeg zijn")
    private String bericht;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getBericht() {
        return bericht;
    }

    public void setBericht(String bericht) {
        this.bericht = bericht;
    }
}
