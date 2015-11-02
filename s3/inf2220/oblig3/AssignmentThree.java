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
	//Takk til Ole-Christian Hagenes for tips
	StringBuilder needleBuild = new StringBuilder(filNeedle.nextLine());
	StringBuilder haystackBuild = new StringBuilder(filHaystack.nextLine());
	
	while(filNeedle.hasNextLine()){
	    needleBuild.append(filNeedle.nextLine());
	}
	while(filHaystack.hasNextLine()){
	    haystackBuild.append(filHaystack.nextLine() + "\n");
	}


	needle = needleBuild.toString();
	haystack = haystackBuild.toString();
    }
}
