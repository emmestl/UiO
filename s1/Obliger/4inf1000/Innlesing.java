/** Oppgave 4.1 */

import java.util.Scanner;
import java.io.*;

public class Innlesing {
    public static void main(String [] args) throws Exception{

	String filnavn  = "winnie.txt";
	File  fil = new File(filnavn);
	Scanner innFil = new Scanner(fil);
	int antallWinnie =0;
	int antallValgteOrd =0;
	Scanner in = new Scanner (System.in);
	System.out.print ("Hvilket ord vil du soke etter? ");
	String ordFraBruker = in.nextLine();
	//Oppgave 4.1a,b,c)
	while (innFil.hasNextLine()){
	    String ord = innFil.nextLine();
	    if (ord.equalsIgnoreCase("Winnie-the-Pooh")){
		antallWinnie++;
	    }
	    if (ord.equalsIgnoreCase(ordFraBruker)){
		antallValgteOrd++;

	    }
	}
	System.out.println("Winnie-the-Pooh forekommer " + antallWinnie+ " ganger");
	System.out.println(ordFraBruker + " forkommer " + antallValgteOrd+ " ganger");
    }
}
