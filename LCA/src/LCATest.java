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
	
	@Test
	public void testIsGraphAcyclic() {
		Node louth = new Node(7);
		ArrayList<Node> counties = new ArrayList<Node>();
		counties.add(louth);
		assertEquals("One node in the graph should be acyclic: ", true, LCA.isGraphAcyclic(counties));
		
		Node meath = new Node(13);
		louth.listOfChildNodes.add(meath);
		counties.add(meath);
		assertEquals("Two nodes in graph: ", true, LCA.isGraphAcyclic(counties));
		
		ArrayList<Node> provinces = new ArrayList<Node>();
		assertEquals("Empty graph, I assume is acyclic: ", true, LCA.isGraphAcyclic(provinces));
		
		Node leinster = new Node(8);
		Node munster = new Node (12);
		Node connacht = new Node (97);
		Node ulster = new Node (45);
		leinster.rootFinder(munster);
		munster.rootFinder(connacht);
		munster.rootFinder(ulster);
		connacht.rootFinder(ulster);
		provinces.add(leinster);
		provinces.add(munster);
		provinces.add(connacht);
		provinces.add(ulster);
		assertEquals("Populated acyclic graph: ", true, LCA.isGraphAcyclic(provinces));
		
		ulster.rootFinder(leinster);
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
		
		a.rootFinder(b);
		a.rootFinder(c);
		a.rootFinder(d);
		b.rootFinder(c);
		b.rootFinder(f);
		c.rootFinder(e);
		e.rootFinder(f);
		
		ArrayList<Node> test = new ArrayList<Node>();
		test.add(e);
		test.add(f);
		test.add(d);
		test.add(c);
		test.add(b);
		test.add(a);
		
		assertEquals("Test: ", a.data, LCA.getLCA(test, f, b));
	}
	
}
