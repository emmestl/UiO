import java.util.*;

class Wrappin{

    public static void main(String[] args) {

	int total = 0;
	int ribbon = 0;
	int[] nr = new int[4];
	int[] values = new int[3];
	nr[0] = -1;
	int min = -1;


	Scanner in = new Scanner(System.in);
	String linje;

	while(in.hasNextLine()){
	    linje  = in.nextLine();

	    //get the right dimentions
	    nr[3] = linje.length();
	    for(int i= 1; i < 3; i++){
		nr[i] = linje.indexOf("x", nr[i -1] +1 );
		values[i-1] = Integer.parseInt(linje.substring(nr[i-1] +1, nr[i]));
	    }

	    values[2] = Integer.parseInt(linje.substring(nr[2] +1, nr[3]));
	    Arrays.sort(values);

	    //pakke dim
	    ribbon += values[0]*2 + values[1]*2;
	    ribbon += values[0]*values[1]*values[2];

	    int side = 0;
	    for(int i = 0; i < values.length; i ++){
		for(int j = i + 1; j < values.length; j ++){
		    side = values[i] *values[j];
		    total += 2*side;
		    if(side < min || min == -1){
			min = side;
		    }
		}
	    }

	    total += min;
	    min = -1;
	}
	System.out.println ("Total: " + total);
	System.out.println ("Ribbon: " + ribbon);
    }
}
