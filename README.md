# Bestelapp

Deze applicatie is een bestelapplicatie die het materiaalbeheer vereenvoudigt voor zowel magazijniers als techniekers van Aquafin. Magazijniers kunnen materiaal toevoegen, voorraad opvolgen en bestellingen beheren. Techniekers kunnen via een duidelijke interface materialen selecteren, toevoegen aan hun winkelmand en een bestelling plaatsen. De applicatie werkt met gebruikersrollen (admin, technieker, magazijnier) en bevat beveiliging op basis van autorisatie. Ook hier vertrokken we vanuit reële noden die door een medewerker, Gwen Temperman, werden aangebracht.

# Design Thinking

Probleem: Techniekers moeten materialen bestellen via omslachtige processen. Magazijniers hebben geen overzicht op bestellingen of voorraad.Oplossing: Een Spring Boot-webapplicatie waarin techniekers eenvoudig materiaal kunnen bestellen en magazijniers materialen kunnen beheren. De rollen zijn afgebakend en beveiligd.

# Analyse & structuur

De applicatie bevat:

Rollen: Admin, Magazijnier, Technieker

Pagina’s: login, dashboard, materiaalbeheer, winkelmand, bestellingen, contact

MVC-structuur (Spring Boot, controllers, services, modellen)

Thymeleaf-views gekoppeld aan backendlogica via modellen

Database met MySQL, dump in /database/

Coderingsmethodes & kwaliteitsbewaking

Gebruik van Spring Security voor toegangscontrole

Bcrypt-hashing voor wachtwoorden

Validatie via annotaties en foutmeldingen in views

Versiebeheer via GitHub, commits per feature

# Database en Git

MySQL-database met 5 tabellen: gebruikers, materialen, bestellingen, routines, winkelmand

Map  /database/ te zien in project

Git-repo met commits per functionaliteit en aparte mappen voor model, controller, view

## Inhoudsopgave

* [Technologieën](#-technologieën)
* [Functionaliteiten](#-functionaliteiten)
* [Database](#-database)
* [Vereisten](#-vereisten)
* [Installatie](#-installatie)
* [Configuratie](#-configuratie)
* [Projectstructuur](#-projectstructuur)
* [API Endpoints](#-api-endpoints)
* [Testen](#-testen)
* [Team en werkverdeling](#-team-en-werkverdeling)
* [Bronnen en digitale hulpmiddelen](#-bronnen-en-digitale-hulpmiddelen)
* [Contributie](#-contributie)
* [Licentie](#-licentie)
* * [Schermafbeeldingen](#-schermafbeeldingen)

## Technologieën

* **Backend:**

  * Java 17
  * Spring Boot 3.5.0
  * Spring Security
  * Spring Data JPA (H2 in-memory database)
  * Thymeleaf
  * Maven
* **Frontend:**

  * HTML5
  * CSS3
  * Bootstrap 5

## Functionaliteiten

* **Authenticatie & Autorisatie**

  * Registratie, login/logout
  * Gebruikersrollen: ADMIN, MAGAZIJNIER, TECHNIEKER
* **Bestellingbeheer**

  * Aanmaken, lezen, updaten, verwijderen
  * Technieker koppelen aan bestelling
* **Materiaalbeheer**

  * CRUD-op materiaal
* **Winkelmand**

  * Producten/materialen toevoegen aan winkelmand
* **Contactformulier**

  * Berichten versturen naar beheerder via e-mail
* **Routing & Frontend**

  * Thymeleaf-templates
  * HTML/CSS/Bootstrap–layout, gescheiden views per rol
* **Beveiliging**

  * URL-toegang op basis van rol
  * Bcrypt-wachtwoordhashing
 
# Gebruikersrollen
TECHNIEKER
Kan materialen bekijken en bestellen
Heeft toegang tot eigen bestellingen
Kan winkelmand beheren

MAGAZIJNIER
Beheert materiaalvoorraad
Verwerkt bestellingen
Ziet alle bestellingen

ADMIN
Volledige systeemtoegang
Gebruikersbeheer
Configuratiebeheer

## Database

De databasedump bevindt zich in de map `/database`. Elk bestand bevat een deel van het databankmodel:

* `materiaalbeheer_gebruikers.sql`: bevat de gebruikers met rollen zoals admin, magazijnier...
* `materiaalbeheer_materialen.sql`: beheert het aanbod materiaal
* `materiaalbeheer_bestellingen.sql`: koppeling van gebruikers aan materiaal via bestellingen
* `materiaalbeheer_winkelmand.sql`: winkelmandgegevens
* `materiaalbeheer_routines.sql`: periodieke bestellingen of vaste acties

## Vereisten

* JDK 17 of hoger
* Maven 3.6+
* Git
* MySQL Workbench (voor importeren van database)
  
## Installatie

1. **Clone de repo**

   ```bash
   git clone https://github.com/Mohamed-Amin77/Bestelapp.git
   cd Bestelapp
   ```

2. **Importeer de database**
   Importeer de `.sql`-bestanden uit de map `/database` in je MySQL Workbench.

3. **Run de applicatie**

   * Open het project in IntelliJ
   * Run `BestelappApplication.java`
   * Navigeer naar `http://localhost:8081`

## Bronnen en digitale hulpmiddelen

* ChatGPT (OpenAI): uitleg bij validatie en SpingSecurity (nieuwe onderdelen) en debug van code
* StackOverflow: foutoplossingen
* YouTube tutorials: Spring Boot + Thymeleaf

## Testen

Een volledig testplan met scenario's voor authenticatie, materiaalbeheer, bestellingen, validaties en usability is te vinden in het project onder docs.

# Projectstructuur
![image](https://github.com/user-attachments/assets/254ce2bc-606c-4e27-8302-ac5b219ef500)
![image](https://github.com/user-attachments/assets/abf49213-a58a-434f-a74a-459eb3148a4a)

## Schermafbeeldingen

### Admin-weergave

**Homepagina**
![Admin Homepagina](docs/images/Admin%20-%20Home%20pagina.png)

**Alle medewerkers**
![Admin Alle Medewerkers](docs/images/Admin%20-%20Alle%20Medewerkers%20pagina.png)

**Gebruiker bewerken**
![Admin Gebruiker Bewerken](docs/images/Admin%20-%20Gebruiker%20Bewerken%20pagina.png)

**Nieuw personeelslid toevoegen**
![Admin Nieuw Personeel](docs/images/Admin%20-%20Nieuwe%20personeelslid%20toevoegen%20pagina.png)

---

### Magazijnier-weergave

**Homepagina**
![Magazijnier Homepagina](docs/images/Magazijnier%20-%20Home%20pagina.png)

**Bestellingen**
![Magazijnier Bestellingen](docs/images/Magazijnier%20-%20Bestellingen%20pagina.png)

**Materiaalpagina**
![Magazijnier Materiaal](docs/images/Magazijnier%20-%20Materiaal%20pagina.png)

**Materiaal toevoegen**
![Magazijnier Materiaal Toevoegen](docs/images/Magazijnier%20-%20Materiaal%20Toevoegen%20pagina.png)

---

### Technieker-weergave

**Materiaalpagina**
![Technieker Materiaalpagina](docs/images/Technieker%20-%20Materiaal%20pagina.png)

**Winkelmand**
![Technieker Winkelmand](docs/images/Technieker%20-%20Winkelmand%20pagina.png)

**Bestellingen**
![Technieker Bestellingen](docs/images/Technieker%20-%20Bestelling%20pagina.png)


