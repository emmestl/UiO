import java.util.*;
import java.io.*;

/**
 *
 * @author millemariehansen
 */
public class Oblig7 {
    private Tabell<Legemiddel> legemiddler = new Tabell<>(1000);
    private SortertEnkelListe<Lege> leger = new SortertEnkelListe<>();
    private Tabell<Person> personer = new Tabell<>(1000);
    private EldsteForstReseptListe resepter = new EldsteForstReseptListe();

    private String filnavn;
    private int antlegemiddler = 0;
    private int antpersoner = 0;
    private Scanner in;

    public static void main(String[] args) {
	Oblig7 m = new Oblig7();

	m.meny();
    }
    /*
      Elsie har endret:
      Endret i; if(k ==5) spor om personnummer men metoden settInnResept() tar inn IDnr/plassering.
      Legger til en enhanced for-loop for aa kunne gjore dette
    */
    
    void meny() {
	in = new Scanner(System.in);
	System.out.print("Skriv inn filnavnet: ");
	filnavn = in.nextLine();
	lesFraFil();
	int k;

	// Har kommando for avslutt saa lager en evig lokke
	while (true) {
	    k = kommando();
	    if (k == 1) {
		skrivUtAlt();
	    } else if(k == 2) {
		System.out.print("Navn: ");
		String navn = in.nextLine();
		String avnr;
		System.out.println("Er " + navn + " ansatt av kommunen? (Ja eller Nei)");
		String fast = in.nextLine();

		if (fast.equalsIgnoreCase("Ja")) {
		    System.out.print("Avtalenummer: ");
		    avnr = in.nextLine();
		} else {
		    avnr = "0";
		}
		settInnLege(navn, avnr);

	    } else if (k == 3) {
		System.out.print("Navn: ");
		String navn = in.nextLine();
		System.out.print("Fodselnummeret: ");
		String fnr = in.nextLine();
		System.out.print("Gateadressen: ");
		String add = in.nextLine();
		System.out.print("Postnummer: ");
		String postnr = in.nextLine();
		System.out.println();
		settInnPerson(navn, fnr, add, postnr);

	    } else if (k == 4) {
		System.out.print("Navn: ");
		String navn = in.nextLine();
		System.out.print("Form: (Pille eller Mikstur) ");
		String form = in.nextLine();
		System.out.print("Type: (a, b eller c) ");
		String type = in.nextLine();
		System.out.print("Pris: ");
		String pris = in.nextLine();
		System.out.print("Antall/ Mengde: ");
		String antall = in.nextLine();
		System.out.print("Virkestoff: ");
		String virk = in.nextLine();
		String styrke = null;
		if (!type.equalsIgnoreCase("c")) {
		    System.out.print("Styrke: ");
		    styrke = in.nextLine();
		} else {
		    styrke = "0";
		}
		settInnLegemiddel(navn, form, type, pris, antall, virk, styrke);

	    } else if (k == 5) {
		System.out.print("Type: (Blaa eller hvit) ");
		String type = in.nextLine();
		System.out.print("Personnummer: ");
		String persNr = in.nextLine();
		for (Person p: personer){
		    if (persNr.equalsIgnoreCase(p.fodselnummer() + "")){
			persNr = p.ID() +"";
		    }
		}
		System.out.print("Legens Navn: ");
		String legeNavn = in.nextLine();
		System.out.print("Legemiddelnummer: ");
		String legemiddelNr = in.nextLine();
		System.out.print("Reit: ");
		String reit = in.nextLine();

		settInnResept(type, persNr, legeNavn, legemiddelNr, reit);
	    } else if (k == 6) {
		System.out.print("Personnummer: ");
		String persNr = in.nextLine();

		hentLegemiddel(persNr);

	    } else if (k == 7) {
		statistikk();

	    } else if (k == 8) {
		skrivTilFil();
		break;
	    }
	}
    }

