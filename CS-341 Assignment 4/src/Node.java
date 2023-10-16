
public class Node {
	//DATA MEMBERS
	public String word;
	public Node left;
	public Node right;
		
		
	//CONSTRUCTOR
	public Node (String word) {
		this.word = word;
		left = null;
		right = null;
	}
		
	public String toString() {
		return word;
	}
	
}
