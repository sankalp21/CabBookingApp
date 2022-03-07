package src.Utility;

import src.Model.Location;

public class BookingUtility {
	private static final Long EARNING_PER_UNIT_DISTANCE = 1L;
	private static final Long MIN_DISTANCE = 5L;
	
	public Long calculateEarningByDistance(Location source, Location destination) {
		return this.calculateDistance(source, destination) * EARNING_PER_UNIT_DISTANCE;
	}
	
	public Long calculateDistance(Location source, Location destination) {
		Long latCal = Math.abs(source.getLatitude() - destination.getLatitude());
		Long longCal = Math.abs(source.getLongitude() - destination.getLongitude());
		
		return (long) (Math.sqrt(latCal * latCal + longCal * longCal));
	}
	
	public boolean minRideDistance(Location source, Location destination) {
		return this.calculateDistance(source, destination) < MIN_DISTANCE;
	}
}
