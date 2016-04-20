import java.util.*;
import java.io.*;

class Houses {

    private static int[] pos;
    public static void main(String[] args) throws Exception{

	int[] posRobo = new int[2];
	int[] posSanta = new int[2];
	
	BufferedReader in = new BufferedReader(new FileReader(new File("houses.txt")));
	HashMap<Integer, HashMap<Integer, Integer>> houses = new HashMap<>(); //first is house cord second is nr visits
	int cmd;
	pos = posRobo;
	
	while(((cmd = in.read()) != -1)){
	    pos = (pos == posRobo) ? posSanta : posRobo;
	    
	    if(newPos((char) cmd)){

		if(houses.containsKey(pos[0])){
		    if(houses.get(pos[0]).containsKey(pos[1])){
			int temp = houses.get(pos[0]).get(pos[1]);
			temp ++;
			houses.get(pos[0]).put(pos[1], temp);
		    }
		    else{
			houses.get(pos[0]).put(pos[1], 0);
		    }
		}
		else{
		    houses.put(pos[0], new HashMap<Integer, Integer>());
		    houses.get(pos[0]).put(pos[1], 0);
		}
	    }
	}

	int antHouses = 0;
	for(HashMap<Integer, Integer> h : houses.values()){
	    antHouses += h.size();
	}

	System.out.println ("ant houses: "+ antHouses);
	in.close();
    }



    public static boolean newPos(char cmd){
	if(cmd == '^'){
	    pos[0] ++;
	}
	else if(cmd == 'v'){
	    pos[0] --;
	}
	else if(cmd == '>'){
	    pos[1] ++;
	}
	else if(cmd == '<'){
	    pos[1] --;
	}
	else{
	    return false;
	}

	return true;
    }
}
