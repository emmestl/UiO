/** Regner ut omkrets og areal til et rektangel */

import java.util.Scanner;
public class Oppgave1_1_6 {
    public static void main(String [] args) {

	Scanner input = new Scanner (System.in);
	System.out.print ("lengden på rektangelet (i meter): ");
	double lengde = Double.parseDouble(input.nextLine ()); //får input om lengden på hva lengden i det ønskete rektangelet er
	System.out.print ("bredden på rektangelet (i meter): ");
	double bredde = Double.parseDouble (input.nextLine ()); //får input om hva bredden på det ønskete rektangelet er

	double omkrets =(bredde* 2) + (lengde*2); //regner ut omkrets utifra input
	double areal = bredde*lengde; // regner ut arealet utifra input
	
	System.out.println ("Firkanten har areal = " + areal + " m². Og omkrets = " + omkrets + " m");
	
    }
}

	
