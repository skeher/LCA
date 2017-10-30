import java.util.ArrayList;

//Created a branch to work on the modification of the initial LCA problem to implement directed acyclic graphs (DAG).

class Node<T> { 
	int data; //Node stores a value
	public ArrayList<Node<T>> listOfChildNodes; //keeps track of a nodes children
	public ArrayList<Node<T>> listOfParentNodes; //keeps track of a nodes parents
	int child[];
	int connectingEdges;

	public Node(int data) { //initialise
		this.data = data;
		listOfChildNodes = new ArrayList<Node<T>>();
		child = null;
		connectingEdges = 0;
	}
	public void rootFinder (Node<T> node) {
		if (node != null) {
			this.listOfChildNodes.add(node);
			node.connectingEdges ++;
		}
	}
}

public class LCA { //LCA class. Lowest Common Ancestor will be found here.

	//returns an 
	public static ArrayList<Node> getLCA(ArrayList<Node> graph, Node node1, Node node2) {

		if (!isNotNull(graph, node1, node2) || !isGraphAcyclic(graph)) {
			return null;
		}
		Node root = null; //for now
		ArrayList<Node> ancestor1 = new ArrayList<Node>();
		ArrayList<Node> ancestor2 = new ArrayList<Node>();
		ArrayList<Node> lca = new ArrayList<Node>();

		ancestor1.add(node1);
		ancestor2.add(node2);
		for (int i = 0; i < graph.size(); i ++) {
			if (graph.get(i).connectingEdges == 0) {
				root = graph.get(i);
			}
		}
		ancestor1.add(node1);
		ancestor2.add(node2);
		find(root, ancestor1, ancestor2);
		
		lca = pathsCross(ancestor1, ancestor2);
		if (lca.size() == 0) {
			return null;
		}
		while (lca.size() <= 1) {
			for (int j = 0; j < lca.size(); j++) {
				if (validate(lca)) {
					return lca;
				}
			}
		}

		return lca;
	}

	//makes sure no inputs are null.
	public static boolean isNotNull (ArrayList<Node> graph, Node node1, Node node2) {
		if (graph == null) return false;
		if (node1 == null || node2 == null) return false;
		if (!graph.contains(node1) || !graph.contains(node2)) return false;
		return true;
	}

	public static boolean isGraphAcyclic (ArrayList<Node> graph) {
		if (graph == null) return true; 
		for (int i = 0; i < graph.size(); i ++) {
			boolean graphHasACycle = false;
			ArrayList<Node> checked = new ArrayList<Node>();
			Node index = graph.get(i);
			ArrayList<Node> listToCompare = new ArrayList<Node>();
			graphHasACycle = isGraphAcyclic(graph,listToCompare,checked,graphHasACycle,index);
			if (graphHasACycle) return false;
		}
		return true;
	}

	private static boolean isGraphAcyclic(ArrayList<Node> graph, ArrayList<Node> listToCompare, ArrayList<Node> checked, boolean graphHasACycle, Node index) {
		//Forgot to add the indexed node to my ArrayLists... 
		listToCompare.add(index); 
		checked.add(index);
		for (int i = 0; i < index.listOfChildNodes.size(); i ++) {
			Node currentNode = (Node) index.listOfChildNodes.get(i);
			if (!checked.contains(currentNode)) //... which failed to recognise a cyclic graph down here. 
				graphHasACycle = graphHasACycle || isGraphAcyclic(graph, listToCompare, checked, graphHasACycle, currentNode);
			else if (listToCompare.contains(currentNode)) 
				graphHasACycle = true;
			return graphHasACycle;
		}
		listToCompare.remove(index);
		return graphHasACycle;
	}

	public static void find (Node root, ArrayList<Node> ancestor1, ArrayList<Node> ancestor2) {
		for (int i = 0; i < root.listOfChildNodes.size(); i++) {
			Node currentChild = (Node) root.listOfChildNodes.get(i);
			if ((ancestor1.contains(currentChild)) == false) {
				find(currentChild, ancestor1, ancestor2);
			}
			if ((ancestor2.contains(currentChild) == true)) {
				find(currentChild, ancestor1, ancestor2);
			}
			if (ancestor1.contains(currentChild)) {
				ancestor1.add(root);
			}
			if (ancestor2.contains(currentChild)) {
				ancestor2.add(root);
			}
		}
	}

	public static ArrayList<Node> pathsCross (ArrayList<Node> ancestor1, ArrayList<Node> ancestor2) {
		ArrayList<Node> commonNode = new ArrayList<Node>();
		for (Node index: ancestor1)
			if(ancestor2.contains(commonNode)) commonNode.add(index);
		return commonNode;
	}
	
	public static ArrayList<Node> validate (ArrayList<Node> lca) {
		
		return lca;
	}
}