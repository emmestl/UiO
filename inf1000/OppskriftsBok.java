import java.util.*;
import java.io.*;

class OppskriftsBok{

    HashMap<String, Oppskrift> oppskrifter;

    public OppskriftsBok(String filnavn) throws Exception{
	oppskrifter = new HashMap<>();
	lesInnOppskrifter(filnavn);
    }


    private void lesInnOppskrifter(String filnavn) throws Exception{
	Scanner fil = new Scanner(new File(filnavn));
	String linje;
	String tittelNavn = "";
	boolean tittel = false;
	boolean oppskrift = false;
	
	while(fil.hasNextLine()){
	    linje = fil.nextLine();

	    if(linje.equals("Tittel:")){
		tittel = true;
		oppskrift = false;
	    }

	    else if(tittel){
		oppskrifter.put(linje, new Oppskrift(linje));
		tittelNavn = linje;
		tittel = false;
	    }

	    else if(linje.equals("Oppskrift:")){
		oppskrift = true;
	    }

	    else if(oppskrift){
		oppskrifter.get(tittelNavn).leggTilOppskriftsLinje(linje);
	    }

	    else{
		oppskrifter.get(tittelNavn).leggTilIngrediens(linje);
	    }
	    
	}
	

    }


    public void skrivUtAlleOppskrifter(){
	for(Oppskrift o: oppskrifter.values()){
	    System.out.println (o);
	    o.skrivUtIngredienser();
	    o.skrivUtOppskrift();
	    System.out.println ();
	}
    }

    public boolean finnesOppskrift(String oppskriftsTittel){
	return oppskrifter.containsKey(oppskriftsTittel);
    }

    public void skrivUtOppskrift(String oppskriftsTittel){
	if(finnesOppskrift(oppskriftsTittel)){
	    System.out.println (oppskriftsTittel);
	    Oppskrift o = oppskrifter.get(oppskriftsTittel);
	    o.skrivUtIngredienser();
	    o.skrivUtOppskrift();
	}
    }

    
}
