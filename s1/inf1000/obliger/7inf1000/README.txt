I Oblig7 klassen:
	Har lagt main-metoden i sin egen klasse. Det eneste denne gjør er å kalle på opprette et DVDadministrasjonsobjekt og kalle på metoden brukermenyen() og lestTilFil() i denne klassen. Grunnen til at jeg har valgt å gjøre det sånn er fordi da slipper jeg å skrive stattik forran alle globale variabler og metodene som skal brukes.

I DVDadministrasjon klassen:
  	Når man leser in fra filen ser vi at det som bestermmer er en teller som enten kan ha verdien 1,2 eller 3. Har denne fremgangsmetoden pga måten filen er satt opp på. Er linjen du er på tom vil neste linje ALLTID være en person. Det som kommer etter dette er enten en ny tom linje eller en dvd. Dvden kan da enten være lånt eller ikke. Hvis den er lånt vet vi at neste linje vil være en person, hvis ikke vil neste enten være tom eller en dvd. Obs, hver gang vi skal lage en person må det sjekkes om denne personen finnes fra før av. Gjør den det skal det IKKE lages en nye en.
	Metoden sjekkOmDvdFinnes(String navn) returnerer ikke en boolenan (som hadde vært det mer openbare) men heller et tall (int) 0,1,2 dette er fordi da kan jeg i samme metode sjekke, hvis dvden finnes, om den er utlånt eller ikke.
	Metoden l() skal låne bort en dvd. Den er ganske rett frem men en ting som er verdt å legge merke til er at den ikke bare sjekker om dvden det er snakk om er utlånt men om personen som ønsker å låne ikke låner den samme dvden fra en annen person. Grunnen til at jeg har valgt å gjøre det slik er fordi hvis en person kan låne "samme" dvd fra to personer oppstår det et problem ved r() om hvem dvden skal returneres til.
	I k(): man kan ikke kjøpe en dvd som man samtidig leier fra noen andre. Da må denne dvden først returneres. Dette igjen er pga r() metoden.

I Personoversikt klassen:
  	Da jeg beynte med Obligen startet jeg litt feil, hadde to HashMaps som tok hånd om mer eller mindre det samme. Dette skapte en del problemer. Klassen Personoversikt er en rest fra disse problemene. Ser nå at jeg ikke ville trengt en egen metode for dette men oppdaget det først ganske sent. Skulle jeg ha gjort det om ville hele programmet trengt en omstruktuturering noe jeg ikke orket.
	Men det vi ser at klassen gjør er at den inneholder er overskit over alle personene som er  i bruk. Den inneholder en metode som returnerer personen du er på jakt etter og en metode som returnerer hele HashMapet.

I Person klassen:
  	Tenker at alt er temlig rett frem, men ser at i metoden leverTilbake() at hvis en person skal levere tilbake en dvd til en person og den som låner kun har lånt den ene dvden fra denne personen kan vi fjerne ikke bare dvden fra laaner men også personen sden blir lånt fra. Grunnen til dette er at vi slipper masse nullpekkere.

I Dvd klassen:
	Alle metodene er temmelig rett framme.

Konklusjon:

Hadde endret på en del ting (spessielt det med Personoversiktklassen) hvis jeg skulle lagd programmet på nytt. Men dette vil kreve en totalomskrivning av programmet noe jeg ikke har tid til. Ellers gjør programmet akkuratt det det blir bedt om og jeg er fornøyd.
