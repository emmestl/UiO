class Rute{
    private String lestVerdi;
    private int midlertidligVerdi;
    private Rad r;
    private Kolonne k;
    private Boks b;
    private int[] muligeVerdier;
    private int v;
    private int l;
    private int maksverdi;

    Rute(Rad r, Kolonne k, Boks b, String verdien, int i, int j, int v, int l){
	this.r = r;
	this.k = k;
	this.b = b;
	this.maksverdi = v*l;
	this.l = l;
	this.v = v;

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
	if (lestVerdi == null){
	    Monitor m = new Monitor(maksverdi, 3);
	    
	    (new FinnMulig<Boks>(m, b)).start();
	    (new FinnMulig<Rad> (m, r)).start();
	    (new FinnMulig<Kolonne>(m, k)).start();
	    
	    muligeVerdier = m.finnMulige();
	}
	return muligeVerdier;
    }
}
