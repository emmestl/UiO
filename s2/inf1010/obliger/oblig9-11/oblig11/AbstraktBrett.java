import java.util.*;
import java.lang.Iterable;
import java.io.*;

class AbstraktBrett implements Iterable<Rute>{
    protected Rute[][] alleRutene;
    protected int lengdeV;
    protected int lengdeL;

    
    AbstraktBrett(int lengdeV, int lengdeL){
	this.lengdeV = lengdeV;
	this.lengdeL = lengdeL;
    }
    AbstraktBrett(){}
    
    public Iterator<Rute> iterator(){
	return new RuteIterator();
    }

    
    class RuteIterator implements Iterator<Rute> {
	private int i = 0;
	private int j = 0;
	private boolean sisteRad = false;
	
	public boolean hasNext(){
	    return  !sisteRad;
	}

	public Rute next(){
	    Rute r = alleRutene[i][j];
	    if(j == lengdeL -1 && i == lengdeV -1){
		sisteRad = true;
	    }
	    else if (i == lengdeV - 1){
		j ++;
		i = 0;
	    }
	    else {
		i++;
	    }
	    return r;
	}
    }
}
