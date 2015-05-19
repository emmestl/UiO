/** Oppgave 4.3*/


public class Kalkulator {
    // Oppgave 4.3a)
    static int addisjon(int tall1, int tall2){
	int sum = tall1 + tall2 ;
	return sum ;
    }
    //Oppgave 4.3b)
    static int subtraksjon(int tall1, int tall2){
	int dif = tall1 - tall2;
	return dif;
    }
    //Oppgave 4.3c)
    static int heltallsdivisjon(int tall1, int tall2){
	int helDiv = tall1 / tall2 ;
	return helDiv;
    }
    //Oppgave 4.3d)
    static double divisjon(double tall1, double tall2){
	double div = tall1/tall2;
	return div;
    }

    public static void main (String [] args){
	
	int addSvar =addisjon(3,4);
	int subSvar = subtraksjon(5,2);
	int helDivSvar = heltallsdivisjon(10, 3);
	double divSvar = divisjon(10, 3);

	System.out.println (3 + "+" + 4 + "=" + addSvar);
	System.out.println(5+ "-" + 2+ "="+ subSvar);
	System.out.println (10 + "/"+3+"="+helDivSvar + ", svaret er av heltallsdivisjon");
	System.out.println (10 + "/" + 3 + "=" + divSvar + ", av 'vanlig' divisjon");
    }
}

    
