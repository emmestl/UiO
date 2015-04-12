public class TypeAMiks extends Legemiddel implements Mikstur {
    
    int mengde_cm3;
    
    public TypeAMiks(String navn, int pris, int vm, int mengde) {
        super(navn, pris, vm);
        this.mengde_cm3 = mengde;
        this.form = "mikstur";
        this.type = 'a';
    }
    
    public int mengde_cm3() {
        return this.mengde_cm3;
    }
    
    
    public int virkestoffPercm3() {
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
