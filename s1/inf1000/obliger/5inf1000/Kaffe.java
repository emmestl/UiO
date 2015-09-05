class Kaffe {
    private double kaffe;
    private String styrke = "";

    void kaffe (double vann, double pulverKaffe){
	this.kaffe = vann;
	
	if (pulverKaffe/vann <4){
	    this.styrke = "svak";
	}
	if (pulverKaffe/vann > 6){
	    this.styrke = "sterk";
	}
	else {
	    this.styrke = "normal";
	}
    }
    double hentKaffe (){
	return this.kaffe;
    }
    String hentKaffeStyrke (){
	return this.styrke;
    }
}
