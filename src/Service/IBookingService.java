package src.Service;

import java.util.List;

import src.Model.Booking;
import src.Model.Driver;
import src.Model.Location;

public interface IBookingService {
	public List<Driver> findRide(String riderName, Location source, Location destination);
	public Booking chooseRide(String riderName, String driverName, Location source, Location destination);
	public Long calculateBill(String riderName, String bookingId);
}
