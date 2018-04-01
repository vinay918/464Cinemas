package lecture464.databaseAccessLayer;



import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import java.util.*;

import lecture464.model.*;
import lecture464.servlet.Register;

public class DBAccessClass {	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement ps = null;
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://cse.unl.edu:3306/vbaldevsingh"; 
    static org.apache.log4j.Logger log = Logger.getLogger(DBAccessClass.class);

	//final String DB_URL = "jdbc:mysql://cse.unl.edu:3306/CSE_LOGIN";
	
	

	//  Database credentials
	static final String USER = "vbaldevsingh"; // Replace with your CSE_LOGIN
	static final String PASS = "4F3bog";   // Replace with your CSE MySQL_PASSWORD
	
	public ArrayList<MovieShowing> getMovieShowings(int theatreId,String movie){
		ps = null;
		ArrayList<MovieShowing> showings = new ArrayList<MovieShowing>();
		HashMap<Integer,Movie> movies = new HashMap<Integer,Movie>();
		HashMap<Integer,Showroom> showrooms = getShowrooms();
		movie = "%"+movie+"%";
		
		try {
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
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.debug("query failed",e);
		}
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
			log.debug("query failed",e);
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
			    showrooms.put(showroomId, newShowroom);
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.debug("query failed",e);
		}	
		return showrooms;
	}
	

	public void registerUser(User person){
		Random r = new SecureRandom();
		byte[] saltBytes = new byte[32];
		r.nextBytes(saltBytes);
		String salt = Base64.getEncoder().encodeToString(saltBytes);
		
		
		try {
			String secured ="";
			try {
				MessageDigest md = MessageDigest.getInstance("SHA-256");
				md.update((salt+person.getPassword()).getBytes(), 0, (salt+person.getPassword()).length());
	            secured = new BigInteger(1, md.digest()).toString(16);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				log.debug("query failed",e);
			}

			
			stmt = conn.createStatement();
			String query = "INSERT INTO User (`Username`,`Password`,`FirstName`,`LastName`,`PhoneNumber`,`EmailAddress`,`Salt`) " +
			          "VALUES (?,?,?,?,?,?,?);";
			
			ps = conn.prepareStatement(query);
			ps.setString(1,person.getUserName());
			ps.setString(2,secured);
			ps.setString(3,person.getFirstName());
			ps.setString(4,person.getLastName());
			ps.setString(5,person.getPhone());
			ps.setString(6,person.getEmail());
			ps.setString(7,salt);
			ps.executeUpdate();
			System.out.println(ps.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.debug("query failed",e);
		}
		return;
	}
	
	public void updatePassword(User person, String newPass){
		Random r = new SecureRandom();
		byte[] saltBytes = new byte[32];
		r.nextBytes(saltBytes);
		String salt = Base64.getEncoder().encodeToString(saltBytes);
		
		
		try {
			String secured ="";
			try {
				MessageDigest md = MessageDigest.getInstance("SHA-256");
				md.update((salt+newPass).getBytes(), 0, (salt+newPass).length());
	            secured = new BigInteger(1, md.digest()).toString(16);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				log.debug("query failed",e);
			}

			
			stmt = conn.createStatement();
			String query = "UPDATE User SET Password = ?, Salt = ? WHERE UserId=?;";
			
			ps = conn.prepareStatement(query);
			ps.setString(1,secured);
			ps.setString(2,salt);
			ps.setInt(3,person.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.debug("query failed",e);
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
			log.debug("query failed",e);
		}
		
		return password;
	}
	
	
	public String getSalt(User person){
		ps = null;
		String password = "";
		try {
			String query = "SELECT * FROM `User` WHERE Username=?;";			
			ps = conn.prepareStatement(query);
			ps.setString(1,person.getUserName());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			    password = rs.getString("Password");
			    String salt = rs.getString("Salt");
			    return salt;
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.debug("query failed",e);
		}
		
		return password;
	}
	
	
	public int getUserId(User person){
		ps = null;
		int id = 0;
		try {
			String query = "SELECT * FROM `User` WHERE Username=?;";			
			ps = conn.prepareStatement(query);
			ps.setString(1,person.getUserName());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			    id = rs.getInt("UserId");
			    return id;
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.debug("query failed",e);
		}
		
		return id;
	}
	
	public String getUserName(String id){
		ps = null;
		String fName;
		try {
			String query = "SELECT * FROM `User` WHERE UserId=?;";			
			ps = conn.prepareStatement(query);
			ps.setString(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			    fName = rs.getString("FirstName");
			    return fName;
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.debug("query failed",e);
		}
		return "";
	}	

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
			log.debug("query failed",e);
		}
		
		return null;
	}
	
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
			log.debug("query failed",e);
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
			log.debug("query failed",e);
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
			log.debug("query failed",e);
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
			log.debug("query failed",e);
		}
		
		return null;
	}		
	
	public ArrayList<CustomerReview> getCustomerReviews(int movieId){
		ps = null;
		String customerReview;
		ArrayList<CustomerReview> customerReviews = new ArrayList<CustomerReview>();
		User reviewer;
		String reviewDate;
		double rating;
		Movie movie;
		CustomerReview review;
		int id;
		
		try {
			String query = "SELECT * FROM `CustomerReview` WHERE MovieId=?;";			
			ps = conn.prepareStatement(query);
			ps.setInt(1,movieId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			    customerReview = rs.getString("Review");
			    reviewer = getUser(rs.getInt("UserId"));
			    id = rs.getInt("CustomerReviewId");
			    movie = getMovie(rs.getInt("MovieId"));
			    rating = rs.getInt("Rating");
			    reviewDate = rs.getString("ReviewDate");
			    review = new CustomerReview(id,reviewer,reviewDate,rating,customerReview);
			    customerReviews.add(review);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.debug("query failed",e);
		}
		
		return customerReviews;
	}		
	
	//Test needed
	public void addMovieReview(int movieId, int userId, String review, double rating){
		ps = null;

		try {
			String reviewDate = java.time.LocalDate.now().getMonthValue()+"-"+java.time.LocalDate.now().getDayOfMonth()+"-"+java.time.LocalDate.now().getYear();
			String query = "INSERT INTO `CustomerReview` (`MovieId`,`UserId`,`ReviewDate`,`Rating`,`Review` ) " +
			          "VALUES (?,?,?,?,?);";
			ps = conn.prepareStatement(query);
			ps.setInt(1,movieId);
			ps.setInt(2,userId);
			ps.setString(3, reviewDate);
			ps.setDouble(4, rating);
			ps.setString(5, review);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	    	log.debug("query failed",e);

		}
	}	
	
	public void setBalance(int id, double balance){
		ps = null;
		try {
			String query = "UPDATE `Bank` SET Balance=? WHERE UserId=?;";
			ps = conn.prepareStatement(query);
			ps.setDouble(1,balance);
			ps.setInt(2,id);
			ps.executeUpdate();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	    	log.debug("query failed",e);

		}
	}
	
	public double getBalance(int userId) {
		ps = null;
		User user = getUser(userId);
		double balance = 0;
		try {
			String query = "SELECT * FROM `Bank` WHERE UserId=?;";			
			ps = conn.prepareStatement(query);
			ps.setInt(1,userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				balance = rs.getDouble("Balance");
				return balance;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	    	log.debug("query failed",e);

		}
		return balance;
	}
	
	public BankModel getCardDetails(int userId) {
		ps = null;
		User user = getUser(userId);
		BankModel trans = new BankModel();
		try {
			String query = "SELECT * FROM `User` WHERE UserId=?;";			
			ps = conn.prepareStatement(query);
			ps.setInt(1,userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				trans.setAddress(rs.getString("Address"));
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	    	log.debug("query failed",e);

		}
		
		try {
			String query = "SELECT * FROM `Bank` WHERE UserId=?;";			
			ps = conn.prepareStatement(query);
			ps.setInt(1,userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			trans.setCreditCardNumber(rs.getString("CreditCardNumber"));
			trans.setCardType(rs.getString("CardType"));
			trans.setExpirationDate(rs.getString("ExpirationDate"));
			trans.setCvv(rs.getString("CVV"));
			trans.setName(rs.getString("CardHolderName"));
			trans.setBalance(rs.getDouble("Balance"));
			return trans;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	    	log.debug("query failed",e);

		}
		
		return trans;
		
	}
	
	//add orders TODO: check column names
	//TEST NEEDED CHANGED TO PS
	public void addOrderItem(int showingId, int quantity, int orderId, double totalPrice){
		ps = null;
		int isCancel = 0;
		try {
			String query = "INSERT INTO `OrderItem` (`OrderId`,`ShowingId`,`Quantity`,`TotalPrice`) " +
			          "VALUES ('?,?,?,?');";
			ps = conn.prepareStatement(query);
			ps.setInt(1, orderId);
			ps.setInt(2, showingId);
			ps.setInt(3, quantity);
			ps.setDouble(4, totalPrice);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	    	log.debug("query failed",e);

		}
	}
	
	public void addOrder(int orderId, int userId, double totalCost, String orderDate, String billingAddress, String creditCardNumber) {
		ps = null;
		try {
			String query = "INSERT INTO `Order` (`OrderId`,`CustomerId`,`TotalCost`,`OrderDate`,`BillingAddress`,`CreditCardNumber`) " +
			          "VALUES ('?,?,?,?,?,?');";
			ps = conn.prepareStatement(query);
			ps.setInt(1, orderId);
			ps.setInt(2, userId);
			ps.setDouble(3, totalCost);
			ps.setString(4, orderDate);
			ps.setString(5, billingAddress);
			ps.setString(6, creditCardNumber);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	    	log.debug("query failed",e);

		}
	}
	
	public void removeOrder(int orderId) {
		ps = null;
		try {
			String query = "DELETE FROM `Order` WHERE OrderId=?;";
			ps = conn.prepareStatement(query);
			ps.setInt(1,orderId);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	    	log.debug("query failed",e);

		}
	}
	
	public void removeOrderItems(int orderId) {
		ps = null;
		try {
			String query = "DELETE FROM `OrderItem` WHERE OrderId=?;";
			ps = conn.prepareStatement(query);
			ps.setInt(1,orderId);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	    	log.debug("query failed",e);

		}
	}
	
	public OrderItem getOrderItem(int orderItemId) {
		ps = null;
		OrderItem item = new OrderItem();
		try {
			String query = "SELECT * FROM `OrderItem` WHERE OrderItemId=?;";			
			ps = conn.prepareStatement(query);
			ps.setInt(1,orderItemId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				item.setMovie(getShowing(rs.getInt("showingId")));
				item.setOrderPrice(rs.getDouble("TotalPrice"));
				item.setQuantity(rs.getInt("Quantity"));
				System.out.println("cancel: " + rs.getInt("IsCancel"));
				item.setIsCancel(rs.getInt("IsCancel"));
				item.setOrderId(rs.getInt("OrderId"));
				return item;
			}
		}catch(SQLException e) {
	    	log.debug("query failed",e);

		}
		return item;
	}
	
	//get orders TODO: check column names
	public ArrayList<Orders> getOrders(int userId) {
		ps = null;
		User user = getUser(userId);
		ArrayList<Orders> orders = new ArrayList<Orders>();
		try {
			String query = "SELECT * FROM `Order` WHERE CustomerId=?;";			
			ps = conn.prepareStatement(query);
			ps.setInt(1,userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Orders order = new Orders();
				order.setOrderId(rs.getInt("OrderId"));
				order.setOrderDate(rs.getString("OrderDate"));
				order.setTotalCost(rs.getDouble("TotalCost"));
				orders.add(order);
			}
			return orders;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
	    	log.debug("query failed",e);

		}
		return orders;
	}
	
	//TODO: check column name
	public ArrayList<OrderItem> getOrderItems(int orderId) {
		ps = null;
		ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
		try {
			String query = "SELECT * FROM `OrderItem` WHERE OrderId=?;";			
			ps = conn.prepareStatement(query);
			ps.setInt(1,orderId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("row");
				OrderItem item = new OrderItem();
				item.setOrderItemId(rs.getInt("OrderItemId"));
				item.setMovie(getShowing(rs.getInt("showingId")));
				item.setOrderPrice(rs.getDouble("TotalPrice"));
				item.setQuantity(rs.getInt("Quantity"));
				System.out.println("cancel: " + rs.getInt("IsCancel"));
				item.setIsCancel(rs.getInt("IsCancel"));
				item.setOrderId(rs.getInt("OrderId"));
				orderItems.add(item);
			}
			return orderItems;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
	    	log.debug("query failed",e);

		}
		return orderItems;
	}
	
	public void setCancelOrderItem(int orderItemId) {
		ps = null;
		try {
			String query = "UPDATE `OrderItem` SET IsCancel=? WHERE OrderItemId=?;";
			ps = conn.prepareStatement(query);
			ps.setInt(1, 1);
			ps.setInt(2, orderItemId);
			ps.executeUpdate();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	    	log.debug("query failed",e);

		}
	}
	
	public void setNumberPurchased(int ticketPurchased, int movieShowingId) {
		ps = null;
		try {
			String query = "UPDATE `MovieShowing` SET NumberPurchased=? WHERE MovieShowingId=?;";
			ps = conn.prepareStatement(query);
			ps.setInt(1, ticketPurchased);
			ps.setInt(2, movieShowingId);
			ps.executeUpdate();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	    	log.debug("query failed",e);

		}
	}
	
	public int getNumberPurchased(int movieShowingId) {
		ps = null;
		int ticketPurchased=0;
		try {
			String query = "SELECT * FROM `MovieShowing` WHERE MovieShowingId=?;";
			ps = conn.prepareStatement(query);
			ps.setInt(1, movieShowingId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ticketPurchased = rs.getInt("NumberPurchased");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	    	log.debug("movie showing query failed",e);
		}
		return ticketPurchased;
	}
	
	//Connection and disconnection
	public void connectMeIn() {
		try{
			//Register the JDBC driver
			Class.forName("com.mysql.jdbc.Driver");			
		}catch(ClassNotFoundException e){
	    	log.debug("jdbc driver missing",e);
			System.exit (-1);
		}
		try {
			 //Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e){
	    	log.debug("no connection",e);


		}
	}
	
	public void closeConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
	    	log.debug("database connection not closed",e);
		}
	}
	


}
