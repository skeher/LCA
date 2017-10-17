import static org.junit.Assert.*;

import org.junit.Test;

public class LCATest {

	@Test
	public void emptyTree() {
		LCA bt = new LCA();
		assertNull("The tree is empty: ", bt.getLCA(2,3));
	}

	@Test
	public void oneNodeTree() {
		LCA bt = new LCA();
		bt.firstNode = new Node(1);
		assertEquals("Single node in the tree: ", 1, bt.getLCA(1, 0).data);
		assertEquals("Single node in the tree: ", 1, bt.getLCA(0, 1).data);
		assertEquals("Single node in the tree: ", 1, bt.getLCA(1, 1).data);
	}
	
	@Test
	public void twoNodesTree () {
		LCA bt = new LCA();
		bt.firstNode = new Node(1);
		bt.firstNode.left = new Node(2);
		assertEquals("Two nodes tree: ", 1, bt.getLCA(1, 2).data);
	}
}
