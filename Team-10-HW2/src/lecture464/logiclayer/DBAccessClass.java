package lecture464.logiclayer;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


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


	public void addEmployeeDB(int id, String fName, String lName, double salary){


		try {
			stmt = conn.createStatement();
			String query = "INSERT INTO Employees " +
			          "VALUES ("+id+", '"+fName+"', '"+lName+"', "+salary+");";			
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
