class PersonList{
    PersonList neste;
    String navn;

    void insert(String name){
	if (navn == null){
	    navn = name;
	}
	else {
	    if (neste == null){
		neste = new PersonList();
	    }
	    neste.insert(name);
	}
    }
    

    String allNames(){
	if (neste != null){
	    return neste.allNames() + " " + navn;
	}
	return navn;
    }
    
}

