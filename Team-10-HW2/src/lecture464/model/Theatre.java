package lecture464.model;

import java.util.ArrayList;

public class Theatre {
	private String name;
	private String address;
	private User owner;
	private String city;
	private String state;
	private String postalCode;
	private ArrayList<Showroom> showrooms;
	
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
	
	public ArrayList<Showroom> getShowrooms() {
		return showrooms;
	}
	
	public void addShowroom(Showroom showroom) {
		this.showrooms.add(showroom);
	}
	
	public Theatre(String name, String address, User owner, String city, String state, String postalCode,
			ArrayList<Showroom> showrooms) {
		super();
		this.name = name;
		this.address = address;
		this.owner = owner;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.showrooms = showrooms;
	}
	
	public Theatre() {
		super();
	}
	
	
}
