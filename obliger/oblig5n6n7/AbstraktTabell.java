import java.lang.Iterable;

/**
 *
 * @author millemariehansen
 * @param <T>
 */
public interface AbstraktTabell<T> extends Iterable<T>{
    
    /**
     * Sett in element t inn p&aring; indeks nummer i
     * @param t element av typen T
     * @param i int indeks
     * @return boolean true hvis den ble satt inn
     */
    public boolean settInn(T t, int i);
    
    /**
     * Finn element p&aring; indeks i og returner
     * @param i int indeks
     * @return type T p&aring; indeks i
     */
    public T finn(int i);
}
