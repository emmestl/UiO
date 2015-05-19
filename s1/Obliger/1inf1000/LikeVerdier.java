/** Obligatorisk innlevering 1 - INF100 */

import java.util.Scanner;
public class LikeVerdier {
    public static void main( String [] args) {
	
	// Oppgave 1.4a)

	int c = 1;
	int d = 2;

	//Oppgave 1.4b)
	
	if (c == d) {
	    System.out.println ("c og d er like");
	}
	else {
	    System.out.println ("c er ikke lik d");
	}

	//oppgave 1.4c)
	
	Scanner input = new Scanner (System.in);
	System.out.print ("Velg en heltallig verdig for c: ");
	c = Integer.parseInt(input.nextLine ());
	
	System.out.print ("Velg en heltallig verdi for d: ");
	d = Integer.parseInt(input.nextLine ());

	if (c == d) {
	    System.out.println ("c og d er like");
	}
	else {
	    System.out.println ("c er ikke lik d");
	}
    }
}

	