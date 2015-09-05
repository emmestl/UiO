import java.util.Scanner;
/*Oppgave E.1*/
class Rekkefolge {
    public static void main (String [] args){
	System.out.println("Skriv inn tre tall (obs trykk enter mellom hver): ");
	Scanner in = new Scanner (System.in);
	int[] tall= new int[3];
	int tallFraBruker;
	for (int i =0; i<3; i++){
	    tallFraBruker = Integer.parseInt(in.nextLine());
	    tall[i]= tallFraBruker;
	}
	
	if (tall[0] < tall [1] && tall[1]< tall[2]){
	    System.out.println ("Stigende");
	}
	else if (tall[0]>tall [1] && tall[1]>tall[2]){
	    System.out.println ("Synkende");
	}
	else {
	    System.out.println ("Ingen");
	}
    }
}









