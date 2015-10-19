import java.util.*;
    
class Oppskrift{

    private String tittel;
    private ArrayList<String> oppskriftsLinjer;
    private ArrayList<String> ingredienser;

    public Oppskrift(String tittel){
	this.tittel = tittel;
	oppskriftsLinjer = new ArrayList<>();
	ingredienser = new ArrayList<>();
    }

    
    public void skrivUtOppskrift(){
	for(String linje: oppskriftsLinjer){
	    System.out.println (linje);
	}
    }

    public void skrivUtIngredienser(){
	for(String ingrediens: ingredienser){
	    System.out.println (ingrediens);
	}
    }

    public void leggTilIngrediens(String ingrediens){
	
	if(!ingredienser.contains(ingrediens)){
	    ingredienser.add(ingrediens);
	}
	
    }

    public void leggTilOppskriftsLinje(String oppskriftsLinje){

	for(String linje: oppskriftsLinjer){
	    if(oppskriftsLinje.equals(linje)){
		return;
	    }
	}

	oppskriftsLinjer.add(oppskriftsLinje);
    }

    
    public String toString(){
	return tittel;
    }
    
}
