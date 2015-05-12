import java.util.*;
import java.io.*;

class Brett extends AbstraktBrett{

    private Kolonne[] kolonnene;
    private Rad[] radene;
    private Boks[][] boksene;
    private int v;
    private int l;
    private static String[] tallVerdi;
    private boolean skrivesTilSkjerm = true;
    private String utlesning;
    private PrintWriter p;
    private SudokuBeholder beholder;
    private SudokuGUI gui;
    private Brett neste;
    private Brett utskriftIterator;
    
    Brett(SudokuGUI gui){
	super();
	beholder = new SudokuBeholder();
	this.gui = gui;
	this.utskriftIterator = this;
    }
    
    Brett(String[] utfylling, int v, int l, SudokuGUI gui){
	super();
	lengdeL = v*l;
	lengdeV = v*l;
	this.gui = gui;
	settTallVerdier(lengdeV);

	delInnRuter(v,l);
	int teller = 0;
	for(int j = 0; j < v*l; j++){
	    for(int i = 0; i < v*l; i++){
		alleRutene[i][j] = new Rute(radene[j], kolonnene[i], boksene[i/v][j/l], utfylling[teller], i, j, v, l);
		teller++;
	    }
	}
    }
    
    public void lesFil(String filNavn){ 
	Scanner filen;
	try{
	    filen = new Scanner(new File(filNavn));
	}
	catch(FileNotFoundException e){
	    System.out.println ("Denne filen er ikke tilgjengelig, sjekk at du er i riktig mappe.");
	    System.exit(0);
	    return;
	}

	l = Integer.parseInt(filen.nextLine()); //lodrett
	v = Integer.parseInt(filen.nextLine()); //vannrett

	gui.settStorelse(l, v);
	
	lengdeL = v*l;
	lengdeV = v*l;


	delInnRuter(v, l);
	gui.lagOppsettet();
	
	settTallVerdier(lengdeL);
	
	int j = 0;
	while(filen.hasNextLine()){
	    String linje = filen.nextLine();
	    for(int i = 0; i < v*l; i++){
		String ruteVerdi = linje.substring(i, i +1);
		gui.leggInnRuter(ruteVerdi);
		alleRutene[i][j] = new Rute(this, radene[j], kolonnene[i], boksene[i/v][j/l],ruteVerdi , i, j, v, l);
	    }
	    j++;
	}
	alleRutene[0][0].settNeste();
    }

    public void delInnRuter(int v, int l){
	
	alleRutene = new Rute[v*l][v*l];
	kolonnene = new Kolonne[v*l];
	radene = new Rad[v*l];
	boksene = new Boks[l][v]; //[(v*l)/v][(v*l)/l];

	for (int i = 0; i < v*l; i ++){
	    kolonnene[i] = new Kolonne(v*l);
	    radene[i] = new Rad(v*l);
	}
	for (int i = 0; i < l; i++){
	    for(int j = 0; j < v; j++){
		boksene[i][j] = new Boks(v, l);
	    }
	}
    }

    public Rute getRute(int v, int l){
	return alleRutene[v][l];
    }
    public Boks getBoks(int l, int v){
	return boksene[v][l];
    }
    public Rad getRad(int i){
	return radene[i];
    }
    public Kolonne getKolonne(int i){
	return kolonnene[i];
    }

    public String[] getTallVerdi(){
	return tallVerdi;
    }
    public void antallLosninger(){
	System.out.println ("Antall losninger er: " + beholder.hentAntallLosninger());
    }

    public boolean los(){
	alleRutene[0][0].finnMuligverdiOgNeste();
	alleRutene[0][0].fyllUtDenneRutenOgResten();
	
	return beholder.hentAntallLosninger() != 0;
    }

    public void muligLosning(){
	String[] utfylling = new String[lengdeL*lengdeV];
	int teller = 0;
	for (Rute r: this){
	    utfylling[teller++] = tallVerdi[r.verdi()]; 
	}
	beholder.settInn(new Brett(utfylling, v,l, gui));
    }
    
    public void utskrift() {
	if(utskriftIterator.neste != null){
	    gui.visBrett(utskriftIterator.neste);
	    utskriftIterator = utskriftIterator.neste;
	}
	else{
	    gui.ingenFlererLosninger();
	}
    }
    
    protected void settTallVerdier(int lengde){
	String alfabetet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	tallVerdi = new String[lengde +1];
	tallVerdi[0] = ".";
	for (int i = 1; i < tallVerdi.length; i ++){
	    if (i < 10){
		tallVerdi[i] = i +"";
	    }
	    else{
		try{
		    tallVerdi[i] = alfabetet.substring(i-10, i -9);
		}
		catch (Exception e){
		    System.out.println ("Det er ikke flere bokstaver igjen i alfabetet");
		}
	    }
	}
    }

    public void settNeste(){
	Brett temp = this;
	for(Brett b: beholder){
	    temp.neste = b;
	    temp = b;
	}
    }
    public int antLosninger(){
	return beholder.hentAntallLosninger();
    }
}
