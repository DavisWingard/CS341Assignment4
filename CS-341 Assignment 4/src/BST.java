import java.util.Stack;

public class BST {
	//CLASS ATTRIBUTE
		public Node root;
		Stack<Node> stack = new Stack<>();
		
		//CONSTRUCTOR
		public BST() {
			root = null;
		}
		
		public void addNode(String word) {
			//TASK 1: CREATE A NODE
			Node temp = new Node (word);
			
			
			//SCENARIO 1: IF THE TREE IS EMPTY, ADD IT TO THE ROOT
			if (root == null) {
				root = temp;
			}
				
			//SCENARIO 2: LOCATE THE CORRECT POSITION TO ADD IT.
			else {
				insert(root, temp);
			}
		}
		
		private void insert (Node root, Node temp) {
			
			while (true) {
				
				//SCENARIO 1: IGNORE DUPLICATE WORDS
				if (temp.word.compareTo(root.word) == 0)
					return;
				
				//SCENARIO 2: NAVIGATE TO THE LEFT NODE
				if (temp.word.compareTo(root.word) <= -1) {
					if (root.left != null)
						root = root.left;
					else {
						root.left = temp;
						break;
					}
				}
				
				//SCENARIO 3: NAVIGATE TO THE RIGHT NODE
				else {
					if (root.right != null)
						root = root.right;
					else {
						root.right = temp;
						break;
					}
				}
			}
		}
		
		//check if word is recognized by the BST
		public void spellCheck(String word) {
			spellCheckRecursive(root, word);
			if (!spellCheckRecursive(root, word)) {
				System.out.println("false");
			}
			else {
				System.out.println("true");
			}
		}
		
		private static boolean spellCheckRecursive(Node root, String word) {
			if(root == null) {
				return false;
			}
		    else if (root.word == word) {
		    	return true;
		    }
		    else
		        return spellCheckRecursive(root.left, word) || spellCheckRecursive(root.right, word);
			
		}
		
		//print out BST in order
		public void inOrder() {
			inOrderRecursive(root);
			checkInOrder(root);
		}
		
		private void inOrderRecursive(Node root) {
			if (root != null) {
				inOrderRecursive(root.left);
				System.out.println(root);
				stack.push(root);
				inOrderRecursive(root.right);
			}
		}
		
		public void checkInOrder(Node root) {
			for (Node node : stack) {
				//this assertion doesnt work, im trying to check that the stack contains the words in order as the bst is traversed
				/*
				assert stack.pop().word.compareTo(stack.peek().word) > 0: "Error";
				*/
			}	
		}
		
		//remove a node from the tree
		public void checkWord(String word) {
			checkWordRecursive(root, word);
		}
		
		public Node checkWordRecursive(Node root, String word) {
			if (root == null) {
				return null;
			}
			
			if (root.word.compareTo(word) > 0) {
				root.left = checkWordRecursive(root.left, word);
				return root;
			}
			
			else if (root.word.compareTo(word) < 0) {
				root.right = checkWordRecursive(root.right, word);
				return root;
			}
			
			//one leaf scenario
			if (root.left == null) {
				Node temp = root.right;
				return temp;
			}
			else if (root.right == null) {
				Node temp = root.left;
				return temp;
			}
			
			//two leaves scenario
			else {
				Node successorParent = root;
				Node successor = root.right;
				
	            while (successor.left != null) {
	                successorParent = successor;
	                successor = successor.left;
	            }
	            
	            if (successorParent != root)
	                successorParent.left = successor.right;
	            else
	                successorParent.right = successor.right;
	 
	            // Copy successor Data to root
	            root.word = successor.word;
	 
	            // Delete successor and return root
	            return root;
			}
		}
		
		
		/*
		public void inorderTraversal() {
		    Stack stack = new Stack<>();
		    Node current = root;

		    while (current != null || !stack.isEmpty()) {
		        while (current != null) {
		            stack.push(current);
		            current = current.left;
		        }

		        Node parent = (Node) stack.pop();
		        current = parent.right;
		    }
		}
		*/
}
