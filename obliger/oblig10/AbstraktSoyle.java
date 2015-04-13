import java.util.Arrays;
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

    public Rute getRute(int posisjon){
	return ruter[posisjon];
    }
    public void utskrift(){
	System.out.println (Arrays.toString(verdier));
    }
}
