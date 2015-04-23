import java.util.ArrayList;

class FinnMulig<T> extends Thread{ 
    private Monitor m;
    private T t;
    private int maksverdi;
    private ArrayList<Integer> ikkeMulige = new ArrayList<>();
    
    FinnMulig(Monitor m, T t){
	this.m = m;
	this.t = t;
    }
    
    public void run(){
	if (t instanceof AbstraktBrett){
	    AbstraktBrett ab = (AbstraktBrett) t;
	    for (Rute r : ab){
		if(r.verdi() != 0){
		    ikkeMulige.add(r.verdi());
		}
	    }
	}
	else if (t instanceof AbstraktSoyle){
	    AbstraktSoyle as = (AbstraktSoyle) t;
	    for(int i = 0; i < as.getVerdier().length; i ++){
		if (as.getVerdier()[i] != 0){
		    ikkeMulige.add(as.getVerdier()[i]);
		}
	    }
	}
	m.beregn(ikkeMulige);
    }
}

class Monitor{
    private ArrayList<Integer> alleTallene;
    private int[] alleMulige;
    private int teller = 0;
    private int totalTraader;

    Monitor(int maksverdi, int totalTraader){
	alleTallene = new ArrayList<>();
	this.totalTraader = totalTraader;
	for (int i = 1; i <= maksverdi; i++){
	    alleTallene.add(i);
	}
    }
    
    public synchronized void beregn (ArrayList ikkeMulige){
	for (int i = 0; i< ikkeMulige.size(); i++){
	    if (alleTallene.contains(ikkeMulige.get(i))){
		alleTallene.remove(ikkeMulige.get(i));
	    }
	}
	teller ++;
	if (teller == totalTraader){
	    notify();
	}
    }

    public synchronized int[] finnMulige(){
	try{
	    wait();
	}
	catch (InterruptedException e){
	    System.out.println ("Opperasjonen ble avbrutt");
	    return null;
	}
	alleMulige = new int[alleTallene.size()];
	for (int i = 0; i < alleMulige.length; i++){
	    alleMulige[i] = alleTallene.get(i);
	}

	return alleMulige;
    }
}

