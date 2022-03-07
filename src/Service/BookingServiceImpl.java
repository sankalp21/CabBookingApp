package src.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import src.Model.Booking;
import src.Model.Driver;
import src.Model.Location;
import src.Repository.IRepository;
import src.Repository.RepositoryImpl;
import src.Storage.Storage;
import src.Utility.BookingUtility;

public class BookingServiceImpl implements IBookingService{
	
	private IRepository<String, Booking> bookingRepository;
	
	private IRepository<String, Driver> driverRepository;
	
	private BookingUtility bookingUtility = new BookingUtility();
	
	public BookingServiceImpl(Storage<String, Driver> driverStorage, Storage<String, Booking> bookingStorage) {
		this.driverRepository = new RepositoryImpl<String, Driver>(driverStorage);
		this.bookingRepository = new RepositoryImpl<String, Booking>(bookingStorage);
		this.bookingUtility  = new BookingUtility();
	}

	@Override
	public List<Driver> findRide(String riderName, Location source, Location destination) {
		// TODO Auto-generated method stub
		List<Driver> driver = driverRepository.findAll()
				.stream()
				.filter(driverEle -> driverEle.getStatus() && bookingUtility.minRideDistance(source, driverEle.getLocation()))
				.collect(Collectors.toList());
		return driver;
	}

	@Override
	public Booking chooseRide(String riderName, String driverName, Location source, Location destination) {
		// TODO Auto-generated method stub
		Booking booking = new Booking(UUID.randomUUID().toString(),riderName, driverName, source, destination);
		Booking savedBooking = bookingRepository.save(booking).get();
		return savedBooking;
	}

	@Override
	public Long calculateBill(String riderName, String bookingId) {
		// TODO Auto-generated method stub
		Optional<Booking> bookingOpt = bookingRepository.findAll()
				.stream()
				.filter(booking -> booking.getId().equals(bookingId))
				.findFirst();
		
		return bookingOpt.isPresent() 
				? bookingUtility.calculateEarningByDistance(bookingOpt.get().getSource(), bookingOpt.get().getDestination())
				: 0L;
	}

}
