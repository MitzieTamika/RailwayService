import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

public class GraphNodeTest {
	
	private GraphNode r;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

	}

	/**
	 * Test method for {@link GraphNode#Route(java.lang.String)}.
	 */
	@Test
	public void testRouteString() {
		r = new GraphNode("AB6");
		
		assertEquals(r.getStart(), "A");
		assertEquals(r.getEnd(), "B");
		assertEquals(r.getDistance(), 6);
		
	
		r = new GraphNode("ab900");
		assertEquals(r.getStart(), "A");
		assertEquals(r.getEnd(), "B");
		assertEquals(r.getDistance(), 900);
		
		r = new GraphNode("");
		assertNull(r.getStart());
		assertNull(r.getEnd());
		assertEquals(r.getDistance(), 0);
	}
	
	@Test
	public void testRouteContructor() {
		r = new GraphNode("A", "B", 6);
		
		assertEquals(r.getStart(), "A");
		assertEquals(r.getEnd(), "B");
		assertEquals(r.getDistance(), 6);
		
	
		r = new GraphNode("a", "b", 900);
		assertEquals(r.getStart(), "A");
		assertEquals(r.getEnd(), "B");
		assertEquals(r.getDistance(), 900);
		
	}

	/**
	 * Test method for {@link GraphNode#getStart()}.
	 */
	@Test
	public void testGetStart() {
		r = new GraphNode("CE3");
		assertEquals(r.getStart(), "C");
		
		r = new GraphNode("cE3");
		assertEquals(r.getStart(), "C");
		
	}

	/**
	 * Test method for {@link GraphNode#getEnd()}.
	 */
	@Test
	public void testGetEnd() {
		r = new GraphNode("AE8");
		assertEquals(r.getEnd(), "E");
		
		r = new GraphNode("Ae8");
		assertEquals(r.getEnd(), "E");
	}

	/**
	 * Test method for {@link GraphNode#getDistance()}.
	 */
	@Test
	public void testGetDistance() {
		r = new GraphNode("ab90");
		assertEquals(r.getDistance(), 90);
		
		r = new GraphNode("ab1");
		assertEquals(r.getDistance(), 1);
	}

	/**
	 * Test method for {@link GraphNode#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		GraphNode first = new GraphNode("A", "B",11);
		GraphNode second = new GraphNode("A", "B", 11);
		boolean isEqual = first.equals(second);
		
		assertTrue(isEqual);
		
		first = new GraphNode("A", "b",11);
		second = new GraphNode("A", "B", 11);
		isEqual = first.equals(second);
		
		assertTrue(isEqual);
		
		first = new GraphNode("A", "B",11);
		second = new GraphNode("A", "B", 12);
		isEqual = first.equals(second);
	
		assertTrue(isEqual);
		
		first = new GraphNode("A", "C",2);
		second = new GraphNode("A", "B", 12);
		isEqual = first.equals(second);
	
		assertFalse(isEqual);
		
	}

}
