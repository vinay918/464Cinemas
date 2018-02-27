package lecture464.model;

public class CartItem {
	private MovieShowing movie;
	
	private int ticketQuantity;
	
	private double price;
	
	private double singlePrice;
	
	public double getSinglePrice() {
		return singlePrice;
	}
	public void setSinglePrice(double singlePrice) {
		this.singlePrice = singlePrice;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public MovieShowing getMovie() {
		return movie;
	}
	public void setMovie(MovieShowing movie) {
		this.movie = movie;
	}
	public int getTicketQuantity() {
		return ticketQuantity;
	}
	public void setTicketQuantity(int ticketQuantity) {
		this.ticketQuantity = ticketQuantity;
	}
}
