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

    /*setup takes a bit of time, but once that is done everything else goes quicker*/
    public void setupBadCharShift(){
	badCharShift = new int[256];

	for(int i= 0; i < badCharShift.length; i ++){
	    badCharShift[i] = needle.length;
	}


	/*it letter exists in word the needle will be shiftet so the last charackter maches
	  exept if the the character is the last one in the needle
	*/
	ArrayList<Integer> nrWildcard = new ArrayList<>();
	for(int i= 0; i < needle.length; i++){
	    if(needle[i] != '_' && i != needle.length -1){
		badCharShift[(int) needle[i]] = needle.length -1 -i;
	    }
	    else if(needle[i] == '_'){
		nrWildcard.add(i);
	    }
	}

	//there is at least one wildcard
	if(nrWildcard.size() > 0){
	    equal = false;

	    for(int j = nrWildcard.size() -1; j >= 0; j--){

		if(nrWildcard.get(j) == needle.length -1 ){
		    /* if the wildcard is the last char in the needle do as if it is a normal char
		       AKA do nothing special
		    */
		}
		else if(nrWildcard.size() == needle.length){
		    for(int i= 0; i < badCharShift.length; i ++){
			badCharShift[i] = 1;
		    }
		}
		else{
		    for(int i= 0; i < badCharShift.length; i ++){
			badCharShift[i] = needle.length -1 - nrWildcard.get(j);
		    }

		    for(int i= 0; i < needle.length; i++){
			if(needle[i] != '_' && i != needle.length -1){
			    if(badCharShift[(int) needle[i]] > needle.length - 1 - i){
				badCharShift[(int) needle[i]] = needle.length -1 - i;
			    }
			}
		    }
		    return;
		}
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
	    shiftedIndex += badCharShift[(int)(haystack[shiftedIndex + last])];
	}
	//Nothing found
    }

    /*checks the last char occurace later on in string*/
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
