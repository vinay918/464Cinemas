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
		db.registerUser(newUser);
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
	
	public Boolean existingUser(User newUser){
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		String dbPass = db.getPassword(newUser);
		if(dbPass.equals("")){
			db.closeConnection();
			return false;
		}else{
			db.closeConnection();
			return true;
		}
	}	

}
