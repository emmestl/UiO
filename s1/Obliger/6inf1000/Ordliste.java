//Oblig 6.2
/**
 * Lagrer alle orden som har blitt laget i en Array, men hvis to ord er like vil ordet IKKE bli lagret to ganger
 * 
 * @author Elsie Mestl
 * @version 16.10.2014 
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;

class Ordliste{
    ArrayList<Ord> ordliste = new ArrayList<>();

    /** 
     * Leser inn boken som blir sendt med som parameter
     * Alle ordene i boken skal legges inn i en ordliste, kaller p&aring; for &aring; gj&oslash;e dette
     * @param filnavn navnet p&aring; filen som skal leses inn
     */

    void lesBok(String filnavn) throws Exception{
	String tekstLinje;
	File fil = new File(filnavn);
	Scanner filen = new Scanner(fil);

	while (filen.hasNextLine()){
	    tekstLinje = filen.nextLine();
	    //System.out.println(tekstLinje);
	    leggTilOrd(tekstLinje);
	    //System.out.println(ordliste.size());
	}
    }


    /** 
     *Hvis et ord ikke finnes i ordlisten allerede legges det til i ordlisten hvis ordet finnes skal antallet &oslash;ke
     *Kaller p&aring; for &aring; sjekke om ordet finnes fra f&oslash;r av 
     *hvis finnes fra f&oslash;r av retuneres "null" fra finnord
     *@param s ett ord
     */
    void leggTilOrd (String s){
	Ord nyttOrd;
	Ord ordet;
	ordet = finnOrd(s);

	if (ordet == null) {
	    nyttOrd = new Ord(s);
	    ordliste.add(nyttOrd);
	}

	else {
	    ordet.oekAntall();
	}
    }
    
    /** 
     *Sjekker om det nye ordet allerede ligger i ordlisten
     *
     *@param s ord
     *@return hvis ordet finnes fra f&oslash;r av skal ordet returneres hvis ikke returneres "null"
     */

    Ord finnOrd(String s){
	String toStringavOrd;
	Ord ordi;

	for (int i =0; i < ordliste.size(); i++){
	    ordi = ordliste.get(i);
	    toStringavOrd = ordi.toString(); 
	    
	    if (s.equalsIgnoreCase(toStringavOrd)){
		return ordi;
	    }
	    
	    else if (i == ordliste.size()-1) {
		return null;
	    }
	}
	return null;
    }

    /** 
     *gi antall forskjellige ord som finnes i teksten
     *
     *@return returnerer st&oslash;relsen p&aring; ordliste er det samme som antall forskjellige ord
     */

    int antallOrd(){
	return ordliste.size();
    }

    /** 
     *finner et av ordene som forekommer oftest i teksten
     *kaller p&aring; sin hentAntall() metode, sammenlikner antallet til de forskjellige ordene for &aring; finne det mest brukte
     *@return returnerer det mest brukete/eller et av de mest brukte ordene
     */

    Ord vanligste(){
	int antallForekomster=0;
	int forekommetFlest =0;
	Ord ordi;
	Ord mestBrukteOrdet=ordliste.get(0);
	for (int i =0; i < ordliste.size(); i++){
	    ordi = ordliste.get(i);

	    if (ordi.hentAntall() > forekommetFlest){
		forekommetFlest = ordi.hentAntall();
		mestBrukteOrdet = ordi;
	    }
	}

	return mestBrukteOrdet;
    }
    
    /**
     *finner alle ordene som er mest vanlige, dvs hvis det finnes flere ord som brukes like mange ganger s&aring; skal begge printes ut
     *kaller p&aring; vanligste() for &aring; en av dem, da vet java s&aring; mange ganger forekommer de mest brukte ordene, sjekker om det er noen andre som blir brukt like mange ganger
     *@return returnerer en array av ord som inneholder alle de ordene som har blitt brukt flest ganger
     */
    Ord[] alleVanligste(){
	// samme konseptet som over eneste forskjelden er at det kan vaere flere og dermed skal alle ordene sendes tilbake og dette gjores vha en array av ord;
	Ord [] vanligsteOrdene1 = new Ord[ordliste.size()]; //arrayet er nok for langt men da er vi sikker paa at alt har plass
	Ord [] vanligsteOrdene;
	Ord vanligste = vanligste();
	int forekomster = vanligste.hentAntall();
	int antallVanligste = 0;


	for (int i = 0; i < ordliste.size(); i++){
	    if (ordliste.get(i).hentAntall() == forekomster ){
		vanligsteOrdene1[antallVanligste] = ordliste.get(i);
		antallVanligste++;
	    }
	}
	vanligsteOrdene = Arrays.copyOfRange(vanligsteOrdene1, 0, antallVanligste);
	return vanligsteOrdene;
    }
}

	
    
