public class TypeCPiller extends Legemiddel implements Piller {
    
    int nummerAvPiller;
    
    public TypeCPiller(String navn, int pris, int vm, int antall) {
        super(navn, pris, vm);
        this.nummerAvPiller = antall;
        this.form = "pille";
        this.type = 'c';
    }
    
    public int nummerAvPiller() {
        return this.nummerAvPiller;
    }
    
    public int virkestoffPerPille() {
        return this.virkestoff;
    }
    
}
