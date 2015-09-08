import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;


class Search{

    BinarySearchTree dictionary;
    SimilarWords similar;
    ArrayList<String> posibleWords;

    public static void main(String[] args) {
	Search search = new Search();
	search.mainProgram();
    }


    public void mainProgram(){

	Scanner user = new Scanner(System.in);
	String userInput;

	insertDictionary();
	similar = new SimilarWords();

	welcomemessage();

	//check before because you want the new input right before the check
	System.out.print ("Search: ");
	userInput = user.nextLine().toLowerCase();

	while (!userInput.equals("q")){

	    if(!dictionary.search(userInput)){
		long start = System.currentTimeMillis();
		System.out.println ("The word does not exist, did you mean:");
		compare(similar.findSimilar(userInput));
		long stop = System.currentTimeMillis();
		System.out.println ("\nTime it took to find and produce results: " + (stop- start)+ "ms");
		System.out.println (posibleWords.size() + " sugestions found");
		for(String s : posibleWords){
		    System.out.print(s + ", ");
		}
		System.out.println ("\n");
	    }
	    else{
		System.out.println ("Found: " + userInput);
	    }

	    System.out.print ("Search: ");
	    userInput = user.nextLine().toLowerCase();
	}

	dictionary.statistics();

    }

    public void insertDictionary(){
	Scanner file;
	try {
	    file = new Scanner(new File("dictionary.txt"));
	    dictionary = new BinarySearchTree(file.nextLine());

	    while(file.hasNextLine()){
		dictionary.insert(file.nextLine());
	    }
	}
	catch(FileNotFoundException e){
	    System.out.println ("Couldn't find dictionary.txt");
	    System.exit(0);
	}

	//would normaly not be here, but the exercise asks for it
	dictionary.delete("busybody");
	dictionary.insert("busybody");
    }

    public void welcomemessage(){
	System.out.println ("Welcome to Elsie's homemade spellcheck, complete with typos \n \npress 'q' to quit");
    }


    public void compare(BinarySearchTree tree){
	if(posibleWords != null && !posibleWords.isEmpty()){
	    posibleWords.clear();
	}
	posibleWords = tree.compare(dictionary);
    }
}
