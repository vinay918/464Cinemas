package lecture464.model;

public class CustomerReview {
	private int id;
	private User reviewer;
	private String date;
	private double rating;
	private String comment;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getReviewer() {
		return reviewer;
	}
	public void setReviewer(User reviewer) {
		this.reviewer = reviewer;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public CustomerReview(int id, User reviewer, String date, double rating, String comment) {
		super();
		this.id = id;
		this.reviewer = reviewer;
		this.date = date;
		this.rating = rating;
		this.comment = comment;
	}
	public CustomerReview() {
		super();
	}
	
	
	
	
}