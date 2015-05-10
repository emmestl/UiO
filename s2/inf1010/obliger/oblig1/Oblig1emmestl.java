class Oblig1emmestl {

    public static void main(String[] a) {
        hovedprogram();
    }

    public static void testOmSomForventet(String hva, String verdi, String fverdi) {
	String utfall;
	if (verdi.compareTo(fverdi) == 0) utfall = verdi + ", OK.";
	else utfall =  "FEIL, aktuell verdi: " + verdi 
		 + ", forventet verdi: " + fverdi; 
	System.out.println("== Tester " + hva + ": " + utfall );
    }

    public static void testMusebol( Bol<Mus> musebolet, String id ) {

	// Klasen Bol<T> skal ha en metode tomt() som returnerer true
	// nÃ¥r bolet ikke er bebodd av ei mus.
	if ( musebolet.tomt() ) {
	    System.out.println(" ###### " + id + " Musebolet er tomt");
	} else {
	    System.out.println(" ###### " + id + " Musebolet er bebodd:");
	    musebolet.beboer().sjekktilstand(" IBOL ", "?", false, 0, false );
	}
    }


    public static void hovedprogram() {
	//ENDRER SYKDOMSSTATUSEN TIL PUS! RESTN AV PROGRAMMET ANTAR
	//AT PUS ER ORIGINALT FRISK, MEN BLE LAGET SYK (NAA ENDRET)
	Katt pus = new Katt("Pus", 4560, false);
	System.out.println("============= Tester Pus:");
	testOmSomForventet("kattens navn", pus.navn(), "Pus");
	testOmSomForventet("kattens vekt", pus.vekt(), "4560");
	testOmSomForventet("antall mus i magen", pus.antMus(), "0");
	testOmSomForventet("om katten er syk", pus.syk(), "false");

	// Merk at testmetoden her krever at get-metodene vekt(),
	// antMus() og syk() i Katt returnerer String som type,
	// ikke int og boolean. Dette ser vi av signaturen til
	// testOmSomForventet.

	Katt mons = new Katt("Mons");
	System.out.println("============= Tester Mons:");
	testOmSomForventet("kattens navn", mons.navn(), "Mons");
	testOmSomForventet("kattens vekt", mons.vekt(), "5000");
	testOmSomForventet("antall mus i magen", mons.antMus(), "0");
	testOmSomForventet("om katten er syk", mons.syk(), "false");

	Katt[] katter = new Katt[5];
	katter[0] = mons;
	katter[1] = pus;

	Mus m1 = new Mus(37, false);
	m1.sjekktilstand("A", "musNr1", false, 37, true);
	//              (testid, navn, syk, vekt, lever) 
	Mus m2 = new Mus(38, true);
	m2.sjekktilstand("B", "musNr2", true, 38, true);

	Bol<Mus> musebolet = new Bol<Mus>();
	testMusebol(musebolet, "P");

	musebolet.settInn(new Mus(39, false));
	testMusebol(musebolet, "Q");

	/* 
	 * Oppgave 1a
	 * Tegn datastrukturen slik den ser ut her, med 1 katt-array, 1 musebol,
	 * 2 katter og 3 mus. For mus og katt trenger du bare Ã¥ ha med alle detaljer
	 * i ett av objektene
	 *
	 */


	// Tester taUt-metoden i Bol:
	
	Mus mm = musebolet.taUt();
	testMusebol(musebolet, "R");
	musebolet.settInn(mm);

	if (mm != musebolet.beboer())
	    System.out.println("S: FEIL: mm og musebol ikke samme musobjekt");

	// La jakta starte!
	// FÃ¸rst er det Pus som fÃ¥r 2 forsÃ¸k
	// Hvis Pus ikke spiser musa, setter vi den inn igjen
	// Hvis Pus har spist musa i musebolet, setter vi inn ei ny

	for (int i=0; i < 2; i++) {
	    // Kommentar til sjekktilstand:
	    // "?" som andreparameter skal ha som virkning at metoden
	    // skriver ut info (se utskriftsfila)  istedet for Ã¥ teste.
	    // Da har det ingen betydning hva de tre siste aktuelle
	    // parametrene er, siden de ikke blir sjekket
	    musebolet.beboer().sjekktilstand("B1", "?", false, 0, false );
	    mm = pus.gaaPaaJaktI(musebolet);

	    System.out.println("============= Tester Pus (i lÃ¸kke) :");
	    testOmSomForventet("antall mus i magen", pus.antMus(), new Integer(i+1).toString());
	    testOmSomForventet("kattens vekt", pus.vekt(), new Integer(4560+39+i*(55+i-1)).toString());
	    testOmSomForventet("om katten er syk", pus.syk(), "false");

	    if ( mm != null) musebolet.settInn(mm);	
	    else musebolet.settInn(new Mus(55+i, false));
	}

	// SÃ¥ tester vi at Pus nÃ¥ er mett, og at musa er blitt syk etter
	// Ã¥ ha blitt bitt...
	//ENDRET AV MED, VERDIEN LEVER = true!
	musebolet.beboer().sjekktilstand("X", "musNr5", false, 56, true );
	mm = pus.gaaPaaJaktI(musebolet);
	if ( mm != null) musebolet.settInn(mm);
	musebolet.beboer().sjekktilstand("Y", "musNr5", true, 56, true );

	// Deretter fÃ¥r Mons og Pus 2 forsÃ¸k hver annenhver gang:

	for (int i=0; i < 2; i++) {
        musebolet.beboer().sjekktilstand("B2", "?", false, 0, false );
	    mm = mons.gaaPaaJaktI(musebolet);
	    if ( mm != null) musebolet.settInn(mm);	
	    else musebolet.settInn(new Mus(44+i, false));
        musebolet.beboer().sjekktilstand("B3", "?", false, 0, false );
	    mm = pus.gaaPaaJaktI(musebolet);
	    if ( mm != null) musebolet.settInn(mm);	
	    else musebolet.settInn(new Mus(33+i, false));
	}


	//  Vi lar sÃ¥ en ny katt, Jery spise ei syk mus:
	musebolet.beboer().sjekktilstand("Z", "musNr7", true, 45, true );

	Katt jerry = new Katt("Jerry");
	mm = jerry.gaaPaaJaktI(musebolet);
	if ( mm != null) musebolet.settInn(mm);	
	else musebolet.settInn(new Mus(77, true));

	// SÃ¥ lar vi en mett katt skade musa til den dÃ¸r:

	mm = mons.gaaPaaJaktI(musebolet);
	if ( mm != null) musebolet.settInn(mm);
	mm = mons.gaaPaaJaktI(musebolet);
	if ( mm != null) musebolet.settInn(mm);
	musebolet.beboer().sjekktilstand("B4", "?", false, 0, false );



	// sjekker til slutt at Jerry ikke spiser den dÃ¸de musa i bolet
	testOmSomForventet("Jerrys antall mus i magen", jerry.antMus(), "1");
	mm = jerry.gaaPaaJaktI(musebolet);
	testOmSomForventet("Jerrys antall mus i magen", jerry.antMus(), "1");

	System.out.println("============= Tester Pus:");
	testOmSomForventet("kattens navn", pus.navn(), "Pus");
	testOmSomForventet("kattens vekt", pus.vekt(), "4654");
	testOmSomForventet("antall mus i magen", pus.antMus(), "2");
	testOmSomForventet("om katten er syk", pus.syk(), "false");

	System.out.println("============= Tester Mons:");
	testOmSomForventet("kattens navn", mons.navn(), "Mons");
	testOmSomForventet("kattens vekt", mons.vekt(), "5100");
	testOmSomForventet("antall mus i magen", pus.antMus(), "2");
	testOmSomForventet("om katten er syk", mons.syk(), "true");

	System.out.println("============= Tester Jerry:");
	testOmSomForventet("kattens navn", jerry.navn(), "Jerry");
	testOmSomForventet("kattens vekt", jerry.vekt(), "5045");
	testOmSomForventet("antall mus i magen", jerry.antMus(), "1");
	testOmSomForventet("om katten er syk", jerry.syk(), "true");



    }	
	
	
}



 



       
