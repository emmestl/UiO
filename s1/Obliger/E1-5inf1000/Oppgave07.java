class Oppgave07{
    
    public static void main(String [] args){
	Brev brev = new Brev ();
	String mottaker = "x";
	String avsender = "y";

	brev.tilOGfra(mottaker, avsender);
	brev.skrivLinje("forste linje i Brevet");
	brev.skrivLinje("andre linje i Brevet");

	String[] lestBrev = brev.lesBrev();
	
	for (int i =0; i<brev.brevLengde; i++){
	    System.out.println(lestBrev[i]);
	}
    }
}

