/** Oppgave 3.4*/

public class NegativeTall {
    public static void main(String[]args){
	int [] a={1,4,5,-2,-4,6,10,3,-2};
	int antallNegativeTall=0;
	int antallnegativeTall =0;
	int j =0;
	//Oppgave 3.4a)
	for (int i=0; i<a.length; i++){
	    if (a[i]<0){
		antallNegativeTall++;
	    }
	}
	System.out.println("Antall negative tall: " +antallNegativeTall);
	
	//Oppgave 3.4b)
	while (j <a.length){
	    if (a[j]<0){
		antallnegativeTall++;
	    }
	    j++;
	}
	System.out.println("Antall negative tall: " +antallnegativeTall);

	//Oppgave 3.4c)
	System.out.println("De negative tallene har posisjonene");
	for (int f=0; f<a.length; f++){
	    if (a[f]<0){
		a[f]=f;
		System.out.println(a[f]);
	    }
	}
    }
}

