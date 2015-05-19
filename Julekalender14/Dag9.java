import java.lang.*;
import java.util.*;
class Dag9{
    public static void main (String [] args){
	//Random generator
	int [] tall = {1,2,3,4,5,6,7,8,9,0};
	String tall1 = "";
	String tall2 ="";
	int teller =0;
	Random rnd = new Random();
	int indeks;
	int sum;
	int minste = 987;
	String summen ="";
	int teller2 =0;
	
	while(teller <100000){
	    for (int i =tall.length -1; i >0; i--){
		indeks = rnd.nextInt(i+1);
		int a = tall[indeks];
		tall[indeks] = tall[i];
		tall[i] = a;
	    }
	    
	    //System.out.println ("HEi");
	    
	    for (int i =0; i < 3; i++){
		tall1 += tall[i];
	    }
	    
	    for (int i = 3; i<6; i++){
		tall2 += tall[i];
	    }
	    
	    if(tall1.length() ==3 && tall2.length() ==3){
		sum = Integer.parseInt(tall1) + Integer.parseInt(tall2);
		summen += sum;
		//System.out.println (tall1 + "   " +tall2);
		//System.out.println (sum);
		if(summen.length() == 4){
		    for(int i =0; i<10; i++){
			if(tall1.contains(i +"" ) || tall2.contains(i +"")){
			    if (summen.contains(i+"")){
				//System.out.println ("Feil1");
				break;
			    }
			}
			else if (!summen.contains(i+"")){
			    //System.out.println ("Feil2");
			    break;
			    
			}
			
			teller2++;
		    }
		    //System.out.println (teller2);
		    if(teller2 ==10){
			if(Integer.parseInt(tall1) < minste){
			    minste = Integer.parseInt(tall1);
			}
			if(Integer.parseInt(tall2) <minste){
			    minste = Integer.parseInt(tall2);
			}
		    }
		}
		//System.out.println (summen);
	       	//System.out.println (minste);
		//System.out.println ("Feil3");
		summen ="";
		//System.out.println (teller2);
	    }
	    teller2 =0;
	    tall1 = "";
	    tall2 ="";
	    teller++;
	}
	System.out.println (minste);
    }
}
			
