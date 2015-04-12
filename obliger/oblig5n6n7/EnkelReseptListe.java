import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 *
 * @author millemariehansen
 */
abstract class EnkelReseptListe implements Iterable<Resept> {
    protected Node forste;
    protected Node siste;
    
    abstract boolean settInn(Resept r);
    
    public Resept finn(int nr) {
        if (forste == null || siste == null) {
            return null;
        }
        Node temp = forste;
        if (forste == siste) {
            if (temp.r.ID == nr) {
                return temp.r;
            }
        }
        if (forste.next == siste) {
            if (temp.r.ID == nr) {
                return temp.r;
            } else if (temp.next.r.ID == nr) {
                return temp.next.r;
            }
        }
        while (temp != null){
            if (temp.r.ID == nr) {
                return temp.r;
            }
            temp = temp.next;
        }
        throw new NoSuchElementException();
    }
    
    public Iterator<Resept> iterator(){
        return new ListeIterator();
    }
        
    protected class ListeIterator implements Iterator{
        private Node temp = forste;
        
        public boolean hasNext() {
            return temp != null;
        }
        
        public Resept next() {
            Resept temp1 = temp.r;
            temp = temp.next;
            return temp1;
        }
        
        public void remove() {
        }

    }
    
    protected class Node {
        Node next;
        Resept r;
        
        Node(Resept r) {
            this.r = r;
        }
    }
}
