import java.util.*;
import java.io.*;

class Brett extends AbstraktBrett{

    private Kolonne[] kolonnene;
    private Rad[] radene;
    private Boks[][] boksene;
    private int v;
    private int l;

    Brett(String[] args){
	super();
	lesFil(args);
	beholder = new SudokuBeholder();
    }
    
    Brett(String[] utfylling, int v, int l){
	super();
	lengdeL = v*l;
	lengdeV = v*l;
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
    
    public void lesFil(String[] args){
	Scanner filen;
	try{
	    filen = new Scanner(new File(args[0]));
	}
	catch(FileNotFoundException e){
	    System.out.println ("Denne filen finnes ikke");
	    return;
	}
	try{
	    utlesning = args[1];
	    skrivesTilSkjerm = false;
	}
	catch(IndexOutOfBoundsException e){
	    skrivesTilSkjerm = true;
	}

	l = Integer.parseInt(filen.nextLine()); //vannrett
	v = Integer.parseInt(filen.nextLine()); //loddrett

	lengdeL = v*l;
	lengdeV = v*l;


	delInnRuter(v, l);
	settTallVerdier(lengdeL);

	int j = 0;
	while(filen.hasNextLine()){
	    String linje = filen.nextLine();
	    for(int i = 0; i < v*l; i++){
		alleRutene[i][j] = new Rute(this, radene[j], kolonnene[i], boksene[i/v][j/l], linje.substring(i, i +1), i, j, v, l);
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

    public void antallLosninger(){
	System.out.println ("Antall losninger er: " + beholder.hentAntallLosninger());
    }

    public void los(){
	alleRutene[0][0].finnMuligverdiOgNeste();	
	alleRutene[0][0].fyllUtDenneRutenOgResten();
	
	if (beholder.hentAntallLosninger() == 0){
	    System.out.println ("Det finnes ingen losninger");
	}
	utskrift();
    }

    public void muligLosning(){
	String[] utfylling = new String[lengdeL*lengdeV];
	int teller = 0;
	for (Rute r: this){
	    utfylling[teller++] = tallVerdi[r.verdi()]; 
	}
	beholder.settInn(new Brett(utfylling, v,l));
    }
}
