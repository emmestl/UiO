import java.util.*;
import java.io.*;

public class SjekkOrd   {
    private int antallThreads;
    private String[] heleFilen;
    private String leterEtter;
    private Monitor m;

    
    public static void main(String []args){
        SjekkOrd m = new SjekkOrd();
	m.kjoreProgram(args);
        
    }
    public void kjoreProgram (String[] args){
        String filnavn = args[1];
        Scanner fil;
        
        try {
            fil = new Scanner(new File(filnavn));
        }
        catch(FileNotFoundException e){
            System.out.println("Denne filen finnes ikke: " + filnavn);
	    return;
        }

	leterEtter = args[0];
	if (fil.hasNextLine()){
	    heleFilen = new String[Integer.parseInt(fil.nextLine())];
	}
	else{
	    heleFilen = new String[1];
	    heleFilen[0] = "0"; 
	}
        
	antallThreads = sjekkOmTall(args[2]);
	m = new Monitor(antallThreads);


        int i = 0;
        while (fil.hasNextLine()){
            heleFilen[i++]= fil.nextLine();    
        }
	lagOkjorThreads();
	m.vent();
	m.totalAntall(leterEtter);
    }
    
    public void lagOkjorThreads(){
	int steg = heleFilen.length / antallThreads;
        int start = 0;
	Traad traad;
	//System.out.println (antallThreads);
        for (int j = 0; j < antallThreads; j ++){
	    String [] s;
            if(j == antallThreads -1){
		s = new String[heleFilen.length - start];
		System.out.println ("hele fillengden " + heleFilen.length + " start " + start);
		System.out.println (s.length + " lengden til siste traaden");
		for(int k = 0; k < s.length; k++){
		    s[k] = heleFilen[start++];
		}
	    }
	    else{
		s = new String[steg];
		System.out.println (s.length + " lengden til de andre traadene");
		for(int k = 0; k < s.length; k++){
		    s[k] = heleFilen[start++];
		}
	    }
	    traad = new Traad(leterEtter, s, m);
	    traad.start();
	}
    }
    public int sjekkOmTall(String s){
	int antallTraad;
	try {
	    antallTraad = Integer.parseInt(s);
	}
	catch (Exception e){
	    System.out.println("Det er ikke et tall, vennligst skriv inn et tall storre enn 0");
	    return sjekkOmTall((new Scanner(System.in)).nextLine());
	}
	if (antallTraad > heleFilen.length || antallTraad <= 0){
	    System.out.println ("Skriv inn et tall mellom 1 og " + heleFilen.length);
	    return sjekkOmTall((new Scanner(System.in)).nextLine());
	}
	return antallTraad;

    }
}

