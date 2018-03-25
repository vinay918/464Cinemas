package lecture464.databaseAccessLayer;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import lecture464.model.User;



public class UserDB 
{
	public int getUserId(User user){
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		int userId = db.getUserId(user);
		db.closeConnection();
		return userId;
	}

	public User buildUser(User user){
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		User complete = db.getUser(db.getUserId(user));	
		db.closeConnection();
		return complete;
	}	
	
	
	public void addUser(User newUser){
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		db.registerUser(newUser);
		db.closeConnection();
		return;
	}
	
	public Boolean userValid(User newUser){
		String secured ="";
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(newUser.getPassword().getBytes(), 0, newUser.getPassword().length());
            secured = new BigInteger(1, md.digest()).toString(16);
            System.out.println(secured);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		String dbPass = db.getPassword(newUser);
		if(secured.trim().equals(dbPass.trim())){
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
