class Hovedprogram {
    static Hylle<Bok> bokHylle = new Hylle<Bok>(100);
    public static void main(String[] args){
	boolean feil = false;
	System.out.println (feil);
	feil = feil(feil, tom());
	System.out.println (feil);
	Bok bok1 = new Bok("bok1");
	//boolean tilslutt er om det skal funke eller ikke, true = meningen at skal gaa feil
	feil = feil(feil, settInn(0, bok1, false));
	feil = feil(feil, !settInn(0, new Bok("bok2"), true));
	feil = feil(feil, tarUt(0, bok1, false));
	feil = feil(feil, tarUt(0, null, false));
	feil = feil(feil, tom());
	Bok[] bok = new Bok[100];
	for (int i = 0; i<100; i++){
	    bok[i] = new Bok("bok" + i);
	    feil = feil(feil, settInn(i, bok[i], false));
	}
	feil = feil(feil, !tom());
	feil = feil(feil, !settInn(100, new Bok("bok100"), true));
	for (int i = 0; i < 100; i++){
	    feil = feil(feil, tarUt(i, bok[i], false));
	}

	//Sjekker at tom
	feil = feil(feil, tom());
	if (!feil){
	    System.out.println ("Supert, alt funket!");
	}
	
	
    }

    public static boolean settInn(int nr, Bok bok, boolean meningen){
	if(!bokHylle.settInn(nr, bok)){
	    System.out.print ("Kan ikke sette " + bok.toString() + " inn paa plass nr "+ nr);
	    if (meningen){
		System.out.println ("   BRA!");
	    }
	    return false;
	}
	return true;
    }

    public static boolean tarUt(int nr, Bok sammenlignes, boolean meningen){
	Bok mid = bokHylle.taUt(nr);
	if(mid != sammenlignes){
	    System.out.print ("Returnerer " + mid.toString() + " skal returnere " + sammenlignes.toString());
	    if (meningen){
		System.out.println ("   BRA!");
	    }
	    return false;
	}
	return true;
    }

    public static boolean feil(boolean feil, boolean resultat){
	if (!feil){
	    feil = !resultat;
	}
	
	return feil;
    }
    public static boolean tom(){
	boolean temp = true;
	for (int i = 0; i < bokHylle.storrelse(); i++){
	    if (!bokHylle.sjekkOmLedig(i)){
		temp = false;
	    }
	}
	return temp;
    }
	    
	
}
