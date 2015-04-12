class Rute{
    private String lestVerdi;
    private int midlertidligVerdi;
    private Rad r;
    private Kolonne k;
    private Boks b;
    private int[] muligeVerdier;
    private int v; //lengden paa boksen
    private int l; //bredden paa boksen
    private int posisjonV;
    private int posisjonL;
    private int maksverdi;
    private Rute neste;
    private int teller = 0;

    Rute(Rad r, Kolonne k, Boks b, String verdien, int i, int j, int v, int l){
	this.r = r;
	this.k = k;
	this.b = b;
	this.maksverdi = v*l;
	this.l = l;
	this.v = v;
	this.posisjonV = i;
	this.posisjonL = j;

	if(!verdien.equals(".")){
	    this.lestVerdi = verdien;
	    muligeVerdier = new int[1];
	    muligeVerdier[0] = gjorTilInt(verdien);
	    midlertidligVerdi = muligeVerdier[0];

	}
	int i1 = i - (i/v)*v;
	int j1 = j - (j/l)*l;


	b.settVerdi(i1, j1, this);
	k.settVerdi(j, this);
	r.settVerdi(i, this);

    }

    public int verdi(){
	return midlertidligVerdi;
    }

    public int gjorTilInt(String i){
	int p =0;
	try{
	    p = Integer.parseInt(i);
	}
	catch(Exception e){
	   p = (i.charAt(0) - 'A' + 10);
	}
	return p;
    }

    
    public int[] finnAlleMuligeTall(){
	settNeste();   
	if (lestVerdi == null){
	    Monitor m = new Monitor(maksverdi, 3);
	    
	    (new FinnMulig<Boks>(m, b)).start();
	    (new FinnMulig<Rad> (m, r)).start();
	    (new FinnMulig<Kolonne>(m, k)).start();
	    
	    muligeVerdier = m.finnMulige();
	}
	return muligeVerdier;
    }

    /*
      Tar ikke aa direkte brute forecer kjorer heller gjennom en gang forst og ser om det er noe som garantert kan settes inn
    */
    public boolean fyllUtDenneRutenOgResten(){
	if (teller == 0){
	    finnAlleMuligeTall();
	}
	
	System.out.print ("Fyller rute " + posisjonV + " " + posisjonL); 
	if (muligeVerdier == null){
	    teller = 0;
	    //System.out.println ("------- MuligeVerdier == null");
	    return false;
	}
	try{
	    midlertidligVerdi = muligeVerdier[teller];
	    //System.out.println ("----------Setter verdi " + midlertidligVerdi);
	}
	catch (Exception e){
	    teller = 0;
	    //System.out.println ("----------Ingen verdier funnet, gaar tilbake");
	    return false;
	}
	
	teller ++;
	if (neste == null){
	    //System.out.println ("Neste finnes ikke");
	    return true;
	}
	else if (!neste.fyllUtDenneRutenOgResten()){
	    
	    //System.out.println("---------Gaa tilbake prov paa nytt" + teller);
	    neste.settVerdi(0);
	    fyllUtDenneRutenOgResten();
	}
	return true;
    }

    public void settNeste(){
	
	//System.out.print ("Rute " + getPosisjon() );
	
	if (posisjonV != maksverdi -1){
	    neste = r.getRute(posisjonV + 1);
	    //System.out.println ("------ Neste " + neste.getPosisjon());
	}
	else if (posisjonL != maksverdi -1){
	    neste = k.getRute(posisjonL+1).getRad().getRute(0);
	    //System.out.println ("------ Neste " + neste.getPosisjon());
	}
	else{
	    neste = null;
	    //System.out.println ("------ Neste " + neste.getPosisjon());
	}
    }

    public void settVerdi(int i){
	midlertidligVerdi = i;
    }
    
    public Rad getRad(){
	return r;
    }

    public String getPosisjon(){
	return "" + posisjonV + " " + posisjonL;
    }

}
