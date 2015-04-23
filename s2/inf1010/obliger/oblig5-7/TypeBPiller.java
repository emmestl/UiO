public class TypeBPiller extends Legemiddel implements Piller {
    
    int nummerAvPiller;
    
    public TypeBPiller(String navn, int pris, int vm, int antall) {
        super(navn, pris, vm);
        this.nummerAvPiller = antall;
        this.form = "pille";
        this.type = 'b';
    }
    
    public int nummerAvPiller() {
        return this.nummerAvPiller;
    }
    
    public int virkestoffPerPille() {
        return this.virkestoff;
    }
    
    /**
     * Returner hvor vanedannende legemiddelet er
     * @return Integer
     */
    public int vanedannende() {
        return this.vane;
    }
    public void vanedannende(int v) {
        this.vane = v;
    }
    
}
