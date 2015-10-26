import java.util.*;
import java.io.*;

class StudentSystem{

    private HashMap<String, Fag> fag = new HashMap<>();
    private HashMap<String, Student> studenter = new HashMap<>();

    public void lesFil(String filnavn) throws Exception{
	Scanner fil = new Scanner(new File(filnavn));
	Fag emne = null;
	String linje;

	while(fil.hasNextLine()){
	    linje = fil.nextLine();

	    if(linje.substring(0, 1).equals("*")){
		//FAG
		linje = linje.substring(1, linje.length());
		
		if(finnFag(linje) == null){
		    /* Fag f = new Fag(linje)
		       fag.put(linje, f);

		       Dette er det samme som linjen under
		    */
		    fag.put(linje, new Fag(linje));
		}

		emne = finnFag(linje);
	    }
	    else {
		//STUDENT

		if(finnStudent(linje) == null){
		    studenter.put(linje, new Student(linje));
		}

		//legge Student til fag og visa versa
		emne.leggTilStudent(studenter.get(linje));
		(studenter.get(linje)).leggTilFag(emne);

	    }
	}
    }


    public Fag finnFag(String fagKode){
	if(fag.containsKey(fagKode)){
	    return fag.get(fagKode);
	}
	return null;
    }

    public Student finnStudent(String student){
	if(studenter.containsKey(student)){
	    return studenter.get(student);
	}
	return null;
    }

    
    public Student studentFlestFag(){
	Student max = null;

	for(Student s: studenter.values()){
	    if(max == null){
		max = s;
	    }
	    else if(max.hentAntall() < s.hentAntall()){
		max = s;
	    }
	}

	return max;
    }

    public Fag fagFlestStudenter(){
	Fag max = null ;

	for(Fag f: fag.values()){
	    if(max == null){
		max = f;
	    }
	    else if(max.hentAntall() < f.hentAntall()){
		max = f;
	    }
	}

	return max;
    }
    
    
    public void skrivTilFil(String filnavn) throws Exception{
	PrintWriter pw = new PrintWriter(filnavn);

	for(Fag f: fag.values()){
	    pw.println("*" + f.toString());

	    Collection<Student> fStud = f.hentStudenter();
	    
	    for(Student s: fStud){
		pw.println(s.toString());
	    }
	}

	pw.close();
    }
}
