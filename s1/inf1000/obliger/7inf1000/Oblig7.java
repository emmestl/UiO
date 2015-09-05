import java.io.*;
    
class Oblig7 {    

    public static void main (String [] args) throws Exception{
	DVDadministrasjon dvdAdministrajon = new DVDadministrasjon();
	dvdAdministrajon.brukermenyen();
	    
	PrintWriter tilFil = new PrintWriter("dvdarkiv.txt");
	dvdAdministrajon.lesTilFil(tilFil);
    }
}
