import java.util.Scanner;
import java.util.Arrays;

class ArrayLek {
    public static int[] reverserArray (int[] heltall){
	int [] motsatt = new int[heltall.length];
	for (int i =0, j=heltall.length-1; i<heltall.length; i++, j--){
	    motsatt[i] = heltall[j];
	}
	return motsatt;
    }

    public static void storsteTall (int[] heltall){
	int storsteTall = heltall[0];
	for (int i = 1; i<heltall.length; i++){
	    if (storsteTall< heltall[i]){
		storsteTall = heltall[i];
	    }
	}
	System.out.println("Det storste tallet er " + storsteTall);
    }

    public static void main (String [] args){
	Scanner in = new Scanner(System.in);
	int [] heltall = new int[5];
	int i =0;
	System.out.println ("Skriv inn 5 heltall, husk aa trykke enter mellom hver");

	while (i< heltall.length){
	    heltall[i] = Integer.parseInt(in.nextLine());
	    i++;
	}

	storsteTall (heltall);
	int[] motsatt = reverserArray(heltall);
	System.out.println (Arrays.toString (motsatt));

    }
}
