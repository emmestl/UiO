/** Obligatorisk innlevering 1 - INF1000*/
import java.util.Scanner;
public class Beslutninger {
    public static void main(String [] args) {
	
	//Oppgave 1.2a)
	int alder =18 ; /* antar at alderen skal vaere et tall (int
			   ) og ikke en tekst (String)*/

	//Oppgave 1.2b)
	int myndig = 18;
	if (alder >= myndig) {
	    System.out.println ("Du er myndig");
	}
	else {
	    System.out.println ("Du er ikke myndig");
	}

	//Oppgave 1.2c)
	int inputAlder;
	Scanner input = new Scanner (System.in) ;
	System.out.print ("Hvor gammel er du? ");
	inputAlder = Integer.parseInt(input.nextLine ());
	if (inputAlder >=  myndig) {
	    System.out.println ("Du er myndig");
	}
	else {
	    System.out.println ("Du er ikke myndig");
	}
    }
}