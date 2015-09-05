import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.Collection;

class DVDadministrasjon{
    Personoversikt oversikt = new Personoversikt();
    //static Dvdarkiv dvdArkiv = new Dvdarkiv();

    public void brukermeny(){
	System.out.println("\nKommandoer: \n A = avslutt \n K = kjop \n L = laan \n N = ny person \n O = oversikt \n R = retur \n V = vis");
    }

    public boolean sjekkOmPersonFinnes(String navn){
	return oversikt.hashMap().keySet().contains(navn);
    }

    public int sjekkOmDvdFinnes(String tittel, String navn){
	HashMap <String, Dvd> dvder= oversikt.personOversikt(navn).hentDvder();

	if (dvder.keySet().contains(tittel)){

	    if (dvder.get(tittel).sjekkOmLaant()){
		return 2;
	    }
	    return 1;
	}
	
	return 0;

    }

    public boolean sjekkOmPersonLaaner(String person, String dvd){
	for (HashMap <String , Dvd> s : oversikt.personOversikt(person).visLaant().values()){
	    if (s.keySet().contains(dvd)){
		System.out.println (person + ", laaner allerede et eksemplar av denne filemen");
		return true;
	    }
	}
	return false;
    }
    
   
    public void l(Scanner in){
	System.out.print("Hvem skal laane? ");
	String laaner = in.nextLine();
	if (sjekkOmPersonFinnes(laaner)){
	    System.out.print("Hvem skal " +laaner + " laane fra? ");
	    String laantFra = in.nextLine();
	    if(sjekkOmPersonFinnes(laantFra) && !laaner.equalsIgnoreCase(laantFra)){
		System.out.print("Hvilken DVD skal " +laaner + " laane? ");
		String dvdLaant = in.nextLine();
		if ((sjekkOmDvdFinnes(dvdLaant, laantFra))==1 && sjekkOmDvdFinnes(dvdLaant , laaner ) == 0){
		    if(sjekkOmPersonLaaner(laaner, dvdLaant)){
			return;
		    }
		    oversikt.personOversikt(laantFra).laanerBort(dvdLaant , oversikt.personOversikt(laaner));
		}
		else {
		    System.out.println(laaner + ", eier denne fra for av");
		}

		if (sjekkOmDvdFinnes(dvdLaant, laantFra) == 0){
		    System.out.println(laantFra + ", eier ikke denne dvd'en");
		}
	    }
	}
	else{
	    System.out.println ("Denne personenen finnes ikke");
	}
    }
      
		    
    public void k(Scanner in){
	System.out.print ("Hvem har kjopt en Dvd? ");
	String hvem = in.nextLine();
	if (sjekkOmPersonFinnes(hvem)){
	    System.out.print("Hvilken dvd har " + hvem + " kjopt? ");
	    String tittel = in.nextLine();

	    if (sjekkOmDvdFinnes(tittel , hvem) == 0){
		    if(sjekkOmPersonLaaner(hvem, tittel)){
			System.out.println ("Returner dvden for du kjoper den");
			return;
		    }
		    
		Dvd dvd = new Dvd(tittel, oversikt.personOversikt(hvem));
		oversikt.personOversikt(hvem).leggTilDvd(dvd);
	    }
	
	
	    else {
		System.out.println(hvem + " eier denne dvden fra for av");
	    }
	}
    }
    
    public void n(Scanner in){
	System.out.print("Hva heter personen? ");
	String navn = in.nextLine();
	if (!sjekkOmPersonFinnes(navn)){
	    Person person = new Person(navn);
	    oversikt.leggTilPerson(person);
	}
	else {
	    System.out.println("Denne personen finnes fra for av ");
	}
    }

    public void o(){
	int laantUt =0;
	int laaner = 0;
	for (String s : oversikt.hashMap().keySet()){
	    Collection <HashMap <String, Dvd>>laantUT =oversikt.personOversikt(s).visLaant().values();
	    int antall = laantUT.size();
	    for (HashMap <String, Dvd> j : laantUT){
		if(j.keySet().size() > 1){
		    antall = antall + j.keySet().size() -1;
		}
	    }
	    
	    System.out.print(s + " eier " + oversikt.personOversikt(s).hentDvder().size() + " dvd'er");
	    System.out.print(", laaner " + antall + " dvd'er");
	    System.out.println(", laant bort " +oversikt.personOversikt(s).laantBort().size() + " dvd'er");
	}
    }
    
