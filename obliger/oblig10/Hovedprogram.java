import java.util.Arrays;
class Hovedprogram {
    public static void main(String[] args) {
	Brett b = new Brett();
	b.utskrift();
	/*
	for (int i = 0; i < 3; i++){
	    for (int j = 0; j< 4 ; j++){
		b.getBoks(i,j).printUt();
	    }
	    }*/

	for (int i = 0; i < 4; i++){
	    for (int j = 0; j < 3; j++){
		System.out.println ();
		b.getBoks(j, i).utskrift();
	    }
	}
    }
}
