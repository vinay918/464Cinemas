package lecture464.model;

public class Showroom {

	private int number;
	private int seats;
	private Theatre theatre;
	
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
	public Theatre getTheatre() {
		return theatre;
	}
	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}	
	public Showroom(int number, int seats, Theatre theatre) {
		super();
		this.number = number;
		this.seats = seats;
		this.theatre = theatre;
	}
	public Showroom() {
		super();
	}
	
	
}
