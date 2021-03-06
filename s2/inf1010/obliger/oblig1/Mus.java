public class Mus{
    private boolean syk; //true = syk
    private int vekt; //i gram
    private boolean lever =true; // true = lever
    private static int teller = 0;
    private String navn;

    Mus(int vekt, boolean syk){
	teller ++;
	navn = "musNr" + teller;
	this.vekt = vekt;
	this.syk = syk;
    }
    public boolean getLever(){
	return lever;
    }
    public int getVekt(){
	return vekt;
    }
    public boolean getSyk(){
	return syk;
    }
    
    public void sjekktilstand(String testID, String navn, boolean syk, int vekt, boolean lever){

	if (navn.equals("?")){
	    String tilstand = "doed";
	    if (this.lever){
		tilstand = "lever";
		if (this.syk){
		    tilstand = "syk";
		}
	    }
	    System.out.println ("--- " + testID + " --- Info om mus: navn: "+ this.navn + ", vekt: " + this.vekt + ", " + tilstand);
	    return;

	}
	System.out.println ("********* Test av musobjekt, testid: "+ testID + " ***");
	//System.out.println(navn + "   " + this.navn);
	if(syk == this.syk && lever == this.lever && vekt == this.vekt){
	    System.out.println ("** navn: " +this.navn + ", OK.\n** syk: " +syk +", OK.\n** vekt: " +vekt+", OK.");
	}
	else{
	    System.out.println("    forventet:    faktisk:");
	    System.out.println("Syk:   " +syk  + "    " + this.syk);
	    System.out.println("Lever: " +lever + "    " +this.lever);
	    System.out.println("Vekt:  " +vekt + "    " + this.vekt);
	}
    }

    public void blirBitt(){
	if (!syk){
	    syk = true;
	}
	else{
	    lever = false;
	}
    }

    public void doe(){
	lever = false;
    }
}

    

