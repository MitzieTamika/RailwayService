import java.util.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ShowRoutes {

	public static void main(String[] args) {
		
		if(args.length == 0){
			System.out.println("Usage: 'java ShowRoutes /path/to/nodes/file.txt'");
			return;
		}
		BufferedReader input_file = null;
		
		
		try{
			input_file = new BufferedReader(new InputStreamReader( new FileInputStream(args[0]),  StandardCharsets.UTF_8));
		}catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}
		
		List<GraphNode> nodes = new ArrayList<GraphNode>();
		
		try {
			String line;
			while(( line = input_file.readLine()) != null){
				

				if(line.matches("[A-z]{2}\\d+")){
				nodes.add(new GraphNode(line.trim()));
				}else{
					throw new IllegalArgumentException("You have an incorrectly formatted Route in your input file. \n " + 
							"Routes must be  TWO letters followed by a number\n" + 
							"Please correct and try your file again");
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		
		// Multi-dimensional array holds output numbers 1-5 and their test requirements
		
		String[][] paths_specs = {{"A-B-C", "1"}
				,{"A-D","2"}
				,{"A-D-C", "3"}
				,{"A-E-B-C-D", "4"}
				,{"A-E-D", "5"}};
		
		for(String[] path_spec: paths_specs){
			System.out.println(RouteDistanceHelper.computeRouteDistance(nodes, path_spec[0], path_spec[1]));
		}
		

		StringBuilder output_string = new StringBuilder();
		
		//Routes starting with c  and ending with c with at most 3 stops
		
		TripCounter tripCounter = new MaximumStopsTripCounter();
		tripCounter.countRoutes(nodes, "C",  "C",  0, 3 );
		output_string = new StringBuilder();
		output_string.append("Output #6: ");
		output_string.append(tripCounter.getCount());
		System.out.println( output_string.toString());

		
		//Routes starting at A and ending at C with exactly for stops
		tripCounter = new ExactStopsTripCounter();
		
		tripCounter.countRoutes(nodes, "A",  "C",  0, 4 );
		output_string = new StringBuilder();
		output_string.append("Output #7: ");
		output_string.append(tripCounter.getCount());
		System.out.println(output_string.toString());

		
		// Length of the shortest route from A to C.
		TripDistanceCalculator tripCalculator = new TripDistanceCalculator();
		
		tripCalculator.findShortestDistance(nodes, "A", "C", 0, new ArrayList<String>());
		output_string = new StringBuilder();
		output_string.append("Output #8: ");
		output_string.append(tripCalculator.getShortestDistance());
		System.out.println(output_string.toString());
		
		
		//The length of the shortest route (in terms of distance to travel) from B to B.
		tripCalculator = new TripDistanceCalculator();
		
		tripCalculator.findShortestDistance(nodes, "B", "B", 0,  new ArrayList<String>());
		output_string = new StringBuilder();
		output_string.append("Output #9: ");
		output_string.append(tripCalculator.getShortestDistance());
		System.out.println(output_string.toString());
		
		
		// Number of unique trips from C to C with distance < 30.
		UniqueTripsCalculator uniqueTripsCounter = new UniqueTripsCalculator();
		
		uniqueTripsCounter.findAllRoutes(nodes, "C", "C", 30, 0, "C");
		output_string = new StringBuilder();
		output_string.append("Output #10: ");
		output_string.append(uniqueTripsCounter.getRouteCount());
		System.out.println(output_string.toString() );
	}



}
