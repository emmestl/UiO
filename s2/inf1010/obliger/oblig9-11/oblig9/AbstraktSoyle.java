class AbstraktSoyle{
    protected Rute[] ruter;

    AbstraktSoyle(int antall){
	ruter = new Rute[antall];
    }

    public void settVerdi(int posisjon, Rute r){
	ruter[posisjon] = r;
    }

    public Rute[] getRuter(){
	return ruter;
    }
    public Rute getRute(int posisjon){
	return ruter[posisjon];
    }
}
