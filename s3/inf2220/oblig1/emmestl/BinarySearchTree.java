import java.util.*;
import java.lang.Comparable;

class BinarySearchTree{

    BinaryNode root;
    int maxHeight;
    int[] amountInDepth;

    BinarySearchTree(String word){
        root = new BinaryNode(word);
        maxHeight = 0;
    }

    public void insert(String word){
        insert(word, root);
    }

    public void delete(String word){
        remove(word, root);
    }

    public boolean search(String word){ //is in all reality a contains() method
        return search(word, root);
    }

    /*compares the two trees and deletse the on in curently. And returns an ArrayList with
      the words that are found */
    public ArrayList<String> compare(BinarySearchTree tree){
        ArrayList<String> similar = new ArrayList<>();
        String temp;
        while(root.left!= null){
            temp = root.left.word;
            delete(temp);
            if(tree.search(temp)){
                similar.add(temp);
            }
        }
        while(root.right != null){
            temp = root.right.word;
            delete(temp);
            if(tree.search(temp)){
                similar.add(temp);
            }
        }
        return similar;
    }

    public void statistics(){
        findHeight(root, maxHeight);
	System.out.println ("\nStatistics:");
        System.out.printf("The longest path has the leght: %d \n\n" , maxHeight);

	System.out.println ("Amount of nodes in each depth:");
        amountInDepth = new int[maxHeight +1];
        amountInDepth(root,  0);//height of root = 0
	int average = 0;
	int totalNodes =0;
	
	for (int i = 0; i< amountInDepth.length; i ++){
	    if(i%2 != 0){ //better looking printout
		System.out.printf("d%2d: %5d \n" , i, amountInDepth[i]);
	    }
	    else{
		System.out.printf("d%2d: %5d \t" , i, amountInDepth[i]);
	    }
	    average += amountInDepth[i]*i; //weights the nubers
	    totalNodes += amountInDepth[i];
	}
	System.out.println ("\n");

	//OBS! integer divition, not that intrested in the exact number
	System.out.printf ("Average deph is: %.2f", (average*1.0/totalNodes)); 

	System.out.println ("\nFirst word is: " + findMin(root).word);
	System.out.println ("Last word is: " + findMax(root).word);
    }

    private void print(){}

    private int findHeight(BinaryNode t, int currentMax){
        if(t == null){ //should in reality never occur.
            return --currentMax;
        }
        if (t.left == null && t.right == null){
            maxHeight = (currentMax > maxHeight) ? currentMax : maxHeight;
            return --currentMax;
        }
        if(t.left != null){
            currentMax = findHeight(t.left, ++currentMax);
        }
        if(t.right != null){
            currentMax = findHeight(t.right, ++currentMax);
        }

        return --currentMax;
    }

    private int amountInDepth(BinaryNode t, int currentHeight){
        if(t == null){ //should in reality never occur.
            return --currentHeight;
        }
        if (t.left == null && t.right == null){
            amountInDepth[currentHeight]++;
	    return --currentHeight;
        }
        if(t.left != null){
            currentHeight = amountInDepth(t.left, ++currentHeight);
        }
        if(t.right != null){
            currentHeight = amountInDepth(t.right, ++currentHeight);
        }

	amountInDepth[currentHeight] ++;
        return --currentHeight;
    }

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
        int compare = word.compareToIgnoreCase(t.word);

        if(compare < 0){
            t.left =  remove(word, t.left);
        }
        else if(compare > 0){
            t.right =  remove(word, t.right);
        }
        else if (t.left != null && t.right != null){
            t.word = findMin(t.right).word;
            t.right = remove(t. word, t.right);
        }

        else {
            t = (t.left != null) ? t.left : t.right;
        }

        return t;
    }

    private boolean search(String word, BinaryNode t){
        if (t == null){
            return false;
        }

        int compare = word.compareToIgnoreCase(t.word);

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

    private static class BinaryNode{

        String word;
        BinaryNode left;
        BinaryNode right;

        BinaryNode(String word){
            this.word = word;
        }

        BinaryNode(String word, BinaryNode left, BinaryNode rigth){
            this.word = word;
            this.left = left;
            this.right = right;
	}
    }
}
