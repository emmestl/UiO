import java.util.Scanner;
import java.io.*;

class PrinsessaOgErten {
    static int forsteBokstav(String ord, char bokstav) throws Exception{
	int teller = 0;

	if (bokstav == Character.toLowerCase(ord.charAt(0))){
	    teller = 1;
	}
		
	return teller;
    }

    public static void main (String [] args) throws Exception{
        String filen = "princessandthepea.txt";
	File fil = new File (filen);
	Scanner minFil = new Scanner(fil);

        int lengdeOrd;
        String linje;
        int antallOrdLengde4=0;
	char bokstav = 'a';
	int ordMedA=0;

	
        while (minFil.hasNextLine()){
            linje = minFil.nextLine();
            lengdeOrd = linje.length();
            if (lengdeOrd == 4){
		antallOrdLengde4++;
            }
	    ordMedA += forsteBokstav(linje, bokstav);

	}
	System.out.println ("Antall ord med lengde 4: " + antallOrdLengde4);
	System.out.println ("Antall ord hvor 'a' er forbokstaven: " + ordMedA);
    }
}
