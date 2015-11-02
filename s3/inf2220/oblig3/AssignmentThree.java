import java.util.*;
import java.io.*;
class AssignmentThree{

    private static String needle = null;
    private static String haystack = null;
    
    public static void main(String[] args) {
	try{
            needle = args[0];
            haystack = args[1];	
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println ("ERROR! Not enough arguments found!");
            System.out.println ("Should be given on the form:\n \njava AssignmentThree <needle> <haystack>\n");
            System.exit(1);
        }

	readFile();
	BoyerMoore stringSearch= new BoyerMoore(needle, haystack); //this object does all the solving
	stringSearch.printMatches();
    }



    public static void readFile(){
	Scanner filNeedle;
	Scanner filHaystack;
	try {
	    filNeedle = new Scanner(new File(needle));
	    filHaystack = new Scanner(new File(haystack));   
	}

	catch(FileNotFoundException e){
	    System.out.println ("ERROR! Not a leagal filename");
	    System.exit(1);
	    return;
	}

	needle = "";
	haystack = "";
	
	while(filNeedle.hasNextLine()){
	    needle += filNeedle.nextLine();
	}
	while(filHaystack.hasNextLine()){
	    haystack += filHaystack.nextLine() + "\n";
	}

    }
}
