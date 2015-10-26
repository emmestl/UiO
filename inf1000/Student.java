import java.util.*;
class Student{
    private String navn;
    private HashMap<String, Fag> fag = new HashMap<>();

    Student(String navn){
	this.navn = navn;
    }

    public void leggTilFag(Fag f){
	if(fag.containsValue(f)){
	    System.out.println ("Studenten tar allerede faget");
	}
	else {
	    fag.put(f.toString(), f);
	}
    }

    public String toString(){
	return navn;
    }

    public int hentAntall(){
	return fag.values().size();
    }
}
