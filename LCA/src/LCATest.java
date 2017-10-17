import static org.junit.Assert.*;

import org.junit.Test;

public class LCATest {
	
	@Test //Ensures the constructor is working.
	public void constructerTest () {
		Node x = new Node(1);
		assertNotNull("Testing if the constructer works ", x);
	}

	@Test //Test to ensure null is returned when the tree is empty.
	public void emptyTree() {
		LCA bt = new LCA();
		assertNull("The tree is empty: ", bt.getLCA(2,3));
	}

	@Test //test to ensure the LCA of a tree with a single node is the node itself i.e the root (firstNode).
	public void oneNodeTree() { 
		LCA bt = new LCA();
		bt.firstNode = new Node(1);
		assertEquals("Single node in the tree: ", 1, bt.getLCA(1, 0).data);
		assertEquals("Single node in the tree: ", 1, bt.getLCA(0, 1).data);
		assertEquals("Single node in the tree: ", 1, bt.getLCA(1, 1).data);
	}
	
	@Test //test to ensure the LCA of a tree with two nodes is returned correctly.
	public void twoNodesTree () { 
		LCA bt = new LCA();
		bt.firstNode = new Node(1);
		bt.firstNode.left = new Node(2);
		assertEquals("Two nodes tree: ", 1, bt.getLCA(1, 2).data);
		assertEquals("Two nodes tree: ", 1, bt.getLCA(2, 1).data);
	}
	
	@Test //test to ensure the LCA of an unbalanced, one sided tree is returned correctly.
	public void unevenTree () { 
		LCA bt = new LCA();
		bt.firstNode = new Node(1);
		bt.firstNode.right = new Node(2);
		bt.firstNode.right.right = new Node(3);
		assertEquals("Uneven tree with three nodes: ", 2, bt.getLCA(2,3).data);	
		assertEquals("Uneven tree with three nodes: ", 1, bt.getLCA(3, 1).data);
	}
	
	@Test //Test to ensure null is returned when we try to find the LCA of nodes that are not present in the tree.
	public void testForNonExistentNodesInTree () { 
		LCA bt = new LCA();
		bt.firstNode = new Node(1);
		bt.firstNode.left = new Node(2);
		bt.firstNode.right = new Node(3);
		bt.firstNode.left.left = new Node(4);
		bt.firstNode.left.right = new Node(5);
		bt.firstNode.right.right = new Node(6);
		bt.firstNode.right.left = new Node(7);
		assertNull("Searching for nodes that are not in the tree: ", bt.getLCA(12, 19).data);
	}
}
