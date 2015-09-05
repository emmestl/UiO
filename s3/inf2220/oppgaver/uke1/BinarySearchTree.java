class BinarySearchTree {

    BinaryNode root;
    
    BinarySearchTree(int i){
	root = new BinaryNode(i);
    }

    public void insert(int e){
	insert(root, e);
    }

    private BinaryNode insert (BinaryNode t, int e){
	if (t = null){
	    return new BinaryNode(e);
	}	    

	int compare = e - t.element; //negativ if e is smaller positive if lager
	if (compare < 0){
	    t.tL = insert(t.tL, e);
	}
	else {
	    t.tR = insert(t.tR, e);
	}

	return t;
    }

    
    private static class BinaryNode{ //why static?

	int element;
	BinaryNode tL;
	BinaryNode tR;

	BinaryNode (int e){
	    BinaryNode(e, null, null);
	}
	
	BinaryNode(int e, int tL, int tR){
	    element = e;
	    this.tL = tL;
	    this.tR = tR;
	}	
    }    

}
