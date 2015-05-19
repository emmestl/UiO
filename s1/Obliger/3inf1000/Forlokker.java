/**Oppgave 3.2)*/

public class Forlokker {
    public static void main(String[]args){
	//Oppgave 3.2a)
	int sumPartall = 0;
	int sumOddetall = 0;
	/*tar ikke med 10 i summen for oppgaven spesifiserer at den onsker mellom 0 og 10 altsaa ikke 10*/
	for (int tall =0, tall2 =1; tall<10; tall+=2, tall2 +=2){
	    System.out.println(tall);
	    // Oppgave 3.2b)
	    sumPartall +=tall;
	    // Oppgave 3.2c)
	    sumOddetall += tall2;

	}
	System.out.println("Summen av partallene er " + sumPartall);
	System.out.println("Summen av oddetallene er " + sumOddetall);
    }

}

