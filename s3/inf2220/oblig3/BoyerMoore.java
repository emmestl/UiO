import java.util.ArrayList;
import java.util.Arrays;
class BoyerMoore{

    private int[] badCharShift;
    private char[] needle;
    private char[] haystack;
    private ArrayList<Integer> matches;
    private boolean equal = true;
    private final String NEEDLE;
    private final String HAYSTACK;
    
    public BoyerMoore(String sNeedle, String sHaystack){
	this.NEEDLE = sNeedle;
	this.HAYSTACK = sHaystack;
	
	matches = new ArrayList<>();

	needle = sNeedle.toCharArray();
	haystack = sHaystack.toCharArray();


	setupBadCharShift();
	findMatches();
    }


    public void setupBadCharShift(){
	badCharShift = new int[256];

	for(int i= 0; i < badCharShift.length; i ++){
	    badCharShift[i] = needle.length;
	}


	for(int i= 0; i < needle.length; i++){
	    if(needle[i] != '_'){
		badCharShift[(int) needle[i]] = 1;
	    }
	    else{
		equal = false;
	    }
	}
    }


    public void findMatches(){
	if(needle.length > haystack.length){
	    return;
	}

	final int last = needle.length -1;
	final int maxShiftet = haystack.length - last;

	int index = 0;
	int shiftedIndex = 0;

	while(shiftedIndex < maxShiftet){
	    for(index = last; equalChar(index, shiftedIndex) ; index --){
		if(index == 0){
		    //match found continue search
		    matches.add(shiftedIndex);
		    break;
		}
	    }

	    System.out.println (shiftedIndex);
	    shiftedIndex += shift(haystack[shiftedIndex + last], last);
	}
	//Nothing found
    }


    public int shift(char c, int index){
	if(needle[index] == '_'){
	    return 1;
	}
	if(badCharShift[(int) c] == needle.length){ //does not exists
	    return needle.length;
	}

	//exists
	for(int i = needle.length -1; i >= 0; i --){
	    if(needle[i] == c){
		return needle.length - i;
	    }
	}

	return -1; //is never suposed to happen
    } /*checks the last char occurace later on in string*/

    public boolean equalChar(int index, int shiftedIndex){
	if(needle[index] == '_'){
	    return true;
	}

	return needle[index] == haystack[index + shiftedIndex];
    }


    public void printMatches(){
	if(matches.size() == 0){
	    System.out.println (NEEDLE +" not found");
	    return;
	}
	if(equal){
	    System.out.println (matches.size() +" matches found");
	    for(int i = 0; i< matches.size(); i ++){
		System.out.print ("Index: " + matches.get(i));
		System.out.println ("\tWord:" + NEEDLE);
	    }
	}

	else{
	    System.out.println (matches.size() +" matches found");
	    for(int i = 0; i< matches.size(); i ++){
		System.out.print ("Index: " + matches.get(i));
		System.out.println ("\tWord: " + HAYSTACK.substring(matches.get(i), matches.get(i) + needle.length));
	    }
	}
    }
}
