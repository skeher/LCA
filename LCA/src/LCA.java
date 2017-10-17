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
public class LCA { //LCA class. Lowest Common Ancestor will be found here.

	Node firstNode; //create a root, called firstNode.

	Node getLCA(int num1, int num2) { //Num1 and Num2 are two integer values.  We will find the lowest common ancestor of these.

		return getLCA(firstNode, num1, num2);
	}

	Node getLCA(Node firstNode, int num1, int num2) {
		//No longer need the private method 'areNumbersPresent' to check if numbers are present in the tree. 
		//The code below will return null if no such numbers are present.  It will also find the LCA of the numbers recursively.

		if (firstNode == null) {
			return null;
		}
		if (firstNode.data == num1 || firstNode.data == num2) { //checks if one of the numbers is equal to the firstNode's value (root).
			return firstNode;
		}

		Node leftNode = getLCA(firstNode.left, num1, num2); //left subtree
		Node rightNode = getLCA(firstNode.right, num1, num2); //right subtree.

		if (leftNode != null && rightNode != null) {
			return firstNode;
		}

		return (leftNode != null) ? leftNode : rightNode;
		//if leftNode is not null, return leftNode. If leftNode is null, return rightNode.
	}
}
