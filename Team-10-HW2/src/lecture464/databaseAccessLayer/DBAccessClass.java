package lecture464.databaseAccessLayer;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import lecture464.model.User;
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
	
	public HashMap<Integer,Theatre> getTheatres(){
		ps = null;
		HashMap<Integer,Theatre> theatres = new HashMap<Integer,Theatre>();
		HashMap<Integer,Showroom> showrooms = new HashMap<Integer,Showroom>();
		try {
			String query = "SELECT * FROM TheatreBuilding t left join Showroom s on t.TheatreBuildingId = s.TheatreBuilding";			
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			Theatre newTheatre;
			ArrayList<Showroom> theatreShowroom;
			while(rs.next()) {
			    int theatreId = rs.getInt("TheatreBuildingId");
			    int showroomId = rs.getInt("ShowroomId");
			    String name = rs.getString("Name");
			    int ownerId = rs.getInt("OwnerId");
			    User owner = getUser(ownerId);
			    String address = rs.getString("Address");
			    String city = rs.getString("City");
			    String state = rs.getString("State");
			    String postalCode = rs.getString("PostalCode");
			    if(!theatres.containsKey(theatreId)){
			    	theatreShowroom = new ArrayList<Showroom>();
			    	theatreShowroom.add(showrooms.get(showroomId));
			    	newTheatre = new Theatre(name,address,owner,city,state,postalCode,theatreShowroom);
			    	theatres.put(theatreId,newTheatre);
			    }else{
			    	theatres.get(theatreId).addShowroom(showrooms.get(showroomId));
			    }
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
		try {
			String query = "SELECT * FROM Showroom;";			
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			    int showroomId = rs.getInt("ShowroomId");
			    int availableSeats = rs.getInt("AvailableSeats");
			    int number = rs.getInt("ShowroomNumber");
			    Showroom newShowroom = new Showroom(number,availableSeats);
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
			String query = "INSERT INTO `User` (`Username`,`Password`) " +
			          "VALUES ('"+person.getUserName()+"', '"+person.getPassword()+"');";
			stmt.executeUpdate(query);		
			
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
			    return new User(username,password);
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
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
