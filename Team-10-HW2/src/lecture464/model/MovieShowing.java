package lecture464.model;

public class MovieShowing {
	
	private int id;
	private int price;
	private Showroom showroom;
	private Movie movie;
	private String startTime;
	private String endTime;
	private int numberPurchased;
	private int seatsRemaining;
	
	public MovieShowing(int id, int price, Showroom showroom, Movie movie, String startTime, String endTime,
			int numberPurchased) {
		super();
		this.id = id;
		this.price = price;
		this.showroom = showroom;
		this.movie = movie;
		this.startTime = startTime;
		this.endTime = endTime;
		this.numberPurchased = numberPurchased;
		this.seatsRemaining = showroom.getSeats()-numberPurchased;
	}
	public int getSeatsRemaining() {
		return seatsRemaining;
	}
	public void setSeatsRemaining(int seatsRemaining) {
		this.seatsRemaining = seatsRemaining;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Showroom getShowroom() {
		return showroom;
	}
	public void setShowroom(Showroom showroom) {
		this.showroom = showroom;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getNumberPurchased() {
		return numberPurchased;
	}
	public void setNumberPurchased(int numberPurchased) {
		this.numberPurchased = numberPurchased;
	}
	public void addPurchase(int purchases){
		this.numberPurchased=this.numberPurchased+purchases;
	}
	
	public MovieShowing() {
		super();
	}
	
	
	
	
}
