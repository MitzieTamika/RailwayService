import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class RouteDistanceHelperTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testComputeRouteDistance() {
		List<GraphNode> nodes = new ArrayList<GraphNode>();
		nodes.add(new GraphNode("AB3"));
		nodes.add(new GraphNode("BC11"));
		
		String message = RouteDistanceHelper.computeRouteDistance(nodes, "A-B-C", "1");
		assertEquals("Output #1: 14", message);
		
		message = RouteDistanceHelper.computeRouteDistance(nodes, "A-E-C", "1");
		assertEquals("Output #1: NO SUCH ROUTE", message);


	}

	@Test
	public void testFindRoute() {
		List<GraphNode> nodes = new ArrayList<GraphNode>();
		nodes.add(new GraphNode("AB3"));
		
		int distance = RouteDistanceHelper.findRoute("A", "B", nodes);
		assertNotEquals(-1, distance);
		
		nodes.add(new GraphNode("AC6"));
		distance = RouteDistanceHelper.findRoute("A", "C", nodes);
		assertNotEquals(-1, distance);
		
		distance = RouteDistanceHelper.findRoute("E", "C", nodes);
		assertEquals(-1, distance);
	}

}
