import java.util.List;

public class MaximumStopsTripCounter extends TripCounter {


	public MaximumStopsTripCounter() {
		super();
	}

	@Override
	public void countRoutes(List<GraphNode> nodes, String start, String end,  int stops, int max_stops ) {
		if( stops < max_stops ){
			List<ConnectionSpecs> connections = TripHelper.getDestinations( nodes, start );
			for( ConnectionSpecs connection: connections ){
				if(connection.getConnectionPoint().equalsIgnoreCase(end)){
					super.tripCount += 1; 
					continue;
				}else if( stops == max_stops - 1 && !connection.getConnectionPoint().equalsIgnoreCase(end)){
					continue;
				}else{
					countRoutes(nodes,  connection.getConnectionPoint(), end, stops + 1, max_stops );
				}
			}

		}
	}

}
