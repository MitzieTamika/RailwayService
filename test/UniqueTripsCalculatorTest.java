import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class UniqueTripsCalculatorTest {

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testFindAllRoutes() {
		UniqueTripsCalculator utc = new UniqueTripsCalculator();
		List<GraphNode> nodes = new ArrayList<GraphNode>();
		nodes.add(new GraphNode("AC1"));
		nodes.add(new GraphNode("CA2"));
		nodes.add(new GraphNode("CD1"));
		nodes.add(new GraphNode("DA1"));
		
		utc.findAllRoutes(nodes, "A", "A", 4, 0, "A");
		assertEquals(2, utc.getRouteCount());
	}

}
