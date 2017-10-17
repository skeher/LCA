import static org.junit.Assert.*;

import org.junit.Test;

public class LCATest {

	@Test //Test to ensure null is returned when the tree is empty.
	public void emptyTree() {
		LCA bt = new LCA();
		assertNull("The tree is empty: ", bt.getLCA(2,3));
	}

	@Test
	public void oneNodeTree() { //test to ensure the LCA of a tree with a single node is the node itself i.e the root (firstNode).
		LCA bt = new LCA();
		bt.firstNode = new Node(1);
		assertEquals("Single node in the tree: ", 1, bt.getLCA(1, 0).data);
		assertEquals("Single node in the tree: ", 1, bt.getLCA(0, 1).data);
		assertEquals("Single node in the tree: ", 1, bt.getLCA(1, 1).data);
	}
	
	@Test
	public void twoNodesTree () { //test to ensure the LCA of a tree with two nodes is returned correctly.
		LCA bt = new LCA();
		bt.firstNode = new Node(1);
		bt.firstNode.left = new Node(2);
		assertEquals("Two nodes tree: ", 1, bt.getLCA(1, 2).data);
		assertEquals("Two nodes tree: ", 1, bt.getLCA(2, 1).data);
	}
	
	@Test
	public void unevenTree () { //test to ensure the LCA of an unbalanced, one sided tree is returned correctly.
		LCA bt = new LCA();
		bt.firstNode = new Node(1);
		bt.firstNode.right = new Node(2);
		bt.firstNode.right.right = new Node(3);
		assertEquals("Uneven tree with three nodes: ", 2, bt.getLCA(2,3).data);	
		assertEquals("Uneven tree with three nodes: ", 1, bt.getLCA(3, 1).data);
	}
}
