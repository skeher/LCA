import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class LCATest {
	
	@Test 
	public void testNullInputs() {
		assertNull("null inputs: ", LCA.getLCA(null, null, null));
		Node dublin = new Node(1);
		assertNull("null inputs: ", LCA.getLCA(null, dublin, null));
		assertNull("null inputs: ", LCA.getLCA(null, null, dublin));
		Node kildare = new Node(2);
		assertNull("null inputs: ", LCA.getLCA(null, dublin, kildare));
		assertNull("null inputs: ", LCA.getLCA(null, kildare, dublin));
		
		ArrayList<Node> counties = new ArrayList<Node>();
		assertNull("null inputs: ", LCA.getLCA(counties, null, null));
		assertNull("null inputs: ", LCA.getLCA(counties, dublin, null));
		assertNull("null inputs: ", LCA.getLCA(counties, null, kildare));
		assertNull("null inputs: ", LCA.getLCA(counties, dublin, kildare));
	}
	
	@Test
	public void testSingleNode() {
		
	}
	
//	@Test //Ensures the constructor is working.
//	public void constructerTest () {
//		Node x = new Node(1);
//		assertNotNull("Testing if the constructer works ", x);
//	}
//
//	@Test //Test to ensure null is returned when the tree is empty.
//	public void emptyTree() {
//		LCA bt = new LCA();
//		assertNull("The tree is empty: ", bt.getLCA(2,3));
//	}
//
//	@Test //test to ensure the LCA of a tree with a single node is the node itself i.e the root (firstNode).
//	public void oneNodeTree() { 
//		LCA bt = new LCA();
//		bt.firstNode = new Node(1);
//		assertEquals("Single node in the tree: ", 1, bt.getLCA(1, 1).data);
//	}
//	
//	@Test //test to ensure the LCA of a tree with two nodes is returned correctly.
//	public void twoNodesTree () { 
//		LCA bt = new LCA();
//		bt.firstNode = new Node(1);
//		bt.firstNode.left = new Node(2);
//		assertEquals("Two nodes tree: ", 1, bt.getLCA(1, 2).data);
//		assertEquals("Two nodes tree: ", 1, bt.getLCA(2, 1).data);
//	}
//	
//	@Test //test to ensure the LCA of an unbalanced, one sided tree is returned correctly.
//	public void unevenTree () { 
//		LCA bt = new LCA();
//		bt.firstNode = new Node(1);
//		bt.firstNode.right = new Node(2);
//		bt.firstNode.right.right = new Node(3);
//		assertEquals("Uneven tree with three nodes: ", 2, bt.getLCA(2,3).data);	
//		assertEquals("Uneven tree with three nodes: ", 1, bt.getLCA(3, 1).data);
//	}
//	
//	@Test //Test to ensure null is returned when we try to find the LCA of numbers that are not present in the tree.
//	public void testForNonExistentNodesInTree () { 
//		LCA bt = new LCA();
//		bt.firstNode = new Node(1);
//		bt.firstNode.left = new Node(2);
//		bt.firstNode.right = new Node(3);
//		bt.firstNode.left.left = new Node(4);
//		bt.firstNode.left.right = new Node(5);
//		bt.firstNode.right.right = new Node(6);
//		bt.firstNode.right.left = new Node(7);
//		assertNull("Searching for two nodes that are not in the tree: ", bt.getLCA(12, 19)); //fixed mistake here. Removed '.data'
//		assertNull("Searching for one node that is not in the tree: ", bt.getLCA(3, 10)); //found a glitch here. Assertion error
//		assertNull("Searching for one node that is not in the tree: ", bt.getLCA(56, 7));
//	}
//	
//	@Test //ensures the LCA of two nodes in a large tree is returned correctly.
//	public void largeTree () {
//		LCA bt = new LCA();
//		bt.firstNode = new Node(1);
//		bt.firstNode.left = new Node(2);
//		bt.firstNode.right = new Node(3);
//		bt.firstNode.left.left = new Node(4);
//		bt.firstNode.left.right = new Node(5);
//		bt.firstNode.right.right = new Node(6);
//		bt.firstNode.right.left = new Node(7);
//		bt.firstNode.left.left.left = new Node(8);
//		bt.firstNode.right.left.left = new Node(9);
//		bt.firstNode.right.left.right = new Node(10);
//		assertEquals("Many nodes in a tree: ", 1 ,bt.getLCA(1, 3).data);
//		assertEquals("Many nodes in a tree: ", 1 ,bt.getLCA(5, 1).data);
//		assertEquals("Many nodes in a tree: ", 2 ,bt.getLCA(5, 4).data);
//		assertEquals("Many nodes in a tree: ", 7 ,bt.getLCA(9, 10).data);
//		assertEquals("Many nodes in a tree: ", 3 ,bt.getLCA(6, 9).data);
//	}
}
