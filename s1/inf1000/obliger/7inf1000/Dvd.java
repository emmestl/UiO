class Dvd {
    private String tittel;
    private Person eier;
    private Person laanesAv;

    Dvd (String tittel, Person eier){
	this.tittel = tittel;
	this.eier = eier;
    }

    public String toString(){
	return tittel;
    }

    public void laan(Person laaner){
	laaner.leier(tittel, eier);
	this.laanesAv = laaner;
    }

    public void retur(){
	laanesAv.leverTilbake(tittel, eier);
	this.laanesAv = null;
    }
    
    public boolean sjekkOmLaant(){
	boolean finnes = false;
	if (laanesAv != null){
	    finnes =true;
	}
	return finnes;
    }
    public Person laanesAv(){
	return laanesAv;
    }
}
