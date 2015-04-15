import java.util.*;
import java.lang.Iterable;
import java.io.*;

class AbstraktBrett implements Iterable<Rute>{
    protected Rute[][] alleRutene;
    protected int lengdeV;
    protected int lengdeL;
    protected static String[] tallVerdi;
    protected boolean skrivesTilSkjerm;
    protected String utlesning;
    private PrintWriter p;
    
    AbstraktBrett(int lengdeV, int lengdeL){
	this.lengdeV = lengdeV;
	this.lengdeL = lengdeL;
	settTallVerdier(lengdeV*lengdeL);
	skrivesTilSkjerm = true;
    }
    AbstraktBrett(){}
    
    public Iterator<Rute> iterator(){
	return new RuteIterator();
    }

    public void utskrift(){
	//System.out.println(tallVerdi.length);
	if(skrivesTilSkjerm){
	    int teller = 0;
	    for (Rute r: this){
		if(teller == lengdeV){
		    System.out.println ();
		    teller = 0;
		}
	    
		System.out.print (tallVerdi[r.verdi()] + " ");
		teller ++;
	    }
	    System.out.println("\n");
	}
	else{
	    try{
		p = new PrintWriter(new File(utlesning));
	    }
	    catch(FileNotFoundException e) {
		System.out.println ("Filen er ikke en godkjent fil; skriver ut paa skjermen");
		skrivesTilSkjerm = true;
		utskrift();
		return;
	    }
	    int teller = 0;
	    for (Rute r: this){
		if(teller == lengdeV){
		    System.out.println ();
		    teller = 0;
		}
	    
		System.out.print (tallVerdi[r.verdi()]);
		teller ++;
	    }
	    p.close();
	}
    }

    protected void settTallVerdier(int lengde){
	String alfabetet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	alfabetet = alfabetet + alfabetet.toLowerCase();
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
    class RuteIterator implements Iterator<Rute> {
	private int i = 0;
	private int j = 0;
	private boolean sisteRad = false;
	
	public boolean hasNext(){
	    if (sisteRad){
		return false;
	    }
	    
	    return true;
	}

	public Rute next(){
	    Rute r = alleRutene[i][j];
	    if(j == lengdeL -1 && i == lengdeV -1){
		sisteRad = true;
	    }
	    else if (i == lengdeV - 1){
		j ++;
		i = 0;
	    }
	    else {
		i++;
	    }

	    return r;
	}
    }
}
