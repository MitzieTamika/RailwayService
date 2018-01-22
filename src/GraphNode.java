import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GraphNode {
	private String start;
	private String end;
	private int  distance;
	
	public GraphNode(){
		this.start = "";
		this.end = "";
		this.distance = 0;
	}
	
	public GraphNode( String start, String end, int distance ) {
		this.start = start.toUpperCase();
		this.end = end.toUpperCase();
		this.distance = distance;
	}
	
	public GraphNode( String routeCombination ){

		String ROUTE_PATTERN = "([A-z])([A-z])(\\d+)";
		
		Pattern pattern = Pattern.compile( ROUTE_PATTERN );
		Matcher matcher = pattern.matcher( routeCombination );
		if( matcher.matches() ){
			this.start = matcher.group(1).toUpperCase();
			this.end  = matcher.group(2).toUpperCase();
			this.distance =  Integer.parseInt(matcher.group(3));
		}
		
	}
	public String getStart() {
		return start;
	}
	public void setStart( String start ) {
		this.start = start.toUpperCase();
	}
	public String getEnd() {
		return end;
	}
	public void setEnd( String end ) {
		this.end = end.toUpperCase();
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance( int distance ) {
		this.distance = distance;
	}
	
	@Override
	public boolean equals( Object obj ){
		
		if( obj != null && obj instanceof GraphNode ){
			if ( this.start.equalsIgnoreCase(((GraphNode) obj).start) && this.end.equalsIgnoreCase(((GraphNode) obj).end)){
				return true;
			}
		}
		return false;
		
	}
	
	

}
