package lecture464.databaseAccessLayer;
import java.util.ArrayList;

import lecture464.model.MovieShowing;


public class MovieShowingDB {
	
	public ArrayList<MovieShowing> getMovieShowings(int theatreId,String movie){
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		ArrayList<MovieShowing> movieShowings = db.getMovieShowings(theatreId,movie);
		db.closeConnection();
		return movieShowings;
	}
	
	public MovieShowing getMovieShowing(int showingId){
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		MovieShowing output = db.getShowing(showingId);
		db.closeConnection();
		return output;
	}
}
