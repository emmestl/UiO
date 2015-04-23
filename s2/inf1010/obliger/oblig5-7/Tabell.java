import java.util.Iterator;

/**
 *
 * @author millemariehansen
 * @param <T>
 */
public class Tabell<T> implements AbstraktTabell<T> {
    private T[] tabell;
    
    /**
     * Lag en tabell med plass til l objekter av typen T
     * @param l lengden til tabellen
     */
    Tabell(int l) {
        tabell = (T[])new Object[l];
    }
    
    public boolean settInn(T t, int i) {
        if (i < tabell.length && i >= 0 && tabell[i] == null) {
            tabell[i] = t;
            return true;
        }
        return false;
    }
    
    public T finn(int i) {
        if (i >= 0 && i < tabell.length) {
            T t = tabell[i];
            return t;
        }
        return null;
    }
    
    public Iterator<T> iterator() {
        return new TabellIterator<>();
    }
    
    
    
    class TabellIterator<T> implements Iterator<T>{
        private int teller = 0;
        
        public boolean hasNext() {
            if (teller == tabell.length) {
                return false;
            }
            return tabell[teller] != null;
        }
        
        public T next() {
            T t = (T) tabell[teller];
            teller++;
            return t;
        }
        
        public void remove() {
        }

    }
}
