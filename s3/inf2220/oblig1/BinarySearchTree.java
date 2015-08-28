class BinarySearchTree<String>{

    BinaryNode root;

    BinarySearchTree(String word){
	root = new BinaryNode(word);
    }

    public void insert(String word){
	insert(word, root);
    }

    public void delete(String word){
	remove(word, root);
    }

    public void search(String word){ //is in all reality a contains() method
	if(search(word, root)){ //word found
	    System.out.println ("The word: " + word +" is exists");
	}
	else{
	    System.out.println ("The word does not exist, did you mean:");
	    //findSimilar(word);
	}
    }

    public void statics(){}



    private BinaryNode insert(String word, BinaryNode t){
	if(t == null){
	    return new BinaryNode(word);
	}

	int compare = word.compareTo(t.word);

	if(compare < 0){
	    t.left = insert(word, t.left);
	}
	else if(compare > 0){
	    t.right = insert(word, t.right);
	}
	else{} //if there happens to be a duplicate word

	return t;
    }

    private BinaryNode remove(String word, BinaryNode t){
	if (t == null){
	    System.out.println (word + " does not exist");
	    return null;
	}

	//removes the smalest child of the right noe

	int compare = word.compareTo(t.word);

	if(compare < 0){
	    t.left =  remove(word, t.left);
	}
	else if(compare > 0){
	    t.right =  remove(word, t.right);
	}
	else if (t.left != null && t.right != null){
	    t.word = removeMin(t.right);
	}

	else if (t.left != null){
	    t.word = removeMin(t);
	}
	else{
	    

    }
	
    private boolean search(String word, BinaryNode t){
	if (t == null){
	    return false;
	}

	int compare = word.compareTo(t.word);

	if (compare < 0){
	    return search(word, t.left);
	}
	else if(compare > 0){
	    return search(word, t.right);
	}
	else{
	    return true;
	}
    }

    private BinaryNode findMax(BinaryNode t){
	if (t.right == null){
	    return t;
	}

	return findMax(t.right);
    }

    private BinaryNode findMin(BinaryNode t){
	if (t.left == null){
	    return t;
	}

	return findMin(t.left);
    }

    private String removeMin(BinaryNode t){
	if (t.left.left == null){
	    String replacement = t.left.word;
	    t.left = null;
	    
	    return replacement;
	}

	return removeMin(t.left);
    }


    private static class BinaryNode {

	String word;
	BinaryNode left;
	BinaryNode right;

	BinaryNode(String word){
	    this.word = word;
	}

	BinaryNode(String word, BinaryNode left, BinaryNode rigth){
	    this.word = word;
	    this.left = left;
	    this.rigth = right;
	}
    }
}
