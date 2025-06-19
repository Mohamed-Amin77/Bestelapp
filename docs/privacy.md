
# GDPR en privacy

Deze applicatie respecteert de regels van de Algemene Verordening Gegevensbescherming (GDPR).

Er worden geen echte persoonsgegevens opgeslagen of verwerkt tijdens de ontwikkeling en testfase.

Gebruikersaccounts en e-mails in de databank zijn fictief of testgegevens.

Alle gebruikersinformatie is lokaal opgeslagen op de ontwikkelmachine en wordt niet gedeeld met externe partijen.

# Veiligheid

De applicatie maakt gebruik van Spring Security voor toegangsbeheer per rol (technieker, magazijnier, admin).

Wachtwoorden worden gehasht met Bcrypt en nooit als platte tekst opgeslagen.

CSRF-bescherming is ingeschakeld om te voorkomen dat ongewenste acties via sessies worden uitgevoerd.

Enkel geautoriseerde gebruikers krijgen toegang tot gevoelige functionaliteiten (zoals gebruikersbeheer of bestellingen).

# Richtlijnen & ethiek

De code is geschreven volgens de professionele standaarden van secure web development (o.a. inputvalidatie, authenticatie, session management).

Alle teamleden hebben zich gehouden aan de richtlijnen van de opleiding en de gedragscode van de onderwijsinstelling.

Geen enkele vorm van plagiaat of ongepaste AI-gebruik is toegepast: alle AI-hulp is transparant gedocumenteerd in de README.

Bronvermeldingen (zoals afbeeldingen, API's of codefragmenten) zijn correct opgenomen.