import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

class Bilreg{
    public static void main(String[] args){
	Scanner term = new Scanner(System.in);
	String filNavn;
	File fil;
	Scanner innFil;
	String linje;

	ArrayList<Bil>biler = new ArrayList<Bil>();

	System.out.println("Hva heter filen med bilene? ");
	filNavn = term.nextLine();
    
	try{
	    fil = new File(filNavn);
	    innFil = new Scanner (fil);
    
	    while (innFil.hasNextLine()){
		linje = innFil.nextLine();
		String[] delt = linje.split(" ");
		//System.out.println(delt[0]);
		if (delt[0].contains("FOSSIL")){
		    if (delt[0].contains("PERSON")){
			biler.add(new Personbil(Integer.parseInt(delt[3]), Double.parseDouble(delt[2]), delt[1]));
		    }
		    else{
			biler.add(new Fossilbil(Double.parseDouble(delt[2]), delt[1]));
		    }
		}
		else if(delt[0].contains("LAST")){
		    biler.add(new Lastebil(Double.parseDouble(delt[3]), Double.parseDouble(delt[2]), delt[1]));
		}

		else if (delt[0].equalsIgnoreCase("bil")){
		    biler.add(new Bil(delt[1]));
		}
		else if(delt[0].equalsIgnoreCase("el")){
		    biler.add(new Elbil(Integer.parseInt(delt[2]), delt[1]));
		}
	    }
	}
	catch(FileNotFoundException e){
	    System.out.println ("Fant ikke filen");
	    e.printStackTrace();
	}
	System.out.println("RegNr:     AntSeter: ");
	for (Bil b : biler){
	    if (b instanceof Personbil){
		Personbil temp = (Personbil) b;
		System.out.println(b.regNr + "         " + temp.antallPlasser);
	    }
	}
    }
}
