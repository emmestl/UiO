class Boks extends AbstraktBrett{

    Boks(int v, int l){ //vannrett og loddrett
	super(v, l);
	alleRutene = new Rute[v][l];
    }
    public void settVerdi(int v, int l, Rute r){
	alleRutene[v][l]= r;
    }

}
