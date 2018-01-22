import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MaximumStopsTripCounterTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCountRoutes() {
		List<GraphNode> nodes = new ArrayList<GraphNode>();
		nodes.add(new GraphNode("AC1"));
		nodes.add(new GraphNode("CA3"));
		nodes.add(new GraphNode("CD1"));
		nodes.add(new GraphNode("DA1"));
		MaximumStopsTripCounter max_stops_tc = new MaximumStopsTripCounter();
		max_stops_tc.countRoutes(nodes, "A", "a", 0, 2);
		
		assertEquals(1, max_stops_tc.tripCount);
		
	}

}
