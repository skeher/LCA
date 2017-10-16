import static org.junit.Assert.*;

import org.junit.Test;

public class LCATest {

	@Test
	public void emptyTree() {
		LCA bt = new LCA();
		assertNull("The tree is empty: ", bt.getLCA(2,3));
	}

}
