import java.util.List;

public abstract class TripCounter{

	protected int tripCount;
	

	public TripCounter(){
		tripCount = 0;
	}
	// method to be called recursively to count number of routes between two points with consideration for number of stops 
	public abstract void countRoutes(List<GraphNode> nodes, String start, String end,  int stops, int max_stops);
	 


	public int getCount() {
		return tripCount;
	}

	public void setCount(int count) {
		this.tripCount = count;
	}
	
}
