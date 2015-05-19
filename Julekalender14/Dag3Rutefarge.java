class Dag3Rutefarge{
    
    private String farge = "h";

    public void endreFarge(){
	if (farge.equals("h")){
	    farge = "s";
	}

	else {
	    farge = "h";
	}
    }
    public String seNaFarge(){
	return farge;
    }
    public String toString(){
	return farge;
    }
}

