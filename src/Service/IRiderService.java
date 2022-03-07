package src.Service;

import src.Model.Location;
import src.Model.Rider;

public interface IRiderService {
	public Rider addRider(Rider rider);
	public Rider updateRider(String riderName, Rider rider);
	public void updateRiderLocation(String riderName, Location location) throws Exception ;
}
