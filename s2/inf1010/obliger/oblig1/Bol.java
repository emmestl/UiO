public class Bol<T>{
    private T beboer;

    public boolean tomt(){
	return beboer == null;
    }

    public void settInn (T innFlytter){
	if (beboer == null){
	    beboer = innFlytter;
	}
	else{
	    //System.out.println ("Det bor noen der fra for av");
	}
    }
    public T beboer(){
	return beboer;
    }
    
    public T taUt(){
	T midlertidig = beboer;
	beboer = null;
	return midlertidig;
    }
}

    
