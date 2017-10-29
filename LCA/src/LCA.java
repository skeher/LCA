import java.util.ArrayList;

//Created a branch to work on the modification of the initial LCA problem to implement directed acyclic graphs (DAG).

class Node<T> { 
	int data; //Node stores a value
	public ArrayList<Node<T>> listOfChildNodes; //keeps track of a nodes children
	int child[];

	public Node(int data) { //initialise
		this.data = data;
		listOfChildNodes = new ArrayList<Node<T>>();
		child = null;
	}
}

public class LCA { //LCA class. Lowest Common Ancestor will be found here.
	
	Node root;
	
	//returns an 
	public static Node getLCA(ArrayList<Node> graph, Node node1, Node node2) {
		
		if (!isNotNull(graph, node1, node2) && !isGraphAcyclic()) {
			return null;
		} else {
			//ToDo: find lca
		}
		return null;
	}

	//makes sure no inputs are null.
	public static boolean isNotNull (ArrayList<Node> graph, Node node1, Node node2) {
		if (graph == null) return false;
		if (node1 == null || node2 == null) return false;
		if (!graph.contains(node1) || !graph.contains(node2)) return false;
		return true;
	}
	
	public static boolean isGraphAcyclic () {
		return false;
		
	}

}