    int kommando () {
	in = new Scanner(System.in);

	System.out.println("\nMeny: \n");
	System.out.println("1. Skriv ut all informasjon.");
	System.out.println("2. Fore inn en ny lege.");
	System.out.println("3. Fore inn en ny person.");
	System.out.println("4. Lage et nytt legemiddel.");
	System.out.println("5. Lage en ny resept.");
	System.out.println("6. Hent legemiddel til en person");
	System.out.println("7. Statistikk.");
	System.out.println("8. Avslutt");

	String kommando = in.nextLine();
	int kommandoTall = 0;

	try {
	    kommandoTall = Integer.parseInt(kommando);
	} catch (Exception e) {
	    System.out.println("Dette er ikke en gyldig kommando.");
	}

	if (kommandoTall < 1 || kommandoTall > 8) {
	    System.out.println("Dette er ikke en gyldig kommando.");
	    return 0;
	}

	return kommandoTall;
    }

    int statistikkMeny() {
	System.out.println("\nStatistikk Meny: \n");
	System.out.println("1. Antall Vanedanndenderesepter. (Totalt og i Oslo)");
	System.out.println("2. Informasjon om blaa resepter til en person.");
	System.out.println("3. Informasjon om en leges resepter.");
	System.out.println("4. Informsjon om narkotiske resepter.");
	System.out.println("8. Avslutt.");

	String kommando = in.nextLine();
	int kommandoTall = 0;

	try {
	    kommandoTall = Integer.parseInt(kommando);
	} catch (Exception e) {
	    System.out.println("Dette er ikke en gyldig kommando.");
	}

	if (kommandoTall < 1 || kommandoTall > 8) {
	    System.out.println("Dette er ikke en gyldig kommando.");
	    return 0;
	}

	return kommandoTall;
    }

    /*Elsie har endret:
      1. Endrer persNr til String. Fordi det er det i person et er i person
      2. pga over fjernes try-catch
    */
    void statistikk() {
	while (true) {
	    int s = statistikkMeny();

	    if (s == 1) {
		System.out.println();
		sVanedanndende();

	    } else if (s == 2) {
		System.out.print("\nPersonnummer: ");
		String persNr = in.nextLine();
		sBlaResept(persNr);

	    } else if (s == 3) {
		System.out.print("\nLegens Navn: ");
		String legeNavn = in.nextLine();
		sLegesResepter(legeNavn);

	    } else if (s == 4) {
		System.out.println();
		sNarkotika();

	    } else if (s == 5 || s == 8) {
		return;
	    }
	}
    }

    boolean settInnLegemiddel(String navn, String form, String type1,
			      String pris1, String antall1, String virkestoff1, String styrke1) {

	char type = 'z';
	int pris = 0;
	int antall = 0;
	int virkestoff = 0;
	int styrke = 0;


	try {
	    type = type1.charAt(0);
	    pris = Integer.parseInt(pris1);
	    antall = Integer.parseInt(antall1);
	    virkestoff = Integer.parseInt(virkestoff1);
	    styrke = Integer.parseInt(styrke1);

	} catch (Exception e) {
	    System.out.println("Alle nummer maa vaere heltall.");
	}


	if (form.equalsIgnoreCase("mikstur")) {
	    if (type == 'a') {
		TypeAMiks am = new TypeAMiks(navn, pris, virkestoff, antall);
		am.narkotisk(styrke);
		return legemiddler.settInn(am, antlegemiddler++);

	    } else if (type == 'b') {
		TypeBMiks bm = new TypeBMiks(navn, pris, virkestoff, antall);
		bm.vanedannende(styrke);
		return legemiddler.settInn(bm, antlegemiddler++);

	    } else if (type == 'c') {
		TypeCMiks cm = new TypeCMiks(navn, pris, virkestoff, antall);
		return legemiddler.settInn(cm, antlegemiddler++);

	    }
	} else if (form.equalsIgnoreCase("pille")) {
	    if (type == 'a') {
		TypeAPiller ap = new TypeAPiller(navn, pris, virkestoff, antall);
		ap.narkotisk(styrke);
		return legemiddler.settInn(ap, antlegemiddler++);

	    } else if (type == 'b') {
		TypeBPiller bp = new TypeBPiller(navn, pris, virkestoff, antall);
		bp.vanedannende(styrke);
		return legemiddler.settInn(bp, antlegemiddler++);

	    } else if (type == 'c') {
		TypeCPiller cp = new TypeCPiller(navn, pris, virkestoff, antall);
		return legemiddler.settInn(cp, antlegemiddler++);

	    }
	}
	return false;
    }

