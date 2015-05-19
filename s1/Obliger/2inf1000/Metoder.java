/** Oppgave 2.1 inf1000-oblig2*/
import java.util.Scanner;
public class Metoder {
    static void metodeMetode() {
	//Oppgave 2.1a)
	Scanner in = new Scanner (System.in);
	System.out.println ("Skriv inn navn: " );
	String navn = in.nextLine();
	System.out.println ("Skriv inn bosted: ");
	String bosted = in.nextLine();
	System.out.println ("Hei, " + navn + "! Du er fra " + bosted + ".");
	System.out.println (""); /*legger til en tom tekstlinje for aa faa 
				   melommrom mellom hver gang metoden kjores */
    }

    //Oppgave 2.1b)
    public static void main (String []args ){

	metodeMetode ();
	metodeMetode ();
	metodeMetode ();

    }
}
