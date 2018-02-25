package lecture464.databaseAccessLayer;

import java.util.*;

import lecture464.model.User;



public class MovieReviewDB 
{
	public List<String> getMovieReviews(int id){
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		return db.getMovieReviews(id);
	}
	
	public void addMovieReview(Movie movie){
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		db.addCustomerReview();
		db.closeConnection();
	}

}
