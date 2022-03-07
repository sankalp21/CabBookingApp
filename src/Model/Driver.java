package src.Model;

public class Driver extends User{
	private Boolean status = true;
	private Vehicle vehicle;
	
	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Driver(String name, Character gender, Integer age, Location location, Boolean status, Vehicle vehicle) {
		super(name, gender, age, location);
		this.status = status;
		this.vehicle = vehicle;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	
}
