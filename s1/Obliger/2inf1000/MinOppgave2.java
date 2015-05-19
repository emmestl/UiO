/**Oppgave 2.5 olbig 2 inf1000
Programmet er en utvideles av kalkulatoren som jeg lagde i Oppgave 2.3 (EnkelKalkulator. Dele funksjonen er lagt inn og programmet fortsetter aa kjore frem til det blir fortalt at det skal stoppe. */

import java.util.Scanner;
public class MinOppgave2 {

    static void plusse(int tall1, int tall2){ //Samme som i Oppgave 2.3
	int sum = tall1 + tall2; 
	System.out.println (tall1+ "+"+ tall2 + "="+ sum);
    }

    static void minus(int tall1, int tall2) { //Samme som i Oppgave 2.3
	int differance = tall1-tall2;
	System.out.println (tall1 + "-" + tall2 + "=" + differance);
	}

    static void gange(int tall1, int tall2){	// Samme som i Oppgave 2.3
	int produkt = tall1 * tall2;
	System.out.println (tall1+ "*"+ tall2+ "="+ produkt);
    }

    public static String  dele(int tallInput1, int tallInput2, Scanner in){ //ny, parameterne har andre navn enn de som blir satt inn.
	/* siden man kan risikere at brukeren skriver inn et tall som skal deles paa null maa det i programmet finnes et form for sikkerhets nett som passer paa at dette ikke skjer. Derfor har jeg valgt aa lage en metode som returnerer en verdi slik at hvis det skulle skje at brukeren skriver inn noe som skal deles paa null at vedkommende faar beskjed at dette ikke gaar og kan dermed velge om han vil velge et annet tall eller avslutte programmet. */

	String returnValue = "hei"; //tilfeldig retur verdi, uviktig hva det er 
	if (tallInput2 == 0){ //hvis parameter2 = 0 er opperasjonen ikke lovlig og det må skje en endring for at ikke programmet skal krasje
	    System.out.println("Du kan ikke dele paa 0, venligst velg et annet tall,\nevt trykk e hvis du onsker aa avslutte: ");
	    String  input = (in.nextLine ());
	    
	    if (input.equals("e")){
		returnValue = "e"; //dette er grunnen for at det trenktes en return value. 
	    }
	    else {
		tallInput2 =Integer.parseInt(input);
	    }
	    
	}
	if (tallInput2 !=0){	// hvis ingenting er logisk feil.
	    double tall1 = (double) tallInput1; // slik at man faar ordentlige svar og ikke bare avrundinger.
	    double tall2 = (double) tallInput2;// samme gjelder her
	    double divisjon = tall1 / tall2 ;
	    System.out.println (tall1 + "/" + tall2 +"=" + divisjon);
	} 
	return returnValue; //sendes tilbake til main metoden, er kun vesntlig hvis brukeren onkser aa avslutte programmet, da er den lik "e".
    }
	
    public static void main(String [] args ) {
	Scanner in = new Scanner (System.in);
	int x=1; //deklareres saann at while-loopen blir gyldig. Verdien endres aldri saa programmet er en evig loop med mindre brukeren velger aa avslutte.
	while (x==1){
	    System.out.println ("Velg hvilken opperasjon du onsker aa utfore");
	    System.out.println ("Velg bokstaven som representerer onsket ditt:");
	    System.out.println ("a. addere (+)\nb. subtrahere (-)\nc. multiplisere (*)\nd. dividere (/)\ne. avslutte programmet");
	    String opperasjon = in.nextLine ();
	    if (opperasjon.equals("e")){ // hvis brukeren har tastet inn "e" avbrytes loopen og programmet stopper.
		break;
	      }
	    System.out.println ("Skriv inn det foerste  heltallet: ");
	    int tall1 = Integer.parseInt(in.nextLine());
	    System.out.println ("Skriv inn det andre heltallet: ");
	    int tall2 = Integer.parseInt(in.nextLine());

	    /* under blir en metodet utfort avhengig av hva brukeren skrev inn tidligere */ 
	    if (opperasjon.equals("a")){
		plusse(tall1, tall2);
	    }
	    if (opperasjon.equals("b")){
		minus(tall1, tall2);
	    }
	    if (opperasjon.equals("c")){
		gange(tall1, tall2);
	    }
	    if (opperasjon.equals("d")){
		opperasjon = dele(tall1, tall2,in);
	    }
	    if (opperasjon.equals("e")){ //denne blir kun utfort hvis brukeren provde aa dele paa 0 i metoden "dele" og saa trykket "e" for aa avslutte. 
		break;
	    }


	}
    }
}
