/** Obligatorisk innlevering 1 -INF1000 */

import java.util.Scanner;
public class Billettpris {
    public static void main (String[] args) {
	
	//Oppgave 1.3)
	int alder;                     // deklarerer konstanter
	double billettpris = 50.00; 
	final int barn = 12;
	final int honor = 67;
	final double rabatt = 0.5;

	Scanner input = new Scanner (System.in); //brukerens alder blir lest inn
	System.out.print ("Hva er din alder? ");
	alder = Integer.parseInt(input.nextLine());

	if (alder < barn || alder > honor) { /*forstod det slik at ved alder 12
					       og 67 maa fullpris fremdeles 
					       betales*/
	    billettpris = rabatt * billettpris; /* hvis brukeren skal ha rabatt 
						   endres billettprisen, hvis 
						   ikke forblir den den samme*/
	}
	System.out.println ("Billetten din koster " + billettpris + " kr");
    }
}
