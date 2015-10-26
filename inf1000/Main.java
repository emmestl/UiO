class Main{

    public static void main(String[] args) throws Exception{
	StudentSystem s = new StudentSystem();

	s.lesFil("emnestudenter.txt");
	s.skrivTilFil("emner.txt");

	System.out.println("Fag med flest studenter: " + s.fagFlestStudenter() + " " + s.fagFlestStudenter().hentAntall() + "tar faget");

	
	System.out.println("Student med flest fag: " + s.studentFlestFag() + " " + s.studentFlestFag().hentAntall() + "antall fag");
    } 
    
}
