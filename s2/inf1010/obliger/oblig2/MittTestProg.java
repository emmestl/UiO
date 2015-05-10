class MittTestProg{
    public static void main (String [] args){
	Mengde<String> test = new Mengde<String>();
	System.out.println ("Forventer true: " + test.tom());
	String e = "1.";
	System.out.println ("Forventer true: " + test.leggTil(e));
	System.out.println ("Forventer false: " + test.tom());

	System.out.println ("Loops");
	for (int i = 2; i < 10000; i ++){
	    boolean temp = test.leggTil(i+".");
	}
	
	System.out.println ("Forventer true: " + test.inneholder(e));
	System.out.println ("Forventer false: " + test.inneholder("0"));


	System.out.println ("Forventer true: " + test.leggTil("10000."));
	System.out.println ("Forventer false: " + test.leggTil(e));

	System.out.println ("Forventer '1.': " + test.fjernEldste());
	System.out.println ("Forventer '10000': " + test.fjernNyeste());

	System.out.println ("Forventer false: " + test.tom());
    }
}
			    
	
