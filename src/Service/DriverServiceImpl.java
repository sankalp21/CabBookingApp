package src.Service;

import java.util.Optional;

import src.Model.Booking;
import src.Model.Driver;
import src.Model.Location;
import src.Model.Vehicle;
import src.Repository.IRepository;
import src.Repository.RepositoryImpl;
import src.Storage.Storage;
import src.Utility.BookingUtility;

public class DriverServiceImpl implements IDriverService{
	
	private IRepository<String, Driver> driverRepository;
	
	private IRepository<String, Booking> bookingRepository;
	
	private BookingUtility bookingUtility;
	
	public DriverServiceImpl(Storage<String, Driver> driverStorage, Storage<String, Booking> bookingStorage) {
		this.driverRepository = new RepositoryImpl<String, Driver>(driverStorage);
		this.bookingRepository = new RepositoryImpl<String, Booking>(bookingStorage);
		this.bookingUtility  = new BookingUtility();
	}

	@Override
	public Driver addDriver(Driver driver, Vehicle vehicle, Location location) {
		// TODO Auto-generated method stub
		driver.setVehicle(vehicle);
		driver.setLocation(location);
		Optional<Driver> driverOpt = driverRepository.save(driver);
		return driverOpt.get();
	}

	@Override
	public void updateDriverLocation(String driverName, Location location) throws Exception {
		// TODO Auto-generated method stub
		Optional<Driver> driverOpt = driverRepository.findById(driverName);
		
		if(!driverOpt.isPresent()) {
			throw new RuntimeException("Driver with driver name : "+driverName+" doesn't exists");
		}
		
		Driver driver = driverOpt.get();
		driver.setLocation(location);
		driverRepository.save(driver);
	}

	@Override
	public void changeDriverStatus(String driverName, Boolean status) throws Exception {
		// TODO Auto-generated method stub
		Optional<Driver> driverOpt = driverRepository.findById(driverName);
		
		if(!driverOpt.isPresent()) {
			throw new RuntimeException("Driver with driver name : "+driverName+" doesn't exists");
		}
		
		Driver driver = driverOpt.get();
		driver.setStatus(status);
		driverRepository.save(driver);
	}

	@Override
	public Long findTotalEarning(String driverName) {
		// TODO Auto-generated method stub
		Long totalEarnings = bookingRepository.findAll()
				.stream()
				.filter(booking -> booking.getId().contains(driverName))
				.reduce(
						0L, 
						(subEarning, booking) -> subEarning + bookingUtility.calculateEarningByDistance(booking.getSource(),booking.getDestination()),
						Long::sum
				);

		
		return totalEarnings;
	}

}
