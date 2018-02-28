package lecture464.databaseAccessLayer;

import java.util.*;

import lecture464.model.*;



public class CustomerReviewDB 
{
	public ArrayList<CustomerReview> getMovieReviews(int id){
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		return db.getCustomerReviews(id);
	}
	
	public void addMovieReview(int movieId, int userId, String review, double rating){
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		db.addMovieReview(movieId, userId, review, rating);
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
