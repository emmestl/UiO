import java.util.Scanner;
class Oppgave06 {

    public static void main (String [] args){
	Person person = new Person ();
	Scanner in = new Scanner (System.in);
	System.out.print ("Skriv inn navn: ");
	String navn = in.nextLine();
	System.out.print ("Skriv inn alder: ");
	int alder = Integer.parseInt(in.nextLine());

	person.personInfo(navn, alder);
	Bil bil = new Bil ();

	
	if (alder >= 18){

	    System.out.println("Skiltnummer: ");
	    String skiltnummer = in.nextLine();
	    person.giBil(skiltnummer, bil);
	}
    }

}
