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
		Node one = new Node(1);
		ArrayList<Node> list = new ArrayList<Node>();
		list.add(one);
		assertEquals("One node: ", one, LCA.getLCA(list, one, one));
	}
	
	@Test
	public void testNullAcyclic () {
		ArrayList<Node> nullList = new ArrayList<Node>();
		assertTrue("If the graph is null, it is acyclic: ", LCA.isGraphAcyclic(nullList));
	}
	
	@Test
	public void testIsGraphAcyclic() {
		Node louth = new Node(7);
		ArrayList<Node> counties = new ArrayList<Node>();
		counties.add(louth);
		assertEquals("One node in the graph should be acyclic: ", true, LCA.isGraphAcyclic(counties));
		
		Node meath = new Node(13);
		louth.linkAndRootFinder(meath);
		counties.add(meath);
		assertEquals("Two nodes in graph: ", true, LCA.isGraphAcyclic(counties));
		
		ArrayList<Node> provinces = new ArrayList<Node>();		
		Node leinster = new Node(8);
		Node munster = new Node (12);
		Node connacht = new Node (97);
		Node ulster = new Node (45);
		leinster.linkAndRootFinder(munster);
		munster.linkAndRootFinder(connacht);
		munster.linkAndRootFinder(ulster);
		connacht.linkAndRootFinder(ulster);
		provinces.add(leinster);
		provinces.add(munster);
		provinces.add(connacht);
		provinces.add(ulster);
		assertEquals("Populated acyclic graph: ", true, LCA.isGraphAcyclic(provinces));
		
		ulster.linkAndRootFinder(leinster);
		assertEquals("Populated cyclic graph: ", false, LCA.isGraphAcyclic(provinces));
	}
	
	@Test 
	public void testGetLCA () {
		
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		Node f = new Node(6);
		
		a.linkAndRootFinder(b);
		a.linkAndRootFinder(c);
		a.linkAndRootFinder(d);
		b.linkAndRootFinder(c);
		c.linkAndRootFinder(e);
		e.linkAndRootFinder(f);
		b.linkAndRootFinder(f);
		
		ArrayList<Node> test = new ArrayList<Node>();
		test.add(a);
		test.add(b);
		test.add(c);
		test.add(d);
		test.add(e);
		test.add(f);
		
		assertEquals("Test: ", e.data, LCA.getLCA(test, f, e).data);
		assertEquals("Test: ", a.data, LCA.getLCA(test, c, d).data);
		assertEquals("Test: ", c.data, LCA.getLCA(test, f, c).data);
		assertEquals("Test: ", b.data, LCA.getLCA(test, c, b).data);
	}
}
