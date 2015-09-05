class Linked {
    public static void main (String [] args){
	PersonList list = new PersonList ();
	
	list.insert("Geir");
	list.insert("Lise");
	list.insert("Ali");
	list.insert("Oddvar");
	
	list.allNames();
	
	System.out.println (list.allNames());

    }
}

