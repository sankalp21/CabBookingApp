package src.Model;

public class Vehicle extends Entity<String>{
	private String name;
	private String number;
	
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Vehicle(String name, String number) {
		super(name);
		this.name = name;
		this.number = number;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	
}
