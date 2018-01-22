import java.util.ArrayList;
import java.util.List;

public class TripDistanceCalculator {
	
	private int shortestDistance ;

	

	public TripDistanceCalculator() {
		this.shortestDistance = 0;

	}
	/**
	 * 
	 * @param nodes - The Directed Graph
	 * @param start - The Starting position for eligible paths
	 * @param stop - The Stop position for eligible paths
	 * @param distance - Pracks the distance of current paths
	 * @param visitedPoints - Keeps track of nodes that have been visited.
	 */
	public void findShortestDistance( List<GraphNode> nodes, String start, String stop, int distance, List<String>visitedPoints ){
		
		List<ConnectionSpecs> connections = TripHelper.getDestinations( nodes, start );
		visitedPoints.add( start );
		
		for( ConnectionSpecs connection : connections ){
			
			if( visitedPoints.contains( connection.getConnectionPoint()) && !connection.getConnectionPoint().equalsIgnoreCase( stop )){
				continue;
			} else{
				 
				if( connection.getConnectionPoint().equalsIgnoreCase( stop )){
					shortestDistance = shortestDistance != 0 && shortestDistance < distance + connection.getDistance() ? shortestDistance : distance + connection.getDistance() ;
					continue;
				}else {
					findShortestDistance( nodes, connection.getConnectionPoint(), stop, distance + connection.getDistance(), new ArrayList<String>( visitedPoints ));
				}
			}
		}
		
	}
	public int getShortestDistance() {
		return shortestDistance;
	}



}
