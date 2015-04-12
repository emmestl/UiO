class Bok implements TilUtlaan{
    private String tittel;
    private String utlaaner;
    
    Bok(String tittel){
	this.tittel = tittel;
    }
    public String laaner(String utlaaner){
	if (utlaaner != null){
	    System.out.println ("Den er utlaant fra for av");
	    return null;
	}
	this.utlaaner = utlaaner;
	return tittel;
    }

    public void leveresTilbake(){
	utlaaner = null;
    }
    public String toString(){
	return tittel;
    }
}

    
