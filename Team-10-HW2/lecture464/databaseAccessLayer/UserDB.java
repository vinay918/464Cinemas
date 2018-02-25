package lecture464.databaseAccessLayer;

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
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		String enteredPassword = newUser.getPassword();
		String dbPass = db.getPassword(newUser);
		if(enteredPassword.trim().equals(dbPass.trim())){
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
