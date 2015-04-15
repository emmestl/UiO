/**
 *
 * @author millemariehansen
 */
public class Person {
    private String name;
    private String fnum; //fodselnummer
    // Dette er en String fordi det ikke ga mening aa lagre det som Long
    // Du mistet forste null i nummeret: 09068265393
    private String adresse;
    private int postnr;
    private int ID;
    private static int amount;
    
    private YngsteForstReseptListe personResept = new YngsteForstReseptListe();
    
    /**
     * Set all variables
     * @param n name
     * @param f f&oslash;dselnummer
     * @param a adress
     * @param p post number
     */
    Person(String n, String f, String a, int p) {
        this.name = n;
        this.fnum = f;
        this.adresse = a;
        this.postnr = p;
        this.ID = amount;
        amount++;
    }
    
    /**
     * Return name of person
     * @return String
     */
    public String name() {
        return this.name;
    }
    
    public String toString () {
        return this.name;
    }
    
    /**
     * Returner f&oslash;dselnummer til person
     * @return Integer
     */
    public String fodselnummer() {
        return this.fnum;
    }
    
    /**
     * Return address of person
     * @return String
     */
    public String adresse() {
        return this.adresse;
    }
    
    /**
     * Return post number of person
     * @return Integer
     */
    public int postnummer() {
        return this.postnr;
    }
    
    /**
     * Return unique ID of person
     * @return Integer
     */
    public int ID() {
        return this.ID;
    }
    
    public Resept finnResept(int rID) {
        return this.personResept.finn(rID);
    }
    
    public boolean settInnResept(Resept r) {
        return this.personResept.settInn(r);
    }
    
    public YngsteForstReseptListe personResept() {
        return this.personResept;
    }
}
