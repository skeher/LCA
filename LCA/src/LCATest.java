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
		
	}
	
	@Test 
	public void testGetLCA () {
		
	}
	
}
