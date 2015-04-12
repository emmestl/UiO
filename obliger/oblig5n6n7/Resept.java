/**
 *
 * @author millemariehansen
 */
public class Resept {
    Legemiddel legemiddel;
    Lege lege;
    Person eier;
    String type;
    int reit;
    int pris;
    int ID;
    static int amount = 0;
    
    /**
     * Set all variables
     * @param l legemiddel
     * @param le lege
     * @param e eier av resept
     * @param p pris
     */
    Resept(Legemiddel l, Lege le, Person e, int r){
        this.legemiddel = l;
        this.lege = le;
        this.eier = e;
        this.reit = r;
        this.pris = l.pris();
        this.ID = amount;
        amount++;
    }
    
    /**
     * Returner unik ID til resept
     * @return Ingeger
     */
    public int ID(){
        return this.ID;
    }
    
    public String toString() {
        return this.ID + "";
    }
    
    /**
     * Returner pris av legemiddel til resept
     * @return Integer
     */
    public int pris(){
        return this.pris;
    }
    
    /**
     * Returner nummer av resepter i hele programmet
     * @return Integer
     */
    public int amount() {
        return this.amount;
    }
    
    /**
     * Returner legemiddelet som resepten refererer til
     * @return Legemiddel object
     */
    public Legemiddel legemiddel() {
        return this.legemiddel;
    }
    
    /**
     * Returner lege som utga resepten
     * @return Lege object
     */
    public Lege lege() {
        return this.lege;
    }
    
    /**
     * Returner eier av recepten
     * @return Person object
     */
    public Person eier() {
        return this.eier;
    }
    
    public int reit(){
        return reit;
    }
    
    public void bruk() {
        reit--;
    }
    
    public String type() {
        return this.type;
    }
}
