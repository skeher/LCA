class Node { //Node class will be used to create a binary tree
	int data; //Node stores a value
	Node left; 
	Node right;

	public Node(int data) { //initialise
		this.data = data;
		left = null;
		right = null;
	}
}
public class LCA { //LCA class.  Lowest common ancestor will be found in here.

	Node firstNode; //create a root, called firstNode.

	Node getLCA (int num1, int num2) { //Num1 and Num2 are two integer values.  We will find the lowest common ancestor of these.

		if (areNumbersPresent(firstNode, num1, num2)) {
			//Todo: find the LCA
		} else {
			return null;
		}
		return null; //return null for now. Write test cases first.
	}

	private static boolean areNumbersPresent (Node firstNode, int num1, int num2) {

		return false;
	}

}
