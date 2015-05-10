/** regner ut om x 0,335l bokser eller en 2 liter flaske 
	   inneholder mest brus */

import java.util.Scanner;

class Sodacans {
    public static void main(String [] args){
	
	Scanner user_input = new Scanner (System.in);
	int number_of_cans;
	System.out.print ("Enter number of cans i pack: ");
	number_of_cans = user_input.nextInt ();
	

	final double VOLUME_IN_CAN = 0.335;
	final int VOLUME_IN_BOTTLE = 2;
	
	System.out.println (VOLUME_IN_CAN);
	System.out.println (number_of_cans);

	double liter_in_cans = 1;
	liter_in_cans = number_of_cans * VOLUME_IN_CAN;
	System.out.println (liter_in_cans);
	
	if (liter_in_cans > VOLUME_IN_BOTTLE) {
	    System.out.println ("There is " + liter_in_cans + "l soda in cans. Therfore you should by the cans!" );
	}
	else if (liter_in_cans == 2) {
	    System.out.println ("The amount of soda is the same, you choose");
	}
	else {
	    System.out.println ("There is more soda in the bottle, by the bottle!");
	}
    }
}

	