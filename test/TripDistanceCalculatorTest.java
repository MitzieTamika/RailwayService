import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TripDistanceCalculatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testfindShortestDistance() {
		List<GraphNode> nodes = new ArrayList<GraphNode>();
		nodes.add(new GraphNode("AC1"));
		nodes.add(new GraphNode("CA3"));
		nodes.add(new GraphNode("CD1"));
		nodes.add(new GraphNode("DA1"));
		
		TripDistanceCalculator tdc = new TripDistanceCalculator();
		tdc.findShortestDistance(nodes, "A", "A", 0, new ArrayList<String>());
		
		assertEquals(3, tdc.getShortestDistance());
		
		
	}

}
