class Personbil extends Fossilbil{
    int antallPlasser;
    
    Personbil(int ant, double utslipp, String regNr){
	super(utslipp, regNr);
	antallPlasser = ant;
    }
}

    