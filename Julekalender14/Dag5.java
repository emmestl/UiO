//*******************************************************************
// Java compiler created in PHP to quickly and safely test code.
// NOTE: please read the 'More Info' tab to the right for shortcuts.
//*******************************************************************

import java.util.*;
import java.lang.*;

public class Dag5
{
    public static void main(String args[])
    {
	Random rnd = new Random();
	String tall ="";
	int tallet;
	int teller =0;
	int [] ar = {1,2,3,4,5,6,7,8,9};
	int [] store = new int[100000];
	// 1, 2, 3, 4, 5, 6, 7, 8, 9
		
	//System.out.println(tallet);
	//int[]store = new int[];
	int prim = 2;
	int storst =0;
	//System.out.println ((1+2+3+4+5+6+7+8+9)%9);
	while (teller <100000){
	    for (int i = ar.length - 1; i > 0; i--){	
		int index = rnd.nextInt(i + 1);
		// Simple swap
		int a = ar[index];
		ar[index] = ar[i];
		ar[i] = a;
	    }
	    //System.out.println(Arrays.toString(ar));
	    for (int i =0; i < ar.length; i++){
		tall += ar[i];
	    }
    		
	    tallet = Integer.parseInt(tall);
    		
	    while(prim< Math.sqrt(tallet)+1){	
		if(tallet%prim == 0){
		    tallet = tallet/prim;
		    //System.out.println(prim);
		    storst = prim;
		}
		else{
		    prim++;
		}
	    }
			
	    //System.out.println("Her");
	    if (tallet > prim){
		store[teller] = tallet;
	    }
	    else{
		store[teller] = prim;
	    }
	    prim = 2;
	    teller++;
	    //System.out.println("Naa da");
	    tall ="";
	}
	Arrays.sort(store);
	//System.out.println("Naa");
	System.out.println(store[0] + ": " + store[store.length-1]);
    }
}
	