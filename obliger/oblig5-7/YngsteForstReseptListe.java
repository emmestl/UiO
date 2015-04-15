public class YngsteForstReseptListe extends EnkelReseptListe {
    
    boolean settInn(Resept r) {
        if (siste == null) {
            siste = new Node (r);
            forste = siste;
        } else if (siste == forste) {
            forste = new Node (r);
            forste.next = siste;
        } else {
            Node n = new Node (r);
            n.next = forste;
            forste = n;
        }
        return true;
    }
    
}
