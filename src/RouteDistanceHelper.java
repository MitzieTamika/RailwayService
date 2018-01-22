import java.util.List;

public class RouteDistanceHelper {


	public static String computeRouteDistance(List<GraphNode> nodes, String path, String output_number) {

		String[] terms = path.split("-");
		int total_distance = 0; 
		StringBuilder output_string;
		output_string = new StringBuilder();
		output_string.append("Output #");
		output_string.append(output_number);
		output_string.append(": ");
		
		for( int i = 0; i < terms.length-1; i++ ){
			int distance = findRoute(terms[i], terms[i+1], nodes);
			if(distance > -1){
				total_distance += distance;				
			}else{
				
				output_string.append("NO SUCH ROUTE");
				return output_string.toString();
			}
		}
		output_string.append(total_distance);
		return output_string.toString();
		
	}
	
	protected static int findRoute(String start, String stop, List<GraphNode> nodes) {
		int distance = -1;
		for( GraphNode node: nodes){
			if(node.equals(new GraphNode(start+stop+"0"))){
				distance = node.getDistance();
				break;
			}
					
		}
		return distance;
	}

}
