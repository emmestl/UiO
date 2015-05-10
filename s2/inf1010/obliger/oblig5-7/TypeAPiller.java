public class TypeAPiller extends Legemiddel implements Piller {
    
    int nummerAvPiller;
    
    public TypeAPiller(String navn, int pris, int vm, int antall) {
        super(navn, pris, vm);
        this.nummerAvPiller = antall;
        this.form = "pille";
        this.type = 'a';
    }
    
    public int nummerAvPiller() {
        return this.nummerAvPiller;
    }
    
    public int virkestoffPerPille() {
        return this.virkestoff;
    }
    
    /**
     * Returnerer hvor narkotisk legemiddelet er
     * @return Integer
     */
    public int narkotisk() {
        return this.narkotisk;
    }
    public void narkotisk(int n) {
        this.narkotisk = n;
    }
}
