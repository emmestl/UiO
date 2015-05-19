class Bil { 
    private String nummerskilt;
    private String eier;
    
    void lagreInfo(String navn, String skiltnummer){
	nummerskilt = skiltnummer;
	eier = navn;
    }

    String hentNummerskilt(){
	return nummerskilt;
    }
    String hentEier (){
	return eier;
    }
}
