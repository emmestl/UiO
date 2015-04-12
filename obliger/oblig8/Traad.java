class Traad extends Thread{
    private int antallForekomster = 0;
    private String leterEtter;
    private String[] leterI;
    private Monitor m;
    
    Traad(String leterEtter, String[] leterI, Monitor m){
        this.leterEtter = leterEtter;
	this.leterI = leterI;
	this.m = m;
    }
    
    public void run(){
        for (int i = 0; i< leterI.length; i++){
            //antar at smaa og store bokstaver er irrelevant
            if (leterI[i].equalsIgnoreCase(leterEtter)){
                antallForekomster ++;
            }
        }
	m.antall(antallForekomster);
    }
}
