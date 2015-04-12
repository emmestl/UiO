public class Bol<T>{
    private T beboer;

    public void settInn (T innFlytter){
	if (beboer == null){
	    beboer = innFlytter;
	}
	else{
	    System.out.println ("Det bor noen der fra for av");
	}
    }
    public T getBeboer(){
	if (beboer != null){
	    return beboer;
	}
	System.out.println ("Det bor ingen her");
	return beboer;
    }
    
    public T taUt(){
	T midlertidig = beboer;
	beboer = null;
	returm midlertidig;
    }
}

    
