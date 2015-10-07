
class Test{

    public static void main(String[] args) {

	//SimilarWords sim = new SimilarWords();
	//sim.findSimilar("hei");

	BinarySearchTree tree = new BinarySearchTree("E");
	tree.insert("L");
	tree.insert("S");
	tree.insert("I");
	tree.insert("A");
	tree.insert("J");

	tree.statistics();
    }
}


