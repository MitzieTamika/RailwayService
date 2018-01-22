import java.util.ArrayList;
import java.util.List;

public class TripHelper {

	
	public static List <ConnectionSpecs>getDestinations( List<GraphNode> nodes, String start ){
		List<ConnectionSpecs> destinations = new ArrayList<ConnectionSpecs>();
		for(GraphNode node: nodes){
			if(node.getStart().equalsIgnoreCase(start)){
				destinations.add(new ConnectionSpecs(node.getEnd(), node.getDistance()));
			}
				
		}
		return destinations;
	}


}
