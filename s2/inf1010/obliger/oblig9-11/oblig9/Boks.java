class Boks extends AbstraktBrett{
    private int[][] verdier;

    Boks(int v, int l){ //vannrett og loddrett
	super(v, l);
	alleRutene = new Rute[v][l];
	verdier = new int[v][l];
    }
    public void settVerdi(int v, int l, Rute r){
	alleRutene[v][l]= r;
	verdier[v][l] = r.verdi();
    }


    public void printUt(){
	System.out.println ("NY BOKS");
	for (Rute r: this){
	    System.out.println (r.verdi());
	}
    }
}
