import java.util.Arrays;
import java.util.ArrayList;
class Dag15{
    public int[] iSomArray (int i){
	int[] tallIi = new int[4];
	for(int k =3; k>=0; k--){
	    tallIi[k] = i%10;
	    i = i/10;
	}
	return tallIi;
    }

    public int[][] muligeX(int j){
	int[] i = iSomArray(j);
	int[][] xEr = new int[12][3];
	int teller = 0;
	for(int h = 0; h<4; h++){
	    for(int k = 0; k<4; k++){
		ArrayList <Integer> enTilfire = new ArrayList<>();
		enTilfire.clear();
		for (int g =0; g<4; g++){
		    enTilfire.add(g);
		}
		
		if (k!= h){
		    if(k<h){
			enTilfire.remove(h);
			enTilfire.remove(k);
		    }
		    else{
			enTilfire.remove(k);
			enTilfire.remove(h);
		    }
		    
		    xEr[teller][0] = Integer.parseInt("" + i[h] +i[k]);
		    xEr[teller][1] = Integer.parseInt ("" +i[enTilfire.get(1)] + i[enTilfire.get(0)]);
		    xEr[teller][2] = Integer.parseInt("" + i[enTilfire.get(0)] + i[enTilfire.get(1)]);
		    teller ++;
		}
	    }
	}
	//System.out.println (Arrays.toString(xEr));
	return xEr;
    }	    
	    
    public boolean finnMulige(int j){
	boolean mulig = false;
	int[][] xEr = muligeX(j);
	int y = 0;
	for (int i =0; i < xEr.length; i++){
	    if(xEr[i][0] ==0){
		//kan ikke dele paa 0
	    }
	    else if(j%xEr[i][0] == 0){
		y = j/xEr[i][0];
		for(int m = 1; m<3; m++){
		    if (y == xEr[i][m]){
			/*for(int l =0; l < xEr.length; l++){
			    if(y== xEr[l][0] && l != i){
				if(y/100 == 0){*/
			if(xEr[i][0]%10==0 && y%10==0){
			    //ikke denne
			}
			else{
			    mulig = true;
			    System.out.println (j + "     " + xEr[i][0] + " : " + y);
			    return mulig;
			}		    
				    //		}
		    //  }
		    //}
		    }
		}
	    }

	}
	return mulig;
    }
    
	    
    public static void main (String[] agrs){
	Dag15 m = new Dag15();
	int antall = 0;
	for (int i = 1000; i<10000; i++){
	    if(m.finnMulige(i)){
		antall++;
	    }
	}

	System.out.println (antall);
    }
}

	
		
	    
		
	    
