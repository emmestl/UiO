/**Oppgave 3.5 programmet konverterer mellom 10-tallsystemet og det binaere tallsystemet, programmet kan ikke konvertere negative tall*/
import java.util.*;
public class MinOppgave3 {
    public static void main(String [] args){
	//Ide hentet fra Trix 3.5.2 (men jeg har utvidet programmet til aa inneholde arrays
	Scanner in = new Scanner (System.in);
	System.out.print ("Velg et tall du onsker aa konvertere fra: ");
	int tall10 = Integer.parseInt(in.nextLine());

	ArrayList<Integer> tall2 = new ArrayList<Integer>();
 	while ( tall10>0){
	    tall2.add(tall10%2);
	    tall10=tall10/2;
	   
      	}
	int [] binaereTallet = new int [tall2.size()];
	for(int i = tall2.size()-1, j=0; i>=0; i--, j++){
	    System.out.print(tall2.get(i));
	    binaereTallet[j]=tall2.get(i);
	}
	// System.out.println(Arrays.toString(binaereTallet));, for aa vaere sikkker paa at oppgaven er godkjent. Hvis programmet skal brukes videre kan det vaere praktisk at tallet er sortert i rikktig rekkefolge.
    }
}

	
	
