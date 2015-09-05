/*' Oppgave 3.1) */

import java.util.Scanner;
public class SumTall {
    public static void main(String [] args){

	Scanner in = new Scanner (System.in);
	int tallFraBruker =1;
	int summen =0;
	System.out.println("Skriv inn forskjellige heltall for aa faa dem summert\nfor aa avslutte programmet skirv "0"");
	//Oppgave 3.1a)
	while (tallFraBruker !=0){
	    tallFraBruker = Integer.parseInt(in.nextLine()); //velger aa unnlate aa sporre bruker om nytt tall mellom hver gang fordi det er irriterende at det samme sporsmaalet dukker opp 1000000ganger
	    // Oppgave 3.1b)
	    summen += tallFraBruker;
	}
	System.out.println(summen);

    }
}
