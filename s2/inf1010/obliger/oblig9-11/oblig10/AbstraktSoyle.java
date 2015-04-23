import java.util.Arrays;
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
    public void utskrift(){
	for (int i = 0; i< ruter.length; i++){
	    System.out.print (ruter[i].verdi());
	}
	System.out.println ();
    }
}
