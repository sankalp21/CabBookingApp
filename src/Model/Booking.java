package src.Model;

public class Booking extends Entity<String>{
	private String riderName;
	private String driverName;
	private Location source;
	private Location destination;

	public Booking() {
		
	}


	public Booking(String id, String riderName, String driverName, Location source, Location destination) {
		super(riderName+id+driverName);
		this.riderName = riderName;
		this.driverName = driverName;
		this.source = source;
		this.destination = destination;
	}


	public String getRiderName() {
		return riderName;
	}


	public void setRiderName(String riderName) {
		this.riderName = riderName;
	}


	public String getDriverName() {
		return driverName;
	}


	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}


	public Location getSource() {
		return source;
	}


	public void setSource(Location source) {
		this.source = source;
	}


	public Location getDestination() {
		return destination;
	}


	public void setDestination(Location destination) {
		this.destination = destination;
	}
	
}
