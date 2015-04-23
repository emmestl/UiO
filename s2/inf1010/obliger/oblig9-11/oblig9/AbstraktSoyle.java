class AbstraktSoyle{
    protected int [] verdier;
    protected Rute[] ruter;

    AbstraktSoyle(int antall){
	verdier = new int[antall];
	ruter = new Rute[antall];
    }

    public void settVerdi(int posisjon, Rute r){
	ruter[posisjon] = r;
	verdier[posisjon] = r.verdi();
    }

    public int[] getVerdier(){
	return verdier;
    }
}
