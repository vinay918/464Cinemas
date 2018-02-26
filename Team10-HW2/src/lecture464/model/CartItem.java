package lecture464.model;

public class CartItem {
	private MovieShowing movie;
	
	private int ticketQuantity;
	
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
