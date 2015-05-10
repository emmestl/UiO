/** Tekst basert java adventure spill som handler om en ny student som skal på en forelesning ved instituttet for informatikk i rommet som heter Fortress men vet ikke hvor det er. Han har 15 min på seg før forelesningen starter og han er for sein. */

import java.util.Scanner;
public class LostAtIfi  {
    public static void main(String[]args) {
	final int a =1; //valgmuligheter som kommer sener i spillet, gjelder b og c og.
	final int b =2;
	final int c =3;
	Scanner input = new Scanner (System.in);
	int tidIgjen =15;
	
	System.out.println ("Du er strandet på Blindern og må komme deg til rorm Fortress i ifi-bygningen innen 15 min. Du vet ikke hvor du er og du vet ikke hvor du skal.");
	System.out.println ("... Du har tre muligheter:");
	System.out.println ("1. Ring en venn");
	System.out.println ("2. Spør en forbipasserende");
	System.out.println ("3. Sjekk en av de mange Campuskartene som er rund forbi");
	System.out.println ("trykk; 1, 2 eller 3 for å velge");
	
	int valg = Integer.parseInt(input.nextLine());
	if (c==valg){
	    System.out.println ("Desverre vet du ikke hva bygget heter mer enn at det er informatikk instituttet sitt bygg. Kartet hjelper deg ikke.");
	    tidIgjen = tidIgjen - 2; //tiden som er igjen etter at du lette på kartet
	    System.out.println ("Du kan fremdeles ringe en venn (1) eller spørre en forbipasserende, hva gjør  du?");
	    System.out.println ("og du har bare " + tidIgjen + " min igjen.");
	    valg = Integer.parseInt (input.nextLine());
	}
	if (b == valg){
	    
	    
	
    }
}
	   
	    






