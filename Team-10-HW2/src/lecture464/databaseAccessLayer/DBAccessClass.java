package lecture464.databaseAccessLayer;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import lecture464.model.User;


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


	public void registerUser(User person){

		try {
			stmt = conn.createStatement();
			String query = "INSERT INTO `User` (`Username`,`Password`) " +
			          "VALUES ('"+person.getUserName()+"', '"+person.getPassword()+"');";
			stmt.executeUpdate(query);		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public void getUser(){
		
	}

}
