import java.util.Scanner;

public class Oppgave51 {
   
    public static int person(Scanner in, Person person){

	System.out.print("Navn: ");
	String navn = in.nextLine();
	System.out.print("Alder: ");
	int alder = Integer.parseInt(in.nextLine());
	System.out.print("Bosted: ");
	String bosted = in.nextLine();

	person.personInfo(navn, alder, bosted);
	return alder;
    }

    public static void main (String[] args){
	Scanner in = new Scanner (System.in);
	Mobil mobil =new Mobil();
	Person person = new Person();
	int alder = person(in, person);

	if (alder >14){
	    System.out.print("Mobilmerke: ");
	    String tlf = in.nextLine();
	    System.out.print ("Telefonnummer: ");
	    int tlfnr = Integer.parseInt(in.nextLine());
	    person.mobil(alder,mobil, tlf, tlfnr);
	
	}
    }
}
