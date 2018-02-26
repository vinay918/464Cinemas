package lecture464.databaseAccessLayer;

import java.util.*;

import lecture464.model.*;



public class CustomerReviewDB 
{
	public List<CustomerReview> getMovieReviews(int id){
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		System.out.println(id);
		return db.getMovieReviews(id);
	}
	
	public void addMovieReview(MovieShowing movie, User user, String review, double rating){
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		db.addMovieReview(movie,user, review, rating);
		db.closeConnection();
	}
	
	public Boolean userValid(User newUser){
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		String enteredPassword = newUser.getPassword();
		String dbPass = db.getPassword(newUser);
		if(enteredPassword.trim().equals(dbPass.trim())){
			db.closeConnection();
			return true;
		}else{
			db.closeConnection();
			return false;
		}
	}

}
