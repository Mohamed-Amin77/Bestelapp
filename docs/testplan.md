# Testplan Bestelapp

Dit testplan beschrijft de belangrijkste testscenario's voor het controleren van de werking, beveiliging en gebruiksvriendelijkheid van de Bestelapp-toepassing.

\#Testing
\#Testscenario's
\#Doeltreffend
\#Software aanpassen aan testresultaten
\#Usability

## Authenticatie en autorisatie

### Login - Correct

**Beschrijving:** Gebruiker logt in met geldig e-mailadres en wachtwoord
**Input:** [admin@ehb.be](mailto:admin@ehb.be) / Password!321
**Verwacht resultaat:** Redirect naar dashboard

### Login - Fout wachtwoord

**Beschrijving:** Gebruiker geeft fout wachtwoord in
**Input:** [admin@ehb.be](mailto:admin@ehb.be) / foutwachtwoord
**Verwacht resultaat:** Foutmelding "Onjuiste gegevens"

### Ongeautoriseerde toegang

**Beschrijving:** Technieker probeert adminpagina te openen
**Verwacht resultaat:** Redirect naar foutpagina of "403 Forbidden"

## Materiaalbeheer

### Zoeken op naam

**Beschrijving:** Gebruiker zoekt op bestaande materiaalnaam
**Input:** "Pomp"
**Verwacht resultaat:** Enkel materiaal met naam "Pomp" wordt getoond

### Filter op categorie

**Beschrijving:** Gebruiker selecteert een categorie uit de dropdown
**Input:** "Elektrisch"
**Verwacht resultaat:** Enkel materiaal uit categorie "Elektrisch" zichtbaar

### Nieuw materiaal toevoegen (Admin)

**Beschrijving:** Admin voegt materiaal toe via formulier
**Input:** Naam, categorie, omschrijving
**Verwacht resultaat:** Materiaal verschijnt in lijst

## Winkelmand en bestellen

### Materiaal toevoegen aan winkelmand

**Beschrijving:** Technieker klikt op "Bestel" naast materiaal
**Verwacht resultaat:** Materiaal toegevoegd aan winkelmand met status

### Winkelmand bekijken

**Beschrijving:** Gebruiker klikt op "Naar winkelmand"
**Verwacht resultaat:** Lijst van gekozen materialen wordt getoond

### Bestelling bevestigen

**Beschrijving:** Gebruiker klikt op "Bestelling plaatsen"
**Verwacht resultaat:** Bestelling geregistreerd, winkelmand geleegd

## Contactformulier

### Bericht verzenden

**Beschrijving:** Gebruiker vult formulier in en verzendt
**Input:** Naam, e-mail, bericht
**Verwacht resultaat:** E-mail wordt verstuurd, succesmelding op scherm

## Validatie en fouten

### Lege velden in formulier

**Beschrijving:** Gebruiker verzendt formulier zonder verplichte velden
**Verwacht resultaat:** Validatiefout weergegeven, formulier wordt niet verzonden

## Usability

### Responsief gedrag

**Beschrijving:** Pagina past zich aan op verschillende schermgroottes
**Verwacht resultaat:** Elementen herschikken zich correct (Bootstrap 5)

### Navigatie per rol

**Beschrijving:** Menu-items verschillen per rol
**Verwacht resultaat:** Admin ziet beheerpagina's, technieker alleen bestelpagina's
