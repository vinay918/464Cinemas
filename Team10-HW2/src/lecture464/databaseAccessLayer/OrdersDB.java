package lecture464.databaseAccessLayer;

import java.util.ArrayList;

import lecture464.model.*;

public class OrdersDB {

	public void addOrderItem(int orderId, int showingId, int quantity, double totalPrice) {
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		db.addOrderItem(showingId, quantity, orderId, totalPrice);
	}
	
	public ArrayList<Orders> getUserOrders(int userId) {
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		ArrayList<Orders> orders = new ArrayList<Orders>();
		orders = db.getOrders(userId);
		return orders;
	}
	
	public ArrayList<OrderItem> getOrderItems(int orderId){
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		ArrayList<OrderItem> items = new ArrayList<OrderItem>();
		items = db.getOrderItem(orderId);
		return items;
	}
	
	public void addOrder(int orderId, int userId, double totalCost, String orderDate, String billingAddress, String creditCardNumber) {
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		db.addOrder(orderId, userId, totalCost, orderDate, billingAddress, creditCardNumber);
	}
	
	
}
