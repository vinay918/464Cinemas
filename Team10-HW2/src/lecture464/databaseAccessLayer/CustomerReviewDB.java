package lecture464.databaseAccessLayer;

import java.util.*;

import lecture464.model.*;



public class CustomerReviewDB 
{
	public List<String> getMovieReviews(int id){
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		return db.getMovieReviews(id);
	}
	
	public void addMovieReview(MovieShowing movie, User user, String review, double rating){
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		db.addMovieReview(movie,user, review, rating);
		db.closeConnection();
	}
	
	
	public ArrayList<CustomerReview> getCustomerReview(int movieId){
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		ArrayList<CustomerReview> output = db.getCustomerReviews(movieId);
		db.closeConnection();
		return output;
	}	

}
