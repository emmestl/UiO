import java.util.*;
import java.io.*;
class AssignmentThree{

    private static String needle;
    private static String haystack;
    
    public static void main(String[] args) {
	try{
            needle = args[0];
            haystack = args[1];	
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println ("ERROR! Not enough arguments found!");
            System.out.println ("Should be given on the form:\n \njava AssignmentThree <needle> <haystack>\n");
            System.exit(1);
	    return;
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

	//as to not make a new String every time a new line is read.
	StringBuilder needleBuild = new StringBuilder();
	StringBuilder haystackBuild = new StringBuilder();
	
	while(filNeedle.hasNextLine()){
	    needleBuild.append(filNeedle.nextLine() + "\n");
	}
	while(filHaystack.hasNextLine()){
	    haystackBuild.append(filHaystack.nextLine() + "\n");
	}

	needleBuild.deleteCharAt(needleBuild.length() -1); //get rid of the last "\n" that was added
	haystackBuild.deleteCharAt(haystackBuild.length() -1); //get rid of the last "\n" that was added
	
	needle = needleBuild.toString();
	haystack = haystackBuild.toString();
    }
}
