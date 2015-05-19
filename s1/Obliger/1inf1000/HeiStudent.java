/** Obligatorisk innlevering 1 - INF 1000*/


import java.util.Scanner ;
public class HeiStudent {
    public static void main(String [] args) {

	// Oppgave 1.1a) 	
	System.out.println ("Hei Student!");

	// Oppgave 1.1b)
	String navn = "Elsie" ;
	System.out.println ("Hei, " + navn);

	//Oppgave 1.1c)
	Scanner input1 = new Scanner (System.in) ;
	String brukerNavn;
	System.out.print ("Hei, hva heter du? ");
	brukerNavn = input1.nextLine ();
	System.out.println ("Hello, " + brukerNavn);

	//Oppgave 1.1d)
	int tall1 = 3;
	int tall2 = 4;
	System.out.println (tall1 + "+" + tall2+ "=" + (tall1 + tall2));

	//Oppgave 1.1e)
	Scanner input_1 = new Scanner (System.in);
	int tall_1;
	System.out.println ("velg det foerste tallet som skal summeres: ");
	tall_1 = Integer.parseInt(input_1.nextLine ());
	Scanner input_2 = new Scanner (System.in);
	int tall_2;
	System.out.println ("velg tall 2: ");
	tall_2 = Integer.parseInt(input_2.nextLine ());
	System.out.println ("Summen av tallene er: " + (tall_1 + tall_2));
	
	
    }
}



