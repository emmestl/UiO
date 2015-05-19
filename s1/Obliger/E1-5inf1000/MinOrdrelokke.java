import java.util.Scanner;
class MinOrdrelokke {
    
    public static void printSum(Scanner in){
	System.out.println ("Skriv inn to tall (husk enter mellom dem): ");
	int tall1 = Integer.parseInt(in.nextLine());
	int tall2 = Integer.parseInt(in.nextLine());

	int sum = tall1 + tall2;
	
	System.out.println (tall1 + "+" + tall2 + "=" + sum);


    }

    public static void printHei (Scanner in){
	System.out.println ("Hva heter du?");
	String navn = in.nextLine();
	
	System.out.println ("Hei, " + navn);
    }
    
    public static void main(String [] args){
	Scanner in = new Scanner (System.in);
	int tall = 1;

	while (tall!=0){
	    System.out.println("Meny\n0. Avslutt\n1. Summen av to tall\n2. Hilsen");
	    tall = Integer.parseInt(in.nextLine());

	    if (tall == 1){
		printSum (in);
	    }
	    if (tall ==2 ){
		printHei (in);
	    }
	
	}
    }
}
