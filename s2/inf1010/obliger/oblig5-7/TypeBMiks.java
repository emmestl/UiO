public class TypeBMiks extends Legemiddel implements Mikstur {
    
    int mengde_cm3;
    
    public TypeBMiks(String navn, int pris, int vm, int mengde) {
        super(navn, pris, vm);
        this.mengde_cm3 = mengde;
        this.form = "mikstur";
        this.type = 'b';
    }
    
    public int mengde_cm3() {
        return this.mengde_cm3;
    }
    
    public int virkestoffPercm3() {
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
