/**
 * Er en mobil
 * en mobil har en eier et merke og et nummer
 * @author Elsie Mestl
 * @version 21.10.14
 */
class Mobil {
    private String eier;
    private String tlfmerke;
    private int tlfnummer;

    /**
     * Gir mobilene en eier, telefonnummer og et merke
     *
     * @param eier eieren til telefonen
     * @param tlf merke til telefonen
     * @param tlfnr telefonnummeret
     */
    void mobilInfo (String eier, String tlf, int tlfnr){
	this.eier = eier;
	this.tlfmerke =tlf;
	this.tlfnummer=tlfnr;
	/*
	System.out.println (eier);
	System.out.println (tlf);
	System.out.println (tlfnr);*/	
    }
}
