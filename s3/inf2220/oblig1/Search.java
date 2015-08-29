import java.util.Scanner;
import java.io.*;


class Search{

    BinarySearchTree dictionary;
    
    public static void main(String[] args) {
	Search search = new Search();
	search.mainProgram();
	
    } 


    public void mainProgram(){

	Scanner user = new Scanner(System.in);
	String userInput;

	insertDictionary();
	welcomemessage();
	
	//check before because you want the new input right before the check
	System.out.print ("Search: ");
	userInput = user.nextLine();
	
	while (!userInput.equals("q")){
	    

	    
	    System.out.print ("Search: ");
	    userInput = user.nextLine();
	}

    }

    public void insertDictionary(){
	Scanner file = new Scanner(new File("dictionary.txt"));
	dictionary = new BinarySearchTree(file.nextLine());
	
	while(file.hasNextLine()){
	    dictionary.insert(file.nextLine());
	}

	//would normaly not be here, but the exercise asks for it
	dictionary.remove("busybody");
	dictionary.insert("busybody");
    }

    public void welcomemessage(){}
}

