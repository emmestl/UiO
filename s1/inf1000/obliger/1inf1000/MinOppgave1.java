/** Obligatorisk innlevering 1 - INF1000 */
/* Program som finner ut hvilket tall du tenker har valgt. */

import java.util.Scanner;
public class MinOppgave1 {
    public static void main(String [] args) {
	
	//Oppgave 1.5
	Scanner input =new Scanner (System.in);
	System.out.println ("Velg et tall mellom 1-100");
	int valgt_tall = Integer.parseInt(input.nextLine()); //tilfeldig tall mellom 1-100 som brukeren velger selv.
	
	int nedreBegrensning = 1; //tallet er alltid stoerre enn dette
	int ovreBegrensning = 101; //tallet er alltid mindre enn dette, velger oevrebegrensing som 101 fremfor 100 fordi naar java runder av til int runder den ned. 
	int ovreBegrensningMulig = ovreBegrensning -1; //dette er maks tallet det er lov til aa velge for å kjoere programmet.
	int midlertidligTall =(ovreBegrensning +nedreBegrensning)/2;; //tallet er midlertidlig uspesifisert til vi finner ut hvor input tallet staar i forhold til midten av omraadet tallet kan ligge. 
	
	if (valgt_tall < nedreBegrensning || valgt_tall > ovreBegrensningMulig) {
	    System.out.println ("Desverre dette er ikke et gyldig tall, venligst start programmet på nytt og velg et annet tall.");
	}
	else {
	    while (valgt_tall != midlertidligTall){
		if (valgt_tall > midlertidligTall){
		    midlertidligTall = (ovreBegrensning + midlertidligTall)/2; //finner  ut hvordan input tallet staar i forhold til den den halvparten vi vet den ligger i. Dette finner vi ut ved aa halvere sonene og finne ut om det nye tallet er stoerre eller mindre enn inputtallet
		    if (midlertidligTall  < valgt_tall) {
			nedreBegrensning = midlertidligTall;
		    }
		    else if (midlertidligTall > valgt_tall) {
			ovreBegrensning = midlertidligTall;
		    }
		}
		else if (valgt_tall < midlertidligTall){
		    midlertidligTall = (nedreBegrensning + midlertidligTall)/2;
		    if (midlertidligTall < valgt_tall) {
			nedreBegrensning = midlertidligTall;
		    }
		    else if (midlertidligTall > valgt_tall){
			ovreBegrensning = midlertidligTall;
		    }
		}
		// System.out.println (midlertidligTall); //fjern markeringstengene for aa finne ut hvordan det midlertidlige tallet er i forhold til tallet som skal finnes.
	    }   
	    System.out.println ("Tallet du skrev inn var " + midlertidligTall);
	}
    }
}