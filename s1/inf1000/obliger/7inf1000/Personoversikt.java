import java.util.HashMap;

public class Personoversikt {
    private HashMap<String, Person> personArkiv = new HashMap<>();

    public void leggTilPerson(Person person){
	personArkiv.put(person.toString() , person);
    }
    
    public Person personOversikt(String navn){
	Person midlertilig = personArkiv.get(navn);
	if (midlertilig == null){
	    System.out.println("Denne personen finnes ikke");
	}
	return midlertilig;
    }

    public HashMap<String, Person> hashMap(){
	return personArkiv;
    }
}
