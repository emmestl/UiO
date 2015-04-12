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

	b.los();
    }
}
