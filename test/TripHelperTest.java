import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TripHelperTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetDestinations() {
		List<GraphNode> nodes = new ArrayList<GraphNode>();
		nodes.add(new GraphNode("AB2"));
		nodes.add(new GraphNode("BC2"));
		nodes.add(new GraphNode("BD5"));
		
		List<ConnectionSpecs> connections = TripHelper.getDestinations(nodes, "B");
		
		assertEquals(2, connections.size());
		
		assertEquals("C", connections.get(0).getConnectionPoint());
		assertEquals(2 , connections.get(0).getDistance());
		
		assertEquals("D", connections.get(1).getConnectionPoint());
		assertEquals( 5 , connections.get(1).getDistance());
		
	}

}
