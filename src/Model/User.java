package src.Model;

public class User extends Entity<String>{
	private String name;
	private Character gender;
	private Integer age;
	private Location location;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, Character gender, Integer age, Location location) {
		super(name);
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
