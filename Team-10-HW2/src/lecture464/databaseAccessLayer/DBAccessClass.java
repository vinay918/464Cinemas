package lecture464.databaseAccessLayer;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
<<<<<<< HEAD
<<<<<<< HEAD
import java.util.*;
=======
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
>>>>>>> refs/remotes/origin/master
=======
import java.util.ArrayList;
import java.util.HashMap;
>>>>>>> refs/remotes/origin/master

import lecture464.model.User;
<<<<<<< HEAD
=======
import lecture464.model.Movie;
import lecture464.model.MovieShowing;
>>>>>>> refs/remotes/origin/master
import lecture464.model.Showroom;
import lecture464.model.Theatre;

public class DBAccessClass {	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement ps = null;
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://cse.unl.edu:3306/vbaldevsingh"; 
	//final String DB_URL = "jdbc:mysql://cse.unl.edu:3306/CSE_LOGIN";
	
	

	//  Database credentials
	static final String USER = "vbaldevsingh"; // Replace with your CSE_LOGIN
	static final String PASS = "4F3bog";   // Replace with your CSE MySQL_PASSWORD
	
<<<<<<< HEAD
	public HashMap<Integer,Theatre> getTheatres(){
		ps = null;
		HashMap<Integer,Theatre> theatres = new HashMap<Integer,Theatre>();
=======
	public ArrayList<MovieShowing> getMovieShowings(int theatreId,String movie){
		ps = null;
		ArrayList<MovieShowing> showings = new ArrayList<MovieShowing>();
		HashMap<Integer,Movie> movies = new HashMap<Integer,Movie>();
		HashMap<Integer,Showroom> showrooms = getShowrooms();
		movie = "%"+movie+"%";
		
>>>>>>> refs/remotes/origin/master
		try {
<<<<<<< HEAD
			String query = "SELECT * FROM TheatreBuilding;";			
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			Theatre newTheatre;
			while(rs.next()) {
			    int theatreId = rs.getInt("TheatreBuildingId");
			    String name = rs.getString("Name");
			    int ownerId = rs.getInt("OwnerId");
			    User owner = getUser(ownerId);
			    String address = rs.getString("Address");
			    String city = rs.getString("City");
			    String state = rs.getString("State");
			    String postalCode = rs.getString("PostalCode");
			    newTheatre = new Theatre(name,address,owner,city,state,postalCode);
			    theatres.put(theatreId,newTheatre);
=======
			String query = "SELECT * FROM Movie m join MovieShowing ms on m.MovieId = ms.MovieId join Showroom s on ms.ShowroomId = s.ShowroomId join TheatreBuilding tb on s.TheatreBuilding = tb.TheatreBuildingId WHERE "
						+ "tb.TheatreBuildingId = ? AND m.MovieName like ?;";
			ps = conn.prepareStatement(query);
			ps.setInt(1,theatreId);
			ps.setString(2,movie);
			ResultSet rs = ps.executeQuery();
			Movie currentMovie;
			MovieShowing newShowing;
			
			while(rs.next()) {
			    int movieId = rs.getInt("MovieId");
			    if(movies.containsKey(movieId)){
			    	currentMovie = movies.get(movieId);
			    }else{
			    	currentMovie = getMovie(movieId);
			    }			    
			    int id = rs.getInt("MovieShowingId");
			    int price = rs.getInt("Price");
			    int purchased = rs.getInt("NumberPurchased");
			    int showroomId = rs.getInt("ShowroomId");
			    Showroom showroom = showrooms.get(showroomId);
			    String start = rs.getString("StartTime");
			    String end = rs.getString("EndTime");
			    newShowing = new MovieShowing(id,price,showroom,currentMovie,start,end,purchased);
			    showings.add(newShowing);
>>>>>>> refs/remotes/origin/master
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
<<<<<<< HEAD
		return theatres;
	
	}
	
	public HashMap<Integer,Showroom> getShowrooms(){
		ps = null;
		HashMap<Integer,Showroom> showrooms = new HashMap<Integer,Showroom>();
		HashMap<Integer,Theatre> theatres = getTheatres();
		try {
			String query = "SELECT * FROM Showroom s JOIN TheatreBuilding t on t.TheatreBuildingId = s.TheatreBuilding";			
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			    int showroomId = rs.getInt("ShowroomId");
			    int theatreBuildingId = rs.getInt("TheatreBuildingId");
			    int availableSeats = rs.getInt("AvailableSeats");
			    int number = rs.getInt("ShowroomNumber");
			    Showroom newShowroom = new Showroom(number,availableSeats,theatres.get(theatreBuildingId));
=======
		return showings;
	}
	
	public HashMap<Integer,Theatre> getTheatres(){
		ps = null;
		HashMap<Integer,Theatre> theatres = new HashMap<Integer,Theatre>();
		try {
			String query = "SELECT * FROM TheatreBuilding;";			
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			Theatre newTheatre;
			while(rs.next()) {
			    int theatreId = rs.getInt("TheatreBuildingId");
			    String name = rs.getString("Name");
			    int ownerId = rs.getInt("OwnerId");
			    User owner = getUser(ownerId);
			    String address = rs.getString("Address");
			    String city = rs.getString("City");
			    String state = rs.getString("State");
			    String postalCode = rs.getString("PostalCode");
			    newTheatre = new Theatre(theatreId,name,address,owner,city,state,postalCode);
			    theatres.put(theatreId,newTheatre);
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return theatres;
	
	}
	
	public HashMap<Integer,Showroom> getShowrooms(){
		ps = null;
		HashMap<Integer,Showroom> showrooms = new HashMap<Integer,Showroom>();
		HashMap<Integer,Theatre> theatres = getTheatres();
		try {
			String query = "SELECT * FROM Showroom s JOIN TheatreBuilding t on t.TheatreBuildingId = s.TheatreBuilding";			
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			    int showroomId = rs.getInt("ShowroomId");
			    int theatreBuildingId = rs.getInt("TheatreBuildingId");
			    int availableSeats = rs.getInt("AvailableSeats");
			    int number = rs.getInt("ShowroomNumber");
			    Showroom newShowroom = new Showroom(showroomId,number,availableSeats,theatres.get(theatreBuildingId));
>>>>>>> refs/remotes/origin/master
			    showrooms.put(showroomId, newShowroom);
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return showrooms;
	}
	

	public void registerUser(User person){

		try {
			stmt = conn.createStatement();
			String query = "INSERT INTO User (`Username`,`Password`,`FirstName`,`LastName`,`PhoneNumber`,`EmailAddress`) " +
			          "VALUES (?,?,?,?,?,?);";		
			ps = conn.prepareStatement(query);
			ps.setString(1,person.getUserName());
			ps.setString(2,person.getPassword());
			ps.setString(3,person.getFirstName());
			ps.setString(4,person.getLastName());
			ps.setString(5,person.getPhone());
			ps.setString(6,person.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
	
	public String getPassword(User person){
		ps = null;
		String password = "";
		try {
			String query = "SELECT * FROM `User` WHERE Username=?;";			
			ps = conn.prepareStatement(query);
			ps.setString(1,person.getUserName());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			    password = rs.getString("Password");
			    if(password.trim().equals(person.getPassword().trim())){
			    	return password;
			    }
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return password;
	}
	
	public int getUserId(User person){
		ps = null;
		int id = 0;
		try {
			String query = "SELECT * FROM `User` WHERE Username=? and Password=?;";			
			ps = conn.prepareStatement(query);
			ps.setString(1,person.getUserName());
			ps.setString(2,person.getPassword());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			    id = rs.getInt("UserId");
			    return id;
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}		
<<<<<<< HEAD
<<<<<<< HEAD
=======

	public User getUser(int id){
		ps = null;
		try {
			String query = "SELECT * FROM `User` WHERE UserId=?;";			
			ps = conn.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			    String username = rs.getString("UserName");
			    String password = rs.getString("Password");
			    String fName = rs.getString("FirstName");
			    String lName = rs.getString("LastName");
			    String email = rs.getString("EmailAddress");
			    String phone = rs.getString("PhoneNumber");			    
			    return new User(id,username,password,fName, lName, email, phone);
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
>>>>>>> refs/remotes/origin/master
	
<<<<<<< HEAD
	public List<String> getMovieReviews(int id){
		ps = null;
		String customerReview;
		List<String> customerReviews = new ArrayList<String>();
		try {
			String query = "SELECT * FROM `CustomerReview` WHERE MovieId=?;";			
			ps = conn.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			    customerReview = rs.getString("Review");
			    customerReviews.add(customerReview);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customerReviews;
	}		
	
	public void addMovieReview(Movie movie, User user, String review, double rating){
		ps = null;
		String customerReview;

		try {
			stmt = conn.createStatement();
			String query = "INSERT INTO `CustomerReview` (`MovieId`,`UserId`,`ReviewDate`,`Rating`,`Review` ) " +
			          "VALUES ('"+movie.getId()+"', '"+user.getId()+"', '"+java.time.LocalDate.now()+"', '"+rating+"', '"+review+"');";
			stmt.executeUpdate(query);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}		
=======

	public User getUser(int id){
		ps = null;
		try {
			String query = "SELECT * FROM `User` WHERE UserId=?;";			
			ps = conn.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			    String username = rs.getString("UserName");
			    String password = rs.getString("Password");
			    String fName = rs.getString("FirstName");
			    String lName = rs.getString("LastName");
			    String email = rs.getString("EmailAddress");
			    String phone = rs.getString("PhoneNumber");			    
			    return new User(username,password,fName, lName, email, phone);
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
>>>>>>> refs/remotes/origin/master
=======
	public MovieShowing getShowing(int id){
		ps = null;
		try {
			String query = "SELECT * FROM `MovieShowing` WHERE MovieShowingId=?;";			
			ps = conn.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			    int price = rs.getInt("Price");
			    int numPurchased = rs.getInt("NumberPurchased");
			    String start = rs.getString("StartTime");
			    String end = rs.getString("EndTime");
			    Movie movie =getMovie(rs.getInt("MovieId"));
			    Showroom showroom = getShowroom(rs.getInt("MovieId"));
			    return new MovieShowing(id,price,showroom, movie, start, end,numPurchased);
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;		
	}
	
	
	public Movie getMovie(int id){
		ps = null;
		try {
			String query = "SELECT * FROM `Movie` WHERE MovieId=?;";			
			ps = conn.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			    String name = rs.getString("MovieName");
			    String description = rs.getString("Description");
			    String thumbnail = rs.getString("Thumbnail");
			    String rating = rs.getString("Rating");		    
			    return new Movie(id,name,description,thumbnail, rating);
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Theatre getTheatre(int id){
		ps = null;
		try {
			String query = "SELECT * FROM `TheatreBuilding` WHERE TheatreBuildingId=?;";			
			ps = conn.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			    String name = rs.getString("Name");
			    String address = rs.getString("Address");
			    User owner = getUser(rs.getInt("OwnerId"));
			    String city = rs.getString("City");
			    String state = rs.getString("State");
			    String zipcode = rs.getString("PostalCode");
			    return new Theatre(id,name,address,owner,city,state,zipcode);
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Showroom getShowroom(int id){
		ps = null;
		try {
			String query = "SELECT * FROM `Showroom` WHERE ShowroomId=?;";			
			ps = conn.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			    int number = rs.getInt("ShowroomNumber");
			    int seats = rs.getInt("AvailableSeats");
			    Theatre theatre = getTheatre(rs.getInt("TheatreBuilding"));
			    return new Showroom(id,number,seats,theatre);
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}		
>>>>>>> refs/remotes/origin/master
	
	
	public void connectMeIn() {
		try{
			//Register the JDBC driver
			Class.forName("com.mysql.jdbc.Driver");			
		}catch(ClassNotFoundException e){
			System.err.println(e);
			System.exit (-1);
		}
		try {
			 //Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e){
			e.printStackTrace();

		}
	}
	
	
	public void closeConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	


}
