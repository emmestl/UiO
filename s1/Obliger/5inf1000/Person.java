/** 
 * Lager et objekt person
 * en person har navn, alder, bosted og kanskje en mobil avhengig av alderen
 * @author Elsie Mestl
 * @version 21.10.14
 */
class Person {
    private String navn;
    private int alder;
    private String bosted;
    private Mobil mobil;

    /**
     * Gir setter inn navnet, alderen og bostedet til personen
     *
     * @param navn navnet til personen, er en String
     * @param bosted stedet hvor personen er bosatt
     * @param alder alderen til personen
     */
    void personInfo (String navn, int alder, String bosted){
	this.navn = navn;
	this.alder = alder;
	this.bosted = bosted;
    }
    /**
     * Gir personene en bobil
     * Helt grusom kode, mange parametere som ikke blir brukt flere gangenger. Helt h&aring;pl&oslash; &aring; lese
     * @param alder alderen til personen //ikke sikker på hvorfor den er med
     * @param mobil, gir personen en mobil
     * @param tlf merke p&aring; telefonen til personen 
     * @param tlfnr telefonnummert til personen
     */
    void mobil (int alder, Mobil mobil, String tlf, int tlfnr){
	mobil.mobilInfo(this.navn, tlf, tlfnr);
    }
}

    
