class GrafiskFakultet {

    static int  fac(int n){
	if (n>0){
	    int fakultetetAvN = n*fac(n-1);
	    return fakultetetAvN;
	}
	return 1;
    }

    public static void main(String [] args){
	Grafisk grafisk = new Grafisk();
	
	int fakultetet = Integer.parseInt(grafisk.inText());
	int fakultet = fac(fakultetet);
	
    }

}
