//Created a branch to work on the modification of the initial LCA problem to implement directed acyclic graphs.

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

	Node getLCA(Node node, int num1, int num2) {
		//The code below will find the LCA of two nodes recursively.
		
		if (node == null) { //Checks if the current node is null.
			return null;
		}
		if(!numsPresent(firstNode, num1) || !numsPresent(firstNode, num2)) { //if one of the nodes isn't present, return null.
			return null;
		}
		if (node.data == num1 || node.data == num2) { //checks if one of the numbers is equal to the node's value.
			return node;
		}

		Node leftNode = getLCA(node.left, num1, num2); //left subtree
		Node rightNode = getLCA(node.right, num1, num2); //right subtree.
		
		if (leftNode != null && rightNode != null) {
			return node;
		}

		return (leftNode != null) ? leftNode : rightNode;
		//if leftNode is not null, return leftNode. If leftNode is null, return rightNode.
	}
	
	public boolean numsPresent (Node node, int num) { //check to see if a node is present in the tree.
		
		if (node == null) return false;
		if (node.data == num) return true;
		if (numsPresent(node.left, num)) return true;
		if (numsPresent(node.right, num)) return true;
		
		return false;
	}
}
