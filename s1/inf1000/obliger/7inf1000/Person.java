import java.util.HashMap;

class Person {
    private HashMap<String, Dvd> dvder = new HashMap<>();
    private String navn;
    private HashMap <Person, HashMap<String, Dvd> > laaner = new HashMap <>();
    private HashMap <Dvd, Person> laantBort = new HashMap <>();

    Person (String navn){
	this.navn = navn;
    }

    public void leggTilDvd(Dvd dvd){
	dvder.put(dvd.toString(), dvd);
    }

    public String toString(){
	return navn;
    }

    public HashMap<String, Dvd> hentDvder(){
	return dvder;
    }
    
    public void leier(String dvd, Person laanerFra){
	if (!laaner.keySet().contains(laanerFra)){
	    HashMap <String , Dvd > midlertilig = new HashMap<>();
	    laaner.put(laanerFra, midlertilig);
	}
	laaner.get(laanerFra).put(dvd, laanerFra.hentDvder().get(dvd));
    }

    public void laanerBort(String dvd, Person person){
	laantBort.put(dvder.get(dvd), person);
	dvder.get(dvd).laan(person);
    }

    public HashMap<Dvd, Person> laantBort (){
	return laantBort;
    }

    public HashMap<Person, HashMap<String, Dvd>> visLaant (){
	return laaner;
    }

    public void leverTilbake(String tittel, Person eier){
	if(laaner.get(eier).keySet().size() ==1){
	    laaner.remove(eier);
	}
	else{
	    laaner.get(eier).remove(tittel);
	}
	eier.laantBort().remove(eier.hentDvder().get(tittel));
    }
}
