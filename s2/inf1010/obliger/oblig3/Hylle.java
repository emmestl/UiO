class Hylle <T> implements GenHylle<T>{
    T[] stor;
    
    Hylle (int storrelse){
	stor = (T[])new Object[storrelse];
    }

    public boolean sjekkOmLedig(int hylleNr){
	if (hylleNr < storrelse() && hylleNr >= 0){
	    return stor[hylleNr] == null;
	}
	return false;
    }
    public boolean settInn(int hylleNr, T objekt){
	boolean sattInn =  false;
	if(sjekkOmLedig(hylleNr) && hylleNr < storrelse() && hylleNr >= 0){
	    stor[hylleNr] = objekt;
	    sattInn = true;
	}
	return sattInn;
    }
	
    public int storrelse(){
	return stor.length;
    }

    public T taUt(int hylleNr){
	if (hylleNr < storrelse() && hylleNr >= 0){
	    T temp = stor[hylleNr];
	    stor[hylleNr] = null;
	    return temp;
	}
	return null;
    }
	
}
