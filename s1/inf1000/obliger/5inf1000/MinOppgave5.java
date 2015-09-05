/** Oppgaven 5.5, oppgaven er en kaffetrakter som lager kaffe*/
import java.util.Scanner;

class MinOppgave5 {
    
    public static void main(String [] args){
	Scanner in = new Scanner (System.in);
	Vann vann = new Vann ();
	Kaffepulver kaffepulver = new Kaffepulver ();
	Kaffe kaffe = new Kaffe ();
	
	System.out.print ("Fyll paa vann (i liter): ");
	vann.fyllPaaVann(Double.parseDouble(in.nextLine()));
	
	System.out.print ("Fyll paa kaffepulver (i skjeer): ");
	kaffepulver.fyllPaaKaffe (Double.parseDouble(in.nextLine()));
	
	kaffe.kaffe(vann.kaffeVann(), kaffepulver.pulverIkaffe ());
	
	System.out.println ("Du har laget " + kaffe.hentKaffe() + "l " + kaffe.hentKaffeStyrke() + "kaffe.");

	
    }

}
