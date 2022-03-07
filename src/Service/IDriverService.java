package src.Service;

import src.Model.Driver;
import src.Model.Location;
import src.Model.Vehicle;

public interface IDriverService {
	public Driver addDriver(Driver driver, Vehicle vehicle, Location location);
	public void updateDriverLocation(String driverName, Location location) throws Exception ;
	public void changeDriverStatus(String driverName, Boolean status) throws Exception ;
	public Long findTotalEarning(String driverName);
}
