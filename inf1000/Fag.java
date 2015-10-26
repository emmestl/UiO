import java.util.*;

class Fag{
    private String fagKode;
    private HashMap<String, Student> studenter = new HashMap<>();
    
    Fag(String fagKode){
	this.fagKode = fagKode;
    }

    public void leggTilStudent(Student s){
	if(studenter.containsValue(s)){
	    System.out.println ("Studenten tar allerede faget"); 
	}
	else {
	    studenter.put(s.toString(), s);
	}
    }

    public String toString(){
	return fagKode;
    }

    public Collection<Student> hentStudenter(){
	return studenter.values();
    }

    public int hentAntall(){
	return studenter.values().size();
    }
}
