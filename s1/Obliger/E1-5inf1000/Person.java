class Person {
    private String navn;
    private int alder;
    private Bil bil;
    
    void personInfo (String name, int age){
	navn =name;
	alder = age;
    }
    void giBil(String skiltnummer, Bil bilen){
	bil = bilen;
	bil.lagreInfo(navn, skiltnummer);
    }
}


