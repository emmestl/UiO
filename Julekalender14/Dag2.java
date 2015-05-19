import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;



class Dag2 {

    private HashMap <Integer, ArrayList<Integer>> primtall = new HashMap<>();
    private int [] tallet;
    
    public static void main (String [] args) {
	Dag2 d2 = new Dag2();
	System.out.println (d2.finnTallet());
    }

    public String finnTallet(){
	int onsket = 9;
	tallet = new int[onsket];
	tallet[0] = onsket;
	int teller =0;
	String svaret ="";
	while (teller <onsket-1){
	    settInnTall(teller);
	    teller++;
	}
	for(int i =0; i < onsket; i ++){
	    svaret = svaret + tallet[i];
	}
	return svaret;
    }
	

    public void settInnTall(int teller){
	if(!primtall.containsKey(tallet[teller])){
	    finnPrimtall(tallet[teller]);
	}

	for (int i =0; i < primtall.get(tallet[teller]).size() ; i++){
	    if(!sjekkOmBrukt(tallet[teller]*10 + primtall.get(tallet[teller]).get(i))){
		if(tallet[teller +1] != primtall.get(tallet[teller]).get(i)){
		    
		    tallet[teller +1] = primtall.get(tallet[teller]).get(i);
		    return;
		}
	    }
	}
	teller = teller - 1;
	if(teller == primtall.get(teller).size()){
	    teller -= 1;
	}
    }
	
    public boolean sjekkOmBrukt(int prim){
	for (int i=0; i < tallet.length; i++){
	    if(tallet[i] == prim/10){
		if(tallet [i+1] == prim%10){
		    return true;
		}
	    }
	}
	return false;
    }

    public void finnPrimtall(int tall1){
	int tall10 = tall1*10;
	int tall = tall10;
	ArrayList <Integer> mid = new ArrayList<>(); 
	primtall.put(tall1, mid);
	
	for (int i = 0; i < tall10+10; i ++){
	    tall ++;
	    if (tall%7==0 || tall%5==0 || tall%3==0 || tall%2==0){
	    }
	    else {
		primtall.get(tall1).add(tall%10);
	    }
	}
    }
}
    

	
