package lecture464.databaseAccessLayer;

import lecture464.model.*;

public class TransactionDB {

	public Transaction getTransaction(int id){
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		Transaction transDb = db.getCardDetails(id);
		db.closeConnection();
		return transDb;
	}
	
	public void setTransaction(double balance, int id) {
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		System.out.println(balance + "   " + id);
		db.setBalance(id, balance);
	}

}
