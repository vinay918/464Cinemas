package lecture464.databaseAccessLayer;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
