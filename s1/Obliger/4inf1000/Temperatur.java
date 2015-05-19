/**Oppgave 4.2 */

import java.util.Scanner;
import java.io.*;

public class Temperatur {
    static double gjennomsnittsTemperatur(int [] gjnTmpMnd) throws Exception {
	int totalTemp =0; //samler temperaturen for hver maaned
	for (int i=0; i<gjnTmpMnd.length; i++){
	    totalTemp += gjnTmpMnd[i];
	}
	double gjennomsnittsTemp = 1.0*totalTemp/gjnTmpMnd.length;
	return gjennomsnittsTemp;
    }
    public static void main (String []args) throws Exception {
	
	String filNavn = "temperatur.txt";
	File fil = new File(filNavn);
	Scanner inFil = new Scanner (fil);
	int [] gjnTmpMnd= new int[12]; // forkortellse for gjennomsnittsTemperaturPerMaaned
	int linjeTemp;
	int i =0;
 
	// Oppgave 4.2a)
	while (inFil.hasNextLine()){
	    linjeTemp = Integer.parseInt(inFil.nextLine());
	    gjnTmpMnd [i]= linjeTemp;
	    // System.out.println (gjnTmpMnd[i]);
	    i++;
	}
	double gjennomsnittsTemp= gjennomsnittsTemperatur (gjnTmpMnd);
	System.out.println("Gjennomsnittstemperaturen er " + gjennomsnittsTemp);
	
	
    }
}


	
