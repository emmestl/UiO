import java.util.Iterator;
import java.lang.Iterable;
import java.lang.Comparable;


public class SortertEnkelListe<T extends Comparable & Lik> implements AbstraktSortertEnkelListe<T> {
    private Node minste;
    private Node storste;
    private int amount = 0;
    
    public boolean settInn(T t) {
        try {
        if (t == null) {
            return false;
        }
        if (t instanceof Comparable && t instanceof Lik){
            if (amount == 0){
                minste = new Node(t);
                storste = minste;
                amount ++;
                return true;
            }

            else if (amount == 1){
                if (t.compareTo(minste.objekt) < 0){
                    Node n = new Node (t);
                    n.next =  minste;
                    minste = n;
                    amount++;
                    return true;
                }
                else {
                    Node n = new Node (t);
                    minste.next= n;
                    storste = n;
                    amount ++;
                    return true;
                }
            }
            else {
                if (t.compareTo(minste.objekt) < 0){
                    Node n = new Node (t);
                    n.next = minste;
                    minste = n;
                    amount++;
                    return true;
                }
                Node temp1 = minste;
                Node temp2 = null;
                Comparable temp = (Comparable) minste.objekt;
                if (t.compareTo(temp) <= 0){
                    Node n = new Node(t);
                    n.next = minste;
                    minste = n;
                    amount++;
                    return true;
                }
                else{
                    while (t.compareTo(temp) > 0){
                        if (temp1.next == null){
                            Node n = new Node (t);
                            temp1.next = n;
                            storste = n;
                            amount++;
                            return true;
                        }
                        temp2 = temp1;
                        temp1 = temp1.next;
                        temp = (Comparable) temp1.objekt;
                    }
                    Node n = new Node (t);
                    temp2.next = n;
                    n.next = temp1;
                    amount++;
                    return true;
                }
            }
        }
        } catch (NullPointerException e) {
            System.out.println("Kan ikke sette inn " + t.toString());
        }
        return false;
    }
    
    public T finn(String nokkel) {
        Node temp = minste;
        for (int j = 0; j < amount; j++){
            if (temp == null || temp.objekt == null) {
                return null;
            }
            if (temp.objekt instanceof Lik){
                //Lik c = (Lik) temp.objekt;
                if (temp.objekt.samme(nokkel)){
                    return temp.objekt;
                }
            }
            temp = temp.next;
        }
        return null;
    }
    
    public Iterator<T> iterator() {
        return new Iterer<>();
    }
    
    private class Node {
        Node next;
        T objekt;
        
        Node(T t){
            objekt = t;
        }

    }
    
    class Iterer<T> implements Iterator<T>{
        private Node temp = minste;
        
        public boolean hasNext() {
            return temp != null;
        }
        
        public T next() {
            T temp1 = (T) temp.objekt;
            temp = temp.next;
            return temp1;
        }
        
        public void remove() {
        }

    }

}
