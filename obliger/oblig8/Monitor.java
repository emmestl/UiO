class Monitor{
    private int antall = 0;
    private int antallTraader;
    private int teller = 0;

    Monitor(int a){
	antallTraader = a;
    }

    public synchronized void antall(int i){
	antall += i;
	teller ++;
	if (teller == antallTraader){
	    notify();
	}
    }
    public synchronized void totalAntall(String ordet){
	System.out.println("Antall forekomster av " + ordet + " er " + antall);
    }
    
    public synchronized void vent(){
	while (teller != antallTraader){
	    try{
		wait();
	    }
	    catch(InterruptedException e){
		e.printStackTrace();
	    }
	}
    } 
}
