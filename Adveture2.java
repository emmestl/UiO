import java.util.Scanner;
public class LostAtIfi  {
    public static void main(String[]args) {
	
	System.out.println ("You're standing on deck on a large ship. The ship is heading for an ice berg, and the captain has fallen asleep. Behind you there's a door. What do you do?");

	Scanner input = new Scanner (System.in);
	Scanner input2 = new Scanner (System.in);
	String right_choice = "wake captain";
	String right_choice2 = "open door";
       
	int numberOfTries = 1;
	
	    while (numberOfTries<10) {
	        String choice = input.nextLine ();
	
		if (choice == right_choice) {
		    System.out.println ("The captain doesn't wake up, but out of his pocket falls a key."); 
		}
		else if (choice == right_choice2) {
			System.out.println ("You don't have the key to open this door.");
		    }
		else {
		    System.out.println ("This is not a comand, try again.");
		}
		numberOfTries ++;
	    }
    
    }
}
	   
	    






