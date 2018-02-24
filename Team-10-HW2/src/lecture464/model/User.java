package lecture464.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;

import lecture464.databaseAccessLayer.UserDB;

public class User {
	
	private String userName;
	private String password;
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public User() {
		super();
	}
	
	public void registerUser(User aUser) {
		UserDB dbInterface = new UserDB();
		dbInterface.addUser(aUser);
	}
	
	public Boolean validateUser(User currentUser){
		UserDB dbInterface = new UserDB();
		return dbInterface.userValid(currentUser);
	}
	
	public Boolean userRegistered(User currentUser){
		UserDB dbInterface = new UserDB();
		return dbInterface.existingUser(currentUser);		
	}
	// removeUser
	
	
}
