/* Oppgave 4.4*/
import java.util.*;
public class TicTacToe {

    /* dette har du igjen aa gjore! Plasser der hvor den bestemmer om passen er gyldig i main metoden, dvs lag en egen metode som sjekker dette og om raden er gyldig. Lag en System.out.println som printer ut hele brettet slik at brukerne kan se hvordan bettet ser ut. Maa ogsaa lage en maate aa sjekke om en av spillerne har vunnet*/


    public static int hvilkenSpiller (int hvilkenSpiller) {
	return 3-hvilkenSpiller;
    }



    public static int sjekkplass (int plass, int rad, int[][] radNummer) {

	if (plass<3  && plass >= 0 && rad <3 && rad >= 0 && radNummer[rad][plass]==0){
	    return 1;
	}
	else  {
	    System.out.println ("Du valgte en ikke gyldig plass i raden, vennligst velg paa nytt.");
	    return 0;
	}
    }



    public static void brettet (int [] [] rader){
	for (int i =0; i <3; i++){
	    System.out.println (Arrays.toString(rader[i]));
	}
    }


    
    public static int vinner (int [] [] rader){
	for (int i = 0; i<3 ; i++){
	    if (rader[i][0] == rader[i][1]&& rader [i][1]==rader[i][2]&& rader[i][0]!=0){
		int spiller = rader[i][0];
		System.out.println ("Gratulerer, Spiller " + spiller + " du vant!");
		return 1;
	    }
	    if (rader[0][0]==rader[1][1]&& rader[1][1]==rader[2][2]&& rader[0][0]!= 0){
		int spiller = rader [0][0];
		System.out.println ("Gratulerer, Spiller" + spiller + " du vant!"); 
		return 1;
	    }
	    if (rader [2][0]== rader[1][1]&& rader [1][1]== rader[0][2]&& rader[2][0]!=0){
		int spiller = rader [0][2];
		System.out.println ("Gratulerer, Spiller" + spiller+ " du vant!");
		return 1;
	    }
	    if (rader [0][i]==rader[1][i] && rader[1][i]==rader[2][i]&&rader[2][i] !=0){
		int spiller =rader[0][i];
		System.out.println("Gratulerer, Spiller" + spiller + " du vant!");
		return 1;
	    }
	}
	return 0;
    }


    public static void main(String [] args){
	int [] rad0 =new int[3];
	int [] rad1 = new int [3];
	int [] rad2 =new int[3];
	int [] [] radNummer = {rad0, rad1, rad2};
	int radNummerValg = 0;
	int plass =0;
	int spiller =1;
	int ledig =0;
	Scanner in = new Scanner (System.in);

	System.out.println("Velkommen til TicTacToe! For aa markere en rute maa du vente til det er din tur. Deretter maa du velge i hvilken av 3 rader (1,2,3) onsker aa plasere deg i. Deretter maa du velge hvor i raden du onsker markert (venstre (1) midten (2) hoyre (3)). Naar dette er gjort er det nestes spillers tur. Spiller1 og Spiller2 bytter paa aa markere plasser paa brettet fram til brettet er fult. Hvis ruten er ledig markeres den med 0 er den i bruk markeres den med enten 1 eller 2 som representerer Spiller1 og Spiller2");

	// Lokke som ber spillerne velge rader, den fortsetter aa gaa frem til det ikke er flere ledige plasser 
	while (rad0[0]==0 || rad0[1]==0 || rad0[2]==0 || rad1[0]==0 || rad1[1]==0 || rad1[2]==0 || rad2[0]==0 || rad2[1]==0 ||rad2[2]==0){
	    System.out.print ("Spiller" +spiller+ ", Tast inn rad: ");
	    radNummerValg = Integer.parseInt(in.nextLine()) -1;
	    System.out.print ("Spiller" + spiller + ", Tast inn plass: ");
	    plass = Integer.parseInt(in.nextLine()) -1;
	// hver gang en bruker skriver inn en rad og en plass maa det skjekkes om den er ledig, dette maa skje i en metode
	    ledig = sjekkplass(plass , radNummerValg, radNummer);
	    if (ledig == 1) {
		radNummer[radNummerValg][plass]= spiller;
		spiller = hvilkenSpiller (spiller);
	    }

	    else {
	    }
	    brettet (radNummer);
	    int vunnet = vinner (radNummer);
	    if (vunnet ==1){
		break;
	    }
	    else{
	    }
	}
    }
}
