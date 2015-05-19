/** Oppgave 5.3 */
import java.util.Arrays;
public class Tekster {

    public static boolean like(String iNF1000, String inf1000){
	boolean like = inf1000.equals(iNF1000);
	return like;
    }

    public static void main (String []args){
	//Oppgave 5.3a)
	String palindrom = "Agnes i senga";
	String baklengs ="";

	for (int i=palindrom.length(); i>0; i--){
	    baklengs += palindrom.substring(i-1, i);
	}
	
	System.out.println (baklengs);

	//Oppgave 5.3b)
	String iNF1000 ="INF1000";
	String inf1000 = "inf1000";

	boolean like = like(iNF1000, inf1000);
	if (like){
	    System.out.println ("De er like");
	}
	else{
	    System.out.println("De er ikke like");
	}

	//Oppgave 5.3c)
	String myeInf = "INF1100INF1000INF1010";
	String iNf1000 = myeInf.substring(0,7);
	
	System.out.println (iNf1000);

	//Oppgave 5.3d)
	String eventyr = "Espen Askeladd";
	char []eventyrChar = eventyr.toCharArray();
	for (int i=0; i<eventyrChar.length; i++){
	    if (eventyrChar[i]=='a'){
		eventyrChar[i]='A';
	    }
	}
	System.out.println (eventyrChar);

    }
}
