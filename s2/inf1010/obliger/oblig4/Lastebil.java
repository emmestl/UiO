class Lastebil extends Fossilbil{
    double nytteVekt; 

    Lastebil(double vekt, double utslipp, String regNr){
	super(utslipp, regNr);
	nytteVekt = vekt;

    }
}
