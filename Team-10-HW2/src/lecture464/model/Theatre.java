package lecture464.model;

public class Theatre {
<<<<<<< HEAD
	private String name;
	private String address;
	private User owner;
	private String city;
	private String state;
	private String postalCode;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public User getOwner() {
		return owner;
	}
	
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}	
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	

	
	public Theatre(String name, String address, User owner, String city, String state, String postalCode) {
		super();
		this.name = name;
		this.address = address;
		this.owner = owner;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
	}
=======
	
	private int id;
	private String name;
	private String address;
	private User owner;
	private String city;
	private String state;
	private String postalCode;
	
	
	public Theatre(int id, String name, String address, User owner, String city, String state, String postalCode) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.owner = owner;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public User getOwner() {
		return owner;
	}
	
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}	
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
>>>>>>> refs/remotes/origin/master
	
	public Theatre() {
		super();
	}
	
	
}
