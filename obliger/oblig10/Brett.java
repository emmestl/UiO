import java.util.*;
import java.io.*;

class Brett extends AbstraktBrett{

    private Kolonne[] kolonnene;
    private Rad[] radene;
    private Boks[][] boksene;
    private String[] tallVerdi;

    Brett(){
	super();
	lesFil();
    }

    public void lesFil(){
	Scanner in = new Scanner(System.in);
	Scanner filen;
	System.out.print ("Filnavn: ");
	try{
	    filen = new Scanner(new File(in.nextLine()));
	}
	catch(FileNotFoundException e){
	    System.out.println ("Denne filen finnes ikke");
	    return;
	}

	int l = Integer.parseInt(filen.nextLine()); //vannrett
	int v = Integer.parseInt(filen.nextLine()); //loddrett

	lengdeL = v*l;
	lengdeV = v*l;


	delInnRuter(v, l);
	settTallVerdier(lengdeL);

	int j = 0;
	while(filen.hasNextLine()){
	    String linje = filen.nextLine();
	    for(int i = 0; i < v*l; i++){
		alleRutene[i][j] = new Rute(radene[j], kolonnene[i], boksene[i/v][j/l], linje.substring(i, i +1), i, j, v, l);
	    }
	    j++;
	}
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

    public void utskrift(){
	int teller = 0;
	for (Rute r: this){
	    if(teller == radene.length){
		System.out.println ();
		teller = 0;
	    }
	    System.out.print (tallVerdi[r.verdi()]);
	    teller ++;
	}
	System.out.println();
    }

    private void settTallVerdier(int lengde){
	String alfabetet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	tallVerdi = new String[lengde +1];
	tallVerdi[0] = ".";
	for (int i = 1; i <= lengde; i ++){
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
    public Rute getRute(int v, int l){
	return alleRutene[v][l];
    }
    public Boks getBoks(int l, int v){
	return boksene[v][l];
    }

    public void los(){
	if(alleRutene[0][0].fyllUtDenneRutenOgResten()){
	    utskrift();
	}
	else{
	    System.out.println("Dette brettet kunne ikke loses");
	}
    }
}
