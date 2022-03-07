package src;

import java.util.List;

import src.Model.Booking;
import src.Model.Driver;
import src.Model.Location;
import src.Model.Rider;
import src.Model.Vehicle;
import src.Service.BookingServiceImpl;
import src.Service.DriverServiceImpl;
import src.Service.IBookingService;
import src.Service.IDriverService;
import src.Service.IRiderService;
import src.Service.RiderServiceImpl;
import src.Storage.Storage;

public class CabBookingApp {
	
	private static IDriverService driverService;
	private static IRiderService riderService;
	private static IBookingService bookingService;
	
	public static void initService() {
		Storage<String, Driver> driverStorage = new Storage();
		Storage<String, Rider> riderStorage = new Storage();
		Storage<String, Booking> BookingStorage = new Storage();
		
		driverService = new DriverServiceImpl(driverStorage, BookingStorage);
		riderService = new RiderServiceImpl(riderStorage);
		bookingService = new BookingServiceImpl(driverStorage, BookingStorage);
	}
	
	public static void sampleTest1() {
		Rider abhishek = new Rider();
		abhishek.setId("Abhishek");
		abhishek.setName("Abhishek");
		abhishek.setGender('M');
		abhishek.setAge(23);
		
		Rider rahul = new Rider();
		rahul.setId("Rahul");
		rahul.setName("Rahul");
		rahul.setGender('M');
		rahul.setAge(29);
		
		Rider nandini = new Rider();
		nandini.setId("Nandini");
		nandini.setName("Nandini");
		nandini.setGender('F');
		nandini.setAge(22);
		
		riderService.addRider(rahul);
		riderService.addRider(abhishek);
		riderService.addRider(nandini);
		
		try {
			riderService.updateRiderLocation(abhishek.getName(), new Location(0L,0L));
			riderService.updateRiderLocation(rahul.getName(), new Location(10L,0L));
			riderService.updateRiderLocation(nandini.getName(), new Location(15L,6L));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void sampleTest2() {
		Driver driver1 = new Driver();
		driver1.setId("Driver1");
		driver1.setName("Driver1");
		driver1.setGender('M');
		driver1.setAge(22);
		
		Vehicle v1 = new Vehicle("Swift","KA-01-12345");
		Location l1 = new Location(10L, 1L);
		
		Driver driver2 = new Driver();
		driver2.setId("Driver2");
		driver2.setName("Driver2");
		driver2.setGender('M');
		driver2.setAge(29);
		
		Vehicle v2 = new Vehicle("Swift","KA-01-12345");
		Location l2 = new Location(11L, 10L);
		
		Driver driver3 = new Driver();
		driver3.setId("Driver3");
		driver3.setName("Driver3");
		driver3.setGender('M');
		driver3.setAge(24);
		
		Vehicle v3 = new Vehicle("Swift","KA-01-12345");
		Location l3 = new Location(5L, 3L);
		
		driverService.addDriver(driver1, v1, l1);
		driverService.addDriver(driver2, v2, l2);
		driverService.addDriver(driver3, v3, l3);
	}
	
	public static void chooseAvailableDrivers(String riderName, Location source, Location destination) throws Exception {
		List<Driver> driverList = bookingService.findRide(riderName, source, destination);
		
		if(driverList.size() == 0) {
			System.out.println("No ride found [Since all the driver are more than 5 units away from user]");
			return;
		}
		
		for(Driver driver : driverList) {
			System.out.println(driver.getName()+" [Available]");
		}
		
		Driver choosedDriver = driverList.get(0);
		
		Booking booking = bookingService.chooseRide("Rahul", choosedDriver.getName(), source, destination);
		
		if(booking == null) return;
		
		System.out.println("ride Started");
		
		Long bill = bookingService.calculateBill(riderName, booking.getId());
		System.out.println("ride Ended bill amount $ "+ bill);
		
		riderService.updateRiderLocation(riderName, destination);
		driverService.updateDriverLocation(choosedDriver.getName(), destination);
		
	}
	
	public static void sampleTest3() {

		try {
			chooseAvailableDrivers("Abhishek", new Location(0L, 0L), new Location(20L, 0L));
			
			chooseAvailableDrivers("Rahul", new Location(10L, 0L), new Location(15L, 3L));
			driverService.changeDriverStatus("Driver1", false);
			
			chooseAvailableDrivers("Nandini", new Location(15L, 6L), new Location(20L, 4L));
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public static void sampleTest4() {
		System.out.println("Driver1 earns $ "+ driverService.findTotalEarning("Driver1"));
		System.out.println("Driver2 earns $ "+ driverService.findTotalEarning("Driver2"));
		System.out.println("Driver3 earns $ "+ driverService.findTotalEarning("Driver3"));
	}
	
	public static void main(String args[]) {
		initService();
		sampleTest1();
		sampleTest2();
		sampleTest3();
		sampleTest4();
	}
}
