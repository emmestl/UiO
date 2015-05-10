public class Fastlege extends Lege implements Kommuneavtale{
    private int avtalenummer;

    public Fastlege(String n, int nr) {
        super(n);
        avtalenummer = nr;
    }
    
    public int avtalenummer() {
        return this.avtalenummer;
    }
    
}