    boolean settInnLege(String navn, String avtalenr1){
	int avtalenr = 0;

	try {
	    avtalenr = Integer.parseInt(avtalenr1);
	} catch (Exception e) {
	    System.out.println("Avtalenummer maa vaere tall.");
	}

	Lege l = null;
	if (avtalenr == 0){
	    l = new Lege(navn);
	}
	else{
	    l= new Fastlege(navn, avtalenr);
	}
	if(l.name() != null){
	    return leger.settInn(l);
	}
	return false;
    }

    /* Elsie har endret:
       fnr maa fortsette aa vaere en String pga Person klassen
    */
    boolean settInnPerson(String navn, String fnr, String add, String postnr) {
	int postnrInt = 0;

	try {
	    postnrInt = Integer.parseInt(postnr, 10);
	} catch (Exception e) {
	    System.out.println("Postnummer maa vaere tall.");
	}

	return personer.settInn(new Person(navn, fnr, add, postnrInt), antpersoner++);
    }

    /*
      Skal faktisk vaere IDnr her! m.a.o. alt ok!
    */
    boolean settInnResept(String type, String persNr1, String legeNavn, String legemiddelNr1, String reit1){

	int persNr = 0;
	int legemiddelNr = 0;
	int reit = 0;

	try {
	    persNr = Integer.parseInt(persNr1);
	    legemiddelNr = Integer.parseInt(legemiddelNr1);
	    reit = Integer.parseInt(reit1);

	} catch (Exception e) {
	    System.out.println("Personnummer, legemiddelnummer og reit maa vaere tall.");
	}

	Lege lege = leger.finn(legeNavn);
	Legemiddel legemiddel = legemiddler.finn(legemiddelNr);
	Person person = personer.finn(persNr);

	Resept r = null;
	if (type.equalsIgnoreCase("hvit")){
	    r = new HvitResept(legemiddel, lege, person, reit);
	}
	else if(type.equalsIgnoreCase("blaa")){
	    r = new BlaResept(legemiddel, lege, person, reit);
	}

	lege.settInnResept(r);
	person.settInnResept(r);
	return resepter.settInn(r);
    }

