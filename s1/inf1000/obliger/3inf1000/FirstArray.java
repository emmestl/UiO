/**oppgave 3.3*/

import java.util.Scanner;
public class FirstArray {
    public static void main(String[]args){

	Scanner in = new Scanner (System.in);
	//Oppgave 3.3a,b)
	int []meningslostArray=new int[4];
	for (int i=0; i<4; i++){
	    meningslostArray[i]=i;
	}
	//Oppgave 3.3c)
	meningslostArray[0]=1337;
	meningslostArray[3]=1337;
	System.out.println(meningslostArray[0]);
	
	//Oppgave 3.3d)
	String [] meningslostArray2 = new String[4];
	for (int j=0; j<4; j++){
	    System.out.print("Skriv inn et navn: ");
	    meningslostArray2[j]=in.nextLine();
	}
    }
}
 
