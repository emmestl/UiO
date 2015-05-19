/**
 *Finner ut hvor mange forskjellige ord det er i en tekst og hvilket ord som er mest bruk. Finner ogs&aring; ut hvor mange ganger et valgt ord er brukt
 *bruker klassen Ordliste for &aring; finne all informasjonen, det eneste denne klassen inneholder er filen som &oslash;nskes lest og hva som skal printes ut i terminalen
 *@author Elsie Mestl
 *@version 16.10.2014
 */
import java.util.Arrays; // importerer denne for aa kunne printe ut rerturnverdien til ol.alleVanligste()
class Oblig6{
    
    /**
     *eneste metoden i klassen og gj&oslah;r det samme som beskrevet i klassebeskrivelsen
     */
    public static void main(String[] args)throws Exception{
	
	String tekst = "scarlet.text";
	Ordliste ol = new Ordliste();
	
	ol.lesBok(tekst);
	//
	System.out.println("\nAntall forskjellige ord: "+ ol.antallOrd());
	//b
	System.out.println ("'Holmes' blir brukt: "+ ol.finnOrd("Holmes").hentAntall()+" ganger");
	//c
	System.out.println("'Elementary' blir brukt: " + ol.finnOrd("Elementary").hentAntall()+" gang");
	//d
	System.out.println("De(t) vanligste ordene er: " + Arrays.toString(ol.alleVanligste())+"\n");

    }
}

