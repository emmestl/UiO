import java.util.Arrays;
import java.util.Scanner;
/** 
 * Er en bondeg&aring;rd som inneholder, griser, hester, kyr
 * Det er en bruker meny s&aring; brukeren kan selv velge hvor mange av hver bondeg&aring;rden skal inneholde.
 * @author Elsie Mestl
 * @version 21.10.14
 */
public class Bondegard {
    static Gris[] grisebinge = new Gris [10];
    static Hest[] stall = new Hest [5];
    static Ku [] fjos = new Ku[30];
    static Scanner in = new Scanner (System.in);
    static String navn = "";
    
    /**
     * Setter inn en gris i grisebingen hvis det er plass
     * 
     * @param g g er av objekt av typen Gris
     */
    static void settInnGris(Gris g){
	System.out.println("Hva skal grisen hete?");
	navn= in.nextLine();
	g.grisFaarNavn(navn);

	for (int i=0; i<grisebinge.length; i++){
	    if (grisebinge[i] == null){
		grisebinge[i]= g;
		break;
	    }

	    if (grisebinge[grisebinge.length-1] != null) {
		System.out.println ("Grisebingen er full");
		break;
	    }
	}
    }
  
    /** 
     * Setter in en hest i stallen hvis det er plass
     *
     * @param h objekt av typen Hest
     */
    static void settInnHest(Hest h){
	System.out.println("Hva skal hesten hete?");
	navn = in.nextLine();
	h.hestFaarNavn(navn);

	for (int i = 0; i<stall.length ; i ++){
	    if (stall[i] == null){
		stall[i]=h;
		break;
	    }
	    
	    if (stall[stall.length-1] != null){
		System.out.println ("Stallen er full");
		break;
	    }
	}
    }
   
    /**
     * Setter inn en ku i fj&oslash;set hvis det er plass
     *
     * @param k objekt av typen Ku
     */
    static void settInnKu(Ku k){
	System.out.println("Hva skal kua hete?");
	navn = in.nextLine();
	k.kuFaarNavn(navn);

	for (int i = 0; i < fjos.length; i++){
	    if (fjos[i]== null){
		fjos[i] = k;
		break;
	    }
	    if (fjos[fjos.length -1 ] !=null){
		System.out.println ("Fjoset er fullt");
		break;
	    }
	}

    }

    /**
     * selger valgt antall dyr av valgt type
     *
     * @param type forteller om gris, hest, ku er dyrearten som skal selges
     * @param antall hvor mange av den ene typen dyr som skal selges
     */
    static void selgDyr (String type, int antall){
	int i = 0;
	int j=0;
	if (type.equals("gris")){
	    while (i < antall && j<grisebinge.length){
		if (grisebinge[i] != null){
		    grisebinge[i] = null;
		    i++;		    
		}
		if (j == grisebinge.length-1){
		    System.out.println("Har ikke saa mange griser aa selge\n du har solg " + i + "griser");
		}
		j++;
	    }
	}
	if (type.equals("ku")){
	    while (i<antall && j <fjos.length){
		if (fjos[i] != null){
		    fjos[i]= null;
		    i++;
		}
		if (j == fjos.length-1){
		    System.out.println("Har ikke saa mange kyr aa selge\n du har solgt " +i + "kyr");
		}
		j++;
	    }
	}
	if (type.equals("hest")){
	    while (i<antall && j < stall.length){
		if (stall[i] != null){
		    stall[i]= null;
		    i++;
		}
		if (j==stall.length-1){
		    System.out.println("Har ikke saa mange hester aa selge\n du har solgt " +i+ "hester");
		}
		j++;
	    }
	}	
    }

    /**
     * Skriver i terminalen hvor mange det er av hver type, og hva dyrene heter
     */
    public static void skrivUt(){
	System.out.println ("Griser:");
	for (int i =0; i< grisebinge.length; i++){
	    if (grisebinge[i]!= null){
		System.out.println(grisebinge[i].gris);
	    }
	}
	System.out.println ("\nKyr:");
	for (int i =0; i < fjos.length; i++){
	    if (fjos[i]!= null){
		System.out.println(fjos[i].ku);
	    }
	}
	System.out.println ("\nHester:");
	for (int i =0; i< stall.length; i++){
	    if (stall[i] != null){
		System.out.println(stall[i].hest);
	    }
	}
    }

    /**
     * Gir brukeren valg om hva programmet skal gj&oslash;re 
     * En bruker meny med 5 valg
     */
    public static void main(String []args){
	
	int valg = -1;
	int antall = 0;
	String rase ="";
	// Abrukermeny
	System.out.println ("Hei, velkommen til din egen bondegar, akkurat naa har du ingen dyr men du kan sette inn dyr som du onsker.");

	
	while (valg != 0){
	    System.out.println("0: Avslutt\n1: Sett inn en gris\n2: Sett inn en hest\n3: Sett inn en ku\n4: Selg et dyr\n5: Skriv ut bondegaarden");
	    valg = Integer.parseInt(in.nextLine());
	    if (valg ==1){
		System.out.print ("Hvor mange griser vil du ha?");
		antall = Integer.parseInt(in.nextLine());
		for (int i =1; i<=antall; i++){
		    settInnGris(new Gris());
		}
	    }
	    if (valg ==2){
		System.out.print("Hvor mange hester vil du ha?");
		antall = Integer.parseInt(in.nextLine());
		for (int i =1; i<=antall; i++){
		    settInnHest(new Hest());
		}
	    }
	    if (valg ==3){
		System.out.println("Hvor mange kyr vil du ha?");
		antall = Integer.parseInt(in.nextLine());
		for (int i =1; i<=antall; i++){
		    settInnKu(new Ku());
		}
	    }
	    if (valg == 4){
		System.out.println("Hvilken rase skal selges, oppgi svaret i entall");
		rase = (in.nextLine()).toLowerCase();
		System.out.println("Hvor mange " + rase + " vil du selge?");
		antall = Integer.parseInt(in.nextLine());
		selgDyr(rase, antall);
	    }
	    if (valg == 5){
		skrivUt();
	    }
	}
    }

}



