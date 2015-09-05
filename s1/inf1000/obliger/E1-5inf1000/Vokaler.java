import java.util.Scanner;
class Vokaler {
    public static void main(String  [] args){
	Scanner in = new Scanner (System.in);
	char[] vokaler = {'a','e','i','o','u','y'};
	System.out.println("Skriv inn et ord");
	String ord= in.nextLine();
	int antallVokaler =0;

	for (int i = 0; i<ord.length(); i++){
	    for (int j =0; j < vokaler.length; j++){
		if (ord.charAt(i) == vokaler[j]){
		    antallVokaler ++;
		}
	    }
	}
	System.out.println ("antall vokaler: " + antallVokaler);
    }
}

			
