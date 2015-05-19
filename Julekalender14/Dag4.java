import java.util.*;
import java.io.*;

public class Dag4{
    public static void main(String [] args) throws Exception{
	File fil = new File ("kilma_data_blindern.txt");
	Scanner innFil = new Scanner (fil);
	ArrayList<String[]> filen = new ArrayList<>();
	double lavest = 0;
	String finalDato ="";
	System.out.println (Arrays.toString(dato));
	while (innFil.hasNextLine()){
	    filen.add(innFil.nextLine().trim().split("      "));
	}

	System.out.println (Arrays.toString(filen.get(0)));

	for(int i = 0; i < filen.size(); i++){
	    filen.get(i)[2]=filen.get(i)[2].replace(',' , '.');
	    filen.get(i)[0] = filen.get(i)[0].replace ("18700 ", "");
	    //dato = filen.get(i)[0].split("\.");
	    if (Double.parseDouble(filen.get(i)[2]) < lavest){
		if(filen.get(i)[0].substring(3,5).equals("12")){
		    lavest = Double.parseDouble(filen.get(i)[2]);
		    finalDato = filen.get(i)[0];
		}
	    }
	    // System.out.println (Arrays.toString(dato));
	}

	System.out.println (finalDato);
	System.out.println (lavest);
    }
}

	

