import java.util.Iterator;


public class EldsteForstReseptListe extends EnkelReseptListe {
    
    boolean settInn(Resept r) {
        if (forste == null) {
            forste = new Node (r);
            siste = forste;
        } else if (forste == siste) {
            forste.next = new Node (r);
            siste = forste.next;
        } else {
            Node n = new Node (r);
            siste.next = n;
            siste = n;
        }
        return true;
    }
    
    
}
