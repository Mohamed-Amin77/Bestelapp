# Bestelapp

Een Spring Boot–webapplicatie voor het beheren van bestellingen en materialen, met gebruikersrollen, beveiliging, contactformulier en een winkelmandfunctionaliteit.

---

## Inhoudsopgave

- [Technologieën](#-technologieën)  
- [Functionaliteiten](#-functionaliteiten)  
- [Vereisten](#-vereisten)  
- [Installatie](#-installatie)  
- [Configuratie](#-configuratie)  
- [Projectstructuur](#-projectstructuur)  
- [API Endpoints](#-api-endpoints)  
- [Testen](#-testen)  
- [Contributie](#-contributie)  
- [Licentie](#-licentie)  

---

## Technologieën

- **Backend:**  
  - Java 17  
  - Spring Boot 3.5.0  
  - Spring Security  
  - Spring Data JPA (H2 in-memory database)  
  - Thymeleaf  
  - Maven  
- **Frontend:**  
  - HTML5  
  - CSS3  
  - Bootstrap 5  

---

##  Functionaliteiten

- **Authenticatie & Autorisatie**  
  - Registratie, login/logout  
  - Gebruikersrollen: ADMIN, MAGAZIJNIER, TECHNIEKER  
- **Bestellingbeheer**  
  - Aanmaken, lezen, updaten, verwijderen  
  - Technieker koppelen aan bestelling  
- **Materiaalbeheer**  
  - CRUD-op materiaal  
- **Winkelmand**  
  - Producten/materialen toevoegen aan winkelmand  
- **Contactformulier**  
  - Berichten versturen naar beheerder via e-mail  
- **Routing & Frontend**  
  - Thymeleaf-templates  
  - HTML/CSS/Bootstrap–layout, gescheiden views per rol  
- **Beveiliging**  
  - URL-toegang op basis van rol  
  - Bcrypt-wachtwoordhashing  

---

##  Vereisten

- JDK 17 of hoger  
- Maven 3.6+  
- Git  

---

##  Installatie

1. **Clone de repo**  
   ```bash
   git clone https://github.com/Mohamed-Amin77/Bestelapp.git
   cd Bestelapp
