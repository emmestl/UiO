class Brev {
    private String mottaker;
    private String avsender;
    private String[] teksten = new String[100];
    int brevLengde=1;

    void tilOGfra (String til, String fra ){
	mottaker = til;
	teksten[0] = ("Hei, " + mottaker + "!");
	avsender = fra;
	teksten[1] = " ";
    }
    void skrivLinje(String linje){
	for (int i = 0; i < teksten.length; i++){ 
	    //System.out.println (teksten[i]);
	    //System.out.println ("test");
	    if (teksten[i] == null){
		teksten[i] = linje;
		if (brevLengde < i){
		    brevLengde = i;

		}
		
		break;
	    }
	}
    }
    String[] lesBrev (){
	brevLengde ++;
	teksten[brevLengde] ="";
	brevLengde++;
	teksten[brevLengde] = "Hilsen fra";
	brevLengde++;
	teksten[brevLengde]= avsender;
	brevLengde++;
	teksten[brevLengde]= "";
	brevLengde ++;
	return teksten;
    }    
}

