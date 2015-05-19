
class KnappFakultet {
    static int  fac(int n){
	if (n>0){
	    int fakultetetAvN = n*fac(n-1);
	    return fakultetetAvN;
	}
	return 1;
    }

    public static void main(String [] args){
	int fakultetet =fac (6);
	Grafisk grafisk = new Grafisk();
	
	

    }

}
