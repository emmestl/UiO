public class Katt{
    private String navn;
    private int vekt;
    private int antMus = 0; //i magen
    private boolean syk;

    Katt(String navn, int vekt, boolean syk){
	this.navn = navn;
	this.vekt = vekt;
	this.syk = syk;
    }

    Katt(String navn){
	this.navn = navn;
	vekt = 5000;
	syk = false;
    }

    public String navn(){
	return navn ;
    }
    public String vekt(){
	return vekt + "";
    }
    public String antMus(){
	return antMus +"";
    }
    public String syk(){
	return syk +"";
    }
    
    public Mus gaaPaaJaktI(Bol<Mus> byttet){
	Mus beboer = byttet.beboer();
	if(beboer != null){
	    if(beboer.getLever()){
		if(antMus <2){
		    vekt += beboer.getVekt();
		    if (!syk){
			syk = beboer.getSyk();
		    }
		    Mus temp = byttet.taUt(); 
		    antMus++;
		    beboer.doe();
		    return null;
		}
		else{
		    //System.out.println("TEST!!!!!!!!!!!!!!!!!!!!");
		    beboer.blirBitt();
		}
	    }
	}
	return beboer;
    }
}


    
