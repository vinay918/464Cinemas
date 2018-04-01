package lecture464.databaseAccessLayer;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

import lecture464.model.User;
import lecture464.servlet.PlaceOrder;



public class UserDB {

    static org.apache.log4j.Logger log = Logger.getLogger(PlaceOrder.class);

	
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
	
	public void changePassword(User user, String newPass){
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		db.updatePassword(user, newPass);	
		db.closeConnection();
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
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		String dbPass = db.getPassword(newUser);
		String salt = db.getSalt(newUser);

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update((salt+newUser.getPassword()).getBytes(), 0, (salt+newUser.getPassword()).length());
            secured = new BigInteger(1, md.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			log.debug("Hashing Exception",e);
		}
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
