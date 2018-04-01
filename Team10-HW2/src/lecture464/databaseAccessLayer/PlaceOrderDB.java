package lecture464.databaseAccessLayer;

import lecture464.model.*;

public class PlaceOrderDB {
	
	public void setTransaction(double balance, int id) {
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		db.setBalance(id, balance);
		db.closeConnection();
	}

	public double getCardBalance(int userId) {
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		double balance = db.getBalance(userId);
		db.closeConnection();
		return balance;
	}
	
	public void setNumberPurchased(int numberPurchased, int movieShowingId) {
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		db.setNumberPurchased(numberPurchased, movieShowingId);;
		db.closeConnection();
	}
	
	public int getNumberPurchased(int movieShowingId) {
		DBAccessClass db = new DBAccessClass();
		int ticket;
		db.connectMeIn();
		ticket = db.getNumberPurchased(movieShowingId);
		db.closeConnection();
		return ticket;
	}
	
	
}