
public class Main {

	public static void main(String[] args) {
		BST tree = new BST();
		
		tree.addNode("ghost");
		tree.addNode("donut");
		tree.addNode("banana");
		tree.addNode("apple");
		tree.addNode("icee");
		tree.addNode("nougat");
		
		//print out tree in order
		tree.inOrder();
		System.out.println("\n");
		
		//remove a node from the tree
		tree.checkWord("donut");
		
		//reprint the BST in order
		tree.inOrder();
		System.out.println("\n");
		
		//spellcheck a node in the BST
		tree.spellCheck("banana");
		
		//assertions
		assert tree.root != null: "Root is not null";
		
		
	}

}
