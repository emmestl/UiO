public class TypeCMiks extends Legemiddel implements Mikstur {
    
    int mengde_cm3;
    
    public TypeCMiks(String navn, int pris, int vm, int mengde) {
        super(navn, pris, vm);
        this.mengde_cm3 = mengde;
        this.form = "mikstur";
        this.type = 'c';
    }
    
    public int mengde_cm3() {
        return this.mengde_cm3;
    }
    
    public int virkestoffPercm3() {
        return this.virkestoff;
    }
    
}
