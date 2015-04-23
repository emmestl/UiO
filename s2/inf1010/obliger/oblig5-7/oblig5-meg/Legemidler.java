class Legemidler{
    static int teller = 0;
    private String navn;
    private String uNr;
    private Double pris;

    Legemidler(){
	uNr = "0" + teller;
	teller++;
    }
}
