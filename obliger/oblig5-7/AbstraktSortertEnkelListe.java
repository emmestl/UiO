import java.util.*;
/**
 *
 * @author millemariehansen
 * @param <T>
 */
public interface AbstraktSortertEnkelListe<T extends Comparable & Lik>  extends Iterable<T>{
    
    /**
     * setter inn et objekt T i sortert rekkef&oslash;lge 
     * @param t objektet som settes inn
     * @return returnerer sann hvis objektet er satt inn
     */
    public boolean settInn(T t);
    
    /**
     * finner et objekt basert p&aring; en String n&oslash;kkel
     * @param nokkel Typen string
     * @return returnerer objektet med gitt n&oslash;kkel
     */
    public T finn(String nokkel);
    
}
