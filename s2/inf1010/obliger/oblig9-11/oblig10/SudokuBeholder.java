import java.util.*;
import java.lang.Iterable;
import java.io.*;

class SudokuBeholder implements Iterable<Brett>{
    //Fifo-liste
    private Node forste;
    private Node siste;
    private int antallNoder;
    private int antallLosninger;

    SudokuBeholder(){
	antallLosninger = 0;
	antallNoder = 0;
    }

    public void settInn(Brett brett){
	if (antallNoder < 2500){
	    if (forste == null){
		forste = new Node(brett);
		siste = forste;
	    }
	    else{
		Node temp = siste;
		siste.neste = new Node(brett);
		siste = temp.neste;
	    }
	    antallNoder++;
	}
	antallLosninger++;
    }
    public Brett taUt(){
	if(forste == null){
	    Brett temp = forste.brett;
	    forste = forste.neste;
	    antallNoder --;
	    return temp;
	}
	if (forste == null){
	    siste = null;
	}
	return null;
    }
    public int hentAntallLosninger(){
	return antallLosninger;
    }

    public Iterator<Brett> iterator(){
	return new BrettIterator();
    }

    private class Node{
	Node neste;
	Brett brett;

	Node(Brett brett){
	    this.brett = brett;
	}
    }


    class BrettIterator implements Iterator<Brett>{
	private Node node = forste;

	public boolean hasNext(){
	    return node != null;
	}

	public Brett next(){
	    Brett temp = node.brett;
	    node = node.neste;
	    return temp;
	}
    }
}
