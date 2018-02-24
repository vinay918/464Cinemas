package lecture464.databaseAccessLayer;

import lecture464.model.User;



public class UserDB 
{
	public int getUserId(String userName, String password){
		return 10;
	}
	
	public void addUser(User newUser){
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		db.registerUser(newUser);
		db.closeConnection();
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
			return false;
		}else{
			return true;
		}
	}	

}
