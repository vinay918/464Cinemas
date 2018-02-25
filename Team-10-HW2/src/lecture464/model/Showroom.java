package lecture464.model;

public class Showroom {

	private int number;
	private int seats;
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public Showroom(int number, int seats) {
		super();
		this.number = number;
		this.seats = seats;
	}
	public Showroom() {
		super();
	}
	
	
}
