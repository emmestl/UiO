public class BlaResept extends Resept {

    public BlaResept(Legemiddel l, Lege le, Person e, int r) {
        super(l, le, e, r);
        this.pris = 0;
        type = "Blaa";
    }
    
    
}