    /*Elsie har endret:
      1. personnr til String (det er det som originalt er gjort i Person-klassen og som kommentert gir mest mening)
      2. Try; finn() i tabell finner på indeks ikke paa persNr altsaa maa den itterere gjennom lista istedenfor
      3. Catch tilbakemeldingen
    */
    void hentLegemiddel(String personnr) {
	YngsteForstReseptListe re = finnResept(personnr);

	in = new Scanner(System.in);
	Resept r = null;
	for (Resept resept : re) {
	    System.out.println("Skal du hente legemiddel " + resept.legemiddel().navn() + "? \n(Ja eller Nei)");
	    if (in.nextLine().startsWith("Ja")) {
		r = resept;
		break;
	    }
	}
	if (r == null) {
	    System.out.println("Denne personen har ingen gyldige resepter.");
	    return;
	}
	if (r.reit() == 0) {
	    System.out.println("Denne resepten er ugyldig.");
	} else {
	    Legemiddel l = r.legemiddel();
	    if (r instanceof BlaResept) {
		System.out.println("Pris: 0 kr");
	    } else {
		System.out.println("Pris: " + l.pris());
	    }
	    System.out.println("Lege: " + r.lege());
	    System.out.println("Eier: " + r.eier());
	    System.out.println("\nInfo om Legemiddel:\nNavn: " + l.navn() + "\nID: " + l.ID());

	    if (l.form().equalsIgnoreCase("mikstur")) {
		Mikstur m = (Mikstur) l;
		System.out.println("Mengde i cm^3: " + m.mengde_cm3());
		System.out.println("Vikestoff per cm^3: " + m.virkestoffPercm3());
	    } else if (l.form().equalsIgnoreCase("pille")){
		Piller pille = (Piller) l;
		System.out.println("Nummer av piller: " + pille.nummerAvPiller());
		System.out.println("Virkestoff per Pille: " + pille.virkestoffPerPille());
	    }

	    if (l.type() == 'a') {
		System.out.println("Narkotisk: " + l.narkotisk());
	    } else if (l.type == 'b') {
		System.out.println("Vannedannende: " + l.vanedannende());
	    }
	    r.bruk();
	}
    }

    void skrivUtAlt() {
	System.out.println("\nPersoner: \n");
	System.out.printf("%-3s %-25s %-11s\n", "ID", "Navn", "Fodselnummer");
	for (Person p: personer) {
	    System.out.printf("%-3d %-25s %-11s\n", p.ID(), p.name(), p.fodselnummer());
	}
	System.out.println("\nLeger: \n");
	System.out.println("Navn");
	for (Lege l: leger) {
	    System.out.println(l.name());
	}
	System.out.println("\nLegemiddler: \n");
	System.out.printf("%-3s %-12s %-6s %-10s\n", "ID", "Navn", "Type", "Form");
	for (Legemiddel le: legemiddler) {
	    System.out.printf("%-3d %-12s %-6c %-10s\n", le.ID(), le.navn(), le.type(), le.form());
	}
	System.out.println("\nResepter: \n");
	System.out.printf("%-3s %-12s %-6s %-10s %-25s %-10s\n", "ID", "Legemiddel", "Type", "Lege", "Eier", "Reit");
	for (Resept r: resepter) {
	    System.out.printf("%-3d %-12s %-6s %-10s %-25s %-10d\n", r.ID(), r.legemiddel().navn(), r.type(),
			      r.lege().name(), r.eier().name(), r.reit());
	}
    }

