
public class ConnectionSpecs {
	private String connectionPoint ;
	private int distance ;
	
	public ConnectionSpecs(String end, int distance) {
		this.connectionPoint = end;
		this.distance = distance;
	}
	public String getConnectionPoint() {
		return connectionPoint;
	}
	public void setConnection(String connection) {
		this.connectionPoint = connection;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
}
