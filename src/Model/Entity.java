package src.Model;

public class Entity <I>{
	private I id;

	public Entity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Entity(I id) {
		super();
		this.id = id;
	}

	public I getId() {
		return id;
	}

	public void setId(I id) {
		this.id = id;
	}
	
}
