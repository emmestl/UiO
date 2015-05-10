import java.util.*;
/**
 *
 * @author millemariehansen
 */
public class Legemiddel {
    String navn;
    int ID;
    int pris;
    int virkestoff;
    static int amount = 0;
    String form;
    char type;
    int narkotisk = 0;
    int vane = 0;
    
    /**
     * Construct a new legemiddel
     * @param navn name of legemiddel
     * @param pris price of legemiddel
     * @param virkestoff amount of virkestoff
     */
    Legemiddel (String navn, int pris, int virkestoff) {
        this.navn = navn;
        this.pris = pris;
        this.ID = amount;
        this.virkestoff = virkestoff;
        amount++;
    }
    
    /**
     * Return name of object
     * @return String name
     */
    public String navn() {
        return this.navn;
    }
    
    public String toString() {
        return this.navn;
    }
    
    /**
     * Return unique ID number
     * @return Integer
     */
    public int ID() {
        return this.ID;
    }
    
    /**
     * Return price of object
     * @return Integer
     */
    public int pris() {
        return this.pris;
    }
    
    /**
     * Return amount of object in entire program
     * @return Integer
     */
    public int amount() {
        return this.amount;
    }
    
    /**
     * Return amount of virkestoff per mg
     * @return Integer
     */
    public int virkestoffMg(){
        return this.virkestoff;
    }
    
    public String form() {
        return this.form;
    }
    public char type() {
        return this.type;
    }
    public int narkotisk() {
        return this.narkotisk;
    }
    public int vanedannende() {
        return this.vane;
    }
}
