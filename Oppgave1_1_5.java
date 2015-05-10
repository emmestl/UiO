/** lager en pyramide formet av bokstaver*/

import java.util.Scanner;
public class Oppgave1_1_5 {
    public static void main(String [] args) {
	
	System.out.println ("Vil du lage din egen pyramide som ser slik ut: ");

	System.out.println ("    a");
	System.out.println ("   a a" );
	System.out.println ("  a b a");
	System.out.println (" a b b a");
	System.out.println ("a b c b a");
	
	Scanner input = new Scanner (System.in);
	System.out.println ("velg symbolet du ønsker skal være toppen av pyramiden: ");
	String linje1 = input.nextLine () ;

	System.out.println ("velg de neste 2, obs! husk mellomrom mellom dem: ");
	String linje2 = input.nextLine ();
	
	System.out.println ("Og nå 3: ");
	String linje3 = input.nextLine ();

	System.out.println ("velg de neste 4 symbolene til pyramiden: ");
	String linje4 = input.nextLine ();

	System.out.println ("nå velg de siste 5 symbolene: ");
	String linje5 = input.nextLine ();

	System.out.println ("     " + linje1);
	System.out.println ("    " + linje2);
	System.out.println ("   " + linje3);
	System.out.println ("  " + linje4);
	System.out.println (" " + linje5);

	System.out.println ("Gratulerer du har laget din egen pryramide!" );
    }
}
