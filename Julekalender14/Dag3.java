import java.util.Arrays;
class Dag3{
    private Dag3Rutefarge[][] oversikt = new Dag3Rutefarge [10][10];
    private int hestPosisjon =00;
    private Dag3Rutefarge hestFage = new Dag3Rutefarge ();
    private int teller =0;

    public Dag3(){
	for (int i =0; i < 10*10; i ++){
	    oversikt[i/10][i%10]= new Dag3Rutefarge();
	}
    }
  
	
    public static void main (String [] args){
	Dag3 d3 = new Dag3();
	for (int i = 0; i < 200; i ++){
	    d3.onsketTrekk();
	}

	System.out.println (d3.antallSorte());

    }

    public void onsketTrekk(){
	int [] mulige = muligetrekk();
	//System.out.println (hestPosisjon);
	//System.out.println(Arrays.toString(mulige));
	System.out.println ("");
	for(int i = 0; i < 10; i ++){
	    System.out.println (Arrays.toString(oversikt[i]));
	}
	
	for (int i =0; i < mulige.length; i ++){
	    if (mulige[i]!= 100){
		if((oversikt[mulige[i]/10][mulige[i]%10]).seNaFarge().equals(hestFage.seNaFarge())){
		    oversikt[hestPosisjon/10][hestPosisjon%10].endreFarge();
		    hestPosisjon = mulige[i];
		    
		    teller ++;
		    //System.out.println ("hvit");
		    return;
		}
	    }
	}

	for (int i = mulige.length-1; i >= 0; i--){
	    if (mulige[i]!= 100){
		//System.out.println ("svart");
		oversikt[hestPosisjon/10][hestPosisjon%10].endreFarge();
		hestPosisjon = mulige[i];
		hestFage.endreFarge();
		teller ++;
		return;
	    }
	}  
	
    }

    
    public int[] muligetrekk(){
	int [] trekk = new int [8];
	for (int i = 0; i < trekk.length; i++){
	    trekk[i] = 100;
	}
	
	if ((hestPosisjon%10 - 2 >= 0)){
	    if(hestPosisjon/10-1 >=0){
		trekk[2] = hestPosisjon -12;
	    }
	    if(hestPosisjon/10 +1 <10){
		trekk[4] = hestPosisjon +8;
	    }
	}
	
	if ( (hestPosisjon%10 +2 < 10)){
	    if (hestPosisjon/10-1 >=0){
		trekk[3] = hestPosisjon -8;
	    }
	    if(hestPosisjon/10 +1 <10){
		trekk[5] = hestPosisjon +12;
	    }
	}
	
	if((hestPosisjon/10 -2 >=0)){
	    if(hestPosisjon%10 - 1 >=0){
		trekk[0] = hestPosisjon -21;
	    }
	    if(hestPosisjon%10 +1 <10){
		trekk[1] = hestPosisjon -19;
	    }
	}

	if (hestPosisjon/10 +2 <10){
	    if (hestPosisjon%10 -1 >= 0){
		trekk[6] = hestPosisjon +19;
	    }
	    if(hestPosisjon%10 +1 <10){
		trekk[7] = hestPosisjon +21;
	    }
	}
	
	return trekk;
    }

    public int antallSorte(){
	int antallSorte =0;
	for (int i =0; i <10; i ++){
	    for (int j =0; j<10; j++){
		//System.out.println (i*10+j);
		if(oversikt[i][j].seNaFarge().equals("s")){
		    antallSorte ++;
		}
	    }
	}
	System.out.println (teller);
	return antallSorte;
    }
}
    
	   

    
