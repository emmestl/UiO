import java.lang.Comparable;
import java.util.ArrayList;

/**
 *
 * @author millemariehansen
 */
public class Lege implements Lik, Comparable {
    protected EldsteForstReseptListe legeResept = new EldsteForstReseptListe();
    protected String name;
    protected static ArrayList<String> names = new ArrayList<>();
    
    Lege(String name) {
        if (names.contains(name)) {
        } else {
            this.name = name;
            names.add(name);
        }
    }
    
    public void removeLege() {
        names.remove(this.name);
    }
    
    /**
     * Returns name of doctor
     * @return String
     */
    public String name() {
        return this.name;
    }
    public String toString() {
        return this.name;
    }
    
    public Boolean samme(String s) {
        if (name.equalsIgnoreCase(s)) {
            return true;
        } else {
            return false;
        }
    }
    
    public int compareTo(Object o) {
        Lege l = (Lege) o;
        String n = l.name();
        return name.compareTo(n);
    }
    public Resept finnResept(int rID) {
        return this.legeResept.finn(rID);
    }
    
    public boolean settInnResept(Resept r) {
        return this.legeResept.settInn(r);
    }
    
    public EldsteForstReseptListe legeResept() {
        return this.legeResept;
    }
}