    void skrivTilFil(){
	try{
	    PrintWriter pw = new PrintWriter(filnavn);
	    pw.println("# Personer (nr, navn, fnr, adresse, postnr)");
	    for (Person p : personer){
		String postNr = String.valueOf(p.postnummer());
		if (postNr.length() < 4) {
		    postNr = "0" + postNr;
		}

		pw.println(p.ID() + ", " + p.name() +", " + p.fodselnummer()
			   +", " + p.adresse() + ", " + postNr);
	    }

	    pw.println("\n# Legemidler (nr, navn, form, type, pris, antall/mengde,"
		       + " virkestoff [, styrke])");

	    for (Legemiddel l : legemiddler){
		int styrke = 0;
		if (l instanceof TypeAMiks || l instanceof TypeAPiller){
		    styrke = l.narkotisk();
		}

		if (l instanceof TypeBMiks || l instanceof TypeBPiller){
		    styrke = l.vanedannende();
		}

		if (l instanceof Mikstur){
		    Mikstur m = (Mikstur) l;
		    if (l instanceof TypeAMiks || l instanceof TypeBMiks){
			pw.println(l.ID() +", " + l.navn() +", " + l.form()
				   + ", " + l.type()+ ", " + l.pris() +", "
				   + m.mengde_cm3() + ", " + l.virkestoffMg()
				   + ", " + styrke);
		    }
		    else{
			pw.println(l.ID() +", " + l.navn() +", " + l.form()
				   + ", " + l.type()+ ", " + l.pris() +", "
				   + m.mengde_cm3() + ", " + l.virkestoffMg());
		    }
		}

		else if(l instanceof Piller){
		    Piller p = (Piller) l;
		    if(l instanceof TypeAPiller || l instanceof TypeBPiller){
			pw.println(l.ID() +", " + l.navn() +", " + l.form()
				   + ", " + l.type()+ ", " + l.pris() +", "
				   + p.nummerAvPiller() + ", " + l.virkestoffMg()
				   + ", " + styrke);
		    }
		    else{
			pw.println(l.ID() +", " + l.navn() +", " + l.form()
				   + ", " + l.type()+ ", " + l.pris() +", "
				   + p.nummerAvPiller() + ", " + l.virkestoffMg());
		    }
		}

	    }

	    pw.println("\n# Leger (navn, avtalenr / 0 hvis ingen avtale)");
	    for (Lege l: leger){
		int i = 0;
		if (l instanceof Fastlege){
		    Fastlege fl = (Fastlege) l;
		    i = fl.avtalenummer();
		}
		pw.println(l.name() + ", " + i);
	    }

	    pw.println("\n# Resepter (nr, hvit/blaa, persNummer, legeNavn, "
		       + "legemiddelNummer, reit)");
	    for (Resept r : resepter){
		String type = "";
		if (r instanceof HvitResept){
		    type = "hvit";
		}
		else if (r instanceof BlaResept){
		    type = "blaa";
		}

		pw.println(r.ID() + ", " + type + ", " + r.eier().ID() + ", "
			   + r.lege().name() + ", " + r.legemiddel().ID()
			   + ", " + r.reit());
	    }

	    pw.println("\n# Slutt");
	    pw.close();
	}
	catch (FileNotFoundException e){
	    System.out.println("File " + filnavn + " could not be created");
	}

    }

    void lesFraFil() {

	try {
	    in = new Scanner(new File(filnavn));
	} catch (Exception e) {
	    System.out.println("File " + filnavn + " can not be located.");
	}
	String[] text = null;

	while (in.hasNextLine()) {
	    text = in.nextLine().split(" ,");

	    outerloop:
	    if (text[0].startsWith("# Personer")) {
		int tall = 0;
		while (in.hasNextLine()) {
		    text = in.nextLine().split(", ");
		    if (text[0].equals(tall+"")) {
			settInnPerson(text[1], text[2], text[3], text[4]);
			tall++;
		    } else {
			break outerloop;
		    }
		}
	    }
	    else if (text[0].startsWith("# Legemidler")) {
		int tall = 0;
		while (in.hasNextLine()) {
		    text = in.nextLine().split(", ");
		    if (text[0].equals(tall+"")) {
			String styrke = "0";
			if (text.length == 8) {
			    styrke = text[7];
			}
			settInnLegemiddel(text[1], text[2], text[3], text[4], text[5], text[6], styrke);

		    } else {
			break outerloop;
		    }
		    tall++;
		}
	    } else if (text[0].startsWith("# Leger")) {
		while (in.hasNextLine()) {
		    text = in.nextLine().split(", ");
		    if (text[0].startsWith("Dr")) {
			settInnLege(text[0], text[1]);

		    } else {
			break outerloop;
		    }
		}
	    } else if (text[0].startsWith("# Resepter")) {
		int tall = 0;
		while (in.hasNextLine()) {
		    text = in.nextLine().split(", ");
		    if (text[0].equals(tall+"")) {
			settInnResept(text[1], text[2], text[3], text[4], text[5]);
		    } else {
			break outerloop;
		    }
		    tall++;
		}
	    } else if (text[0].startsWith("# Slutt")) {
		return;
	    }
	}
    }

