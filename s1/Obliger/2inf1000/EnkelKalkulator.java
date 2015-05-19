/**Oppgave 2.3 oblig 2 inf 1000 */
import java.util.Scanner;
public class EnkelKalkulator {
 
    static void plusse(int tall1, int tall2){
    	//Oppgave 2.3a)
	int sum = tall1 + tall2; 
	System.out.println (tall1+ "+"+ tall2 + "="+ sum);
	
    }
    static void minus(int tall1, int tall2) {
	//Oppgave 2.3b)
	int differance = tall1-tall2;
	System.out.println (tall1 + "-" + tall2 + "=" + differance);
    }

   static void gange(int tall1, int tall2){
	//Oppgave 2.3c)
	int produkt = tall1 * tall2;
	System.out.println (tall1+ "*"+ tall2+ "="+ produkt);
    }

    public  static void main(String [] args ){ //programmet begynner her
	Scanner in = new Scanner (System.in);
	System.out.println ("Skriv inn et heltall: ");
	int tall1 = Integer.parseInt(in.nextLine());
	System.out.println ("Skriv inn et annet heltall: ");
	int tall2 = Integer.parseInt(in.nextLine());
	
	/* henter inn metodene og utfører dem med parameterne som er gitt */
	plusse(tall1, tall2);
	minus(tall1, tall2);
	gange(tall1, tall2);
	
    }
}
