import java.util.List;

public class ExactStopsTripCounter extends TripCounter {


	public ExactStopsTripCounter() {
		super();
	}

	@Override
	public void countRoutes(List<GraphNode> nodes, String start, String end,  int stops, int max_stops) {
		List<ConnectionSpecs> connections = TripHelper.getDestinations(nodes, start);
		for( ConnectionSpecs connection: connections ){
			
			if ( stops == max_stops-1 && connection.getConnectionPoint().equalsIgnoreCase(end)){
				super.tripCount +=1;
				continue;
			}else if ( stops >= max_stops){
				break;
			}else{
				countRoutes( nodes, connection.getConnectionPoint(), end, stops + 1, max_stops );
			}
		}
	}

}