    void sVanedanndende() {
	int antall = 0;
	int antallOslo = 0;

	for (Resept r: resepter) {
	    if (r.legemiddel().type == 'b') {
		antall++;
		// Sjekker om postnummeret er under 1300
		// fordi Oslo postnummer gar fra 0000 til 1299
		if (r.eier().postnummer() < 1300) {
		    antallOslo++;
		}
	    }
	}
	System.out.println("Antall vanedanndende resepter: " + antall);
	System.out.println("Antall vanedanndende resepter i Oslo: " + antallOslo);
    }

    /*
      Elsie har endret:
      1. Tabell finner paa indesk maa altsaa iterere gjennom liste istedenfor aa bruke finn
      2. endrer persNr til String
      3. finner reseptene i finnResept() (ny metode)
    */
    void sBlaResept(String personNr) {
	YngsteForstReseptListe liste  = finnResept(personNr);

	for (Resept r: liste) {
	    if (r instanceof BlaResept) {
		System.out.println("\nInfo om Resept:\nID: " + r.ID() + "\nLegemiddel: " +
				   r.legemiddel().navn() + "\nLege: " + r.lege().name() + "\nReit: " + r.reit());
	    }
	}
    }

    void sLegesResepter(String legeNavn){
	Lege l = leger.finn(legeNavn);

	EldsteForstReseptListe reseptListe = l.legeResept();
	int virkestoffPille =0;
	int virkestoffMikstur =0;
	for (Resept r : reseptListe){
	    if (r.legemiddel() instanceof Mikstur){
		System.out.println("\nInfo om Resept:\nID: " + r.ID() + "\nLegemiddel: " +
				   r.legemiddel().navn() + "\nEier: " + r.eier().name() + "\nReit: " + r.reit());
		Mikstur m= (Mikstur) r.legemiddel();
		virkestoffMikstur += m.virkestoffPercm3()*m.mengde_cm3();
	    }
	    else{
		Piller p = (Piller) r.legemiddel();
		virkestoffPille += p.virkestoffPerPille()*p.nummerAvPiller();
	    }
	}
	System.out.println("Virkestoff totalt: " + (virkestoffPille + virkestoffMikstur));
	System.out.println("Virkestoff (Piller:Mikstur) " + virkestoffPille +":" + virkestoffMikstur);
    }

    void sNarkotika() {
	int antall = 0;
	boolean narkotisk = false;

	System.out.println("Leger: ");
	for (Lege l: leger) {
	    EldsteForstReseptListe liste = l.legeResept();
	    for (Resept r: liste) {
		if (r.legemiddel() instanceof TypeAMiks || r.legemiddel() instanceof TypeAPiller) {
		    narkotisk = true;
		    antall++;
		}
	    }
	    if (narkotisk) {
		System.out.println(l.name() + ", " + antall);
		narkotisk = false;
		antall = 0;
	    }
	}

	System.out.println("\nPersoner: ");
	for (Person p: personer) {
	    YngsteForstReseptListe liste = p.personResept();
	    for (Resept r: liste) {
		if (r.legemiddel() instanceof TypeAMiks || r.legemiddel() instanceof TypeAPiller) {
		    if (r.reit() != 0) {
			narkotisk = true;
			antall++;
		    }
		}
	    }
	    if (narkotisk) {
		System.out.println(p.name() + ", " + antall);
		narkotisk = false;
		antall = 0;
	    }
	}
	// Kan ta lang tid aa gaa gjennom lokkene, kunne vaert lurt aa lagre informasjonen i en array.
    }

    /* Elsie lagt til:
       La til denne metoden som finner Reseptene til en person via personnummeret. Grunnen til at egen metode er 
       at det er saa mange steder det skal skje
    */
    YngsteForstReseptListe finnResept(String personNr){
	try{
	    for(Person p : personer){
		if (personNr.equalsIgnoreCase(p.fodselnummer() +"")){
		    return p.personResept();
		}
	    }
	}
	catch(Exception e){
	    System.out.println ("Personen finnes ikke");
	}
	return null;
    }
}
