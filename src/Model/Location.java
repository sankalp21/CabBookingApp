package src.Model;

public class Location extends Entity<Long>{
	private Long latitude;
	private Long longitude;
	
	public Location(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	public Location(Long latitude, Long longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Long getLatitude() {
		return latitude;
	}
	
	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}
	
	public Long getLongitude() {
		return longitude;
	}
	
	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}
	
}
