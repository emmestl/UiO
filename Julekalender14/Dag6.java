import java.util.HashMap;

class Dag6{
    public static void main(String [] args){
	HashMap <Long,Long > forskjellige = new HashMap <>();

	for(long i = 1; i <= 8000; i++){
	    for (long j = 1; j <= 8000; j++){
		if(!forskjellige.containsKey(i*j)){
		    forskjellige.put(i*j, i*j);
		}
	    }
	}

	System.out.println(forskjellige.keySet().size());

    }
}

	