    public void r(Scanner in) {
	System.out.print("Hvem har laant en dvd? ");
	String laaner = in.nextLine();
	System.out.print("Hva skal retureneres? ");
	String returner  = in.nextLine();

	if (sjekkOmPersonFinnes(laaner)){
	    for (Person s : oversikt.personOversikt(laaner).visLaant().keySet()){
		HashMap <String , Dvd> laant = oversikt.personOversikt(laaner).visLaant().get(s);
		if(laant.containsKey(returner)){
		    laant.get(returner).retur();
		}
	    }
	}
    }

    public void v(Scanner in){
	System.out.print ("Velg person, * for alle: ");
	String valg = in.nextLine();
	System.out.println("");
	
	for (String s : oversikt.hashMap().keySet()){
	    if (valg.equalsIgnoreCase(s) || valg.equalsIgnoreCase("*")){
		System.out.println(s + ", eier:");
		for (String d : oversikt.personOversikt(s).hentDvder().keySet()){
		    Dvd dvd = oversikt.personOversikt(s).hentDvder().get(d);
		    if (dvd.sjekkOmLaant()){
			System.out.println(d + " (laanes av " + dvd.laanesAv().toString() + ")");
		    }
		    else {
			System.out.println(d);
		    }
		}
		System.out.println("");
	    }
	}
    }

    public void brukermenyen() throws Exception{
	Scanner in = new Scanner (System.in);
	File fil = new File ("dvdarkiv.txt");
	String kommando = "z";
	lesFraFil(in, fil);
	/*
	  valgt aa kalle metodene det samme som kommandoen som kommer inn.
	  Grunnen til dette er at jeg personlig foler at det blir mer oversiktlig, 
	  fordi dette gjor at naar man faar inn en kommentar saa vet man automatisk hvilken metode dette tilhorer.*/
	
	while (!kommando.equalsIgnoreCase("a")){
	    brukermeny();
	    kommando = in.nextLine();
	    if (kommando.equalsIgnoreCase("l")){
		l(in); //laan
	    }
	    else if (kommando.equalsIgnoreCase("k")){
		k(in); // kjop
	    }
	    else if(kommando.equalsIgnoreCase("n")){
		n(in); //ny person
	    }
	    else if (kommando.equalsIgnoreCase("o")){
		o(); //oversikt
	    }
	    else if (kommando.equalsIgnoreCase("r")){
		r(in); //retur
	    }
	    else if (kommando.equalsIgnoreCase("v")){
		v(in); //vis
	    }
	}
    }
    

    public void lesFraFil(Scanner in, File fil) throws Exception{
	Scanner innFil = new Scanner (fil);
	String linje;
	Person eier = null;
	String dvdTekst ="";
	int antall=1;
	Person laaner = null;
	
	while(innFil.hasNextLine()){
	    linje =innFil.nextLine();
	    if (linje.isEmpty()){
		antall = 1;
	    }
	    else if (antall ==1){
		if(oversikt.hashMap().keySet().contains(linje)){
		    eier = oversikt.personOversikt(linje);
		}
		else{
		    Person person = new Person (linje);
		    oversikt.leggTilPerson(person);
		    eier = person;
		}
		antall ++;
	    }
	    else if (antall==2){
		if(linje.substring(0,1).equals("*")){
		    linje = linje.substring(1, linje.length());
		    dvdTekst = linje;
		    antall++;
		}
		Dvd dvd = new Dvd (linje, eier);
		eier.leggTilDvd(dvd);
		
	    }

	    else if (antall == 3){
		if (oversikt.hashMap().keySet().contains(linje)){
		    laaner = oversikt.personOversikt(linje);
		}
		else {
		    laaner = new Person (linje);
		    oversikt.leggTilPerson(laaner);
		}
		eier.laanerBort(dvdTekst , laaner);
		antall = 2;
	    }
	}
    }

    public void lesTilFil(PrintWriter tilFil){
	boolean laantVekk = false;
	Dvd dvdMidlertidig = null;
	for(String s : oversikt.hashMap().keySet()){
	    tilFil.println(s);
	    for (String i : oversikt.personOversikt(s).hentDvder().keySet()){
		dvdMidlertidig = (oversikt.personOversikt(s).hentDvder().get(i));
		if (dvdMidlertidig.sjekkOmLaant()){
		    tilFil.println ("*" + dvdMidlertidig.toString());
		    laantVekk = true;
		}
		if (!dvdMidlertidig.sjekkOmLaant()) {
		    tilFil.println (dvdMidlertidig.toString());
		    laantVekk = false;
		}
		if (laantVekk ){
		    tilFil.println (dvdMidlertidig.laanesAv().toString());
		}
	    }

	    tilFil.println("");
	}
	tilFil.close();
    }
}
