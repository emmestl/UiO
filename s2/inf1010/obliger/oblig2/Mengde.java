class Mengde <E> {
    Node first; //eldste (forrerst)
    Node last;  //nyeste (bakest)

    public boolean tom(){
	return (first == null);
    }

    /* antar at det nye elementet/objektet skal legges til bakerst i lenken*/
    public boolean leggTil(E e){
	if(tom()){
	    first = new Node();
	    last = first;
	    first.data = e;
	    return true;
	}
	
	Node temp = first;
	if(inneholder(e)){
	    return false;
	}
	last.next = new Node();
	last = last.next;
	last.data = e;
	return true;
    }

    public E fjernEldste(){
	if (tom()){
	    return null;
	}
	E temp = first.data;
	first = first.next;
	if (tom()){
	    last = first;
	}
	return temp;	    
    }

    public E fjernNyeste(){
	if (tom()){
	    return null;
	}

	E temp = last.data;
	Node mid = first;
	if (last == first){
	    last = null;
	    first = last;
	}
	else{
	    while (mid.next != last ){
		mid = mid.next;
		//System.out.println (mid.data);
	    }
	    last = mid;
	    last.next = null;
	}
	return temp;	
    }

    public boolean inneholder(E e){
	Node temp = first;
	while (temp!= null){
	    if(e == temp.data){
		return true;
	    }
	    temp = temp.next;
	}
	return false;
    }

    private class Node{
	E data;
	Node next;
    }

    public void antall(){
	int antall =0;
	Node temp2 = first;
	if(first != null){
	    while(temp2 != last){
		antall ++;
		temp2 = temp2.next;
	    }
	}
	System.out.println (antall);
    }
}
