import java.util.ArrayList;
import java.util.List;

public class UniqueTripsCalculator {

	private  int route_count;
	private List<String> routes;
	
	public UniqueTripsCalculator() {
		route_count = 0;
		routes = new ArrayList<String>();
	}

	
	public int getRouteCount() {
		return route_count;
	}


	public List<String> getRoutes() {
		return routes;
	}

	/**
	 * @param nodes - The Directed Graph to process.
	 * @param start - Starting point for eligible routes.
	 * @param stop - Ending point for eligible routes.
	 * @param max_distance - The distance constraint for eligible routes.
	 * @param distance_total - Set to 0 at the start and accumulates in recursive call.
	 * @param path - set to start at the first call, then accumulates all visited nodes.
	 */
	public void findAllRoutes(List<GraphNode> nodes, String start, String stop, int max_distance, int distance_total, String path) {
		if(distance_total < max_distance){
			List<ConnectionSpecs> connections = TripHelper.getDestinations( nodes, start );
			
			for( ConnectionSpecs connection : connections ){
				
				if(connection.getConnectionPoint().equalsIgnoreCase(stop)){
					if(distance_total + connection.getDistance() < max_distance){
						if(!this.routes.contains(path)){
							this.routes.add(path + connection.getConnectionPoint());
							this.route_count = this.routes.size() ;
						}
					}
					findAllRoutes(nodes, connection.getConnectionPoint(), stop, max_distance, distance_total+connection.getDistance(), path + connection.getConnectionPoint());
				}else{
					
					findAllRoutes(nodes, connection.getConnectionPoint(), stop, max_distance, distance_total+connection.getDistance(), path + connection.getConnectionPoint());
				}
			}
		}
	}


}
