/**Oppgave 4.5 Programmet finner ut hvor mange partall det er i en liste med heltall*/
import java.util.Scanner;
import java.io.*;

public class MinOppgave4 {
    public static int teller (int linje ){
	if (linje %2 ==0){
	    return 1;
	}
	return 0;
    }

    public static void main (String [] args) throws Exception{
	String filNavn = "minFil.txt";
	File fil = new File (filNavn);
	Scanner filen = new Scanner(fil);
	int i =0;
	int antallPartall =0;

	while (filen.hasNextLine()){
	    int linje = Integer.parseInt(filen.nextLine());
	    antallPartall += teller(linje);
	    i ++;
	}
	System.out.println (antallPartall + " av " + i +" tall er partall");
    }
}
