//Oppgave 6.1

/**
 *Lager et ord
 *Gir ordet et antall(forekomster) og en String representasjon
 *@author Elsie Mestl
 *@version 16.10.2014
 */
class Ord {
    private String ord;
    private int antall;

    /**
     *Lager et ord
     *
     *@param o stringformen av et ord som skal lages
     */
    Ord(String o){
	o = o.toLowerCase();
	ord = o;
	antall = 1;
    }

    /** 
     *Returnerer String versjonen av et ordet
     *
     *@return string versjonen av Ordet
     */
    public String toString(){
	return ord;
    }

    /**
     *&oslash;ker antallet(forekomster) av et ord med 1
     */
    public void oekAntall(){
	antall ++;
    }

    /**
     *finner antall ganger et ord har forkommet
     *
     *@return antallet forekomster av et ord
     */
    public int hentAntall(){
	return antall;
    }
}
